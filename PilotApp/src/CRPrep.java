import javax.swing.*;
import java.awt.*;

public class CRPrep extends JPanel {
    private static final long serialVersionUID = 1L;
    private PilotPal mainFrame;

    public CRPrep(PilotPal mainFrame) {
        this.mainFrame = mainFrame;
        setupLayout();
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        setBackground(Color.LIGHT_GRAY);

        JLabel label = new JLabel("Select License:");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(label, gbc);

        JButton pplButton = new JButton("Private Pilot License (PPL)");
        JButton cplButton = new JButton("Commercial Pilot License (CPL)");
        JButton irButton = new JButton("Instrument Rating (IR)");
        JButton multiEngineButton = new JButton("Multi Engine Rating");
        JButton cfiButton = new JButton("Flight Instructor Certificate (CFI)");

        Dimension buttonSize = new Dimension(300, 50);
        pplButton.setPreferredSize(buttonSize);
        cplButton.setPreferredSize(buttonSize);
        irButton.setPreferredSize(buttonSize);
        multiEngineButton.setPreferredSize(buttonSize);
        cfiButton.setPreferredSize(buttonSize);

        pplButton.addActionListener(e -> openPPLPanel());
        cplButton.addActionListener(e -> openCPLPanel());
        irButton.addActionListener(e -> openIRPanel());
        multiEngineButton.addActionListener(e -> openMultiEnginePanel());
        cfiButton.addActionListener(e -> openCFIPanel());

        gbc.gridy++;
        add(pplButton, gbc);

        gbc.gridy++;
        add(cplButton, gbc);

        gbc.gridy++;
        add(irButton, gbc);

        gbc.gridy++;
        add(multiEngineButton, gbc);

        gbc.gridy++;
        add(cfiButton, gbc);

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(buttonSize);
        backButton.addActionListener(e -> goBack());
        gbc.gridy++;
        add(backButton, gbc);
    }

    private void openPPLPanel() {
        mainFrame.setContentPane(new PPLPanel(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void openCPLPanel() {
        mainFrame.setContentPane(new CPLPanel(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void openIRPanel() {
        mainFrame.setContentPane(new IRPanel(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void openMultiEnginePanel() {
        mainFrame.setContentPane(new MultiEnginePanel(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void openCFIPanel() {
        mainFrame.setContentPane(new CFIPanel(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void goBack() {
        mainFrame.showMainScreen();
    }
}
