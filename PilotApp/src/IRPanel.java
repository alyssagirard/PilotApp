import javax.swing.*;
import java.awt.*;

public class IRPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private PilotPal mainFrame;

    public IRPanel(PilotPal mainFrame) {
        this.mainFrame = mainFrame;
        setupLayout();
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("Instrument Rating (IR) Details");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        textPanel.setBackground(Color.LIGHT_GRAY);

        JLabel requirementsLabel = new JLabel("Requirements");
        requirementsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        requirementsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textPanel.add(requirementsLabel, BorderLayout.NORTH);

        JTextArea requirementsTextArea = new JTextArea(
            "50 hours of cross-country flight time as pilot in command\n" +
            "Forty hours of actual or simulated instrument time, including 15 hours must have been received from an authorized instructor\n" +
            "Three hours of instrument flight training within two calendar months before the check ride\n" +
            "A cross country flight of 250 nautical miles, that includes an instrument approach at each airport, and three different kinds of approaches (for example, VOR, ILS, GPS)"
        );
        requirementsTextArea.setEditable(false);
        requirementsTextArea.setBackground(Color.LIGHT_GRAY);
        requirementsTextArea.setLineWrap(true);
        requirementsTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(requirementsTextArea);
        scrollPane.setPreferredSize(new Dimension(500, 200));
        textPanel.add(scrollPane, BorderLayout.CENTER);

        add(textPanel, BorderLayout.CENTER);

        JButton goBackButton = new JButton("Go Back");
        goBackButton.setPreferredSize(new Dimension(200, 50));
        goBackButton.addActionListener(e -> goBack());
        add(goBackButton, BorderLayout.SOUTH);
    }

    private void goBack() {
        mainFrame.setContentPane(new CRPrep(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
