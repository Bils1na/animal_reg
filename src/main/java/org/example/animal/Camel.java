package org.example.animal;

import java.util.ArrayList;

public class Camel extends PackAnimal{
    public Camel(String name, String birthDate) {
        super(name, birthDate);
        super.type = "Camel";
    }

    public Camel(String name, String birthDate, ArrayList<String> commands) {
        super(name, commands, birthDate);
        super.type = "Camel";
    }
}
