import javax.swing.*;
import java.awt.*;

public class PlanFlight extends JPanel {
    private static final long serialVersionUID = 1L;
    private PilotPal mainFrame;

    public PlanFlight(PilotPal mainFrame) {
        this.mainFrame = mainFrame;
        setupLayout();
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        setBackground(Color.LIGHT_GRAY);

        JLabel label = new JLabel("Flight Planning");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(label, gbc);

        JButton flightPlanButton = new JButton("Flight Plan");
        JButton weatherButton = new JButton("Weather");
        JButton calculationsButton = new JButton("Calculations");

        Dimension buttonSize = new Dimension(300, 50);
        flightPlanButton.setPreferredSize(buttonSize);
        weatherButton.setPreferredSize(buttonSize);
        calculationsButton.setPreferredSize(buttonSize);

        flightPlanButton.addActionListener(e -> openFlightPlanPanel());
        weatherButton.addActionListener(e -> openWeatherPanel());
        calculationsButton.addActionListener(e -> openCalculationsPanel());

        gbc.gridy++;
        add(flightPlanButton, gbc);

        gbc.gridy++;
        add(weatherButton, gbc);

        gbc.gridy++;
        add(calculationsButton, gbc);

        JButton backButton = new JButton("Go Back");
        backButton.setPreferredSize(buttonSize);
        backButton.addActionListener(e -> goBack());
        gbc.gridy++;
        add(backButton, gbc);
    }

    private void openFlightPlanPanel() {
        mainFrame.setContentPane(new FlightPlanPanel(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void openWeatherPanel() {
        mainFrame.setContentPane(new WeatherPanel(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void openCalculationsPanel() {
        mainFrame.setContentPane(new CalculationsPanel(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void goBack() {
        mainFrame.showMainScreen();
    }
}
