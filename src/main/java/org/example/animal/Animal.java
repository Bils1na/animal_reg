package org.example.animal;

import java.util.ArrayList;

public class Animal {
    String name;
    ArrayList<String> commands;
    String birthDate;
    String type;

    public String getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", commands=" + commands +
                ", birthDate='" + birthDate + '\'';
    }
}
