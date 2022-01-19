/**
 * 
 * @author Reges and Stepp, Building Java Programs
 * modified for CS211 
 * at Bellevue College
 *
 */

// Stuart Reges
// 3/28/07
//
// Class ShoppingFrame provides the user interface for a simple shopping
// program.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class ShoppingFrame extends JFrame {
    private ShoppingCart items;
    private JTextField total;

    public ShoppingFrame(Catalog products)      {
        // create frame and order list
        setTitle(products.getName());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        items = new ShoppingCart();

        // set up text field with order total
        total = new JTextField("$0.00", 12);
        total.setEditable(false);
        total.setEnabled(false);
        total.setDisabledTextColor(Color.BLACK);
        JPanel p = new JPanel();
        p.setBackground(Color.blue);
        JLabel l = new JLabel("order total");
        l.setForeground(Color.YELLOW);
        p.add(l);
        p.add(total);
        add(p, BorderLayout.NORTH);

        p = new JPanel(new GridLayout(products.size(), 1));
        for (int i = 0; i < products.size(); i++)
            addItem(products.get(i), p);
        add(p, BorderLayout.CENTER);

        p = new JPanel();
       add(makeCheckBoxPanel(), BorderLayout.SOUTH);

        // adjust size to just fit
        pack();
    }

    // Sets up the "discount" checkbox for the frame
    private JPanel makeCheckBoxPanel() {
        JPanel p = new JPanel();
        p.setBackground(Color.blue);
        final JCheckBox cb = new JCheckBox("qualify for discount");
        p.add(cb);
        cb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                items.setDiscount(cb.isSelected());
                updateTotal();
            }
        });
        return p;
    }

    // adds a product to the panel, including a textfield for user input of
    // the quantity
    private void addItem(final Item product, JPanel p) {
        JPanel sub = new JPanel(new FlowLayout(FlowLayout.LEFT));
        sub.setBackground(new Color(0, 180, 0));
        final JTextField quantity = new JTextField(3);
        quantity.setHorizontalAlignment(SwingConstants.CENTER);
        quantity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateItem(product, quantity);
                quantity.transferFocus();
            }
        });
        quantity.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                updateItem(product, quantity);
            }
        });
        sub.add(quantity);
        JLabel l = new JLabel("" + product);
        l.setForeground(Color.white);
        sub.add(l);
        p.add(sub);
    }

    // When the user types a new value into one of the quantity fields,
    // parse the input and update the ShoppingCart.  Display an error
    // message if text is not a number or is negative.
    private void updateItem(Item product, JTextField quantity) {
        int number;
        String text = quantity.getText().trim();
        try {
            number = Integer.parseInt(text);
        } catch (NumberFormatException error) {
            number = 0;
        }
        if (number <= 0 && text.length() > 0) {
            Toolkit.getDefaultToolkit().beep();
            quantity.setText("");
            number = 0;
        }
        items.add(new ItemOrder(product, number));
        updateTotal();
    }

    // reset the text field for order total
    private void updateTotal() {
        double amount = items.getTotal();
        total.setText(NumberFormat.getCurrencyInstance().format(amount));
    }
}
