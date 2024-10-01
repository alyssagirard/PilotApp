import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewFlightLog extends JPanel {
    private static final long serialVersionUID = 1L;
    private PilotPal mainFrame;
    private JTable table;
    public static String[] flightColumnNames = {"Date", "Flight Time", "Departure Airport", "Arrival Airport", "Aircraft Type", "Aircraft Registration", "Safety Pilot"};

    public ViewFlightLog(PilotPal mainFrame) {
        this.mainFrame = mainFrame;
        setupLayout();
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel label = new JLabel("Flight Log");
        label.setFont(new Font("Arial", Font.BOLD, 24));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 20, 0);
        gbc.gridwidth = 2;
        add(label, gbc);
        
        makeTable();
        gbc.gridy++;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridwidth = 1;
        add(new JScrollPane(table), gbc);

        JButton goBackButton = new JButton("Go Back");
        goBackButton.setPreferredSize(new Dimension(200, 50));
        goBackButton.addActionListener(e -> goBackToLog());
        gbc.gridy++;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(20, 0, 0, 0);
        add(goBackButton, gbc);
    }
    
    private void makeTable() {
        ArrayList<ArrayList<String>> flightData = mainFrame.getFlightLogData();

        Object[][] lists = PilotPal.convertDataList(flightData);
        
        table = new JTable(lists, flightColumnNames);
        table.setPreferredScrollableViewportSize(new Dimension(700, 200));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private void goBackToLog() {
        mainFrame.setContentPane(new Log(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
