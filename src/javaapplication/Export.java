package javaapplication;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

public class Export {

	
Export(ArrayList<Livre> books) throws IOException{	
		
	      //Blank Document
	      XWPFDocument document = new XWPFDocument(); 
	      
	      CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
		  XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document, sectPr);
		  
		//write header content
			CTP ctpHeader = CTP.Factory.newInstance();
		    CTR ctrHeader = ctpHeader.addNewR();
			CTText ctHeader = ctrHeader.addNewT();
			
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
			Date date = new Date();
			String tctDate = format.format(date);
			
			String headerText = "generate : "+ tctDate+"Nom du fichier :  DemoBiBlio ";
			ctHeader.setStringValue(headerText);	
			XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, document);
		    XWPFParagraph[] parsHeader = new XWPFParagraph[1];
		    parsHeader[0] = headerParagraph;
		    policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);
		   	    
	      XWPFParagraph para1 = document.createParagraph();
	      XWPFRun run1 = para1.createRun();
	  		
	  		
	  		
	      run1.setText("Biblo");
	      run1.setFontSize(100);
	      para1.setAlignment(ParagraphAlignment.CENTER);
	      para1.setBorderBottom(Borders.BASIC_THIN_LINES);
	      para1.setBorderTop(Borders.BASIC_THIN_LINES);
	      para1.setPageBreak(true);
	      
	      
	      XWPFParagraph para2 = document.createParagraph();
	      XWPFRun run2 = para2.createRun();
	      run2.setText("Sommaire");
	      run2.setFontSize(16);
	      para2.setAlignment(ParagraphAlignment.CENTER);
	      para2.setPageBreak(true);
	      
	    //TABLEAU
          XWPFParagraph paragraphOutTitreTab = document.createParagraph();
          paragraphOutTitreTab.setAlignment(ParagraphAlignment.CENTER);
          XWPFRun titreTab = paragraphOutTitreTab.createRun();
          titreTab.isBold();
          titreTab.setFontSize(20);
          titreTab.setText("Tableau des emprunts");
          
          XWPFTable table = document.createTable();
          table.setWidth(8000);
          XWPFTableRow tableRowOne = table.getRow(0);
          tableRowOne.setHeight(1000);
          table.setTableAlignment(TableRowAlign.CENTER);

          tableRowOne.getCell(0).setText("Livre");
          tableRowOne.addNewTableCell().setText("Nom");

          //create second row 
          for (int i = 0; i < books.size(); i++) {
              if (books.get(i).getType().compareTo("Prete") == 0
                      || books.get(i).getType().compareTo("Pret") == 0) {
                  XWPFTableRow tableRowTwo = table.createRow();
                  tableRowTwo.setHeight(1000);
                  tableRowTwo.getCell(0).setText(books.get(i).getTitre());
                  tableRowTwo.getCell(1).setText(books.get(i).getWho());
              }
          }

          XWPFParagraph sautDePage = document.createParagraph();
          XWPFRun saut = sautDePage.createRun();
          saut.addBreak(BreakType.PAGE);
	     
   
	      //Write the Document in file system
          String path = "C:\\Users\\Val\\Desktop\\DemoBiblio.docx";
		try (FileOutputStream out = new FileOutputStream(new File(path))) {
			
			XWPFParagraph paras = document.createParagraph();
			XWPFRun run = paras.createRun();
			for (int i = 0; i <books.size(); i++ ) {
				
				run.setText(books.get(i).getTitre());
				run.addCarriageReturn();
				run.setText(books.get(i).getAuteur());
				run.addCarriageReturn();
				run.setText(books.get(i).getPresentation());
				run.addCarriageReturn();
				run.setText(books.get(i).getImg());
				run.addCarriageReturn();
				run.addCarriageReturn();
				run.addCarriageReturn();
				
			}
			
			document.write(out);
			new AlertWindow("Document written successully in " + path);	
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			new AlertWindow("Error while trying to write the document. Please try again later.");
			e.printStackTrace();
		}
	      
	}
	
}
