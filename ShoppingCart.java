// Allen Bao
// 1/18/2022
// CS 211
// The ShoppingCart class for Assignment 3 in CS 211

// import libraries
import java.util.ArrayList;

public class ShoppingCart {
    // declare private fields
    private ArrayList<ItemOrder> itemInfos;
    private boolean isDiscount;

    // constructor
    public ShoppingCart() {
        this.itemInfos = new ArrayList<>();
        // should default to not being a discounted item
        isDiscount = false;
    }

    // this method manages the items in the itemInfos arraylist
    public void add(ItemOrder itemInfo) {
        // replace any previous order for this item with the new order
        for (int i = 0; i < itemInfos.size(); ++i) {
            // go through the arraylist until you find the same item
            if (itemInfo.getItem() == itemInfos.get(i).getItem()){
                itemInfos.set(i, itemInfo);
                return; // empty return works on void method
            }
        }
        // if there isn't a previous order for that item, add it
        itemInfos.add(itemInfo);
    }

    public void setDiscount(boolean isDiscount) {
        // apply discount if the user is qualified for one
        if (isDiscount) {
            this.isDiscount = isDiscount;
        }
    }

    public double getTotal() {
        // loop through the items and find the total cost
        double totalCost = 0;

        for (ItemOrder i : itemInfos) {
            totalCost += i.getPrice();
        }

        // use tertiary operators; if the user qualifies for discount take 10% off their total
        return isDiscount ? totalCost * 0.9 : totalCost;
    }
}
