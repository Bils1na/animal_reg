package org.example.animal;

import java.util.ArrayList;

public class Cat extends Pet{
    public Cat(String name, String birthDate) {
        super.name = name;
        super.birthDate = birthDate;
        super.commands = new ArrayList<>();
        super.type = "Cat";
    }

    public Cat(String name, String birthDate, ArrayList<String> commands) {
        super.name = name;
        super.birthDate = birthDate;
        super.commands = new ArrayList<>(commands);
        super.type = "Cat";
    }
}
