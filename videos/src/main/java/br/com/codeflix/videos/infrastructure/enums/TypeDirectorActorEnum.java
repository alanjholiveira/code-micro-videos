package br.com.codeflix.videos.infrastructure.enums;

public enum TypeDirectorActorEnum {

    TYPE_DIRECTOR(1, "Director"),
    TYPE_ACTOR(2, "Actor");

    private Integer code;
    private String description;

    TypeDirectorActorEnum(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
