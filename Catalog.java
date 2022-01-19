// Allen Bao
// 1/18/2022
// CS 211
// The Catalog class for Assignment 3 in CS 211

// import libraries
import java.util.ArrayList;

public class Catalog {

    // declare private fields
    private String name;
    private ArrayList<Item> items;

    // constructor
    public Catalog(String name) {
        // set default values
        this.name = name;
        this.items = new ArrayList<>();
    }

    // method that adds the given item to the ArrayList
    public void add(Item itemToAdd) {
        items.add(itemToAdd);
    }

    // getter that returns the size of the array
    public int size() {
        return items.size();
    }

    // getter that returns the item at a certain index
    public Item get(int index) {
        return items.get(index);
    }

    // gets the name of the catalog
    public String getName() {
        return name;
    }


}
