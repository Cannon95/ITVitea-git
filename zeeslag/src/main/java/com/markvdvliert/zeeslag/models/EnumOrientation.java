package com.markvdvliert.zeeslag.models;

public enum EnumOrientation {
    HORIZONTAL,
    VERTICAL;

    public static EnumOrientation flip(EnumOrientation orientation) {
        if (orientation == EnumOrientation.HORIZONTAL) {
            return EnumOrientation.VERTICAL;
        } else {
            return EnumOrientation.HORIZONTAL;
        }
    }
}
