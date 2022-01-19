// Allen Bao
// 1/18/2022
// CS 211
// The ShoppingCart class for Assignment 3 in CS 211

import java.util.ArrayList;

public class ShoppingCart {
    // declare private fields
    private ArrayList<ItemOrder> itemInfos;
    private boolean isDiscount;

    public ShoppingCart() {
        this.itemInfos = new ArrayList<>();
        // should default to not being a discounted item
        isDiscount = false;
    }

    public void add(ItemOrder itemInfo) {
        // replace any previous order for this item with the new order
        for (int i = 0; i < itemInfos.size(); ++i) {
            if (itemInfo.getItem() == itemInfos.get(i).getItem()){
                itemInfos.set(i, itemInfo);
                return;
            }
        }
        itemInfos.add(itemInfo);
    }

    public void setDiscount(boolean isDiscount) {
        if (isDiscount) {
            this.isDiscount = isDiscount;
        }
    }

    public double getTotal() {
        double totalCost = 0;

        for (ItemOrder i : itemInfos) {
            totalCost += i.getPrice();
        }

        return isDiscount ? totalCost * 0.9 : totalCost;
    }
}
