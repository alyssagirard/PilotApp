import javax.swing.*;
import java.awt.*;

public class CPLPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private PilotPal mainFrame;

    public CPLPanel(PilotPal mainFrame) {
        this.mainFrame = mainFrame;
        setupLayout();
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("Commercial Pilot License (CPL) Details");
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
            "To obtain a commercial certificate in an airplane under FAR Part 61 rules a pilot must have:\n\n" +
            "250 hours of flight time, 100 hours of which must be in powered aircraft, and 50 must be in airplanes.\n" +
            "100 hours of pilot-in-command time, 50 of which must be in airplanes.\n" +
            "50 hours of cross-country time, 10 of which must be in an airplane.\n" +
            "20 hours of training, including 10 of instrument, 10 of complex or TAA, and a smattering of cross-country and practical test preparation.\n" +
            "10 hours of solo training, including a smattering of cross-country and night."
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
