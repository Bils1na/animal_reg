package org.example.animal;

import java.util.ArrayList;

public class Dog extends Pet{
    public Dog(String name, String birthDate, ArrayList<String> commands) {
        super.name = name;
        super.birthDate = birthDate;
        super.commands = new ArrayList<>(commands);
        super.type = "Dog";
    }
}
