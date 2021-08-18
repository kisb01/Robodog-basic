package com.example.robodogbasic.models;

public enum Breed {
    BILLY("Billy"),
    BULLDOG("Bulldog"),
    TERRIER("Terrier"),
    DUNKER("Dunker"),
    HUSKY("Husky"),
    GERMAN_SHEPHERD("German Shepherd");

    private final String breedName;

    Breed(String breed) {
        this.breedName = breed;
    }

    public String getBreedName() {
        return breedName;
    }
}




