package scuolasci;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class GIU {

	private JFrame frame;
	private static ElencoCorsi list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GIU window = new GIU();
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
	public GIU() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		list= new ElencoCorsi();
		list.RandomCreate(list);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 562, 347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextPane textPane = new JTextPane();
		panel.add(textPane);
		textPane.setText(list.toString());

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(1, 5));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVisible(false);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Seleziona:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel);
		
		String [] items = { "Corso Sci", "Corso Snowboard"};
		JComboBox comboBox = new JComboBox (items);
		panel_1.add(comboBox);
		
		JButton btnNewButton = new JButton("Cerca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals(items[0])) {
					textPane.setText(list.dammiCorsi("Sci").toString());
				}
				else {
					textPane.setText(list.dammiCorsi("Snowboard").toString());
				}
			}
		});
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setVisible(false);
		panel_1.add(lblNewLabel_2);
	}

}
