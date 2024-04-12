package org.example.animalRegistry;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegistryHandler {
    private static final Type TYPE = new TypeToken<Map<Integer, Map<String, String>>>() {}.getType();
    private static final File REGISTRY = new File("src\\main\\java\\org\\example\\animalRegistry\\registry.json");

    private static Integer id = getLastId();

    public static Map<Integer, Map<String, String>> loadRegistry() {
        Gson gson = new Gson();
        Map<Integer, Map<String, String>> jsonData = new HashMap<>();
        try {
            FileReader reader = new FileReader(REGISTRY.getAbsolutePath());
            jsonData = gson.fromJson(reader, TYPE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonData;
    }

    public static void updateRegistry(ArrayList<String> data) {
        Map<Integer, Map<String, String>> jsonData = loadRegistry();

        Map<String, String> newData = new HashMap<>();
        newData.put("name", data.get(0));
        newData.put("type", data.get(1));
        newData.put("birthday", data.get(2));

        jsonData.put(id++, newData);

        writeRegistry(jsonData);
    }

    public static void updateCommand(ArrayList<String> commands, Integer id) {
        Map<Integer, Map<String, String>> jsonData = loadRegistry();

        Map<String, String> newData = jsonData.get(id);
        String commandsString = newData.get("commands") == null
                || newData.get("commands").isEmpty() ? "" : newData.get("commands") + ", ";
        for (int i = 0; i < commands.size(); i++) {
            if (i == commands.size() - 1) {
                commandsString += commands.get(i);
            } else {
                commandsString += commands.get(i) + ", ";
            }
        }
        newData.put("commands", commandsString);
        jsonData.put(id, newData);

        writeRegistry(jsonData);
    }


    private static void writeRegistry(Map<Integer, Map<String, String>> jsonData) {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(REGISTRY.getAbsolutePath());
            gson.toJson(jsonData, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Integer getLastId() {
        Map<Integer, Map<String, String>> jsonData = loadRegistry();
        Integer lastId = 1;

        for (Integer currentId : jsonData.keySet()) {
            if (lastId <= currentId) {
                lastId = currentId + 1;
            }
        }

        return lastId;
    }
}
