import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class eVoto {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private static Unisa uni;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eVoto window = new eVoto();
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
	public eVoto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		uni=new Unisa();
		frame = new JFrame();
		frame.setBounds(100, 100, 378, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_9 = new JPanel();
		frame.getContentPane().add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_9.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Benvenuto nel sistema eVoto");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.SOUTH);
		
		JPanel panel_8 = new JPanel();
		panel_5.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(76, 37, 245, 70);
		panel_8.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Login:");
		panel_6.add(lblNewLabel_2);
		
		textField = new JTextField();
		panel_6.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		panel_6.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Entra");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login=textField.getText();
				String pass=textField_1.getText();
				Utente ret=uni.findUser(login, pass);
				if(ret == null)
					JOptionPane.showMessageDialog(frame, "errore");
				else {
					if(ret instanceof Docente) {
						JOptionPane.showInputDialog(btnNewButton_2, btnNewButton_2,"ciao");
					}
					else if(ret instanceof Studente) {
						Studente x=(Studente) ret;
						String massage="Ciao "+x.getNome()+" "+x.getCognome()+"\n";
						massage+=x.toString();
						JOptionPane.showMessageDialog(frame, massage);

					}
				}
			}
		});
		panel_7.add(btnNewButton_2);
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_9.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("REGISTRAZIONE");
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(1, 1, 30, 0));
		
		JPanel panel_stundete = new JPanel();
		panel_stundete.setVisible(false);
		frame.getContentPane().add(panel_stundete, BorderLayout.SOUTH);
		panel_stundete.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("Studente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_9.setVisible(false);
				frame.getContentPane().add(panel_9, BorderLayout.NORTH);
				panel_stundete.setVisible(true);
				frame.getContentPane().add(panel_stundete, BorderLayout.CENTER);
			}
		});
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Docente");
		panel_3.add(btnNewButton_1);
		
		
		
		JPanel panel_10 = new JPanel();
		panel_stundete.add(panel_10, BorderLayout.NORTH);
		
		JLabel lblNewLabel_9 = new JLabel("Registarazione Utente:");
		panel_10.add(lblNewLabel_9);
		
		JPanel panel_12 = new JPanel();
		panel_stundete.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new GridLayout(6, 2, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Cognome:");
		panel_12.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		panel_12.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nome:");
		panel_12.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		panel_12.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Matricola:");
		panel_12.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		panel_12.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Piano di Studi:");
		panel_12.add(lblNewLabel_7);
		
		
		String [] li= {"Reti","Sistemi"};
		JComboBox comboBox = new JComboBox(li);
		panel_12.add(comboBox);
		
		JLabel lblNewLabel_8 = new JLabel("Login:");
		panel_12.add(lblNewLabel_8);
		
		textField_5 = new JTextField();
		panel_12.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Password:");
		panel_12.add(lblNewLabel_10);
		
		textField_6 = new JTextField();
		panel_12.add(textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_11 = new JPanel();
		panel_stundete.add(panel_11, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("Registra");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome=textField_3.getText();
				String cognome=textField_2.getText();
				String matricola=textField_4.getText();
				String piano=(String)comboBox.getSelectedItem();
				String login=textField_5.getText();
				String password=textField_6.getText();
				Studente temp=new Studente(nome, cognome, login, password, matricola, piano);
				uni.addUtente(temp);
				panel_stundete.setVisible(false);
				frame.getContentPane().add(panel_stundete, BorderLayout.SOUTH);
				panel_9.setVisible(true);
				frame.getContentPane().add(panel_9, BorderLayout.CENTER);
				JOptionPane.showMessageDialog(frame, "Registrazione avvenuta con successo");
			}
		});
		panel_11.add(btnNewButton_3);
		
		JPanel panel_13 = new JPanel();
		panel_13.setVisible(false);
		frame.getContentPane().add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_13.add(panel_14, BorderLayout.NORTH);
		
		JLabel lblNewLabel_11 = new JLabel("Registrazione docente:");
		panel_14.add(lblNewLabel_11);
		
		JPanel panel_15 = new JPanel();
		panel_13.add(panel_15, BorderLayout.SOUTH);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_4 = new JButton("Registra");
		panel_15.add(btnNewButton_4);
		
		JPanel panel_16 = new JPanel();
		panel_13.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new GridLayout(5, 2, 0, 0));
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		panel_16.add(lblNewLabel_12);
		
		textField_7 = new JTextField();
		panel_16.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		panel_16.add(lblNewLabel_13);
		
		textField_8 = new JTextField();
		panel_16.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		panel_16.add(lblNewLabel_14);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_16.add(comboBox_1);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		panel_16.add(lblNewLabel_15);
		
		textField_9 = new JTextField();
		panel_16.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		panel_16.add(lblNewLabel_16);
		
		textField_10 = new JTextField();
		panel_16.add(textField_10);
		textField_10.setColumns(10);
	}

}
