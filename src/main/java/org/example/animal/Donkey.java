package org.example.animal;

import java.util.ArrayList;

public class Donkey extends PackAnimal{
    public Donkey(String name, String birthDate) {
        super.name = name;
        super.birthDate = birthDate;
        super.commands = new ArrayList<>();
        super.type = "Donkey";
    }

    public Donkey(String name, String birthDate, ArrayList<String> commands) {
        super.name = name;
        super.birthDate = birthDate;
        super.commands = new ArrayList<>(commands);
        super.type = "Donkey";
    }
}
