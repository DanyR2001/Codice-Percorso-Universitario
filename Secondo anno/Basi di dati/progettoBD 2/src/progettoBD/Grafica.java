package progettoBD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Grafica {
	
	private static final String DB_URL="jdbc:mysql://localhost/progetto2022";
	private static final String USER="java";
	private static final String PAS="1234";

	private JFrame frame;
	private static QueryManger q;
	private JTable table;
	private static String[][] Negozi;
	private static String[][] ListaVinNegozi;
	private JComboBox comboBox;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				q=new QueryManger(DB_URL,USER,PAS);
				try {
					Grafica window = new Grafica();
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
	public Grafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Gestionale:");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Conferma");
		table = new JTable();

		JButton btnNewButton_1 = new JButton("Vendi");
		JButton btnNewButton_4 = new JButton("Catalogo");
		JButton btnNewButton_2 = new JButton("Info disco");
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Seleziona il negozio:");
		panel.add(lblNewLabel);
		
		Negozi=q.makeQueryWhitNameColum("select pIva,ragSoc as RagioneSociale,toponimo,civico,comune,cap,provincia from Negozi");
		Negozi[0][1]="Ragione sociale";
		comboBox = new JComboBox(QueryManger.parseCulonFromIndex(Negozi,1));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()!=0) {
				DefaultTableModel model = new DefaultTableModel() {
				    @Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
				    }
				}; 
				String p_iva=Negozi[comboBox.getSelectedIndex()][0];
				String query="select vin.id,vin.titolo,vin.prezzo_Listino from Vinili vin where vin.id in (select x.id_Vinile from (select id_vinile, sum(quantita) as tot from Acquisti where p_Iva="+p_iva+" group by id_Vinile) x left join (select v.id_Vinile,sum(v.quantita) as act from Vendite v where p_Iva="+p_iva+" group by v.id_Vinile) y on y.id_Vinile=x.id_Vinile where x.tot>y.act or y.act is null)";
				ListaVinNegozi=q.makeQueryWhitNameColum(query);
				for(int i=0;i<q.getActualCol();i++)
					model.addColumn(ListaVinNegozi[0][i]);
				for(int j=0;j<=q.getActualRow();j++) {
					model.addRow(ListaVinNegozi[j]);
				}
				table.setModel(model);
				}
				if(comboBox.getSelectedIndex()==0) {
					table.removeAll();
					table.setModel(new DefaultTableModel());
					btnNewButton_1.setEnabled(false);
					btnNewButton_4.setEnabled(false);
					btnNewButton_2.setEnabled(false);
				}else {
					btnNewButton_4.setEnabled(true);
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);

				}
			}
		});
		panel.add(comboBox);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()!=0) {
					DefaultTableModel model = new DefaultTableModel() {
					    @Override
					    public boolean isCellEditable(int row, int column) {
					       //all cells false
					       return false;
					    }
					}; 
				String p_iva=Negozi[comboBox.getSelectedIndex()][0];
				String query1="select vin.id,vin.titolo,vin.prezzo_Listino from Vinili vin where vin.id in (select x.id_Vinile from (select id_vinile, sum(quantita) as tot from Acquisti where p_Iva="+p_iva+" group by id_Vinile) x left join (select v.id_Vinile,sum(v.quantita) as act from Vendite v where p_Iva="+p_iva+" group by v.id_Vinile) y on y.id_Vinile=x.id_Vinile where x.tot>y.act or y.act is null)";
				ListaVinNegozi=q.makeQueryWhitNameColum(query1);
				for(int i=0;i<q.getActualCol();i++)
					model.addColumn(ListaVinNegozi[0][i]);
				for(int j=0;j<=q.getActualRow();j++) {
					model.addRow(ListaVinNegozi[j]);
				}
				table.setModel(model);
				}
				if(comboBox.getSelectedIndex()==0) {
					table.removeAll();
					table.setModel(new DefaultTableModel());
					btnNewButton_1.setEnabled(false);
					btnNewButton_4.setEnabled(false);
					btnNewButton_2.setEnabled(false);
				}else {
					btnNewButton_4.setEnabled(true);
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);

				}
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_2.add(table);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new GridLayout(4, 1, 0, 0));
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				int numrowselected=table.getSelectedRowCount();
				if(row>0&&numrowselected==1) {
					String qQuantiVenduti="select sum(quantita) from Vendite where p_Iva="+Negozi[comboBox.getSelectedIndex()][0]+" and id_vinile="+table.getValueAt(table.getSelectedRow(), 0)+" ";
					String qQuantiComprati="select sum(quantita) from Acquisti where p_Iva="+Negozi[comboBox.getSelectedIndex()][0]+" and id_vinile="+table.getValueAt(table.getSelectedRow(), 0)+" ";
					String []x=q.makeQuery(qQuantiVenduti);
					int venduti=0;
					System.out.println(" "+x[0].charAt(0));
					if(x.length>0&&!x[0].equals("null"))
						venduti=Integer.parseInt(x[0]);
					String []y=q.makeQuery(qQuantiComprati);
					int comprati=0;
					if(y.length>0&&!y[0].equals("null"))
						comprati=Integer.parseInt(y[0]);
					int attuali=comprati-venduti;
					String[] list=new String[attuali];
					for(int i=0;i<attuali;i++) {
						list[i]=(i+1)+"";
					}
					JComboBox num= new JComboBox(list);
					JComboBox sconto= new JComboBox(new String[]{"NP","10","20","30","40","50"});
					JCheckBox stato= new JCheckBox();
					Object[] options = new Object[] {};
			        JOptionPane jop = new JOptionPane("Inserisci le informazioni:",
			                                        JOptionPane.QUESTION_MESSAGE,
			                                        JOptionPane.DEFAULT_OPTION,
			                                        null,options, null);
					//JOptionPane.showMessageDialog(null, num,"inserisci la quantita",JOptionPane.QUESTION_MESSAGE);
				    jop.add(new JLabel("Seleziona la quantita:"));
				    jop.add(num);
				    jop.add(new JLabel("Seleziona lo sconto:"));
				    jop.add(sconto);
				    jop.add(new JLabel("Seleziona la se usato:"));
			        jop.add(stato);
			        JDialog diag = new JDialog();
			        diag.setSize(300, 300);
			        JButton close=new JButton("Conferma acqusito");
					close.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
					        diag.show(false);
					        int numAc=num.getSelectedIndex()+1;
					        boolean stat=stato.isSelected();
					        int perSconto=0;
					        if(!((String)sconto.getSelectedItem()).equals("NP"))
					        	perSconto=Integer.parseInt((String) sconto.getSelectedItem());
					        double prezzo=Double.parseDouble((String) table.getValueAt(table.getSelectedRow(), 2));
					        if(perSconto!=0)
					        	prezzo=prezzo-((prezzo/100)*perSconto);
					        String inserimento="Insert into Vendite (p_Iva,id_Vinile,prezzoUnita,quantita,sconto,usato) values  ("+Negozi[comboBox.getSelectedIndex()][0]+","+table.getValueAt(table.getSelectedRow(), 0)+","+prezzo+","+numAc+","+perSconto+","+stat+");";
					        q.makeInsertQuery(inserimento);
					        JOptionPane.showMessageDialog(frame,"Conferma vendita;");
					        btnNewButton.doClick();
					        
						}
					});
			        jop.add(close);
			        diag.getContentPane().add(jop);
			        diag.show(true);
				}
				else if(row==-1&&numrowselected==0){
					JOptionPane.showMessageDialog(frame, "Seleziona un vinile");
				}
				else if(row==0&&numrowselected==1){
					JOptionPane.showMessageDialog(frame, "Seleziona una riga valida");
				}
				else {
					JOptionPane.showMessageDialog(frame, "Seleziona una sola riga");
				}
			}
		});
		panel_3.add(btnNewButton_1);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				int numrowselected=table.getSelectedRowCount();
				if(row>0&&numrowselected==1) {
					QueryManger q=new QueryManger(DB_URL,USER,PAS);
					String query="select v.titolo, ar.nome, ar.cognome, ar.etichetta, v.durata, v.prezzo_Listino,v.tipo,v.inedito from Vinili v, Autori au , Artisti ar where v.id=au.idVinile and au.matricolaArtista=ar.matricola and v.id="+table.getValueAt(table.getSelectedRow(), 0);
					String [][]value=q.makeQueryWhitNameColum(query);
					String query1="select v.titolo, ar.nome, ar.cognome, ar.etichetta, v.durata, v.prezzo_Listino,v.tipo from Vinili v, Autori au , Artisti ar where v.id=au.idVinile and au.matricolaArtista=ar.matricola and v.id="+table.getValueAt(table.getSelectedRow(), 0);
					String result=q.makeQueryOneRow(query1);
						if(value[1][6].equals("45")) {
							if(value[1][7].equals("0"))
								result+=" BRANO NON INEDITO ";
							else 
								result+=" BRANO INEDITO ";
						}
						else {
							String query2="select t.NomeCanzone from Tracce t where t.idVinile="+table.getValueAt(table.getSelectedRow(), 0);
							String [][]value1=q.makeQueryWhitNameColum(query2);
							result+="\nTracklist:\n";
							for(int i=1;i<value1.length;i++) {
								result+="\t\t-"+value1[i][0]+"\n";
							}
							if(value1.length==1)
								result+="\t\tNon pervenuta";
						}
					JOptionPane.showMessageDialog(frame, result);
					}
				else if(row==-1&&numrowselected==0){
					JOptionPane.showMessageDialog(frame, "Seleziona un vinile");
				}
				else if(row==0&&numrowselected==1){
					JOptionPane.showMessageDialog(frame, "Seleziona una riga valida");
				}
				else {
					JOptionPane.showMessageDialog(frame, "Seleziona una sola riga");
				}
			}
		});
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cerca");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NameVin=JOptionPane.showInputDialog(frame,"Inserisci il titolo del vinile da cercare");
				QueryManger temp=new QueryManger(DB_URL,USER,PAS);
				boolean control=true;
				String query="Select * from Vinili v where v.titolo=\""+NameVin+"\" ";
				control=temp.queryWhithResult(query);
				if(control==true) {
					boolean flag=true;
					String result[][]=temp.makeQueryWhitNameColum(query);
					String idVinile=result[1][0];
					String negoziresult[]= new String[Negozi.length];
					negoziresult[0]="Lista dei negozi dove presente il vinile:";
					for(int j=1,i=0;i<Negozi.length-1;i++) {
						String x="Select vin.id from Vinili vin where vin.id=\""+idVinile+"\" and vin.id in (select x.id_Vinile from (select id_vinile, sum(quantita) as tot from Acquisti where p_Iva=\""+Negozi[i+1][0]+"\" group by id_Vinile) x left join (select v.id_Vinile,sum(v.quantita) as act from Vendite v where p_Iva=\""+Negozi[i+1][0]+"\" group by v.id_Vinile) y on y.id_Vinile=x.id_Vinile where x.tot>y.act or y.act is null)";
						if(temp.queryWhithResult(x)) {
							flag=false;
							negoziresult[j]=QueryManger.printSpaced(Negozi[i+1]);
							j++;
						}
					}
					if(flag)
						JOptionPane.showMessageDialog(frame, "Vinile non presente in nessuna filiale");
					else
						JOptionPane.showMessageDialog(frame, negoziresult);
				}
				else {
					JOptionPane.showMessageDialog(frame, "Vinile non trovato");
				}
			}
		});
		panel_3.add(btnNewButton_3);
		
		
		if(comboBox.getSelectedIndex()==0) {
			btnNewButton_1.setEnabled(false);
			btnNewButton_4.setEnabled(false);
			btnNewButton_2.setEnabled(false);
		}
		else {
			btnNewButton_1.setEnabled(true);
			btnNewButton_4.setEnabled(true);
			btnNewButton_2.setEnabled(true);
		}
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Negozi!=null) {
					Acquisti.main(Negozi,(int) comboBox.getSelectedIndex(),q,btnNewButton);
				}
			}
		});
		panel_3.add(btnNewButton_4);
	}

}
