import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewHoursLog extends JPanel {
    private static final long serialVersionUID = 1L;
    private PilotPal mainFrame;
    private JTable table;
    public static String[] hoursColumnNames = {"Date", "Night", "Cross Country", "Solo", "PIC", "SIC", "Actual Instrument", "Simulated Instrument"};    
    
    public ViewHoursLog(PilotPal mainFrame) {
        this.mainFrame = mainFrame;
        setupLayout();
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel titleLabel = new JLabel("Hours Log");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 20, 0);
        add(titleLabel, gbc);

        makeTable();

        JLabel totalHoursLabel = new JLabel("Total Hours: " + calculateTotalHours());
        gbc.gridy++;
        gbc.insets = new Insets(0, 0, 10, 0);
        add(totalHoursLabel, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(new JScrollPane(table), gbc);

        JButton goBackButton = new JButton("Go Back");
        goBackButton.setPreferredSize(new Dimension(200, 50));
        goBackButton.addActionListener(e -> goBackToLog());
        gbc.gridy++;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        add(goBackButton, gbc);
    }

    private void makeTable() {
        ArrayList<ArrayList<String>> hoursData = mainFrame.getHoursLogData();
        
        Object[][] data = PilotPal.convertDataList(hoursData);

        table = new JTable(data, hoursColumnNames);
        table.setPreferredScrollableViewportSize(new Dimension(700, 200));
        table.setFillsViewportHeight(true);
    }

    private String calculateTotalHours() {
        ArrayList<ArrayList<String>> hoursData = mainFrame.getHoursLogData();
        double totalHours = 0.0;

        int[] hoursColumnIndices = {1, 2, 3, 4, 5, 6, 7};

        for (ArrayList<String> row : hoursData) {
            for (int index : hoursColumnIndices) {
                if (row.size() > index) {
                    try {
                        String hoursString = row.get(index).replace(" hours", "").trim();
                        if (!hoursString.isEmpty()) {
                            totalHours += Double.parseDouble(hoursString);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing hours from column index " + index + ": " + e.getMessage());
                    }
                }
            }
        }

        return String.format("%.2f", totalHours) + " hours";
    }

    private void goBackToLog() {
        mainFrame.setContentPane(new Log(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }
}
