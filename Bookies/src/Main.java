import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bookies");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with CardLayout
        JPanel panelMain = new JPanel(new CardLayout());
        frame.add(panelMain);

        // CardLayout for switching panels
        CardLayout cardLayout = (CardLayout) panelMain.getLayout();

        // Panel: Main screen
        JPanel mainScreen = new JPanel();
        mainScreen.setLayout(new BoxLayout(mainScreen, BoxLayout.Y_AXIS));
        mainScreen.setOpaque(false);

        // Logo and icon
        ImageIcon logoIcon = new ImageIcon("logo.png");
        JLabel logoLabel = new JLabel(new ImageIcon(logoIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainScreen.add(logoLabel);
        frame.setIconImage(logoIcon.getImage());

        // Title and subtitle
        JLabel title = new JLabel("Welcome to Bookies!");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainScreen.add(title);

        JLabel subtitle = new JLabel("Please log in or register if you haven't already");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainScreen.add(subtitle);

        // Buttons: Login and Register
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Panel for buttons
        buttonPanel.setOpaque(false);

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 40)); // Size of a button
        loginButton.setFont(new Font("Arial", Font.PLAIN, 15)); // Text font
        loginButton.setBackground(new Color(76, 175, 80)); // Background color to green
        loginButton.setForeground(Color.WHITE); // Text color to white
        buttonPanel.add(loginButton);

        JButton registerButton = new JButton("Register");
        registerButton.setPreferredSize(new Dimension(100, 40)); // Size of a button
        registerButton.setFont(new Font("Arial", Font.PLAIN, 15)); // Text font
        registerButton.setBackground(new Color(59,80, 182)); // Background color to blue
        registerButton.setForeground(Color.WHITE); // Text color to white
        buttonPanel.add(registerButton);

        mainScreen.add(buttonPanel);

        // Add main screen to panelMain
        panelMain.add(mainScreen, "Main");


        // The reason I am creating to separate buttons is that I ran into a bug that caused that back button
        // appeared only in login or register panels, making 2 buttons was the simplest way to fix that, may change it later on
        JButton loginbackButton = new JButton("Back");
        loginbackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginbackButton.setPreferredSize(new Dimension(100, 40)); // Size of a button
        loginbackButton.setFont(new Font("Arial", Font.PLAIN, 15)); // Text font
        loginbackButton.setBackground(new Color(220, 53, 69)); // Background color to blue
        loginbackButton.setForeground(Color.WHITE); // Text color to white

        // Register back button
        JButton registerbackButton = new JButton("Back");
        registerbackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerbackButton.setPreferredSize(new Dimension(100, 40)); // Size of a button
        registerbackButton.setFont(new Font("Arial", Font.PLAIN, 15)); // Text font
        registerbackButton.setBackground(new Color(220, 53, 69)); // Background color to blue
        registerbackButton.setForeground(Color.WHITE); // Text color to white

        // Register accept button
        JButton registeracceptButton = new JButton("Accept");
        registeracceptButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registeracceptButton.setPreferredSize(new Dimension(100, 40)); // Size of a button
        registeracceptButton.setFont(new Font("Arial", Font.PLAIN, 15)); // Text font
        registeracceptButton.setBackground(new Color(76, 175, 80)); // Background color to blue
        registeracceptButton.setForeground(Color.WHITE); // Text color to white

        // Login accept button
        JButton loginAcceptButton = new JButton("Accept");
        loginAcceptButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginAcceptButton.setPreferredSize(new Dimension(100, 40)); // Size of a button
        loginAcceptButton.setFont(new Font("Arial", Font.PLAIN, 15)); // Text font
        loginAcceptButton.setBackground(new Color(76, 175, 80)); // Background color to green
        loginAcceptButton.setForeground(Color.WHITE); // Text color to white

        // Panel: Home page
        JPanel homePage = new JPanel();
        homePage.setLayout(new BoxLayout(homePage, BoxLayout.Y_AXIS));
        JLabel welcomeLabel = new JLabel("Welcome to !");
        // Panel: Login screen
        JPanel loginScreen = new JPanel();
        loginScreen.setLayout(new BoxLayout(loginScreen, BoxLayout.Y_AXIS));

        JLabel loginTitle = new JLabel("Login");
        loginTitle.setFont(new Font("Arial", Font.BOLD, 20));
        loginTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginScreen.add(loginTitle);

        // Panel for form elements
        JPanel formLoginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcLogin = new GridBagConstraints();
        gbcLogin.insets = new Insets(5, 5, 5, 5);
        gbcLogin.fill = GridBagConstraints.HORIZONTAL;

        // "Username" label and field
        gbcLogin.gridx = 0;
        gbcLogin.gridy = 0;
        gbcLogin.anchor = GridBagConstraints.LINE_END;
        formLoginPanel.add(new JLabel("Username:"), gbcLogin);

        gbcLogin.gridx = 1;
        gbcLogin.gridy = 0;
        gbcLogin.anchor = GridBagConstraints.LINE_START;
        JTextField usernameLoginField = new JTextField();
        usernameLoginField.setPreferredSize(new Dimension(300, 20));
        formLoginPanel.add(usernameLoginField, gbcLogin);

        // "Password" label and field
        gbcLogin.gridx = 0;
        gbcLogin.gridy = 1;
        gbcLogin.anchor = GridBagConstraints.LINE_END;
        formLoginPanel.add(new JLabel("Password:"), gbcLogin);

        gbcLogin.gridx = 1;
        gbcLogin.gridy = 1;
        gbcLogin.anchor = GridBagConstraints.LINE_START;
        JPasswordField passwordLoginField = new JPasswordField();
        passwordLoginField.setPreferredSize(new Dimension(300, 20));
        formLoginPanel.add(passwordLoginField, gbcLogin);

        // Back button
        gbcLogin.gridx = 0;
        gbcLogin.gridy = 2;
        gbcLogin.anchor = GridBagConstraints.LINE_END;
        formLoginPanel.add(loginbackButton, gbcLogin);

        // Accept button
        gbcLogin.gridx = 1;
        gbcLogin.gridy = 2;
        gbcLogin.anchor = GridBagConstraints.LINE_START;
        formLoginPanel.add(loginAcceptButton, gbcLogin);

        // Panel for error login message
        JLabel errorLoginLabel = new JLabel();
        errorLoginLabel.setForeground(Color.RED);
        errorLoginLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        errorLoginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        errorLoginLabel.setText(" ");

        loginScreen.add(errorLoginLabel);

        // Add form panel to login screen
        loginScreen.add(Box.createVerticalStrut(10)); // Add some spacing
        loginScreen.add(formLoginPanel);

        // Panel: Register screen
        JPanel registerScreen = new JPanel();
        registerScreen.setLayout(new BoxLayout(registerScreen, BoxLayout.Y_AXIS));

        JLabel registerTitle = new JLabel("Register");
        registerTitle.setFont(new Font("Arial", Font.PLAIN, 50));
        registerTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerScreen.add(registerTitle);

        JPanel formRegisterPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcRegister = new GridBagConstraints();
        gbcRegister.fill = GridBagConstraints.HORIZONTAL;
        gbcRegister.insets = new Insets(5, 5, 5, 5);

        // "Username" label and field
        gbcRegister.gridx = 0; // Column 0
        gbcRegister.gridy = 0; // Verse 0
        gbcRegister.anchor = GridBagConstraints.LINE_END; // Alignment to the right
        formRegisterPanel.add(new JLabel("Username:"), gbcRegister);

        gbcRegister.gridx = 1; // Column 1
        gbcRegister.gridy = 0; // Verse 0
        gbcRegister.anchor = GridBagConstraints.LINE_START; // Alignment to the left
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(300, 20));
        formRegisterPanel.add(nameField, gbcRegister);

        //"Password" label and field
        gbcRegister.gridx = 0;
        gbcRegister.gridy = 1;
        gbcRegister.anchor = GridBagConstraints.LINE_END;
        formRegisterPanel.add(new JLabel("Password:"), gbcRegister);

        gbcRegister.gridx = 1;
        gbcRegister.gridy = 1;
        gbcRegister.anchor = GridBagConstraints.LINE_START;
        JPasswordField registerPasswordField = new JPasswordField();
        registerPasswordField.setPreferredSize(new Dimension(300, 20));
        formRegisterPanel.add(registerPasswordField, gbcRegister);

        //"Confirm Password" label and field
        gbcRegister.gridx = 0;
        gbcRegister.gridy = 3;
        gbcRegister.anchor = GridBagConstraints.LINE_END;
        formRegisterPanel.add(new JLabel("Confirm Password:"), gbcRegister);

        gbcRegister.gridx = 1;
        gbcRegister.gridy = 3;
        gbcRegister.anchor = GridBagConstraints.LINE_START;
        JPasswordField confirmPassField = new JPasswordField();
        confirmPassField.setPreferredSize(new Dimension(300, 20));
        formRegisterPanel.add(confirmPassField, gbcRegister);

        // "Email" label and field
        gbcRegister.gridx = 0; // Column 0
        gbcRegister.gridy = 4; // Verse 3
        gbcRegister.anchor = GridBagConstraints.LINE_END; // Alignment to the right
        formRegisterPanel.add(new JLabel("Email:"), gbcRegister);

        gbcRegister.gridx = 1; // Column 1
        gbcRegister.gridy = 4; // Verse 3
        gbcRegister.anchor = GridBagConstraints.LINE_START; // Alignment to the left
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(300, 20));
        formRegisterPanel.add(emailField, gbcRegister);

        // "Phone" label and field
        gbcRegister.gridx = 0; // Column 0
        gbcRegister.gridy = 5; // Verse 4
        gbcRegister.anchor = GridBagConstraints.LINE_END; // Alignment to the right
        formRegisterPanel.add(new JLabel("Phone number:"), gbcRegister);

        gbcRegister.gridx = 1; // Column 1
        gbcRegister.gridy = 5; // Verse 4
        gbcRegister.anchor = GridBagConstraints.LINE_START; // Alignment to the left
        JTextField phoneField = new JTextField();
        phoneField.setPreferredSize(new Dimension(300, 20));
        formRegisterPanel.add(phoneField, gbcRegister);

        //Buttons
        gbcRegister.gridx = 0;
        gbcRegister.gridy = 6;
        gbcRegister.anchor = GridBagConstraints.LINE_END;
        formRegisterPanel.add(registerbackButton, gbcRegister);

        gbcRegister.gridx = 1;
        gbcRegister.gridy = 6;
        gbcRegister.anchor = GridBagConstraints.LINE_START;
        formRegisterPanel.add(registeracceptButton, gbcRegister);

        //Password instruction
        gbcRegister.gridx = 1;
        gbcRegister.gridy = 2;
        JLabel passwordHint = new JLabel("<html>Password must:<br>- Be at least 9 characters long<br>- Contain one uppercase letter<br>- Contain one number<br>- Contain one special character</html>");
        passwordHint.setFont(new Font("Arial", Font.PLAIN, 8));
        formRegisterPanel.add(passwordHint, gbcRegister);

        // Panel for error register message
        JLabel errorRegisterLabel = new JLabel();
        errorRegisterLabel.setForeground(Color.RED);
        errorRegisterLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        errorRegisterLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        errorRegisterLabel.setText(" ");

        registerScreen.add(errorRegisterLabel);

        //formPanel to registerScreen
        registerScreen.add(formRegisterPanel);

        panelMain.add(loginScreen, "Login");
        panelMain.add(registerScreen, "Register");

        // Action listeners for buttons
        String url = "jdbc:mysql://127.0.0.1:3306/bookies-scheme";
        String user = "root";
        String rootPassword = "YOU HAVE TO CHANGE IT";
        DatabaseManager databaseManager = new DatabaseManager(url, user, rootPassword);;

        loginButton.addActionListener(e -> cardLayout.show(panelMain, "Login")); // Using lambda to switch panels
        registerButton.addActionListener(e -> cardLayout.show(panelMain, "Register")); // Using lambda to switch panels
        loginbackButton.addActionListener(e -> cardLayout.show(panelMain, "Main")); // Using lambda to switch panels
        registerbackButton.addActionListener(e -> cardLayout.show(panelMain, "Main")); // Using lambda to switch panels
        loginAcceptButton.addActionListener(e -> {
            String loginUsername = usernameLoginField.getText();
            String loginPassword = new String(passwordLoginField.getPassword());
            try {
                if (databaseManager.isUserExists(loginUsername)) {
                    String storedHashedPassword = databaseManager.getHashedPassword(loginUsername);
                    if (PasswordHasher.checkPassword(loginPassword, storedHashedPassword)) {
                        errorLoginLabel.setText("Logged in");
                        HomepagePanel homepagePanel = new HomepagePanel();
                        panelMain.add(homepagePanel, "Homepage");
                        cardLayout.show(panelMain, "Homepage");
                    } else {
                        errorLoginLabel.setText("Invalid username or password");
                    }
                } else {
                    errorLoginLabel.setText("Invalid username or password");
                }
            } catch (SQLException ex) {
                errorLoginLabel.setText("An error accured while logging in please try again later");
                ex.printStackTrace();
            }
        });

        registeracceptButton.addActionListener(e -> {
            String username = nameField.getText().trim();
            String password = new String(registerPasswordField.getPassword());
            String confirmPassword = new String(confirmPassField.getPassword());
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();

            if (!InputValidation.isPasswordValid(password)) {
                errorRegisterLabel.setText("Password must include an uppercase letter, a number, a special character, and be at least 9 characters long.");
                return;
            }

            if (!password.equals(confirmPassword)) {
                errorRegisterLabel.setText("Passwords do not match.");
                return;
            }

            if (!InputValidation.isEmailValid(email)){
                errorRegisterLabel.setText("Invalid email address.");
                return;
            }

            if (!InputValidation.isPhoneValid(phone)){
                errorRegisterLabel.setText("Invalid phone number.");
                return;
            }


            try {
                String hashedPassword = PasswordHasher.hashPassword(password);

                if (databaseManager.isUserExists(username)) {
                    errorRegisterLabel.setText("Username already exists. Please choose another.");
                    return;
                }

                if (databaseManager.isEmailExists(email)) {
                    errorRegisterLabel.setText("This mail is already used. Please choose another.");
                    return;
                }

                if (databaseManager.isPhoneExists(phone)) {
                    errorRegisterLabel.setText("This phone number is already used. Please choose another.");
                    return;
                }

                databaseManager.addUser(username, hashedPassword, email, phone);

                errorRegisterLabel.setText("Registration successful!");
            } catch (Exception ex) {
                errorRegisterLabel.setText("An error occurred while registering. Please try again.");
                ex.printStackTrace();
            }
            cardLayout.show(panelMain, "Login");
        });

        // Frame visibility
        frame.setVisible(true);


    }
}