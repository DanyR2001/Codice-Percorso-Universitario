import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	private PagamentoPasti lista;
	private JTextField textField_1;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 353, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2));
		
		JLabel lblNewLabel = new JLabel("Nome file:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setVisible(false);
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(2, 1));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("Somma incassata: 0");
		panel_3.add(lblNewLabel_3);
			
			JButton btnNewButton = new JButton("Cerca");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Inserisci un nome nella casella. Riprova");
						//lblNewLabel_1.setText("Errore Inserire il nome");
						//lblNewLabel_1.setVisible(true);
					}
					else {
						boolean flag=false;
						String x=textField.getText();
						FileManager temp=new FileManager(x);
						try {
							lista=temp.ReadFile();
							if(lista!=null)
								flag=true;
						} catch (ClassNotFoundException | IOException e1) {
							JOptionPane.showMessageDialog(frame, "Errore con il file. Riprova");
							// TODO Auto-generated catch block
							//lblNewLabel_1.setText("Errore file");
							//lblNewLabel_1.setVisible(true);
							flag=false;
						}
						if(flag) {
							panel.setVisible(false);
							frame.getContentPane().add(panel, BorderLayout.SOUTH);
							panel_1.setVisible(true);
							frame.getContentPane().add(panel_1, BorderLayout.CENTER);
							lblNewLabel_3.setText("Somma incassata: "+lista.calcolaTotale());
						}
						else {
							JOptionPane.showMessageDialog(frame, "File non trovato. Riprova");
							//lblNewLabel_1.setText("Errore file");
							//lblNewLabel_1.setVisible(true);
						}
					}
				}
			});
			btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
			panel.add(btnNewButton);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 3));
		
		JLabel lblNewLabel_2 = new JLabel("Numero tesserino:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("cerca");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().isEmpty()) {
					lblNewLabel_3.setText("Inserire un codice.");
				}
				else {
					try {
						if(lista.usaTesserino(textField_1.getText())) {
							lblNewLabel_3.setText("Somma incassata: "+lista.calcolaTotale());
						}
						else {
							JOptionPane.showMessageDialog(frame, "Tesserino non presente. Riprova");
							//lblNewLabel_3.setText("Inserire un codice presente");
						}
					} catch (TesserinoNonAttivoException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(frame, "Tesserino non attivo. Riprova");
						//e1.printStackTrace();
					}catch (TesserinoScadutoException e1){
						JOptionPane.showMessageDialog(frame, "Tesserino scaduto. Riprova");
					}catch(SaldoInsufficienteException e1) {
						JOptionPane.showMessageDialog(frame, "Tesserino con saldo insuficente. Riprova");
					}
				}
			}
		});
		panel_2.add(btnNewButton_1);
		
		
	
		
		
	}

}
