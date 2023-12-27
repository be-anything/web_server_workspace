package com.sh.ajax.celeb.model.entity;

public class Celeb {
    private Long id;
    private String name;
    private String profile;
    private Type type;

    @Override
    public String toString() {
        return "Celeb{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", type=" + type +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfile() {
        if(profile == null) return "default.png";
        return profile;
    }

    public Type getType() {
        return type;
    }

    public Celeb(Long id, String name, String profile, Type type) {
        this.id = id;
        this.name = name;
        this.profile = profile;
        this.type = type;
    }

    public Celeb() {
    }
}
