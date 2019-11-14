package javaapplication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AlertWindow {
	AlertWindow(String alert) {
		JFrame frame3 = new JFrame("Erreur");
		
		frame3.setSize(600,200);
		frame3.setLayout(null);
		JLabel errorMessage = new JLabel(alert);
		JButton bouton2 = new JButton("OK");
        errorMessage.setBounds(20, 20, 550, 50);
        bouton2.setBounds(180,75,100,20);
        frame3.add(errorMessage);
        frame3.add(bouton2);
	    frame3.setVisible(true);
	    frame3.setLocationRelativeTo(null);
	    frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    bouton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame3.dispose();
            }
	});
	}
}
