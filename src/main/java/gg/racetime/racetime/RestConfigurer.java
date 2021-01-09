package gg.racetime.racetime;

import gg.racetime.racetime.category.Category;
import gg.racetime.racetime.category.CategoryRepository;
import gg.racetime.racetime.race.Race;
import gg.racetime.racetime.race.RaceRepository;
import gg.racetime.racetime.user.UserRepository;
import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.Optional;

@Configuration
public class RestConfigurer implements RepositoryRestConfigurer {
    private final Hashids userHashids;

    public RestConfigurer(Hashids userHashids) {
        this.userHashids = userHashids;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // Categories are exposed by slug, this is a simple 1:1 conversion.
        config.withEntityLookup().forRepository(CategoryRepository.class, Category::getSlug, CategoryRepository::findBySlug);

        // Races are exposed by a combination of their slug and category slug.
        // TODO: This should be its own controller eventually, to keep consistency with the website.
        config.withEntityLookup().forRepository(
                RaceRepository.class,
                race -> String.format("%s~%s", race.getCategory().getSlug(), race.getSlug()),
                (repository, slug) -> {
                    var i = slug.indexOf('~');
                    if (i != -1) {
                        return repository.findBySlugAndCategorySlug(slug.substring(i + 1), slug.substring(0, i));
                    } else {
                        return null;
                    }
                });

        // Users are exposed by Hashid.
        config.withEntityLookup().forRepository(
                UserRepository.class,
                user -> {
                    try {
                        return userHashids.encode(user.getId());
                    } catch (Exception e) {
                        // We must always return a string, so return an invalid hashid instead.
                        return "null";
                    }
                },
                (repository, hashid) -> repository.findById(userHashids.decode(hashid)[0]));
    }
}
