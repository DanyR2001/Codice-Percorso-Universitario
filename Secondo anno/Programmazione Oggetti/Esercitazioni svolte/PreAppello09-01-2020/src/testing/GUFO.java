package testing;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Preappello.Idraulico;
import Preappello.PortaleIdraulici;
import Preappello.TecnicoCaldaia;

public class GUFO {

	private JFrame frame;
	private static PortaleIdraulici p;
	private static int chose;
	private JTable table;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Idraulico i0 = new Idraulico("I000", "Ferraioli", "Giovanni");
                Idraulico i1 = new Idraulico("I001", "Di Capri", "Peppino");
                Idraulico i2 = new Idraulico("I002", "Ferrucci", "Leo");
                Idraulico i3 = new Idraulico("I003", "Colombo", "Tony");
                Idraulico i4 = new Idraulico("I004", "Celeste", "Gianni");
                ArrayList<String> listaMarche = new ArrayList<>();
                listaMarche.add("Cosmogas");
                listaMarche.add("ferraioli");
                listaMarche.add("Ciao");
                listaMarche.add("lamborghini");
                TecnicoCaldaia t0 = new TecnicoCaldaia("T000", "Marc", "Tortoriello", listaMarche);
                TecnicoCaldaia t1 = new TecnicoCaldaia("T001", "Alessandro", "Rossi", listaMarche);
                TecnicoCaldaia t2 = new TecnicoCaldaia("T002", "Mattia", "Cappato", listaMarche);
                TecnicoCaldaia t3 = new TecnicoCaldaia("T003", "Mario", "Gallo", listaMarche);
                TecnicoCaldaia t4 = new TecnicoCaldaia("T004", "Garibaldi", "Verdi", listaMarche);
                p = new PortaleIdraulici();
                p.add(i0);
                p.add(i1);
                p.add(i2);
                p.add(i3);
                p.add(t0);
                p.add(t1);
                p.add(t2);
                p.add(t3);
				try {
					GUFO window = new GUFO();
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
	public GUFO() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3,3,0,0));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setVisible(false);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setVisible(false);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVisible(false);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("inserici marca");
		panel.add(lblNewLabel);
		
		String[] bookTitles = new String[] {"Cosmogas", "ferroli","Ciao", "lamborghini"};
		
		JComboBox comboBox = new JComboBox(bookTitles);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Panel panel_2 = new Panel();
		panel_2.setVisible(false);
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(1, 0, 4, 0));
		
		Label label_1 = new Label("nome cognome:");
		panel_2.add(label_1);
		
		Label label_2 = new Label("numero interventi");
		panel_2.add(label_2);
		
		Label label = new Label("Media:");
		panel_2.add(label);
		
		Label label_3 = new Label("Add intervento");
		panel_2.add(label_3);
		
		Panel panel_3 = new Panel();
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(1, 0, 4, 0));
		
		JButton btnNewButton = new JButton("cerca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chose=comboBox.getSelectedIndex();
				panel.setVisible(false);
				panel_1.setVisible(true);
				panel_2.setVisible(true);
				frame.getContentPane().add(panel_1, BorderLayout.CENTER);
				ArrayList<Idraulico> temp=p.getIdrauliciPerMarche((String)comboBox.getSelectedItem());
				//String[][] data = new String[temp.size()][4];
				String[] colonne = new String[] {"nome cognome", "num ripa","media", "valuta"};
				JTableButtonModel data= new JTableButtonModel(temp.size(),colonne);
				TableCellRenderer tableRenderer;
				JButton[] x = new JButton[temp.size()];
				for(int i=0;i<temp.size();i++) {
					x[i]=new JButton("valuta");
					x[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(frame, "ciao");
						}
					});
					data.addObj(i,temp.get(i).getNome()+" "+temp.get(i).getCognome(),((TecnicoCaldaia) temp.get(i)).getNumRip()+"",((TecnicoCaldaia) temp.get(i)).getMediaVoti()+"",x[i]);
				}
				table = new JTable(data);
			    tableRenderer = table.getDefaultRenderer(JButton.class);
				table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
			    panel_3.add(table);
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setVisible(false);
		panel.add(lblNewLabel_2);

	}
	
	

}
class JTableButtonRenderer implements TableCellRenderer {
	   private TableCellRenderer defaultRenderer;
	   public JTableButtonRenderer(TableCellRenderer renderer) {
	      defaultRenderer = renderer;
	   }
	   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	      if(value instanceof Component)
	         return (Component)value;
	         return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	   }
	}
	class JTableButtonModel extends AbstractTableModel {
	   private Object[][] rows;// = {{"Button1", new JButton("Button1")},{"Button2", new JButton("Button2")},{"Button3", new JButton("Button3")}, {"Button4", new JButton("Button4")}};
	   private String[] columns;// = {"Count", "Buttons"};
	   
	   public JTableButtonModel(int numRow,String[] collums) {
		   rows=new Object[numRow][4];
		   columns=collums;
	   }
	   
	   public void addObj(int index,String nomeCogn,String numRip, String Med,JButton x) {
		   rows[index][0]=nomeCogn;
		   rows[index][1]=numRip;
		   rows[index][2]=Med;
		   rows[index][3]=x;

	   }
	   public String getColumnName(int column) {
	      return columns[column];
	   }
	   public int getRowCount() {
	      return rows.length;
	   }
	   public int getColumnCount() {
	      return columns.length;
	   }
	   public Object getValueAt(int row, int column) {
	      return rows[row][column];
	   }
	   public boolean isCellEditable(int row, int column) {
	      return false;
	   }
	   public Class getColumnClass(int column) {
	      return getValueAt(0, column).getClass();
	   }
	}
