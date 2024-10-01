import javax.swing.*;
import java.awt.*;

public class PPLPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private PilotPal mainFrame;

    public PPLPanel(PilotPal mainFrame) {
        this.mainFrame = mainFrame;
        setupLayout();
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("Private Pilot License (PPL) Details");
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
            "Total Time: 40 hours flying minimum which consists of at least:\n\n" +
            "Dual: 20 hours minimum of flight training with an instructor on the Private Pilot areas of operation including:\n" +
            "3 hours of cross country flight training in a single engine airplane;\n" +
            "3 hours of night flight training in a single engine airplane, that includes at least:\n" +
            "a) 1 cross country flight of over 100 nm total distance; and\n" +
            "b) 10 T/O’s and 10 landings to a full stop with each involving a flight in the traffic pattern at an airport.\n" +
            "3 hours of flight training by reference to instruments in a single engine airplane; and\n" +
            "3 hours of flight training in a single engine airplane within the 60 days prior to the practical test.\n\n" +
            "Solo: 10 hours minimum of solo flying in a single engine airplane on the Private Pilot areas of operation including:\n" +
            "5 hours of solo cross country flying;\n" +
            "1 solo cross country flight of at least 150nm total distance with full stop landings at 3 points and one segment of at least 50nm between T/O and landings; and\n" +
            "3 T/O’s and landings to a full stop at an airport with an operating control tower."
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
