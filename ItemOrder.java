// Allen Bao
// 1/18/2022
// CS 211
// The ItemOrder class for Assignment 3 in CS 211

public class ItemOrder {
    // declare private fields
    private Item orderedItem;
    private int quantity;

    // constructor
    public ItemOrder(Item orderedItem, int quantity) {
        // set default values to the arguments passed in
        this.orderedItem = orderedItem;
        this.quantity = quantity;
    }

    // call the item's priceFor() class for with the provided quantity and return that value
    public double getPrice() {
        return orderedItem.priceFor(quantity);
    }

    // getter for the item we're getting info for
    public Item getItem() {
        return orderedItem;
    }

}
