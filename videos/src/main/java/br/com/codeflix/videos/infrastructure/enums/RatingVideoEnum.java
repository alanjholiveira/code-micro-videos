package br.com.codeflix.videos.infrastructure.enums;

public enum RatingVideoEnum {

    L(1, "L", "Livre Para Todos os Publico"),
    DEZ(2, "10", "Inadeguado para menores de 10 anos"),
    DOZE(3, "12", "Inadeguado para menores de 12 anos"),
    QUATORZE(4, "14", "Inadeguado para menores de 14 anos"),
    DEZESSEIS(5, "16", "Inadeguado para menores de 16 anos"),
    DEZOITO(6, "18", "Inadeguado para menores de 18 anos");

    private int value;
    private String code;
    private String description;

    RatingVideoEnum(int value, String code, String description) {
        this.value = value;
        this.code = code;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
