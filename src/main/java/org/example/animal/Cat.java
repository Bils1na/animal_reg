package org.example.animal;

import java.util.ArrayList;

public class Cat extends Pet{
    public Cat(String name, String birthDate) {
        super(name, birthDate);
        super.type = "Cat";
    }

    public Cat(String name, String birthDate, ArrayList<String> commands) {
        super(name, commands, birthDate);
        super.type = "Cat";
    }
}
