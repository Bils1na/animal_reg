package org.example.animal;

import java.util.ArrayList;

public class Animal {
    static Integer nextAnimalID = 1;
    final Integer animalID;
    String name;
    ArrayList<String> commands;
    String birthDate;
    String type;

    public Animal(String name, String birthDate) {
        this.animalID = nextAnimalID++;
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public Animal(String name, ArrayList<String> commands, String birthDate) {
        this.animalID = nextAnimalID++;
        this.name = name;
        this.commands = commands;
        this.birthDate = birthDate;
    }

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

    public Integer getAnimalID() {
        return animalID;
    }

    @Override
    public String toString() {
        return animalID + ": " +
                "name='" + name + '\'' +
                ", commands=" + commands +
                ", birthDate='" + birthDate + '\'';
    }
}
