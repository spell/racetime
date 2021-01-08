package gg.racetime.racetime.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gg.racetime.racetime.django.DjangoCharFieldSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "racetime_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "search_name")
    private String searchName;

    @JsonIgnore
    private String slug;

    @JsonSerialize(using = DjangoCharFieldSerializer.class)
    private String image;

    @JsonSerialize(using = DjangoCharFieldSerializer.class)
    private String info;

    @Column(name = "streaming_required")
    private Boolean streamingRequired;

    private Boolean active;

    @Column(name = "slug_words")
    private String slugWords;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean getStreamingRequired() {
        return streamingRequired;
    }

    public void setStreamingRequired(Boolean streamingRequired) {
        this.streamingRequired = streamingRequired;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getSlugWords() {
        return slugWords;
    }

    public void setSlugWords(String slugWords) {
        this.slugWords = slugWords;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
