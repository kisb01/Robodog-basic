package com.example.robodogbasic.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DogCommand {
    private String name;
    private int age;
    private String breed;
}
