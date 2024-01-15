package immobili;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUCCI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
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
					GUCCI window = new GUCCI();
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
	public GUCCI() {
		initialize();
	}
	
	public void aggiorna() {
		if(textPane!=null) {
			textPane.setText(list.ToString());
		}
	}
	
	public void setEmpty() {
		textField.setText("");;
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 453, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(5, 1));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 4, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Codice:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Importo;");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 4, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("Indirizzo:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Proprietario");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		panel_4.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Tipologia:");
		panel_5.add(lblNewLabel_4);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 4, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("Balconi:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		panel_6.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Stanze:");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		panel_6.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(1, 4, 0, 0));
		
	
		
		JLabel lblNewLabel_9 = new JLabel("Posti Auto");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_7.add(lblNewLabel_9);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		panel_7.add(textField_6);
		textField_6.setColumns(10);
		
		String[] type= {"Appartamento","Garadge"};
		JComboBox comboBox = new JComboBox(type);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Appartamento")) {
					textField_6.setEnabled(false);
					textField_6.setText("");
					textField_4.setEnabled(true);
					textField_5.setEnabled(true);
				}
				else if (comboBox.getSelectedItem().equals("Garadge")){
					textField_6.setEnabled(true);
					textField_4.setEnabled(false);
					textField_4.setText("");
					textField_5.setEnabled(false);
					textField_5.setText("");
				}
			}
		});
		panel_5.add(comboBox);
		
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setVisible(false);
		panel_7.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setVisible(false);
		panel_7.add(lblNewLabel_7);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		textPane = new JTextPane();
		panel_2.add(textPane);
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty()&&!textField_1.getText().isEmpty()&&!textField_2.getText().isEmpty()&&!textField_3.getText().isEmpty()) {
					String codice=textField.getText();
					double importo=Double.parseDouble(textField_1.getText());
					String indirizzo=textField_2.getText();
					String proprietario=textField_3.getText();
					if(comboBox.getSelectedItem().equals("Appartamento")&&!textField_4.getText().isEmpty()&&!textField_5.getText().isEmpty()) {
						int Balconi=Integer.parseInt(textField_4.getText());
						int Stanze=Integer.parseInt(textField_5.getText());
						Appartamento add=new Appartamento(codice, indirizzo, proprietario, importo, Stanze, Balconi);
						list.addImmobile(add);
						aggiorna();
						setEmpty();
					}
					else if (comboBox.getSelectedItem().equals("Garadge")&&!textField_6.getText().isEmpty()){
						int numAuto=Integer.parseInt(textField_6.getText());
						Garadge add2= new Garadge(codice, indirizzo, proprietario, importo, numAuto);
						list.addImmobile(add2);
						aggiorna();
						setEmpty();
					}
					else {
						JOptionPane.showMessageDialog(frame,"Compila tutti i campi");
					}
				}
				else
					JOptionPane.showMessageDialog(frame,"Compila tutti i campi");
			}
		});
		panel_1.add(btnNewButton);
	}

}
