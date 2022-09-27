import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.Label;
import javax.swing.JList;

public class GUI {

	private JFrame frame;
	private static Albergo manager;
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
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		String userDir = System.getProperty("user.home");
		JFileChooser fileChooser = new JFileChooser(userDir +"/eclipse-workspace/lezione13-12-21");

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		Panel panel_5 = new Panel();
		panel_5.setVisible(false);
		frame.getContentPane().add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_5.add(panel_2);
		panel_2.setVisible(true);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		
		Panel panel_3 = new Panel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 0, 0));
		
		
		Label label = new Label("Mannag");
		panel_3.add(label);
		
		JList list = new JList();
		panel_3.add(list);
		
	
		
		Panel panel_4 = new Panel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(2,1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Carica il file :)");
		frame.getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Load");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 int n = fileChooser.showOpenDialog(null);
				  if(n==JFileChooser.APPROVE_OPTION){
					  File f = fileChooser.getSelectedFile();
					  Albergo_file x=new Albergo_file();
					  try {
						x.Load(f);
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					manager=x.getOggetto(); 
					lblNewLabel.setVisible(false);
					frame.remove(lblNewLabel);
					frame.getContentPane().add(panel_1, BorderLayout.CENTER);
					panel_1.setVisible(true);
					
			}
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		
		JButton btnNewButton = new JButton("Richiesta prenotazioni");
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Gestisci Prenotazioni");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
				frame.getContentPane().add(panel_5, BorderLayout.CENTER);
				panel_5.setVisible(true);
				System.out.print("diomerda");
				
			}
		});
		panel_1.add(btnNewButton_1);
		
		
	
	}

}
