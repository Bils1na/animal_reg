package org.example.animal;

import java.util.ArrayList;

public class Horse extends PackAnimal{
    public Horse(String name, String birthDate) {
        super(name, birthDate);
        super.type = "Horse";
    }

    public Horse(String name, String birthDate, ArrayList<String> commands) {
        super(name, commands, birthDate);
        super.type = "Horse";
    }
}
