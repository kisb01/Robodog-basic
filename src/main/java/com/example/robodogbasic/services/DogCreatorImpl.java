package com.example.robodogbasic.services;

import com.example.robodogbasic.models.Breed;
import com.example.robodogbasic.models.Dog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class DogCreatorImpl implements DogCreator {
    @Override
    public Dog createRandomDog() {
        Dog dog = new Dog();
        dog.setName(generateName());
        dog.setAge(generateAge());
        dog.setBreed(generateBreed());
        return dog;
    }

    private String generateName() {
        String[] names = new String[]{"Morzsa", "Muki", "Dinnye", "Frici", "Kuki", "Picur"};
        return names[new Random().nextInt(names.length)];
    }

    private int generateAge() {
        return new Random().nextInt(20);
    }

    private Breed generateBreed() {
        List<Breed> breedList = new ArrayList<>(Arrays.asList(Breed.values()));
        int randomBreed = new Random().nextInt(breedList.size());
        return breedList.get(randomBreed);
    }
}
