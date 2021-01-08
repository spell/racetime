package gg.racetime.racetime;

import gg.racetime.racetime.category.Category;
import gg.racetime.racetime.category.CategoryRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfigurer implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.withEntityLookup()
                .forRepository(CategoryRepository.class, Category::getSlug, CategoryRepository::findBySlug);
    }
}
