// Allen Bao
// 1/18/2022
// CS 211
// The ItemOrder class for Assignment 3 in CS 211

public class ItemOrder {
    // declare private fields
    private Item orderedItem;
    private int quantity;

    public ItemOrder(Item orderedItem, int quantity) {
        this.orderedItem = orderedItem;
        this.quantity = quantity;
    }

    public double getPrice() {
        return orderedItem.priceFor(quantity);
    }

    public Item getItem() {
        return orderedItem;
    }

}
