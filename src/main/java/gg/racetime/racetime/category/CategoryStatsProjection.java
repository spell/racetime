package gg.racetime.racetime.category;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "stats", types = {Category.class})
public interface CategoryStatsProjection extends CategoryBaseProjection {
}
