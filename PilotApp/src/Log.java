import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Log extends JPanel {
    private static final long serialVersionUID = 1L;
    private JButton viewFlightLogButton;
    private JButton viewHoursLogButton;
    private JButton logHoursButton;
    private PilotPal mainFrame;

    public Log(PilotPal mainFrame) {
        this.mainFrame = mainFrame;
        setupLayout();
    }

    private void setupLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        viewFlightLogButton = new JButton("View Flight Log");
        viewHoursLogButton = new JButton("View Hours Log");
        logHoursButton = new JButton("Log Hours");

        Dimension buttonSize = new Dimension(200, 50);
        viewFlightLogButton.setPreferredSize(buttonSize);
        viewHoursLogButton.setPreferredSize(buttonSize);
        logHoursButton.setPreferredSize(buttonSize);

        viewFlightLogButton.addActionListener(e -> openViewFlightLog());
        viewHoursLogButton.addActionListener(e -> openViewHoursLog());
        logHoursButton.addActionListener(e -> logHours());

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);
        
        JLabel label = new JLabel("Flight/Hours Log");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, gbc);
        gbc.gridy++;
        
        add(viewFlightLogButton, gbc);

        gbc.gridy++;
        add(viewHoursLogButton, gbc);

        gbc.gridy++;
        add(logHoursButton, gbc);

        JButton goBackButton = new JButton("Go Back");
        goBackButton.setPreferredSize(buttonSize);
        goBackButton.addActionListener(e -> goBackToMain());
        gbc.gridy++;
        add(goBackButton, gbc);
    }

    private void openViewFlightLog() {
        mainFrame.setContentPane(new ViewFlightLog(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void openViewHoursLog() {
        mainFrame.setContentPane(new ViewHoursLog(mainFrame));
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void logHours() {
        String[] labels = {
        		"Date (e.g., 2024-09-15):LOG",
                "Total Flight Time (e.g., 2.5 hours):",
                "Departure Airport:",
                "Arrival Airport:",
                "Aircraft Type:",
                "Aircraft Registration:",
                "Name of Safety Pilot:",
                "Was it a Nighttime Flight? (Yes/No):",
                "Was it a Cross Country Flight? (Yes/No):",
                "Pic?",
                "sic?",
                "Instrument?",
                "Simulated instrument?",
                "solo?"
        };
        
        String[] inputs = new String[labels.length];
        
        for (int i = 0; i < 7 ; i++) {
            inputs[i] = JOptionPane.showInputDialog(this, labels[i], "Log Flight Hours", JOptionPane.PLAIN_MESSAGE);
            if (inputs[i] == null) {
                return;
            }
        }

        ArrayList<String> newEntryFlight = new ArrayList<>();
        String input = "";
        for (int i = 0; i < 7; i++) {
            if (inputs[i].trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please provide all required information.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            input = inputs[i].trim();
            newEntryFlight.add(input);
        }

        mainFrame.addFlightLogData(newEntryFlight);
        
        int night = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog (null, "Was it a nighttime flight?","", night);
        if(night == JOptionPane.YES_OPTION) {
        	inputs[7] = inputs[1];
        if(night == JOptionPane.NO_OPTION) {
            }
        	inputs[7] = "0";
          }
        
        int crossCountry = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog (null, "Was it a Cross Country flight?","", crossCountry);
        if(crossCountry == JOptionPane.YES_OPTION) {
        	inputs[8] = inputs[1];
        if(crossCountry == JOptionPane.NO_OPTION) {
        	inputs[8] = "0";
            }
          }
        
        int pic = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog (null, "Were you PIC?","", pic);
        if(pic == JOptionPane.YES_OPTION) {
        	inputs[9] = inputs[1];
        if(pic == JOptionPane.NO_OPTION) {
        	inputs[9] = "0";
            }
          }
        
        int sic = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog (null, "Were you SIC?","", sic);
        if(sic == JOptionPane.YES_OPTION) {
        	inputs[10] = inputs[1];
        if(sic == JOptionPane.NO_OPTION) {
        	inputs[10] = "0";
            }
          }
        
        int instrument = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog (null, "Was it an instrument flight?","", instrument);
        if(instrument == JOptionPane.YES_OPTION) {
        	int sim = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog (null, "Was it a simulated instrument flight?","", sim);
            if(sim == JOptionPane.YES_OPTION) {
            	inputs[12] = inputs[1];
            if(sim == JOptionPane.NO_OPTION) {
            	inputs[11] = inputs[1];
                }
              }
        if(instrument == JOptionPane.NO_OPTION) {
        	inputs[11] = "0";
        	inputs[12] = "0";;
            }
          }
        int solo = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog (null, "Was it a solo flight?","", solo);
        if(solo == JOptionPane.YES_OPTION) {
        	inputs[13] = inputs[1];
        if(solo == JOptionPane.NO_OPTION) {
        	inputs[13] = "0";
            }
          }
        
        ArrayList<String> newEntryHours = new ArrayList<>();
//        System.out.println(inputs);
        String input2 = "";
//        for (int i = 7; i < inputs.length - 1; i++) {
////        for (String input : inputs) {
//        	System.out.println(inputs[i]);
//            if (inputs[i].trim().isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Please provide all required information.", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            input2 = inputs[i].trim();
//            newEntryHours.add(input2);
//        }
//        System.out.println(newEntryHours);
        
        mainFrame.addHoursLogData(newEntryHours);

        // Optionally, show a confirmation message
        JOptionPane.showMessageDialog(this, "Flight hours logged successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void goBackToMain() {
        mainFrame.showMainScreen();
    }
}
