package org.example.animal;

import java.util.ArrayList;

public class Hamster extends Pet{
    public Hamster(String name, String birthDate) {
        super.name = name;
        super.birthDate = birthDate;
        super.commands = new ArrayList<>();
        super.type = "Hamster";
    }

    public Hamster(String name, String birthDate, ArrayList<String> commands) {
        super.name = name;
        super.birthDate = birthDate;
        super.commands = new ArrayList<>(commands);
        super.type = "Hamster";
    }
}
