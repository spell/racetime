package gg.racetime.racetime.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import gg.racetime.racetime.django.DjangoCharFieldSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "racetime_user")
public class User {
    public final static String PYTHON_CLASS = "<class 'racetime.models.user.User'>";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private Boolean active;

    private String name;
    private String discriminator;

    @JsonSerialize(using = DjangoCharFieldSerializer.class)
    private String avatar;

    @JsonSerialize(using = DjangoCharFieldSerializer.class)
    private String pronouns;

    @Column(name = "profile_bio")
    @JsonSerialize(using = DjangoCharFieldSerializer.class)
    private String profileBio;

    @JsonIgnore
    @Column(name = "custom_profile_slug")
    private String customProfileSlug;

    @Column(name = "is_staff")
    private Boolean staff;

    @Column(name = "is_supporter")
    private Boolean supporter;

    @Column(name = "show_supporter")
    private Boolean showSupporter;

    @Column(name = "detailed_timer")
    private Boolean detailedTimer;

    @JsonIgnore
    @Column(name ="date_joined")
    private LocalDateTime joinedOn;

    @JsonIgnore
    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscriminator() {
        return discriminator;
    }

    public void setDiscriminator(String discriminator) {
        this.discriminator = discriminator;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPronouns() {
        return pronouns;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }

    public String getProfileBio() {
        return profileBio;
    }

    public void setProfileBio(String profileBio) {
        this.profileBio = profileBio;
    }

    public String getCustomProfileSlug() {
        return customProfileSlug;
    }

    public void setCustomProfileSlug(String customProfileSlug) {
        this.customProfileSlug = customProfileSlug;
    }

    public Boolean getStaff() {
        return staff;
    }

    public void setStaff(Boolean staff) {
        this.staff = staff;
    }

    public Boolean getSupporter() {
        return supporter;
    }

    public void setSupporter(Boolean supporter) {
        this.supporter = supporter;
    }

    public Boolean getShowSupporter() {
        return showSupporter;
    }

    public void setShowSupporter(Boolean showSupporter) {
        this.showSupporter = showSupporter;
    }

    public Boolean getDetailedTimer() {
        return detailedTimer;
    }

    public void setDetailedTimer(Boolean detailedTimer) {
        this.detailedTimer = detailedTimer;
    }

    public LocalDateTime getJoinedOn() {
        return joinedOn;
    }

    public void setJoinedOn(LocalDateTime joinedOn) {
        this.joinedOn = joinedOn;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
