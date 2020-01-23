package javaapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConnectionWindow {
	ConnectionWindow() {
		JFrame frame = new JFrame("Connexion");
		frame.setSize(350,200);
		frame.setLayout(null);
		JLabel loginText = new JLabel("Login : ");
		JLabel passwordText = new JLabel("Mot de passe : ");
		JTextField login = new JTextField();
		JTextField password = new JTextField();
		JButton bouton2 = new JButton("Se connecter");
		loginText.setBounds(20, 20, 100, 20);
		passwordText.setBounds(20, 50, 100, 20);
		login.setBounds(150, 20, 100, 20);
		password.setBounds(150, 50, 100, 20);
        bouton2.setBounds(100,100,150,20);
        frame.add(loginText);
        frame.add(passwordText);
        frame.add(login);
        frame.add(password);
        frame.add(bouton2);
	    frame.setVisible(true);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    bouton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	String txtpassword = password.getText();
                String txtuser = login.getText();

                if (txtuser.contains("alex") && txtpassword.contains("lorier"))
                {
                    login.setText(null);
                    password.setText(null);

                    // verification pour savoir si admin ou user 

                    frame.dispose();
                    new AdminWindow();
                }

                else 
                {
                    new AlertWindow("Connexion invalide !");
                    login.setText(null);
                    password.setText(null);
                }
            	frame.dispose();
            	new UserWindow();
            }
	});
	}
}
