import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LogHoursButtonHandler implements ActionListener {
    private PilotPal mainFrame;

    public LogHoursButtonHandler(PilotPal mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] labels = {
        		"Date (e.g., 2024-09-15)LHB:",
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
                "Simulated instrument?"
        };
        
        String[] inputs = new String[labels.length];
        
        for (int i = 0; i < 7; i++) {
            inputs[i] = JOptionPane.showInputDialog(mainFrame, labels[i], "Log Flight Hours", JOptionPane.PLAIN_MESSAGE);
            if (inputs[i] == null) {
                return;
            }
        }

        ArrayList<String> newEntryFlight = new ArrayList<>();
        String input = "";
        for (int i = 0; i < 7; i++) {
            if (inputs[i].trim().isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "Please provide all required information.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            input = inputs[i].trim();
            newEntryFlight.add(input);
        }
        System.out.println(newEntryFlight);

        mainFrame.addFlightLogData(newEntryFlight);
        
        int night = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog (null, "Was it a Cross Country Flight?","", night);
        if(night == JOptionPane.YES_OPTION) {
        	inputs[7] = inputs[1];
        if(night == JOptionPane.NO_OPTION) {
            }
        	inputs[7] = "0";
          }
        
        int crossCountry = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog (null, "Was it a Cross Country Flight?","", crossCountry);
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
        JOptionPane.showConfirmDialog (null, "Was it an Instrument Flight?","", instrument);
        if(instrument == JOptionPane.YES_OPTION) {
        	int sim = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog (null, "Were you SIC?","", sim);
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
        
        ArrayList<String> newEntryHours = new ArrayList<>();
        String input2 = "";
        for (int i = 7; i < inputs.length; i++) {
            if (inputs[i].trim().isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "Please provide all required information.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            input2 = inputs[i].trim();
            newEntryHours.add(input2);
        }
        System.out.println(newEntryHours);
        
        mainFrame.addHoursLogData(newEntryHours);

        JOptionPane.showMessageDialog(mainFrame, "Flight hours logged successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
