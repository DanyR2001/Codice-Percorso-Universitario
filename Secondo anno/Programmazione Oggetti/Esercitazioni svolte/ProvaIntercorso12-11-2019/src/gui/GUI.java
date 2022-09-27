package gui;
import esercizio.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private static SistemaDomotico x;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		x=new SistemaDomotico(3);
		for (int i = 1, j = 0; i <= 30; i++, j++) {
			if (j == 0) {
				LampadinaRGB lap = null;
				if (i % 2 == 0) {
					lap = new LampadinaRGB(LocalTime.now(), "Rosso");
				} else {
					lap = new LampadinaRGB(LocalTime.now(), LocalTime.now().plusHours(i), false, "rosa");
				}
				x.aggiungiDispositivo(lap);
			} else if (j == 1) {
				Climatizzatore cli = null;
				if (i % 2 == 0) {
					cli = new Climatizzatore(LocalTime.now(), i);
				} else {
					cli = new Climatizzatore(LocalTime.now(), LocalTime.now().plusHours(i), true, i);
				}
				x.aggiungiDispositivo(cli);
			} else if (j == 2) {
				Persiana per = null;
				if (i % 2 == 0) {
					per = new Persiana(LocalTime.now(), "barbabietola");
				} else {
					per = new Persiana(LocalTime.now(), LocalTime.now().plusHours(i), false, "panino");
				}
				x.aggiungiDispositivo(per);
				j = -1;
			}
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Controllo consumi");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(1, 3));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Dispositivi:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		String[] lista= {"Lampadina","Condizionatore","Persina"};
		JComboBox comboBox = new JComboBox(lista);
		panel_5.add(comboBox);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(7, 7, 438, 215);
		panel_2.add(textPane);
		textPane.setText(x.returnAllActive());
		
		JButton btnNewButton = new JButton("Cerca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText(x.returnType(comboBox.getSelectedIndex()));
			}
		});
		panel_6.add(btnNewButton);
		
		
		
		
	}

}
