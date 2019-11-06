import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Ouvrir {
	
	Ouvrir(){
		
		ArrayList<Livre> mesLivres = new ArrayList<Livre>();
		
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());
        FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
        jfc.setFileFilter(xmlfilter);
        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();

            String chemin  = selectedFile.getAbsolutePath();
            Bibliotheque bibliotheque = new Bibliotheque();

		    try {
		    	JAXBContext jc = JAXBContext.newInstance(Bibliotheque.class);
	            Unmarshaller unmarshaller = jc.createUnmarshaller();
	            //unmarshaller.setValidating(true);

	             bibliotheque = (Bibliotheque) unmarshaller.unmarshal(new File(chemin));
	           
	        	            
		          } catch (JAXBException e) {
		              e.printStackTrace();
		          }
		    new FenetrePrincipal(bibliotheque.getLivre());
		}
	}
	
}
