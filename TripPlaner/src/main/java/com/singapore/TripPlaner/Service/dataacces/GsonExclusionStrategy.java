package com.singapore.TripPlaner.Service.dataacces;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.singapore.TripPlaner.Model.Persistent;
import com.singapore.TripPlaner.Model.PersistentAbstract;

public class GsonExclusionStrategy implements ExclusionStrategy {

    private final Class<?> typeToSkip;

    public GsonExclusionStrategy() {
        this.typeToSkip = PersistentAbstract.class;
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return (typeToSkip.isAssignableFrom(f.getDeclaredClass()));
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }

}

