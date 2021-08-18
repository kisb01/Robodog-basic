package com.example.robodogbasic.services;

import com.example.robodogbasic.models.Breed;
import com.example.robodogbasic.models.Dog;

import java.util.List;

public interface DogStorage {

    void addDog(Dog dog);

    void addRandomDog();

    List<Dog> allDogs();

    void updateDog(String name, int age, Breed breed);
}
