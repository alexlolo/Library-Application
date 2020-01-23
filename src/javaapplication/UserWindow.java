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

public class UserWindow {
	
	public JTable table = new JTable(); 
	public static Object[] columns = {"Titre","Auteur","Presentation","parution","colonne","rangee", "A Qui", "Type", "Image"};
	
	static DefaultTableModel model = new DefaultTableModel(columns,0);
	
	static int SelectRow = 0;
	public ArrayList<Livre> books = new ArrayList<Livre>();
	
	UserWindow(){
		
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
	
	UserWindow(List<Bibliotheque.Livre>mesLivres){
		
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
		    
		  
	        
		    JMenuItem Quitter = new JMenuItem(new QuitterAction("Quitter"));
		    		    
		    JMenuItem Info = new JMenuItem(new AboutAction("About"));
		    
		    JMenuBar menuBar = new JMenuBar();
		    JMenu fichier = new JMenu("Fichier");
		    JMenu About= new JMenu("About");
		    
		    fichier.add(Ouvrir);
		    fichier.add(Quitter);
		    		    
		    About.add(Info);
		    
		    menuBar.add(fichier);
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
	        
	     // create JScrollPane
	        JScrollPane pane = new JScrollPane(table);
	        pane.setBounds(0, 0, 1200, 200);
	        
	        frame.setLayout(null);
	        
	        frame.add(pane);
	        
	     // get selected row data From table to textfields 
	        table.addMouseListener(new MouseAdapter(){
	        
	        @Override
	        public void mouseClicked(MouseEvent e) {	            
	            // i = the index of the selected row
	        	 SelectRow = table.getSelectedRow();
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
