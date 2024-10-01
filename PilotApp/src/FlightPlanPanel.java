import javax.swing.*;
import java.awt.*;

public class FlightPlanPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private PilotPal mainFrame;

    public FlightPlanPanel(PilotPal mainFrame) {
        this.mainFrame = mainFrame;
        setupLayout();
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel label = new JLabel("Flight Plan");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);


        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> goBack());
        add(backButton, BorderLayout.SOUTH);
    }

    private void goBack() {
        mainFrame.setContentPane(new PlanFlight(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
