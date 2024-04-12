package org.example.animal;

import java.util.ArrayList;

public class Donkey extends PackAnimal{
    public Donkey(String name, String birthDate) {
        super(name, birthDate);
        super.type = "Donkey";
    }

    public Donkey(String name, String birthDate, ArrayList<String> commands) {
        super(name, commands, birthDate);
        super.type = "Donkey";
    }
}
