// Allen Bao
// 1/18/2022
// CS 211
// The Item class for Assignment 3 in CS 211

import java.text.*;

public class Item {

    // declare fields
    private String name;
    private double price;
    private int bulkQuantity;
    private double bulkPrice;

    public Item(String name, double price) throws IllegalArgumentException{
        if (price < 0) {
            //
            throw new IllegalArgumentException();
        }

        //
        this.name = name;
        this.price = price;
        // set the bulk quantity to -1 so that bulk price isn't applied.
        this.bulkQuantity = -1;
        this.bulkPrice = price;
    }

    public Item(String name, double price, int bulkQuantity, double bulkPrice) throws IllegalArgumentException {
        if(price < 0 || bulkQuantity < 0 || bulkPrice < 0) {
            // throw exception either the price, bulk quantity, or bulk price is negative
            throw new IllegalArgumentException();
        }

        //
        this.name = name;
        this.price = price;
        this.bulkQuantity = bulkQuantity;
        this.bulkPrice = bulkPrice;
    }

    public double priceFor(int quantity) throws IllegalArgumentException {
        // throw exception if negative items
        if (quantity < 0) {
            throw new IllegalArgumentException();
        }
        // if there's a bulk price then apply it to as many items as possible
        double totalPrice = 0;

        if (hasBulkPrice() && quantity >= bulkQuantity) {
            // apply bulk price to all the items that qualify
            totalPrice += (quantity / bulkQuantity) * bulkPrice;
            // second statement applies the normal price to all the remaining items
            totalPrice += (quantity % bulkQuantity) * price;

            return totalPrice;
        }

        totalPrice += quantity * price;

        return totalPrice;

    }

    public String toString() {

        // create a NumberFormat instance
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String textPrice = nf.format(price);
        // if there's a bulk price, then state the price and quantity needed
        if (hasBulkPrice()) {
            String textBulkPrice = nf.format(bulkPrice);
            return name + ", " + textPrice + " (" + bulkQuantity + " for " + textBulkPrice + ")";
        }
        // if there's no bulk price, then return the normal price per item
        return name + ", " + textPrice;
    }

    private boolean hasBulkPrice() {
        return bulkQuantity >= 0;
    }
}
