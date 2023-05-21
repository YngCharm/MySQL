package com.digdes.school;

import java.util.*;

public class Starter {
    public List<Map<String, Object>> list = new ArrayList<>();

    public Starter() {

    }

    public List<Map<String, Object>> execute(String request) {

        switch (readRequest(request)) {

            case "INSERT" -> insertListElement(request);
            case "UPDATE" -> updateListElement(request);
            case "DELETE" -> deleteListElement(request);
            case "SELECT" -> selectListElement(request);
            default -> throw new RuntimeException("Incorrect request.");
        }
        return list;
    }

    private String readRequest(String request) {
        if (request.startsWith("INSERT") || request.startsWith("UPDATE") || request.startsWith("DELETE") || request.startsWith("SELECT"))
            ;
        return request.substring(0, 6);
    }

    private void selectListElement(String request) {
    }

    private void deleteListElement(String request) {
        request = request.replaceAll("DELETE VALUES", "");
        request = request.replaceAll("‘", "");
        request = request.replaceAll("’", "");

        ArrayList<String> data = new ArrayList<>();

        String[] words = request.split("[=, ]");

        for (String word : words) {
            if (!word.isBlank()) {
                data.add(word.trim());
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).containsKey(data.get(0)) && list.get(i).containsValue(data.get(1))) {
                list.remove(i);
                i--;
            }
        }
        System.out.println("Удалить все строки где есть: " + data);
        System.out.println("Новый лист: " + list);
    }

    private void updateListElement(String request) {
        request = request.replaceAll("UPDATE VALUES", "");
        request = request.replaceAll("where", "");
        request = request.replaceAll("‘", "");
        request = request.replaceAll("’", "");

        ArrayList<String> data = new ArrayList<>();


        String[] words = request.split("[=, ]");

        for (String word : words) {
            if (!word.isBlank()) {
                data.add(word.trim());
            }
        }
        String key = data.get(data.size()-2);
        String value = data.get(data.size()-1);
        data.remove(key);
        data.remove(value);

        System.out.println("Там где содержится: " + key + " " + value + "\n" + "Вы хотите обновить: " + data);


        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).containsValue(value) && list.get(i).containsKey(key)) {
                for (int j = 0; j < data.size() - 1; j++) {
                    list.get(i).remove(data.get(j));
                    list.get(i).remove(data.get(j+1));
                    list.get(i).put(data.get(j), data.get(j+1));
                }
            }
        }
        System.out.println("Обвновлённый лист: " + "\n");
    }

    private void insertListElement(String request) {
        request = request.replaceAll("INSERT VALUES", "");
        request = request.replaceAll("‘", "");
        request = request.replaceAll("’", "");

        ArrayList<String> data = new ArrayList<>();

        String[] words = request.split("[=, ]");

        for (String word : words) {
            if (!word.isBlank()) {
                data.add(word.trim());
            }
        }

        Map<String, Object> row = new HashMap<>();

        for (int i = 0; i < data.size(); i++) {
            if (i > 7) {
                break;
            }
            if (i == 0) {
                row.put(data.get(0), data.get(1));
            }
            if (i >= 2) {
                row.put(data.get(i), data.get(i + 1));
                i = i + 1;
            }
        }
        list.add(row);
        System.out.println("Вы добавили в таблицу: " + row);
        System.out.println("Новый лсит: " + "\n" + list);
    }
}