import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class CreateUserPage extends JFrame implements ActionListener {
    // Declare Swing components
    private JLabel emailLabel, passwordLabel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton createButton, clearButton;

    // Declare database connection variables
    private Connection conn;
    private Statement stmt;

    public CreateUserPage() {
        // Set window properties
        setTitle("Create User");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        createButton = new JButton("Create");
        createButton.addActionListener(this);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);

        // Create layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add email label and field to layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(emailLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(emailField, gbc);

        // Add password label and field to layout
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passwordField, gbc);

        // Add buttons to layout
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(createButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(clearButton, gbc);

        // Connect to database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///CreateUsers", "root", "Jj901026122515");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        // Show window
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle button clicks
        if (e.getSource() == createButton) {
            // Get user input
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            // Validate input
            if (email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter all fields");
            } else {
                // Hash password for security
                String hashedPassword = hashPassword(password);

                // Insert new user into database
                try {
                    String sql = "INSERT INTO users (email, password) VALUES ('" + email + "', '" + hashedPassword + "')";
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(this, "User created successfully");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error creating user");
                }
            }
        } else if (e.getSource() == clearButton) {
            // Clear input fields
            emailField.setText("");
            passwordField.setText("");
        }
    }

    private String hashPassword(String password) {
        try {
            // Create message digest object for SHA-256 algorithm
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Generate hash from password bytes
            byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Convert hash bytes to hexadecimal representation
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        new CreateUserPage();
    }
}
