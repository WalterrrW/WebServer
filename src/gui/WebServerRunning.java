package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import src.WebServerManager;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class WebServerRunning extends JFrame {

	private JPanel contentPane;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_1;
	public JButton btnNewButton;

	public WebServerRunning(Thread server) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(2, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		 lblNewLabel = new JLabel("Server is in state: " + WebServerManager.configManager.getState());
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("Used Port: " + WebServerManager.configManager.getPort());
		contentPane.add(lblNewLabel_2);
		
		String def = setState();
//		lblNewLabel_1 = new JLabel("Default Page is: " + WebServerManager.configManager.getDefaultPage());
		lblNewLabel_1 = new JLabel("Default Page is: " + def);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton = new JButton("Stop Server");
		
		
		btnNewButton.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
				try {
					WebServerManager.serverConnect.close();
					server.interrupt();
				} catch (IOException e1) {
					System.out.println("Cannot close");
					e1.printStackTrace();
				}
				dispose();
			}
		});
		contentPane.add(btnNewButton);
	}
	
	public String setState() {
		if(WebServerManager.configManager.getState().equals("Maintanance")) {
			return WebServerManager.configManager.getMaintanancePage();
		} else {
			String defaultPath =  WebServerManager.configManager.getWebRootFile() + "\\" + WebServerManager.configManager.getDefaultPage();
			return defaultPath;
		}
	}

}
