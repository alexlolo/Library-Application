package javaapplication;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class MainWindow {
	
	public JTable table = new JTable(); 
	public static Object[] columns = {"Titre","Auteur","Presentation","parution","colonne","rangee", "A Qui", "Type", "Image"};
	
	static DefaultTableModel model = new DefaultTableModel(columns,0);
	
	static int SelectRow = 0;
	public ArrayList<Livre> books = new ArrayList<Livre>();
	
	MainWindow(){
		
		// create JFrame and JTable
		 JFrame frame = new JFrame("Library Application");
	        
	        JMenuItem Ouvrir = new JMenuItem("Ouvrir");
		    Ouvrir.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ev) {
		    	frame.setVisible(false);
		    		try {
						new Ouvrir();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}});
	        
		    JMenuItem Quitter = new JMenuItem(new QuitterAction("Quitter"));
		    JMenuBar menuBar = new JMenuBar();
		    JMenu fichier = new JMenu("Fichier");
		    JLabel text = new JLabel("Veuillez ouvrir un fichier XML pour commencer");
		    text.setBounds(300, 70, 300, 300);
		    fichier.add(Ouvrir);
		    fichier.add(Quitter);   
		    menuBar.add(fichier);
		    
		    frame.add(menuBar);
		    frame.setJMenuBar(menuBar);
		    frame.add(text);
		    
	     // create JScrollPane  
	        frame.setLayout(null);
	        frame.setSize(900,475);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);	
	}
	
	MainWindow(List<Bibliotheque.Livre>mesLivres){
		
		 // create JFrame and JTable
		JFrame frame = new JFrame("Library Application");
		 
		JTable table = new JTable(){
            /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

			public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
                Component returnComp = super.prepareRenderer(renderer, row, column);
                Color alternateColor = new Color(252,242,206);
                Color whiteColor = Color.WHITE;
                if (!returnComp.getBackground().equals(getSelectionBackground())){
                    Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
                    returnComp .setBackground(bg);
                    bg = null;
                }
                return returnComp;
        }}; 
	        
        for(int i = 0 ; i < mesLivres.size(); i++){
        	
        	String titre = mesLivres.get(i).getTitre();
        	String auteur = mesLivres.get(i).getAuteur();
        	String presentation = mesLivres.get(i).getPresentation();
        	int parution = mesLivres.get(i).getParution();
        	int colonne = mesLivres.get(i).getColonne();
        	int range = mesLivres.get(i).getRangee();
        	String who = mesLivres.get(i).getAQui();
        	String type = mesLivres.get(i).getType();
        	String img = mesLivres.get(i).getImage();
        	Object[] data = {titre, auteur, presentation, parution, colonne, range, who, type, img};
        	model.addRow(data);
        }
	        
        
	        
	        JMenuItem Ouvrir = new JMenuItem("Ouvrir");
		    Ouvrir.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ev) {
		    	frame.setVisible(false);
		    		try {
						new Ouvrir();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}});
		    
		    JMenuItem Export = new JMenuItem("Export");
		    Export.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ev) {
		    		try {

			    		for (int i= 0 ; i < model.getRowCount(); i++) {
			    			String aQui = "";
		    				if(model.getValueAt(i, 6) == null) {
		    					aQui = "";
		    				} else {
		    					aQui = model.getValueAt(i, 6).toString();
		    				}
		   				 Livre monBook = new Livre(
		   						model.getValueAt(i,0).toString(),
		   						model.getValueAt(i,1).toString(),
		   						model.getValueAt(i,2).toString(),
		   						Integer.parseInt(model.getValueAt(i,3).toString()),
		   						Integer.parseInt(model.getValueAt(i,4).toString()),
		   						Integer.parseInt(model.getValueAt(i,5).toString()),
		   						aQui,
		   						model.getValueAt(i, 7).toString(),
		   						model.getValueAt(i, 8).toString()
		   						);
		   				 books.add(monBook);
			    		}
						new Export(books);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}});
	        
		    JMenuItem Quitter = new JMenuItem(new QuitterAction("Quitter"));
		    
		    JMenuItem Sauvegarder = new JMenuItem("Sauvegarder");
		    Sauvegarder.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ev) {		    	
		    		try {
		    			DefaultTableModel modells = (DefaultTableModel) table.getModel();
		
		    			for(int i = 0 ; i < modells.getRowCount(); i++){
		    				String aQui = "";
		    				if(modells.getValueAt(i,6) == null) {
		    					aQui = "";
		    				} else {
		    					aQui = modells.getValueAt(i,6).toString();
		    				}
		   				 Livre monBook = new Livre(
		   						 
		   						modells.getValueAt(i,0).toString(),
		   						modells.getValueAt(i,1).toString(),
		   						modells.getValueAt(i,2).toString(),
		   						Integer.parseInt(modells.getValueAt(i,3).toString()),
		   						Integer.parseInt(modells.getValueAt(i,4).toString()),
		   						Integer.parseInt(modells.getValueAt(i,5).toString()),
		   						aQui,
		   						modells.getValueAt(i,7).toString(),
		   						modells.getValueAt(i,8).toString()
		   						 );
		   				   books.add(monBook);
		   			 }
		    			new Save(books);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}});		    
		    JMenuItem SauvegarderSous = new JMenuItem("SauvegarderSous");
		    SauvegarderSous.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ev) {		    	
		    		try {
		    			DefaultTableModel modells = (DefaultTableModel) table.getModel();
		
		    			for(int i = 0 ; i < modells.getRowCount(); i++){
		    				String aQui = "";
		    				if(modells.getValueAt(i,6) == null) {
		    					aQui = "";
		    				} else {
		    					aQui = modells.getValueAt(i,6).toString();
		    				}
		   				 Livre monBook = new Livre(
		   						 
		   					    modells.getValueAt(i,0).toString(),
		   						modells.getValueAt(i,2).toString(),
		   						modells.getValueAt(i,1).toString(),
		   						Integer.parseInt(modells.getValueAt(i,3).toString()),
		   						Integer.parseInt(modells.getValueAt(i,4).toString()),
		   						Integer.parseInt(modells.getValueAt(i,5).toString()),
		   						aQui,
		   						modells.getValueAt(i,7).toString(),
		   						modells.getValueAt(i,8).toString()
		   						 );
		   				   books.add(monBook);
		   			 }
		    			new SaveUnder(books);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}});		    
		    JMenuItem Info = new JMenuItem(new AboutAction("About"));
		    
		    JMenuBar menuBar = new JMenuBar();
		    JMenu fichier = new JMenu("Fichier");
		    JMenu Edition = new JMenu("Edition");
		    JMenu About= new JMenu("About");
		    
		    fichier.add(Ouvrir);
		    fichier.add(Export);
		    fichier.add(Quitter);
		    
		    Edition.add(Sauvegarder);
		    Edition.add(SauvegarderSous);
		    
		    About.add(Info);
		    
		    menuBar.add(fichier);
		    menuBar.add(Edition); 
		    menuBar.add(About);
		    
		    frame.add(menuBar);
		    frame.setJMenuBar(menuBar);
	        
	        // set the model to the table
	        table.setModel(model);
	        
	        // Change A JTable Background Color, Font Size, Font Color, Row Height
	        table.setBackground(Color.LIGHT_GRAY);
	        table.setForeground(Color.black);
	        Font font = new Font("",1,22);
	        table.setFont(font);
	        table.setRowHeight(30);
	        
	        
	    
	        
	     // create JButtons
	        JButton btnAdd = new JButton("+");
	        JButton btnUpdate = new JButton("Update");
	        JButton btnDelete = new JButton("-");
	        
	        
	        btnAdd.setBounds(1050, 220, 100, 25);
	        btnUpdate.setBounds(1050, 265, 100, 25);
	        btnDelete.setBounds(1050, 310, 100, 25);
	        
	     // create JScrollPane
	        JScrollPane pane = new JScrollPane(table);
	        pane.setBounds(0, 0, 1200, 200);
	        
	        frame.setLayout(null);
	        
	        frame.add(pane);
	       
	        // add JButtons to the jframe
	        frame.add(btnAdd);
	        frame.add(btnDelete);
	        frame.add(btnUpdate);
	   
	        
	        // button add row
	        btnAdd.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	new FormWindow("", "", "", "", "", "", "", "", ""); 
	            }
	        });
	        
	        // button remove row
	        btnDelete.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            
	                // i = the index of the selected row
	            	SelectRow = table.getSelectedRow();	               
	            	if(SelectRow >= 0) {
	                    // remove a row from jtable
	                    model.removeRow(SelectRow);
	                }
	                else{
	            		 new AlertWindow("Veuillez sélectionnez un livre avant de le supprimer.");
	                }
	            }
	        });
	        
	     // get selected row data From table to textfields 
	        table.addMouseListener(new MouseAdapter(){
	        
	        @Override
	        public void mouseClicked(MouseEvent e) {	            
	            // i = the index of the selected row
	        	 SelectRow = table.getSelectedRow();
	        }
	        });
	        
	        // button update row
	        btnUpdate.addActionListener(new ActionListener(){
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	SelectRow = table.getSelectedRow();
	                 if(SelectRow >= 0) {
	                	 String aQui = "";
		    				if(model.getValueAt(SelectRow,6) == null) {
		    					aQui = "";
		    				} else {
		    					aQui = model.getValueAt(SelectRow,6).toString();
		    				}
		                 new FormWindow(model.getValueAt(SelectRow, 0).toString(), model.getValueAt(SelectRow, 1).toString(), model.getValueAt(SelectRow, 2).toString(), model.getValueAt(SelectRow, 3).toString(), model.getValueAt(SelectRow, 4).toString(), model.getValueAt(SelectRow, 5).toString(),aQui,model.getValueAt(SelectRow, 7).toString(), model.getValueAt(SelectRow, 8).toString());
	                 } else {
	            		 new AlertWindow("Veuillez sélectionnez un livre avant de le modifier.");
	                 }
	            }
	        });
	        
	        frame.setSize(1200,475);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);	
	}
	

	public static void AddElementTableau(Object[] row){

        model.addRow(row);
	}
	
	public static void ModificationTableau(Object[] row){
	       if(SelectRow >= 0) 
	       {
	          model.setValueAt(row[0].toString(), SelectRow, 0);
	          model.setValueAt(row[1].toString(), SelectRow, 1);
	          model.setValueAt(row[2].toString(), SelectRow, 2);
	          model.setValueAt(row[3].toString(), SelectRow, 3);
	          model.setValueAt(row[4].toString(), SelectRow, 4);
	          model.setValueAt(row[5].toString(), SelectRow, 5);
	          model.setValueAt(row[6].toString(), SelectRow, 6);
	          model.setValueAt(row[7].toString(), SelectRow, 7);
	          model.setValueAt(row[8].toString(), SelectRow, 8);   
	       }
	       
	       else{
	           System.out.println("Update Error");
	       }
		}
	
	
	public class QuitterAction extends AbstractAction {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public QuitterAction(String texte){
            super(texte);
        }

        public void actionPerformed(ActionEvent e) { 
            System.exit(0);
        } 
    }
	
	public class EditAction extends AbstractAction {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public EditAction(String texte){
            super(texte);
        }

        public void actionPerformed(ActionEvent e) { 
            System.exit(0);
        } 
    }
	
	
	
	public class AboutAction extends AbstractAction {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public AboutAction(String texte){
            super(texte);
        }

        public void actionPerformed(ActionEvent e){ 
        	new AlertWindow("Nous sommes 3 étudiants en M1 M2i MSID-ILS sur le site de Cergy Saint Christophe : Alexandre LORIER, Florian MANDAR, et Valentin STOCKMAN.");
            
            } 
    }
}
