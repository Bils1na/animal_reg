package org.example.animalRegistry;

import java.util.*;

public class AnimalRegistry {
    private static boolean isActive;
    private static ArrayList<Map<String, String>> animals;
    private static Scanner menuIn = new Scanner(System.in), creatingIn = new Scanner(System.in);

    public static void start() {
        isActive = true;

        while (isActive) {
            System.out.println("Animal Registry");
            System.out.println("Menu:");
            System.out.println("1. Add a new animal");
            System.out.println("2. List of animals");
            System.out.println("3. Teach a new command");
            System.out.println("4. Order by date");
            System.out.println("5. Exit");
            System.out.println();

            int answer = menuIn.nextInt();
            if (answer == 1) {
                addAnimal();
            } else if (answer == 2){
                animalList();
            } else if (answer == 5) {
                isActive = false;
                System.out.println("Registry is closed!");
            }
        }
    }

    private static void addAnimal() {
        System.out.println("Enter name, type and birthday for animal. Example 'Frank dog 2024-04-12'");

        ArrayList<String> newAnimal = new ArrayList<>(Arrays.asList(creatingIn.nextLine().split(" ")));
        try {
            registryHandler.updateRegistry(newAnimal);
            System.out.println("The new animal added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void animalList() {
        Map<Integer, Map<String, String>> jsonData = registryHandler.loadRegistry();
        Integer count = 1;
        for (Map<String, String> pet : jsonData.values()) {
            System.out.println(count++ +": " + pet.get("name") + " " + pet.get("type") + " " + pet.get("birthday"));
        }
    }

    private static void addCommand() {

    }

    private static void orderByDate() {

    }
}
