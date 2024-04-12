package org.example.animalRegistry;

import org.example.animal.*;

import java.util.*;

public class AnimalRegistry {
    private static boolean isActive;
    private static Scanner menuIn = new Scanner(System.in), creatingIn = new Scanner(System.in);
    private static ArrayList<Animal> animals = new ArrayList<>();

    public static void start() {
        fillAnimalList();
        isActive = true;

        while (isActive) {
            System.out.println();
            System.out.println("Animal Registry");
            System.out.println("Menu:");
            System.out.println("1. Add a new animal");
            System.out.println("2. List of animals");
            System.out.println("3. Teach a new command");
            System.out.println("4. Order by date");
            System.out.println("5. List of commands");
            System.out.println("6. Exit");
            System.out.println("Total animals: " + animals.size());
            System.out.println();

            int answer = menuIn.nextInt();

            if (answer == 1) {
                addAnimal();
            } else if (answer == 2){
                animalList();
            } else if (answer == 3) {
                addCommand();
            } else if (answer == 4) {
                orderByDate();
            } else if (answer == 5) {
                commandList();
            } else if (answer == 6) {
                isActive = false;
                System.out.println("Registry is closed!");
            }
        }
    }

    private static void addAnimal() {
        System.out.println("Enter name, type and birthday for animal. Example 'Frank dog 2024-04-12'");
        ArrayList<String> newAnimal = new ArrayList<>(Arrays.asList(creatingIn.nextLine().split(" ")));

        RegistryHandler.updateRegistry(newAnimal);
        System.out.println("The new animal added");

        animals = new ArrayList<>();
        fillAnimalList();
    }

    private static void animalList() {
        Map<Integer, Map<String, String>> jsonData = RegistryHandler.loadRegistry();
        Integer count = 1;
        for (Map<String, String> pet : jsonData.values()) {
            System.out.println(count++ +": " + pet.get("name") + " " + pet.get("type") + " " + pet.get("birthday"));
        }
    }

    private static void addCommand() {
        Integer count = 1;
        System.out.println("Choose animal: ");
        for (Map<String, String> pet : RegistryHandler.loadRegistry().values()) {
            System.out.println(count++ + ": " + pet.get("name"));
        }
        Integer id = menuIn.nextInt();

        System.out.println("Enter command(s). Example 'Sit' or 'Sit Jump'");
        ArrayList<String> newCommands = new ArrayList<>((Arrays.asList((creatingIn.nextLine().split(" ")))));

        RegistryHandler.updateCommand(newCommands, id);
        System.out.println("The new commands added");
    }

    private static void orderByDate() {
        animals.sort(Comparator.comparing(Animal::getBirthDate).reversed());
        Integer count = 1;
        for (Animal animal : animals) {
            System.out.println(count++ + ": " + animal.getName() + " " + animal.getType().toLowerCase() +
                    " " + animal.getBirthDate() + " " + animal.getCommands());
        }
    }

    private static void commandList() {
        Integer count = 1;
        System.out.println("Choose animal: ");
        for (Map<String, String> pet : RegistryHandler.loadRegistry().values()) {
            System.out.println(count++ + ": " + pet.get("name"));
        }
        Integer id = menuIn.nextInt();

        for (Animal animal : animals) {
            if (id == animal.getAnimalID()) {
                System.out.println(animal.getCommands());
            }
        }
    }

    private static void fillAnimalList() {
        Map<Integer, Map<String, String>> jsonData = RegistryHandler.loadRegistry();
        for (Map<String, String> pet : jsonData.values()) {
            if (pet.get("type").equals("dog")) {
                if (pet.get("commands") == null) {
                    animals.add(new Dog(pet.get("name"), pet.get("birthday")));
                } else {
                    animals.add(new Dog(pet.get("name"), pet.get("birthday"),
                            new ArrayList<>(Arrays.asList(pet.get("commands").split(", ")))));
                }
            } else if (pet.get("type").equals("cat")) {
                if (pet.get("commands") == null) {
                    animals.add(new Cat(pet.get("name"), pet.get("birthday")));
                } else {
                    animals.add(new Cat(pet.get("name"), pet.get("birthday"),
                            new ArrayList<>(Arrays.asList(pet.get("commands").split(", ")))));
                }
            } else if (pet.get("type").equals("hamster")) {
                if (pet.get("commands") == null) {
                    animals.add(new Hamster(pet.get("name"), pet.get("birthday")));
                } else {
                    animals.add(new Hamster(pet.get("name"), pet.get("birthday"),
                            new ArrayList<>(Arrays.asList(pet.get("commands").split(", ")))));
                }
            } else if (pet.get("type").equals("horse")) {
                if (pet.get("commands") == null) {
                    animals.add(new Horse(pet.get("name"), pet.get("birthday")));
                } else {
                    animals.add(new Horse(pet.get("name"), pet.get("birthday"),
                            new ArrayList<>(Arrays.asList(pet.get("commands").split(", ")))));
                }
            } else if (pet.get("type").equals("camel")) {
                if (pet.get("commands") == null) {
                    animals.add(new Camel(pet.get("name"), pet.get("birthday")));
                } else {
                    animals.add(new Camel(pet.get("name"), pet.get("birthday"),
                            new ArrayList<>(Arrays.asList(pet.get("commands").split(", ")))));
                }
            } else if (pet.get("type").equals("donkey")) {
                if (pet.get("commands") == null) {
                    animals.add(new Donkey(pet.get("name"), pet.get("birthday")));
                } else {
                    animals.add(new Donkey(pet.get("name"), pet.get("birthday"),
                            new ArrayList<>(Arrays.asList(pet.get("commands").split(", ")))));
                }
            }
        }
    }
}
