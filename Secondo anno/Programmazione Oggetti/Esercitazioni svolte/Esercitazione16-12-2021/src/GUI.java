import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.xml.transform.Templates;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static ElencoVoli lista;
	private static Volo selected;

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
		lista=new ElencoVoli();
		ArrayList<Posto> posti=new ArrayList<>();
		posti.add(new Posto(1, 'A', true));
		posti.add(new Posto(2, 'A', false));
		posti.add(new Posto(3, 'A', false));
		posti.add(new Posto(4, 'A', false));
		posti.add(new Posto(5, 'A', false));
		posti.add(new Posto(1, 'B', true));
		posti.add(new Posto(2, 'B', false));
		posti.add(new Posto(3, 'B', false));
		posti.add(new Posto(4, 'B', false));
		posti.add(new Posto(5, 'B', false));
		try {
			lista.aggiungiVoli(new Volo("Malta", "Milano", "123", "Ryanair", posti, true));
			lista.aggiungiVoli(new Volo("Malta", "Milano", "456", "Ryanair", lista.getIndex(0).clonePosti(), true));
			lista.aggiungiVoli(new Volo("Roma", "Milano", "678", "Ryanair", lista.getIndex(0).clonePosti(), true));
		} catch (BadCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] Mete=lista.allPlace();
		frame = new JFrame();
		frame.setBounds(100, 100, 499, 274);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 5));
		
		JLabel lblNewLabel = new JLabel("Partenza");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox(Mete);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Destinazione");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox(Mete);
		panel.add(comboBox_1);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(1,3));
		
		JLabel lblNewLabel_2 = new JLabel("Voli abilitati:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_2);
		
		JComboBox comboBox_2 = new JComboBox();
		panel_2.add(comboBox_2);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(4, 2));
		
		JLabel lblNewLabel_3 = new JLabel("seleziona il posto:");
		panel_3.add(lblNewLabel_3);
		
		JComboBox comboBox_3 = new JComboBox();
		panel_3.add(comboBox_3);
		
		JLabel lblNewLabel_4 = new JLabel("Inserisci il nome:");
		panel_3.add(lblNewLabel_4);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Inserisci il cognome:");
		panel_3.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Inserisci il codice fiscale:");
		panel_3.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cerca posto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_3.removeAllItems();
				String get=(String) comboBox_2.getSelectedItem();
				selected=lista.getCodeVolo(get);
				Liberi f=new Liberi();
				ArrayList<Posto> NoPrenotati=lista.getCodeVolo(get).filtraPosti(f);
				for(int i=0;i<NoPrenotati.size();i++)
					comboBox_3.addItem(NoPrenotati.get(i).toString());
			}
		});
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Cerca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_3.removeAllItems();
				String Partenza=(String) comboBox.getSelectedItem();
				String Arrivo=(String) comboBox_1.getSelectedItem();
				System.out.println("p "+Partenza+" a "+Arrivo);
				ElencoVoli temp=null;
				try {
					temp=lista.cerca(Partenza,Arrivo);
					if(temp==null)
						System.out.println("p "+Partenza+" a "+Arrivo);
				} catch (BadCodeException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(temp!=null) {
					comboBox_2.removeAllItems();
					System.out.println(temp.toString());
					String[] voli=temp.getCodeNum();
					for(int i=0;i<voli.length;i++)
						comboBox_2.addItem(voli[i]);
				}
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("PrenotaPosto");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()||textField_1.getText().isEmpty()||textField_2.getText().isEmpty()||textField.getText()==""||textField_1.getText()==""||textField_2.getText()==""||textField.getText()==" "||textField_1.getText()==" "||textField_2.getText()==" ")
					JOptionPane.showMessageDialog(frame, "Inserisci tutti i campi. Riprova");
				else {
					String Nome=textField.getText();
					String Cognome=textField_1.getText();
					String CF=textField_2.getText();
					String posto=(String) comboBox_3.getSelectedItem();
					String [] parse=posto.split(" ");
					Posto temp=selected.findPosto(Integer.parseInt(parse[1]),parse[2].charAt(0));
					temp.setStato(false);
					selected.acquistaPosto(Nome, Cognome, posto, CF, temp);
					JOptionPane.showMessageDialog(frame, "Inserimento riusscito.");
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					comboBox_3.removeAllItems();
					comboBox_2.removeAllItems();
				}
			}
		});
		panel_4.setLayout(new GridLayout(1, 5));
		
		JButton btnNewButton_3 = new JButton("info");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, lista.toString());
			}
		});
		panel_4.add(btnNewButton_3);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setVisible(false);
		panel_4.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setVisible(false);
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setVisible(false);
		panel_4.add(lblNewLabel_7);
		panel_4.add(btnNewButton_2);
		
		
	}

}
