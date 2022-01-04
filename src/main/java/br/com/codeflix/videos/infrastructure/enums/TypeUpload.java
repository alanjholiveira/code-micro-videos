package br.com.codeflix.videos.infrastructure.enums;

import lombok.Getter;

@Getter
public enum TypeUpload {

    VIDEO(0, "VIDEO_FILE", "Video do Filme em formato de arquivo"),
    TRAILER(1, "TRAILER_FILE", "Trailer do filme em formato de arquivo"),
    THUMB(2, "THUMB_FILE", "Thumb do filme em formato de arquivo"),
    BANNER(3, "BANNER_FILE", "Banner do filme em formato de arquivo");

    private int value;
    private String code;
    private String description;

    TypeUpload(int value, String code, String description) {
        this.value = value;
        this.code = code;
        this.description = description;
    }

}
