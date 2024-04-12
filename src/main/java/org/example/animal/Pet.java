package org.example.animal;

import java.util.ArrayList;

public class Pet extends Animal{

    public Pet(String name, String birthDate) {
        super(name, birthDate);
    }

    public Pet(String name, ArrayList<String> commands, String birthDate) {
        super(name, commands, birthDate);
    }
}
