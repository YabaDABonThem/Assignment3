// Allen Bao
// 1/18/2022
// CS 211
// The Catalog class for Assignment 3 in CS 211

import java.util.ArrayList;

public class Catalog {

    private String name;
    private ArrayList<Item> items;

    public Catalog(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void add(Item itemToAdd) {
        items.add(itemToAdd);
    }

    public int size() {
        return items.size();
    }

    public Item get(int index) {
        return items.get(index);
    }

    public String getName() {
        return name;
    }


}
