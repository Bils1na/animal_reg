package org.example.animalRegistry;

import com.google.gson.Gson;

import java.io.*;
import java.util.*;

public class AnimalRegistry {
    private static boolean isActive;
    private static ArrayList<String> animals;
    private static Scanner menu = new Scanner(System.in), creating = new Scanner(System.in);
    private static Integer id = 2;

    public static void loadRegistry() {
        Gson gson = new Gson();

        try {
            File registry = new File("src\\main\\java\\org\\example\\animalRegistry\\registry.json");
            FileReader registryJSON = new FileReader(registry.getAbsolutePath());
            Map<String, Map<String, String>> data = gson.fromJson(registryJSON, Map.class);

            System.out.println("Name: " + data.get("2").get("name"));
            System.out.println("Type: " + data.get("2").get("type"));
            System.out.println("Birthday: " + data.get("2").get("birthday"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeRegistry(ArrayList<String> data) throws IOException {
        Map<String, String> newData = new HashMap<>();
        newData.put("name", data.get(0));
        newData.put("type", data.get(1));
        newData.put("birthday", data.get(2));
        Map<Integer, Map<String, String>> registryMap = new HashMap<>();
        registryMap.put(id++, newData);

        File registry = new File("src\\main\\java\\org\\example\\animalRegistry\\registry.json");
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(registry.getAbsolutePath())){
            gson.toJson(registryMap, writer);
        }
    }

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

            int answer = menu.nextInt();
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

        ArrayList<String> newAnimal = new ArrayList<>(Arrays.asList(creating.nextLine().split(" ")));
        try {
            writeRegistry(newAnimal);
            System.out.println("The new animal added");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void animalList() {
        loadRegistry();
    }

    private static void addCommand() {

    }

    private static void orderByDate() {

    }
}
