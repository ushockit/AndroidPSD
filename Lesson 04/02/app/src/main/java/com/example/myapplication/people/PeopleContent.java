package com.example.myapplication.people;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleContent {
    public static final List<PersonItem> ITEMS = new ArrayList<>();
    public static final Map<String, PersonItem> ITEM_MAP = new HashMap<>();
    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(PersonItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PersonItem createDummyItem(int position) {
        return new PersonItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static class PersonItem {
        public final String id;
        public final String content;
        public final String details;

        public PersonItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}