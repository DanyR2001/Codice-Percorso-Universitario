package progettoBD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Acquisti {

	private JFrame frame;
	private JTable table;
	private static String[][] Negozi;
	private static int chose;
	private static String[][] ListaVinNegozi;
	private static QueryManger q;
	private JTextField textField;
	private static JButton button;


	/**
	 * Launch the application.
	 */
	public static void main(String [][]negozi, int index,QueryManger Q,JButton btnNewButton) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Negozi=negozi;
					chose=index;
					q=Q;
					button=btnNewButton;
					Acquisti window = new Acquisti();
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
	public Acquisti() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Interfaccia acquisti:");
		frame.setBounds(100, 100, 479, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(3, 1, 100,0));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setVisible(false);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Negozio: "+Negozi[chose][1]+", indirizzo di spedizine:"+Negozi[chose][2]+ " "+Negozi[chose][3]+", "+Negozi[chose][4]+", "+Negozi[chose][5]);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setVisible(false);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		panel_2.add(table);
		DefaultTableModel model = new DefaultTableModel() {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		}; 
		String query="select vin.id,vin.titolo,vin.prezzo_Listino from Vinili vin";
		ListaVinNegozi=q.makeQueryWhitNameColum(query);
		for(int i=0;i<q.getActualCol();i++)
			model.addColumn(ListaVinNegozi[0][i]);
		for(int j=0;j<=q.getActualRow();j++) {
			model.addRow(ListaVinNegozi[j]);
		}
		table.setModel(model);


		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Quantità:");
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10);
		
		JLabel lblNewLabel_5 = new JLabel("Usato:");
		panel_10.add(lblNewLabel_5);
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		panel_9.add(chckbxNewCheckBox);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_4 = new JLabel("Sconto:");
		panel_7.add(lblNewLabel_4);
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8);
		
		JComboBox comboBox= new JComboBox(new String[]{"NP","10","20","30","40","50"});
		panel_8.add(comboBox);
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		
		JButton btnNewButton_1 = new JButton("Acquista");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().isEmpty()) {
					int quantita=0;
					boolean flag=true;
					try {
						quantita=Integer.parseInt(textField.getText());
					}catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(frame, "Inserisci un valore correttto");
						flag=false;
					}
					if(flag) {
						if(table.getSelectedRow()>0) {
					        boolean stat=chckbxNewCheckBox.isSelected();
					        int perSconto=0;
					        if(!((String)comboBox.getSelectedItem()).equals("NP"))
					        	perSconto=Integer.parseInt((String) comboBox.getSelectedItem());
					        double prezzo=Double.parseDouble((String) table.getValueAt(table.getSelectedRow(), 2));
					        if(perSconto!=0)
					        	prezzo=prezzo-((prezzo/100)*perSconto);
					        String quer="Insert into Acquisti (p_Iva,id_Vinile,prezzoUnita,quantita,sconto,usato) values ("+Negozi[chose][0]+","+table.getValueAt(table.getSelectedRow(), 0)+","+prezzo+","+quantita+","+perSconto+","+stat+")";
					        q.makeInsertQuery(quer);
					        JOptionPane.showMessageDialog(frame,"Conferma acquisto;");
					        //frame.setVisible(false);
					        button.doClick();
					        chckbxNewCheckBox.setSelected(false);
					        textField.setText("");
					        comboBox.setSelectedIndex(0);
					        //frame.dispose();
					        }
						else {
							JOptionPane.showMessageDialog(frame, "Seleziona un vinile");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Inserisci un valore");
				}
			}
		});
		panel_6.add(btnNewButton_1);
	}

}
