package immobili;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	private static Catasto list=null;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				list=new Catasto();
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
	
	public void randomCreate() {
		if(list==null) {
			list=new Catasto();
		}
		else {
			Random rand= new Random();
			for(int i=0;i<10;i++) {
				list.addImmobile(new Appartamento(rand.nextInt(1000)+"", "Via brombies "+i, "Daniele", rand.nextInt(10000000), rand.nextInt(10)+1, rand.nextInt(10)+1));
			}
			for(int i=0;i<5;i++) {
				list.addImmobile(new Garadge(rand.nextInt(1000)+"", "Via senza prepuzio "+i, "Mattia", rand.nextInt(100000000),rand.nextInt(20)+1));
			}
			aggiorna();
		}
	}
	
	public void aggiorna() {
		if(textPane!=null) {
			textPane.setText(list.ToString());
		}
	}
	
	public void aggiornaByArrayList(ArrayList<Immobile> x) {
		if(textPane!=null) {
			if(x!=null) {
				if(!x.isEmpty()) {
					textPane.setText("");
					for(Immobile i: x)
						textPane.setText(textPane.getText()+i.toString());
				}
			}
			else
				textPane.setText("");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 466, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 5, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVisible(false);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Importo:");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Carca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty());
				else {
					String x=textField.getText();
					ArrayList<Immobile> tempArrayList=list.cercaImmobile(Double.parseDouble(x));
					aggiornaByArrayList(tempArrayList);
				}
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setVisible(false);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Genera");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomCreate();
			}
		});
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		textPane = new JTextPane();
		panel_2.add(textPane);
	}

}
