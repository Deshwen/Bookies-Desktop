import java.sql.*;

public class DatabaseManager {
    private String url;
    private String user;
    private String password;

    // Constructor to initialize database credentials
    public DatabaseManager(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    // Method to connect to the database
    public Connection connect() throws SQLException {
        System.out.println("Connecting to database...");
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected!");
        return connection;
    }

    public String getHashedPassword(String username) throws SQLException {
        String hashedPassword = null;
        String query = "SELECT password FROM USERS WHERE username = ?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    hashedPassword = resultSet.getString("password");
                }
            }
        }
        return hashedPassword;
    }

    public boolean isUserExists(String username) throws SQLException {
        String query = "SELECT COUNT(*) FROM USERS WHERE username = ?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public boolean isEmailExists(String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM USERS WHERE mail = ?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public boolean isPhoneExists(String phone) throws SQLException {
        String query = "SELECT COUNT(*) FROM USERS WHERE phone = ?";
        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, phone);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public void addUser(String userUsername, String userPassword, String userMail, String userPhone) {
        String insertQuery = "INSERT INTO USERS (username, password, mail, phone) VALUES (?, ?, ?, ?)";

        try (Connection connection = connect();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, userUsername);
            preparedStatement.setString(2, userPassword);
            preparedStatement.setString(3, userMail);
            preparedStatement.setString(4, userPhone);

            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("User added successfully!");
            } else {
                System.out.println("Failed to add user.");
            }

        } catch (SQLException e) {
            System.out.println("Error while adding user.");
            e.printStackTrace();
        }
    }
}