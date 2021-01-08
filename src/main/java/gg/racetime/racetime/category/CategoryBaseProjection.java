package gg.racetime.racetime.category;

import org.springframework.data.rest.core.config.Projection;

/**
 * CategoryBaseProjection defines the shared, common elements of all other projections.
 */
@Projection(name = "basic", types = {Category.class})
public interface CategoryBaseProjection {
    String getName();
    String getShortName();
    String getSearchName();
    String getSlug();
    String getImage();
    Boolean getStreamingRequired();
}
