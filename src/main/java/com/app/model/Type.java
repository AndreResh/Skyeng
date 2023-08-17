package com.app.model;

import lombok.Getter;

@Getter
public enum Type {
    LETTER("Письмо"),
    PACKAGE("Посылка"),
    PARCEL("Бандероль"),
    POSTCARD("Открытка");

    private final String type;
    Type(String type) {
        this.type = type;
    }

    public static Type getFromString(String type){
        for (Type e: Type.values()){
            if(e.getType().equalsIgnoreCase(type.trim())) return e;
        }
        throw new RuntimeException("Неизвестный тип");
    }
}
