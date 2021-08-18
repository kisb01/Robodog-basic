package com.example.robodogbasic.converters;

import com.example.robodogbasic.commands.DogCommand;
import com.example.robodogbasic.models.Dog;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class DogCommandToDog implements Converter<DogCommand, Dog> {

    @Synchronized
    @Nullable
    @Override
    public Dog convert(DogCommand source) {
        if (source == null) return null;
        final Dog dog = new Dog();
        dog.setName(source.getName());
        dog.setAge(source.getAge());
        dog.setBreed(new BreedToEnum().convert(source.getBreed()));
        return dog;
    }
}
