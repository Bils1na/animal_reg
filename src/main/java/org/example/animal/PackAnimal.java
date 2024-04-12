package org.example.animal;

import java.util.ArrayList;

public class PackAnimal extends Animal{

    public PackAnimal(String name, String birthDate) {
        super(name, birthDate);
    }

    public PackAnimal(String name, ArrayList<String> commands, String birthDate) {
        super(name, commands, birthDate);
    }
}
