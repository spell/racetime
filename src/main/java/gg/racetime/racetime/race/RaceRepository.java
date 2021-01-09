package gg.racetime.racetime.race;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface RaceRepository extends PagingAndSortingRepository<Race, Long> {
    Optional<Race> findBySlugAndCategorySlug(String slug, String categorySlug);
}
