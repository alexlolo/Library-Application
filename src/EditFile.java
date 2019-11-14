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
	        
	        System.out.println("Creation File XML");
	        
	        for (int i = 0; i < newBooks.size(); i++) {
	
	            Element book = doc.createElement("livre");
	            racine.appendChild(book);
	
	            Element title = doc.createElement("titre");
	            title.appendChild(doc.createTextNode(newBooks.get(i).getTitre()));
	            book.appendChild(title);
	
	            Element editor = doc.createElement("auteur");
	            editor.appendChild(doc.createTextNode(newBooks.get(i).getAuteur()));                
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
	            
	            Element who = doc.createElement("whose");
	            who.appendChild(doc.createTextNode(newBooks.get(i).getWho()));
	            book.appendChild(who);
	            
	            Element type = doc.createElement("type");
	            type.appendChild(doc.createTextNode(newBooks.get(i).getType()));
	            book.appendChild(type);
	            
	            Element img = doc.createElement("urlImg");
	            img.appendChild(doc.createTextNode(newBooks.get(i).getImg()));
	            book.appendChild(img);
	            
	           
	
	            // write the content into xml file
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource source = new DOMSource(doc);
	            StreamResult resultat = new StreamResult(new File(chemin.toString()+".xml"));
	
	            transformer.transform(source, resultat);
	          
	        }
	        
	
	    } catch (ParserConfigurationException pce) {
	        pce.printStackTrace();
	    } catch (TransformerException tfe) {
	        tfe.printStackTrace();
	    }
	    System.out.println("Finishing XML ");
	}
}
