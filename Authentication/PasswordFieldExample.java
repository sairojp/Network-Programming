import javax.swing.*;

public class PasswordFieldExample extends JFrame {
    public PasswordFieldExample() {
        super("Password Field Example");
        JPanel panel = new JPanel();
        JPasswordField passwordField = new JPasswordField(10);
        panel.add(new JLabel("Enter password:"));
        panel.add(passwordField);
        JButton button = new JButton("Get Password");
        button.addActionListener(e -> {
            char[] password = passwordField.getPassword();
            System.out.println("Entered password: " + new String(password));
        });
        panel.add(button);
        getContentPane().add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new PasswordFieldExample();
    }
}