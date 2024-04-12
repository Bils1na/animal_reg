package org.example.animal;

import java.util.ArrayList;

public class Hamster extends Pet{
    public Hamster(String name, String birthDate) {
        super(name, birthDate);
        super.type = "Hamster";
    }

    public Hamster(String name, String birthDate, ArrayList<String> commands) {
        super(name, commands, birthDate);
        super.type = "Hamster";
    }
}
