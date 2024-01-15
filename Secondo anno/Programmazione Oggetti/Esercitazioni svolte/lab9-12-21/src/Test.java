import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JCheckBoxMenuItem;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.JTextPane;
import java.awt.Dimension;
import java.awt.TextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Test {

	private JFrame frame;
	private static ArchivioAutomezzi list;
	private TextArea textArea;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					list = new ArchivioAutomezzi();
					Test window = new Test();
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
	public Test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public Dimension getTextAreaSize() {
		return textArea.getSize();
	}
	public void setTextAreaSize(Dimension size_1) {
		textArea.setSize(size_1);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		String userDir = System.getProperty("user.home");

		JFileChooser fileChooser = new JFileChooser(userDir +"/eclipse-workspace/lab9-12-21");
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Load");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  int n = fileChooser.showOpenDialog(null);
				  if(n==JFileChooser.APPROVE_OPTION) {
					  File f = fileChooser.getSelectedFile();
					  I_O_ArchivioAutomezzi x=new I_O_ArchivioAutomezzi();
					  try {
						x.LoadList(f);
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  list.setLista(x.getArchivio().getLista());
					  textArea.setText(list.toString());
				  }
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Macchine");
		panel_2.add(rdbtnNewRadioButton);
		
		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Moto");
		panel_1.add(rdbtnNewRadioButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 7, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Targa:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(5);
		
		JLabel lblNewLabel_1 = new JLabel("Alimentazione:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.LEFT);
		panel_3.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		panel_3.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Numero posti:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel_2);
		
		JComboBox comboBox_1 = new JComboBox();
		panel_3.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Cerca");
		panel_3.add(btnNewButton);
		
		textArea = new TextArea(" ");
		frame.getContentPane().add(textArea, BorderLayout.SOUTH);
		
	}

	
}
