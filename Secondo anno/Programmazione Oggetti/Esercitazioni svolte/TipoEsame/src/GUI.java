import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class GUI {

	private JFrame frame;
	private static Manager lista;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		lista=new Manager();
		ArrayList<String> listaFilm=new ArrayList<>();
		frame = new JFrame();
		frame.setBounds(100, 100, 515, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		panel.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		String userDir = System.getProperty("user.home");
		JFileChooser fileChooser = new JFileChooser(userDir +"/eclipse-workspace/TipoEsame");
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Carica");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = fileChooser.showOpenDialog(null);
				  if(n==JFileChooser.APPROVE_OPTION){
					  File f = fileChooser.getSelectedFile();
					  FileManager Manage= new FileManager(f);
					  try {
						lista=Manage.loadFromFile();
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				  }
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Salva");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Aggiungi");
		
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(5, 4));
		
		JLabel lblNewLabel = new JLabel("Nome:");
		panel_3.add(lblNewLabel);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cognome:");
		panel_3.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Data:");
		panel_3.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Aggiungi film");
		
		textField_6 = new JTextField();
		textField_5 = new JTextField();
		textField_4 = new JTextField();
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setText("0");
		textField_3.setEnabled(false);
		
		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Seleziona tipo:");
		panel_3.add(lblNewLabel_5);
		String[] type= {"Attore film","Attore teatrale"};
		JComboBox comboBox = new JComboBox(type);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(((String) comboBox.getSelectedItem()).equals(type[0])) {
					textField_5.setEnabled(false);
					textField_6.setEnabled(true);
					textField_4.setEnabled(false);
					btnNewButton.setEnabled(true);
					textField_3.setEnabled(false);
					textField_3.setText("0");
					textField_6.setText("");
				}else if(((String) comboBox.getSelectedItem()).equals(type[1])) {
					listaFilm.removeAll(listaFilm);
					textField_5.setEnabled(true);
					textField_6.setEnabled(false);
					textField_4.setEnabled(true);
					btnNewButton.setEnabled(false);
					textField_3.setEnabled(false);
					textField_3.setText("0");
					textField_6.setText("");
				}
			}
		});
		comboBox.setSelectedIndex(0);
		panel_3.add(comboBox);
		
		
	
		JLabel lblNewLabel_3 = new JLabel("Numero Film:");
		panel_3.add(lblNewLabel_3);
		
		
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nome Film:");
		panel_3.add(lblNewLabel_4);	
		
	
		panel_3.add(textField_6);
		textField_6.setColumns(10);
		
		
		
		JLabel lblNewLabel_8 = new JLabel("Numero Spettacoli:");
		panel_3.add(lblNewLabel_8);
		
	
		panel_3.add(textField_4);
		textField_4.setColumns(10);	
		
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setVisible(false);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setVisible(false);
		panel_3.add(lblNewLabel_7);
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_6.getText().isEmpty()) {
					listaFilm.add(textField_6.getText());
					textField_6.setText("");
					int num=Integer.parseInt(textField_3.getText());
					num++;
					textField_3.setText(num+"");
				}
			}
		});
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel_10 = new JLabel("Nome Compagnia:");
		panel_3.add(lblNewLabel_10);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty()&&!textField_1.getText().isEmpty()&&!textField_2.getText().isEmpty()) {
					if(((String) comboBox.getSelectedItem()).equals(type[0])) {
						int num=Integer.parseInt(textField_3.getText());
						if(num==0||listaFilm.size()==0) {
							JOptionPane.showMessageDialog(frame, "aggiungi almeno un film");
						}
						else {
							String x=textField_2.getText();
							String[] data=x.split("/");
							Date z=new Date(Integer.parseInt(data[2]),Integer.parseInt(data[1]),Integer.parseInt(data[0]));
							AttoreFilm add=new AttoreFilm(textField.getText(), textField_1.getText(), z,num,listaFilm);
							lista.addActor(add);
							JOptionPane.showMessageDialog(frame, "Attore Film aggiunto");
							textField.setText("");
							textField_1.setText("");
							textField_3.setText("0");
							textField_2.setText("");

						}
					}else if(((String) comboBox.getSelectedItem()).equals(type[1])) {
						if(!textField_5.getText().isEmpty()&&!textField_4.getText().isEmpty()) {
							String x=textField_2.getText();
							String[] data=x.split("/");
							int numSpet=Integer.parseInt(textField_4.getText());
							Date z=new Date(Integer.parseInt(data[2]),Integer.parseInt(data[1]),Integer.parseInt(data[0]));
							AttoreTeatro add1=new AttoreTeatro(textField.getText(), textField_1.getText(), z,numSpet,textField_5.getText());
							lista.addActor(add1);
							JOptionPane.showMessageDialog(frame, "Attore tatrale aggiunto");
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							textField_4.setText("");
							textField_5.setText("");
						}
						else {
							JOptionPane.showMessageDialog(frame, "Inserisci tutti i campi");
						}
					}
				}else {
					JOptionPane.showMessageDialog(frame, "Inserisci tutti i campi");
				}
			}
		});
	
		
	
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		
		panel_3.add(lblNewLabel_6);		
		
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setVisible(false);
		panel_3.add(lblNewLabel_9);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JTextPane textPane = new JTextPane();
		panel_4.add(textPane);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_11 = new JLabel("FIltra per:");
		panel_5.add(lblNewLabel_11);
		
		String []type2={"Attore film","Attore teatrale","Tutti"};
		JComboBox comboBox_1 = new JComboBox(type2)  ;
		panel_5.add(comboBox_1);
		
		JButton btnNewButton_2 = new JButton("Filtra");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				if(comboBox_1.getSelectedIndex()==0) {
					ArrayList<Attore> x=lista.Filtra(0);
					textPane.setText(x.toString());
				}
				else if(comboBox_1.getSelectedIndex()==1) {
					ArrayList<Attore> x=lista.Filtra(1);
					textPane.setText(x.toString());
					
				}else if(comboBox_1.getSelectedIndex()==2) {
					textPane.setText(lista.toString());
				}
			}
		});
		panel_5.add(btnNewButton_2);
	}

}
