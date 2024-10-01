import javax.swing.*;
import java.awt.*;

public class MultiEnginePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private PilotPal mainFrame;

    public MultiEnginePanel(PilotPal mainFrame) {
        this.mainFrame = mainFrame;
        setupLayout();
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        JLabel titleLabel = new JLabel("Multi Engine Rating Details");
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

        JTextArea requirementsTextArea = new JTextArea("Enter text here");
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
