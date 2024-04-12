package org.example.animal;

import java.util.ArrayList;

public class Dog extends Pet{
    public Dog(String name, String birthDate) {
        super(name, birthDate);
        super.type = "Dog";
    }

    public Dog(String name, String birthDate, ArrayList<String> commands) {
        super(name, commands, birthDate);
        super.type = "Dog";
    }
}
