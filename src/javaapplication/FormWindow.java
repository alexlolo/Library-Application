package javaapplication;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FormWindow {

	Object[] row = new Object[9];
	
	FormWindow(String titre, String auteur, String texteDescription, String date, String column, String rank, String AQui, String typeLivre, String image) {
		Image picture = null;
		String title = "";
		if(titre.isEmpty()) {
			title = "Ajouter un livre";
		} else {
			title = "Modifier un livre";
		}
		JFrame frame2 = new JFrame(title);
		
		frame2.setSize(320,700);
		frame2.setLayout(null);
		
		JLabel aQui = new JLabel("A QUI : ");
		JLabel type = new JLabel("TYPE : ");
		JLabel autor = new JLabel("AUTEUR : ");
		JLabel description = new JLabel("DESCRIPTION : ");
		JLabel parution = new JLabel("PARUTION : ");
		JLabel name = new JLabel("NOM : ");
		JLabel rangée = new JLabel("RANGEE : ");
		JLabel colonne = new JLabel("COLONNE : ");
		JLabel img = new JLabel("IMAGE : ");
    	JLabel errorLabel = new JLabel();
		JTextField textNom = new JTextField(titre);
        JTextField textAuteur = new JTextField(auteur);
        JTextField textDescription = new JTextField(texteDescription);
        JTextField textParution = new JTextField(date);
        JTextField textColonne = new JTextField(column);
        JTextField textAQui = new JTextField(AQui);
        JTextField textRangée = new JTextField(rank);
        Object[] elements = new Object[]{"Acquis", "Pret", "Prete"};
		JComboBox<?> textType = new JComboBox<Object>(elements);
		
		if(typeLivre.compareTo("Pret") == 0) {
			textType.setSelectedIndex(1);
		} else if(typeLivre.compareTo("Prete") == 1) {
			textType.setSelectedIndex(2);
		} else {
			textAQui.setEnabled(false);
			textType.setSelectedIndex(0);
		}
		textType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textType.getSelectedIndex() == 1 || textType.getSelectedIndex() == 2) {
					
					textAQui.setEnabled(true);
				}
				else {
					textAQui.setText("");
					textAQui.setEnabled(false);
				}
			}
		});
		String boutonText = "";
		if (titre.isEmpty()) {
			boutonText = "Ajouter";
		} else {
			boutonText = "Modifier";
		}
        JButton bouton = new JButton(boutonText);
        JTextField textImage = new JTextField(image);
		URL url;
		
		JLabel label = new JLabel();
		if(!titre.isEmpty()) {
			try {
				url = new URL(image);
				picture = ImageIO.read(url);
		        label = new JLabel(new ImageIcon(picture));
			} 
			catch(Exception e){
				label = new JLabel("L'url n'est pas correcte ou ne contient pas d'image.");
			}
		}
        aQui.setBounds(10, 20, 100, 25);
        type.setBounds(10, 50, 100, 25);
        autor.setBounds(10, 80, 100, 25);
        description.setBounds(10, 110, 100, 25);
        parution.setBounds(10, 140, 100, 25);
        name.setBounds(10, 170, 100, 25);
        rangée.setBounds(10, 200, 100, 25);
        colonne.setBounds(10, 230, 100, 25);
        img.setBounds(10, 260, 100, 25);
        textAQui.setBounds(150, 20, 100, 25);
        textType.setBounds(150, 50, 100, 25);
        textAuteur.setBounds(150, 80, 100, 25);
        textDescription.setBounds(150, 110, 100, 25);
        textParution.setBounds(150, 140, 100, 25);
        textNom.setBounds(150, 170, 100, 25);
        textRangée.setBounds(150, 200, 100, 25);
        textColonne.setBounds(150, 230, 100, 25);
        textImage.setBounds(150, 260, 100, 25);
        label.setBounds(10, 300, 350, 350);
        bouton.setBounds(100, 600, 100, 25);
		errorLabel.setBounds(100, 700, 0, 0);
        frame2.add(aQui);
        frame2.add(type);
        frame2.add(autor);
        frame2.add(description);
        frame2.add(parution);
        frame2.add(name);
        frame2.add(rangée);
        frame2.add(colonne);
        frame2.add(img);
		frame2.add(textNom);
	    frame2.add(textAuteur);
	    frame2.add(textDescription);
	    frame2.add(textParution);
	    frame2.add(textColonne);
	    frame2.add(textRangée);
	    frame2.add(textType);
	    frame2.add(textAQui);
	    frame2.add(textImage);
	    frame2.add(bouton);
	    frame2.add(label);    
	    frame2.setVisible(true);
	    frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    
	    bouton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		Integer.parseInt(textParution.getText());
            		Integer.parseInt(textRangée.getText());
            		Integer.parseInt(textColonne.getText());
            		if (textNom.getText().isEmpty() || textAuteur.getText().isEmpty() || textDescription.getText().isEmpty() || textParution.getText().isEmpty()  || textColonne.getText().isEmpty() || textRangée.getText().isEmpty() || textImage.getText().isEmpty()) {
                		new AlertWindow("Un de vos champs est vide. Veuillez le remplir.");
                	}
                	else if(Integer.parseInt(textParution.getText()) > 2019 || Integer.parseInt(textParution.getText()) < 0) {
                		 new AlertWindow("La date de parution doit être comprise entre 0 et 2019. Veuillez la modifier.");
                	}else if(Integer.parseInt(textRangée.getText()) < 0 || Integer.parseInt(textRangée.getText()) > 5) {
                    		 new AlertWindow("La rangée doit être comprise entre 0 et 5 inclus.");
                	}else if(Integer.parseInt(textColonne.getText()) < 0 || Integer.parseInt(textColonne.getText()) > 7) {
           			 new AlertWindow("La colonne doit être comprise entre 0 et 7 inclus.");
                	} else if(!textImage.getText().matches("^(http|https)://.*$")) {
                		new AlertWindow("L'url doit commencer par 'http://' ou 'https://'. Veuillez la modifier.");
                	} else {
                		 row[0] = textNom.getText();
                         row[1] = textAuteur.getText();
                         row[2] = textDescription.getText();
                         row[3] = textParution.getText();
                         row[4] = textColonne.getText();
                         row[5] = textRangée.getText();
                         row[6] = textAQui.getText();
                         row[7] = String.valueOf(textType.getSelectedItem());
                         row[8] = textImage.getText();
                         if(titre.equals("")) {
                        	 MainWindow.AddElementTableau(row);
                         } else {
                             MainWindow.ModificationTableau(row);
                         }
                         frame2.dispose();
                	}
            	} catch(Exception ex) {
            		new AlertWindow("La date de parution, la colonne ou la rangée n'est pas un nombre entier. Veuillez le corriger");
            	}
                }
        });
	}
	
	
}
