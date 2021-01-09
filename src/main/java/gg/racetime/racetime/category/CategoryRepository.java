package gg.racetime.racetime.category;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {
    Optional<Category> findBySlug(String slug);
}
