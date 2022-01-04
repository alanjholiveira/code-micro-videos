package br.com.codeflix.videos.infrastructure.enums;

import java.util.HashMap;
import java.util.Map;

public enum CastMemberType {

    TYPE1(1),
    TYPE2(2);

    private final Integer type;
    private static final Map<Integer, Object> values = new HashMap<>();


    private CastMemberType(Integer type) {
        this.type = type;
    }

    static {
        for (CastMemberType type: CastMemberType.values()) {
            values.put(type.type, type);
        }
    }

    public Integer getType() {
        return type;
    }

    public static Boolean valueOf(CastMemberType type) {
        CastMemberType castMemberType = (CastMemberType) values.get(type.type);
        return castMemberType != null;
    }
    
}
