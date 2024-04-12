package org.example.animal;

import java.util.ArrayList;

public class Camel extends PackAnimal{
    public Camel(String name, String birthDate) {
        super.name = name;
        super.birthDate = birthDate;
        super.commands = new ArrayList<>();
        super.type = "Camel";
    }

    public Camel(String name, String birthDate, ArrayList<String> commands) {
        super.name = name;
        super.birthDate = birthDate;
        super.commands = new ArrayList<>(commands);
        super.type = "Camel";
    }
}
