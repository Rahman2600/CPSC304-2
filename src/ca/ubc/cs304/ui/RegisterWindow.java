//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ca.ubc.cs304.ui;

import ca.ubc.cs304.delegates.RegisterWindowDelegate;
import ca.ubc.cs304.model.Customer;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterWindow extends JFrame implements ActionListener {
    private static final int TEXT_FIELD_WIDTH = 10;
    private static final int MAX_LOGIN_ATTEMPTS = 3;
    private JTextField enter_your_name;
    private JTextField enter_your_address;
    private JTextField your_driving_license;
    private RegisterWindowDelegate registerWindowDelegate;

    public RegisterWindow() {
        super("User Login");
    }

    public void showFrame(RegisterWindowDelegate delegate) {
        this.registerWindowDelegate = delegate;
        JFrame frame = new JFrame();
        frame.setTitle("SUPER RENT");
        frame.setDefaultCloseOperation(3);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo((Component)null);
        JButton newUser = new JButton("Register");
        frame.setVisible(true);
        JLabel label = new JLabel("New User?");
        JPanel contentPane = new JPanel();
        this.setContentPane(contentPane);
        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        contentPane.setLayout(gb);
        contentPane.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        JLabel name = new JLabel("Enter username: ");
        JLabel address = new JLabel("Enter your address: ");
        JLabel drivers_license = new JLabel("Enter your drivers license: ");
        frame.add(contentPane);
        this.enter_your_name = new JTextField(10);
        this.enter_your_address = new JTextField(10);
        this.your_driving_license = new JTextField(10);
        c.gridwidth = 0;
        c.insets = new Insets(10, 0, 5, 10);
        gb.setConstraints(label, c);
        contentPane.add(label);
        c.gridwidth = -1;
        c.insets = new Insets(10, 0, 5, 10);
        gb.setConstraints(name, c);
        contentPane.add(name);
        c.gridwidth = 0;
        c.insets = new Insets(10, 0, 5, 10);
        gb.setConstraints(this.enter_your_name, c);
        contentPane.add(this.enter_your_name);
        c.gridwidth = -1;
        c.insets = new Insets(10, 0, 5, 10);
        gb.setConstraints(address, c);
        contentPane.add(address);
        c.gridwidth = 0;
        c.insets = new Insets(10, 0, 5, 10);
        gb.setConstraints(this.enter_your_address, c);
        contentPane.add(this.enter_your_address);
        c.gridwidth = -1;
        c.insets = new Insets(10, 0, 5, 10);
        gb.setConstraints(drivers_license, c);
        contentPane.add(drivers_license);
        c.gridwidth = 0;
        c.insets = new Insets(10, 0, 5, 10);
        gb.setConstraints(this.your_driving_license, c);
        contentPane.add(this.your_driving_license);
        c.gridwidth = 0;
        c.insets = new Insets(5, 10, 10, 10);
        c.anchor = 10;
        gb.setConstraints(newUser, c);
        contentPane.add(newUser);
        frame.pack();
        this.enter_your_name.requestFocus();
        newUser.addActionListener(this);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent actionEvent) {
        new Customer(this.enter_your_name.getText(), this.enter_your_address.getText(), this.your_driving_license.getText());
        this.enter_your_name.setText("");
        this.enter_your_address.setText("");
        this.your_driving_license.setText("");
    }
}
