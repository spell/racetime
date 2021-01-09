package gg.racetime.racetime.race;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gg.racetime.racetime.category.Category;
import gg.racetime.racetime.django.DjangoCharFieldSerializer;
import gg.racetime.racetime.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "racetime_race")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(name = "custom_goal")
    @JsonSerialize(using = DjangoCharFieldSerializer.class)
    private String customGoal;

    @JsonSerialize(using = DjangoCharFieldSerializer.class)
    private String info;

    private String slug;

    @Column(name = "opened_at")
    private LocalDateTime openedAt;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    @Column(name = "cancelled_at")
    private LocalDateTime cancelledAt;

    private Boolean unlisted;
    private Boolean recordable;
    private Boolean recorded;

    @Column(name = "streaming_required")
    private Boolean streamingRequired;

    @Column(name = "auto_start")
    private Boolean autoStart;

    @Column(name = "allow_comments")
    private Boolean allowComments;

    @Column(name = "hide_comments")
    private Boolean hideComments;

    @Column(name ="allow_midrace_chat")
    private Boolean allowMidraceChat;

    @OneToOne
    @JoinColumn(name = "opened_by_id")
    private User openedBy;

    @OneToOne
    @JoinColumn(name = "recorded_by_id")
    private User recordedBy;

    public Race() {
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getCustomGoal() {
        return customGoal;
    }

    public void setCustomGoal(String customGoal) {
        this.customGoal = customGoal;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public LocalDateTime getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(LocalDateTime openedAt) {
        this.openedAt = openedAt;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public LocalDateTime getCancelledAt() {
        return cancelledAt;
    }

    public void setCancelledAt(LocalDateTime cancelledAt) {
        this.cancelledAt = cancelledAt;
    }

    public Boolean getUnlisted() {
        return unlisted;
    }

    public void setUnlisted(Boolean unlisted) {
        this.unlisted = unlisted;
    }

    public Boolean getRecordable() {
        return recordable;
    }

    public void setRecordable(Boolean recordable) {
        this.recordable = recordable;
    }

    public Boolean getRecorded() {
        return recorded;
    }

    public void setRecorded(Boolean recorded) {
        this.recorded = recorded;
    }

    public Boolean getStreamingRequired() {
        return streamingRequired;
    }

    public void setStreamingRequired(Boolean streamingRequired) {
        this.streamingRequired = streamingRequired;
    }

    public Boolean getAutoStart() {
        return autoStart;
    }

    public void setAutoStart(Boolean autoStart) {
        this.autoStart = autoStart;
    }

    public Boolean getAllowComments() {
        return allowComments;
    }

    public void setAllowComments(Boolean allowComments) {
        this.allowComments = allowComments;
    }

    public Boolean getHideComments() {
        return hideComments;
    }

    public void setHideComments(Boolean hideComments) {
        this.hideComments = hideComments;
    }

    public Boolean getAllowMidraceChat() {
        return allowMidraceChat;
    }

    public void setAllowMidraceChat(Boolean allowMidraceChat) {
        this.allowMidraceChat = allowMidraceChat;
    }

    public User getOpenedBy() {
        return openedBy;
    }

    public void setOpenedBy(User openedBy) {
        this.openedBy = openedBy;
    }

    public User getRecordedBy() {
        return recordedBy;
    }

    public void setRecordedBy(User recordedBy) {
        this.recordedBy = recordedBy;
    }
}
