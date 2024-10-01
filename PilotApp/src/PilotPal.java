import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PilotPal extends JFrame {
    private static final long serialVersionUID = 1L;
    private JLabel background;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel panel;
    private JPanel buttonsPanel;
    private ArrayList<ArrayList<String>> flightData = new ArrayList<ArrayList<String>>();
    private ArrayList<ArrayList<String>> hoursData = new ArrayList<ArrayList<String>>();

    public PilotPal() {
        super();
        addTestData();
        setupLayout();
        ImageIcon icon = loadImageIcon("/PilotPalLogo.png");
        if (icon != null) {
            setIconImage(icon.getImage());
        } else {
            System.err.println("Titlebar icon not found.");
        }
        pack();
        setTitle("PilotPal");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void setupLayout() {
        background = new JLabel();
        ImageIcon icon = loadImageIcon("/pRei.jpg");

        if (icon != null) {
            background.setIcon(icon);
            background.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        } else {
            System.err.println("Image not found.");
        }
        button1 = new JButton("Plan Flight");
        button2 = new JButton("Flight/Hours Log");
        button3 = new JButton("Checkride Prep");

        Dimension buttonSize = new Dimension(200, 50);
        button1.setPreferredSize(buttonSize);
        button2.setPreferredSize(buttonSize);
        button3.setPreferredSize(buttonSize);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                planClicked();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logClicked();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prepClicked();
            }
        });

        panel = new JPanel(new GridBagLayout());
        setContentPane(panel);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(background, gbc);

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 3, 10, 10));
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        buttonsPanel.add(button3);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = GridBagConstraints.RELATIVE;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        panel.add(buttonsPanel, gbc);
    }

    public void showMainScreen() {
        panel.setVisible(true);
        setContentPane(panel);
        revalidate();
        repaint();
    }

    private void planClicked() {
        panel.setVisible(false);

        PlanFlight planFlightPanel = new PlanFlight(this);
        setContentPane(planFlightPanel);

        revalidate();
        repaint();
    }

    private void logClicked() {
        panel.setVisible(false);

        Log logPanel = new Log(this);
        setContentPane(logPanel);

        revalidate();
        repaint();
    }

    private void prepClicked() {
        panel.setVisible(false);

        CRPrep crPrepPanel = new CRPrep(this);
        setContentPane(crPrepPanel);

        revalidate();
        repaint();
    }
    
    public ArrayList<ArrayList<String>> getFlightLogData() {
    	return flightData;
    }
	public ArrayList<ArrayList<String>> getHoursLogData() {
		return hoursData;
	}

	public void addFlightLogData(ArrayList<String> data) {
		flightData.add(data);
	}
	
	public void addHoursLogData(ArrayList<String> data) {
		hoursData.add(data);
	}
	
	public static Object[][] convertDataList(ArrayList<ArrayList<String>> lists) {
        int rows = lists.size();
        int cols = (rows > 0) ? lists.get(0).size() : 0;
        Object[][] array = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            ArrayList<String> innerList = lists.get(i);
            for (int j = 0; j < innerList.size(); j++) {
                array[i][j] = innerList.get(j);
            }
        }

        return array;
	}
	
	private void addTestData() {
	    ArrayList<String> row1 = new ArrayList<>();
	    row1.add("2024-09-01");
	    row1.add("2.5 hours");
	    row1.add("JFK");
	    row1.add("LAX");
	    row1.add("Boeing 737");
	    row1.add("N12345");
	    row1.add("Yes");

	    ArrayList<String> row2 = new ArrayList<>();
	    row2.add("2024-09-10");
	    row2.add("3.0 hours");
	    row2.add("LGA");
	    row2.add("ORD");
	    row2.add("Airbus A320");
	    row2.add("N54321");
	    row2.add("No");

	    flightData.add(row1);
	    flightData.add(row2);
	    
	    ArrayList<String> row1Hours = new ArrayList<>();
	    row1Hours.add("2024-09-01");
	    row1Hours.add("10 hours");
	    row1Hours.add("20 hours");
	    row1Hours.add("5 hours");
	    row1Hours.add("30 hours");
	    row1Hours.add("10 hours");
	    row1Hours.add("15 hours");
	    row1Hours.add("5 hours");

	    ArrayList<String> row2Hours = new ArrayList<>();
	    row2Hours.add("2024-09-10");
	    row2Hours.add("8 hours");
	    row2Hours.add("15 hours");
	    row2Hours.add("7 hours");
	    row2Hours.add("20 hours");
	    row2Hours.add("10 hours");
	    row2Hours.add("10 hours");
	    row2Hours.add("5 hours");

	    hoursData.add(row1Hours);
	    hoursData.add(row2Hours);
	}
	
    private ImageIcon loadImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PilotPal::new);
    }
}
