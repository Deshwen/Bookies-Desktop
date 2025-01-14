import javax.swing.*;
import java.awt.*;

public class HomepagePanel extends JPanel {
    public HomepagePanel() {
        setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JButton logoutButton = new JButton("Logout");
        add(welcomeLabel, BorderLayout.NORTH);
    }
}
