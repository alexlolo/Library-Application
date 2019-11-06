import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class EditFile {
	
	EditFile(ArrayList<Livre> newBooks){
	
		File chemin = null ; 
		
		JFrame parentFrame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
	    fileChooser.setFileFilter(xmlfilter);
		fileChooser.setDialogTitle("Specify a file to save");   
		 
		int userSelection = fileChooser.showSaveDialog(parentFrame);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    chemin = fileToSave;
		}
		
	    try {
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
	
	        Document doc = docBuilder.newDocument();
	        Element racine = doc.createElement("bibliotheque");
	        doc.appendChild(racine);
	        
	        System.out.println("Avant ");
	        for (int i = 0; i < newBooks.size(); i++) {
	
	            Element book = doc.createElement("livre");
	            racine.appendChild(book);
	
	            Element title = doc.createElement("titre");
	            title.appendChild(doc.createTextNode(newBooks.get(i).getTitre()));
	            book.appendChild(title);
	
	            Element editor = doc.createElement("auteur");
	            
	
	            Element nom = doc.createElement("Nom");
	            editor.appendChild(doc.createTextNode(newBooks.get(i).getAuteur()));                
	            editor.appendChild(nom);
	            
	            Element prenom = doc.createElement("Prenom");
	            editor.appendChild(doc.createTextNode(newBooks.get(i).getAuteur()));                
	            editor.appendChild(prenom);
	            
	            book.appendChild(editor);
	            
	            Element presentation = doc.createElement("presentation");
	            presentation.appendChild(doc.createTextNode(newBooks.get(i).getPresentation()));
	            book.appendChild(presentation);
	
	            Element release = doc.createElement("parution");
	            release.appendChild(doc.createTextNode(Integer.toString(newBooks.get(i).getParution())));
	            book.appendChild(release);
	
	            Element colonne = doc.createElement("colonne");
	            colonne.appendChild(doc.createTextNode(Integer.toString(newBooks.get(i).getColonne())));
	            book.appendChild(colonne);
	
	            Element range = doc.createElement("rangee");
	            range.appendChild(doc.createTextNode(Integer.toString(newBooks.get(i).getRange())));
	            book.appendChild(range);
	            
	            System.out.println("Apres ");
	
	            // write the content into xml file
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource source = new DOMSource(doc);
	            StreamResult resultat = new StreamResult(new File(chemin.toString()+".xml"));
	
	            transformer.transform(source, resultat);
	            System.out.println("ta race pd  ");
	        }
	        
	
	    } catch (ParserConfigurationException pce) {
	        pce.printStackTrace();
	    } catch (TransformerException tfe) {
	        tfe.printStackTrace();
	    }
	}
}
