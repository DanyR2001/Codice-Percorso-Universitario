package noleggio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	static private ElencoNoleggi elenco;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Film:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JTextPane textPane = new JTextPane();
		panel_2.add(textPane);
		
		elenco= new ElencoNoleggi();
		try {
			elenco.aggiungiNoleggio(new Noleggio(new Film("123","FARGO"),123,1));
			elenco.aggiungiNoleggio(new Noleggio(new Film("456","MARIO"),123,0));
			elenco.aggiungiNoleggio(new Noleggio(new Film("257","ULTRAS"),346,5));

		} catch (BadIDException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textPane.setText(elenco.toString());
		
		JButton btnNewButton = new JButton("Cerca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isEmpty())
					textPane.setText(elenco.toString());
				else {
					String x=textField.getText();
					ArrayList s=elenco.cerca(x);
					if(s!=null) {
					String finale="";
					for(int i=0;i<s.size();i++)
						finale+=s.get(i).toString();
					textPane.setText("");
					textPane.setText(finale);
					}
					else
					{
						textPane.setText("film no trovato");
					}
				}
				
			}
		});
		panel_1.add(btnNewButton);
		
			
	}

}
