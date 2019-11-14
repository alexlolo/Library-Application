import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FenetreSecondaire {
	Object[] row = new Object[9];
	FenetreSecondaire() {
		JFrame frame2 = new JFrame("Ajouter un livre");
		frame2.setSize(300,475);
		frame2.setLayout(null);
		JLabel aQui = new JLabel("A QUI : ");
		JLabel type = new JLabel("TYPE : ");
		JLabel autor = new JLabel("AUTEUR : ");
		JLabel description = new JLabel("DESCRIPTION : ");
		JLabel parution = new JLabel("PARUTION : ");
		JLabel name = new JLabel("NOM : ");
		JLabel rangée = new JLabel("RANGÉE : ");
		JLabel colonne = new JLabel("COLONNE : ");
		JLabel img = new JLabel("IMAGE : ");
		JTextField textTitre = new JTextField();
        JTextField textAuteur = new JTextField();
        JTextField textPresentation = new JTextField();
        JTextField textParution = new JTextField();
        JTextField textColonne = new JTextField();
        JTextField textRange = new JTextField();
        JTextField textAQui = new JTextField();
        Object[] elements = new Object[]{"Acquis", "Prêt", "Prêté"};
		JComboBox textType = new JComboBox(elements);
        JTextField textImage = new JTextField();
		JButton bouton = new JButton("Ajouter");
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
        textPresentation.setBounds(150, 110, 100, 25);
        textParution.setBounds(150, 140, 100, 25);
        textTitre.setBounds(150, 170, 100, 25);
        textRange.setBounds(150, 200, 100, 25);
        textColonne.setBounds(150, 230, 100, 25);
        textImage.setBounds(150, 260, 100, 25);
        bouton.setBounds(100, 350, 100, 25);
        frame2.add(aQui);
        frame2.add(type);
        frame2.add(autor);
        frame2.add(description);
        frame2.add(parution);
        frame2.add(name);
        frame2.add(rangée);
        frame2.add(colonne);
        frame2.add(img);
		frame2.add(textAQui);
	    frame2.add(textType);
	    frame2.add(textAuteur);
	    frame2.add(textPresentation);
	    frame2.add(textColonne);
	    frame2.add(textParution);
	    frame2.add(textTitre);
	    frame2.add(textRange);
	    frame2.add(textColonne);
	    frame2.add(textImage);
	    frame2.add(bouton);
	    frame2.setVisible(true);
	    frame2.setLocation(1545,283);
	    frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    
	    bouton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                row[0] = textTitre.getText();
                row[1] = textAuteur.getText();
                row[2] = textPresentation.getText();
                row[3] = textParution.getText();
                row[4] = textColonne.getText();
                row[5] = textRange.getText(); 
                row[6] = textAQui.getText();
                row[7] = String.valueOf(textType.getSelectedItem());
                row[8] = textImage.getText();
                FenetrePrincipal.AddElementTableau(row);
                frame2.dispose();
                }
        });
	}
	
	FenetreSecondaire(String titre, String auteur, String texteDescription, String date, String column, String rank, String AQui, String image) {
		Image picture = null;
		JFrame frame2 = new JFrame("Ajouter un livre");
		frame2.setSize(300,700);
		frame2.setLayout(null);
		JLabel aQui = new JLabel("A QUI : ");
		JLabel type = new JLabel("TYPE : ");
		JLabel autor = new JLabel("AUTEUR : ");
		JLabel description = new JLabel("DESCRIPTION : ");
		JLabel parution = new JLabel("PARUTION : ");
		JLabel name = new JLabel("NOM : ");
		JLabel rangée = new JLabel("RANGÉE : ");
		JLabel colonne = new JLabel("COLONNE : ");
		JLabel img = new JLabel("IMAGE : ");
		JTextField textNom = new JTextField(titre);
        JTextField textAuteur = new JTextField(auteur);
        JTextField textDescription = new JTextField(texteDescription);
        JTextField textParution = new JTextField(date);
        JTextField textColonne = new JTextField(column);
        JTextField textAQui = new JTextField(AQui);
        JTextField textRangée = new JTextField(rank);
        Object[] elements = new Object[]{"Acquis", "Prêt", "Prêté"};
		JComboBox textType = new JComboBox(elements);
        JTextField textImage = new JTextField(image);
		JButton bouton = new JButton("Modifier");
		URL url;
		JLabel label = new JLabel();
		try {
			url = new URL(image);
			picture = ImageIO.read(url);
	         label = new JLabel(new ImageIcon(picture));
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
	         label = new JLabel("L'url n'est pas complète. Veuillez réessayer.");

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			  label = new JLabel("Une erreur est survenue. Veuillez réessayer une autre url.");
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
        label.setBounds(10, 300, 250,250);
        bouton.setBounds(100, 600, 100, 25);
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
	    frame2.setLocation(1545,283);	    
	    frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    
	    bouton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                row[0] = textNom.getText();
                row[1] = textAuteur.getText();
                row[2] = textDescription.getText();
                row[3] = textParution.getText();
                row[4] = textColonne.getText();
                row[5] = textRangée.getText();
                row[6] = textAQui.getText();
                row[7] = String.valueOf(textType.getSelectedItem());
                row[8] = textImage.getText();
                FenetrePrincipal.ModificationTableau(row);
                frame2.dispose();
                }
        });
	}
	
}
