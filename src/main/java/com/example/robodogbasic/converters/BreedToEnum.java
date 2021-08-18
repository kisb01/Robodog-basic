package com.example.robodogbasic.converters;

import com.example.robodogbasic.models.Breed;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import java.util.Arrays;

public class BreedToEnum implements Converter<String, Breed> {

    @Synchronized
    @Nullable
    @Override
    public Breed convert(String source) {
        if (source == null) return null;
        return Arrays.stream(Breed.values()).filter(a -> a.getBreedName().equals(source)).findFirst().orElse(null);
    }
}
