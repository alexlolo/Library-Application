import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class FenetrePrincipal {
	
	public ArrayList<Livre> books = new ArrayList<Livre>();
	
	FenetrePrincipal(){
		
		 // create JFrame and JTable
		 JFrame frame = new JFrame();
	        
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
		    
		    JMenuItem Sauvegarder = new JMenuItem("Sauvegarder");
		    Sauvegarder.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ev) {
		    	frame.setVisible(false);
		    		try {
						new Ouvrir();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}});
		    
		    JMenuItem SauvegarderSous = new JMenuItem("SauvegarderSous"); 
		    SauvegarderSous.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ev) {
		    	frame.setVisible(false);
		    		try {
						new Ouvrir();
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
		    fichier.add(Quitter);
		    
		    fichier.add(Ouvrir);
		    fichier.add(Quitter);
		    
		    Edition.add(Sauvegarder);
		    Edition.add(SauvegarderSous);
		    
		    About.add(Info);
		    
		    menuBar.add(fichier);
		    menuBar.add(Edition); 
		    menuBar.add(About);
		    
		    frame.add(menuBar);
		    frame.setJMenuBar(menuBar);
	        
	        JTable table = new JTable(); 
	        
	        Object[] columns = {"Titre","Auteur","Presentation","parution","colonne","range"};
	        DefaultTableModel model = new DefaultTableModel();
	        model.setColumnIdentifiers(columns);

	        // set the model to the table
	        table.setModel(model);
	        
	        // Change A JTable Background Color, Font Size, Font Color, Row Height
	        table.setBackground(Color.LIGHT_GRAY);
	        table.setForeground(Color.black);
	        Font font = new Font("",1,22);
	        table.setFont(font);
	        table.setRowHeight(30);
	        
	        
	        JTextField textTitre = new JTextField();
	        JTextField textAuteur = new JTextField();
	        JTextField textPresentation = new JTextField();
	        JTextField textParution = new JTextField();
	        JTextField textColonne = new JTextField();
	        JTextField textRange = new JTextField();
	        
	     // create JButtons
	        JButton btnAdd = new JButton("Add");
	        JButton btnDelete = new JButton("Delete");
	        JButton btnUpdate = new JButton("Update"); 
	        
	        textTitre.setBounds(20, 220, 100, 25);
	        textAuteur.setBounds(20, 250, 100, 25);
	        textPresentation.setBounds(20, 280, 100, 25);
	        textParution.setBounds(20, 310, 100, 25);
	        textColonne.setBounds(20, 340, 100, 25);
	        textRange.setBounds(20, 370, 100, 25);
	        
	        btnAdd.setBounds(150, 220, 100, 25);
	        btnUpdate.setBounds(150, 265, 100, 25);
	        btnDelete.setBounds(150, 310, 100, 25);
	        
	        
	     // create JScrollPane
	        JScrollPane pane = new JScrollPane(table);
	        pane.setBounds(0, 0, 880, 200);
	        
	        frame.setLayout(null);
	        
	        frame.add(pane);
	        
	        // add JTextFields to the jframe
	        frame.add(textTitre);
	        frame.add(textAuteur);
	        frame.add(textPresentation);
	        frame.add(textParution);
	        frame.add(textColonne);
	        frame.add(textRange);
	    
	        // add JButtons to the jframe
	        frame.add(btnAdd);
	        frame.add(btnDelete);
	        frame.add(btnUpdate);
	        
	        // create an array of objects to set the row data
	        Object[] row = new Object[6];
	        
	        // button add row
	        btnAdd.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                row[0] = textTitre.getText();
	                row[1] = textAuteur.getText();
	                row[2] = textPresentation.getText();
	                row[3] = textParution.getText();
	                row[4] = textColonne.getText();
	                row[5] = textRange.getText();
	                
	                // add row to the model
	                model.addRow(row);
	            }
	        });
	        
	        // button remove row
	        btnDelete.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            
	                // i = the index of the selected row
	                int i = table.getSelectedRow();
	                if(i >= 0){
	                    // remove a row from jtable
	                    model.removeRow(i);
	                }
	                else{
	                    System.out.println("Delete Error");
	                }
	            }
	        });
	        
	     // get selected row data From table to textfields 
	        table.addMouseListener(new MouseAdapter(){
	        
	        @Override
	        public void mouseClicked(MouseEvent e){
	            
	            // i = the index of the selected row
	            int i = table.getSelectedRow();
	            
	            textTitre.setText(model.getValueAt(i, 0).toString());
	            textAuteur.setText(model.getValueAt(i, 1).toString());
	            textPresentation.setText(model.getValueAt(i, 2).toString());
	            textParution.setText(model.getValueAt(i, 3).toString());
	            textColonne.setText(model.getValueAt(i, 4).toString());
	            textRange.setText(model.getValueAt(i, 5).toString());
	        }
	        });
	        
	        // button update row
	        btnUpdate.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(textTitre.getText(), i, 0);
	                   model.setValueAt(textAuteur.getText(), i, 1);
	                   model.setValueAt(textPresentation.getText(), i, 2);
	                   model.setValueAt(textParution.getText(), i, 3);
	                   model.setValueAt(textColonne.getText(), i, 4);
	                   model.setValueAt(textRange.getText(), i, 5);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
	            }
	        });
	        
	        frame.setSize(900,475);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);	
	}
	
	FenetrePrincipal(List<Bibliotheque.Livre>mesLivres){
		
		 // create JFrame and JTable
		 JFrame frame = new JFrame();
		 
		 JTable table = new JTable(){
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
	        
	        Object[] columns = {"Titre","Auteur","Presentation","parution","colonne","range"};
	        DefaultTableModel model = new DefaultTableModel(columns,0);
	        
	        for(int i = 0 ; i < mesLivres.size(); i++){
	        	
	        	String titre = mesLivres.get(i).getTitre();
	        	String auteur = mesLivres.get(i).getAuteur().getNom()+""+ mesLivres.get(i).getAuteur().getPrenom();
	        	String presentation = mesLivres.get(i).getPresentation();
	        	int parution = mesLivres.get(i).getParution();
	        	int colonne = mesLivres.get(i).getColonne();
	        	int range = mesLivres.get(i).getRangee();
	        	
	        	Object[] data = {titre, auteur, presentation, parution, colonne, range};
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
	        
		    JMenuItem Quitter = new JMenuItem(new QuitterAction("Quitter"));
		    
		    JMenuItem Sauvegarder = new JMenuItem("Sauvegarder");
		    Sauvegarder.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ev) {
		    	frame.setVisible(false);
		    	
		    		try {
		    			DefaultTableModel modells = (DefaultTableModel) table.getModel();
		
		    			for(int i = 0 ; i < modells.getRowCount(); i++){
		    				
		   				 Livre monBook = new Livre(
		   						 
		   						modells.getValueAt(i,0).toString(),
		   						modells.getValueAt(i,1).toString(),
		   						modells.getValueAt(i,2).toString(),
		   						 Integer.parseInt(modells.getValueAt(i,3).toString()),
		   						Integer.parseInt(modells.getValueAt(i,4).toString()),
		   						Integer.parseInt(modells.getValueAt(i,5).toString())
		   						 );
		   				   books.add(monBook);
		   			 }
		    			new Edit(books);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	}});		    
		    JMenuItem SauvegarderSous = new JMenuItem("SauvegarderSous");
		    SauvegarderSous.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent ev) {
		    	frame.setVisible(false);
		    	
		    		try {
		    			DefaultTableModel modells = (DefaultTableModel) table.getModel();
		
		    			for(int i = 0 ; i < modells.getRowCount(); i++){
		    				
		   				 Livre monBook = new Livre(
		   						 
		   					    modells.getValueAt(i,0).toString(),
		   						modells.getValueAt(i,1).toString(),
		   						modells.getValueAt(i,2).toString(),
		   						Integer.parseInt(modells.getValueAt(i,3).toString()),
		   						Integer.parseInt(modells.getValueAt(i,4).toString()),
		   						Integer.parseInt(modells.getValueAt(i,5).toString())
		   						 );
		   				   books.add(monBook);
		   			 }
		    			new EditFile(books);
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
		    fichier.add(Quitter);
		    
		    fichier.add(Ouvrir);
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
	        
	        
	        JTextField textTitre = new JTextField();
	        JTextField textAuteur = new JTextField();
	        JTextField textPresentation = new JTextField();
	        JTextField textParution = new JTextField();
	        JTextField textColonne = new JTextField();
	        JTextField textRange = new JTextField();
	        
	     // create JButtons
	        JButton btnAdd = new JButton("Add");
	        JButton btnDelete = new JButton("Delete");
	        JButton btnUpdate = new JButton("Update"); 
	        
	        textTitre.setBounds(20, 220, 100, 25);
	        textAuteur.setBounds(20, 250, 100, 25);
	        textPresentation.setBounds(20, 280, 100, 25);
	        textParution.setBounds(20, 310, 100, 25);
	        textColonne.setBounds(20, 340, 100, 25);
	        textRange.setBounds(20, 370, 100, 25);
	        
	        btnAdd.setBounds(150, 220, 100, 25);
	        btnUpdate.setBounds(150, 265, 100, 25);
	        btnDelete.setBounds(150, 310, 100, 25);
	        
	        
	     // create JScrollPane
	        JScrollPane pane = new JScrollPane(table);
	        pane.setBounds(0, 0, 880, 200);
	        
	        frame.setLayout(null);
	        
	        frame.add(pane);
	        
	        // add JTextFields to the jframe
	        frame.add(textTitre);
	        frame.add(textAuteur);
	        frame.add(textPresentation);
	        frame.add(textParution);
	        frame.add(textColonne);
	        frame.add(textRange);
	    
	        // add JButtons to the jframe
	        frame.add(btnAdd);
	        frame.add(btnDelete);
	        frame.add(btnUpdate);
	        
	        // create an array of objects to set the row data
	        Object[] row = new Object[6];
	        
	        // button add row
	        btnAdd.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                row[0] = textTitre.getText();
	                row[1] = textAuteur.getText();
	                row[2] = textPresentation.getText();
	                row[3] = textParution.getText();
	                row[4] = textColonne.getText();
	                row[5] = textRange.getText();
	                
	                // add row to the model
	                model.addRow(row);
	            }
	        });
	        
	        // button remove row
	        btnDelete.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            
	                // i = the index of the selected row
	                int i = table.getSelectedRow();
	                if(i >= 0){
	                    // remove a row from jtable
	                    model.removeRow(i);
	                }
	                else{
	                    System.out.println("Delete Error");
	                }
	            }
	        });
	        
	     // get selected row data From table to textfields 
	        table.addMouseListener(new MouseAdapter(){
	        
	        @Override
	        public void mouseClicked(MouseEvent e){
	            
	            // i = the index of the selected row
	            int i = table.getSelectedRow();
	            
	            textTitre.setText(model.getValueAt(i, 0).toString());
	            textAuteur.setText(model.getValueAt(i, 1).toString());
	            textPresentation.setText(model.getValueAt(i, 2).toString());
	            textParution.setText(model.getValueAt(i, 3).toString());
	            textColonne.setText(model.getValueAt(i, 4).toString());
	            textRange.setText(model.getValueAt(i, 5).toString());
	        }
	        });
	        
	        // button update row
	        btnUpdate.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	                // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(textTitre.getText(), i, 0);
	                   model.setValueAt(textAuteur.getText(), i, 1);
	                   model.setValueAt(textPresentation.getText(), i, 2);
	                   model.setValueAt(textParution.getText(), i, 3);
	                   model.setValueAt(textColonne.getText(), i, 4);
	                   model.setValueAt(textRange.getText(), i, 5);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
	            }
	        });
	        
	        frame.setSize(900,475);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);	
	}
	

	public static void main(String[] args){
        
       new FenetrePrincipal();
       
	}
	
	public class QuitterAction extends AbstractAction {
        public QuitterAction(String texte){
            super(texte);
        }

        public void actionPerformed(ActionEvent e) { 
            System.exit(0);
        } 
    }
	
	public class EditAction extends AbstractAction {
        public EditAction(String texte){
            super(texte);
        }

        public void actionPerformed(ActionEvent e) { 
            System.exit(0);
        } 
    }
	
	
	
	public class AboutAction extends AbstractAction {
        public AboutAction(String texte){
            super(texte);
        }

        public void actionPerformed(ActionEvent e){ 
            JFrame frame = new JFrame();
            frame.setTitle("About");
            frame.setPreferredSize(new Dimension(875, 300));
            frame.setLocation(100,100); 
            frame.setLocationRelativeTo(null);
            JLabel label = new JLabel("Nous sommes 3 étudiants en M1 M2i MSID-ILS sur le site de Cergy Saint Christophe : Alexandre LORIER, Florian MANDAR, et Valentin STOCKMAN.");
            frame.add(label);
            frame.pack();
            frame.setVisible(true);
            } 
    }
}
