package com.example.robodogbasic.services;

import com.example.robodogbasic.models.Breed;
import com.example.robodogbasic.models.Dog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogStorageImpl implements DogStorage {
    private final List<Dog> dogs;
    private final DogCreator newDog;


    public DogStorageImpl() {
        this.dogs = new ArrayList<>();
        this.newDog = new DogCreatorImpl();
    }

    @Override
    public void addDog(Dog dog) {
        this.dogs.add(dog);
    }

    @Override
    public void addRandomDog() {
        this.dogs.add(newDog.createRandomDog());
    }

    @Override
    public List<Dog> allDogs() {
        return this.dogs;
    }

    @Override
    public void updateDog(String name, int age, Breed breed) {
        Dog dog = this.dogs.stream().filter(a -> a.getName().equals(name)).findFirst().orElse(null);
        if (this.dogs.contains(dog)) {
            this.dogs.get(this.dogs.indexOf(dog)).setAge(age);
            this.dogs.get(this.dogs.indexOf(dog)).setBreed(breed);
        }
    }

}
