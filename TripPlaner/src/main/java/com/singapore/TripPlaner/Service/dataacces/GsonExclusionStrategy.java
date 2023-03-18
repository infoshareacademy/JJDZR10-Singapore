package com.singapore.TripPlaner.Service.dataacces;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class GsonExclusionStrategy implements ExclusionStrategy {

    private final Class<?> typeToSkip;

    public GsonExclusionStrategy() {
        this.typeToSkip = Object.class;
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }

}

