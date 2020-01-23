package javaapplication;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Ouvrir {
	
	Ouvrir(){
				
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
		    new UserWindow(bibliotheque.getLivre());
		}
	}
	
}
