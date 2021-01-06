package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

import exceptions.GivenParameterNotExistingException;
import exceptions.PortOutOfBoundException;
import exceptions.UsedPortException;
import src.Configuration;
import src.MyWebServer;
import src.WebServerManager;

import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;

public class WebServerSetup extends JFrame {

	private JPanel contentPane;
	public JTextField portNumberInput;
	public JRadioButton maintananceServer;
	public JLabel portNumber;
	public JLabel lblNewLabel;
	public JButton btnNewButton_1;
	public JLabel lblNewLabel_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton;
	
	public WebServerRunning webserverrunning;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebServerSetup frame = new WebServerSetup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WebServerSetup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 4, 0, 0));
		 maintananceServer = new JRadioButton("Maintanance mode");
		contentPane.add(maintananceServer);
			
		
		maintananceServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		portNumber = new JLabel("Port Number:");
		contentPane.add(portNumber);
		
		portNumberInput = new JTextField();
		portNumberInput.setText(WebServerManager.configManager.getPort()+"");
		contentPane.add(portNumberInput);
		portNumberInput.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		contentPane.add(lblNewLabel_2);
		
		 lblNewLabel = new JLabel("SetDefaultRoot");
		contentPane.add(lblNewLabel);
		
		 btnNewButton_1 = new JButton("AddRoot");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
				j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        int r = j.showSaveDialog(null); 

		        if (r == JFileChooser.APPROVE_OPTION)  { 
		            System.out.println(j.getSelectedFile().getAbsolutePath());
		            try {
						WebServerManager.configManager.setWebRootFile(j.getSelectedFile().getAbsolutePath());
					} catch (GivenParameterNotExistingException e1) {
						e1.printStackTrace();
					}
		        } 
			}
		});

		contentPane.add(btnNewButton_1);
		
		 lblNewLabel_1 = new JLabel("SetDefaultMaintanance");
		contentPane.add(lblNewLabel_1);
		
		 btnNewButton_2 = new JButton("AddMaintanance");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
		        int r = j.showSaveDialog(null); 

		        if (r == JFileChooser.APPROVE_OPTION)  { 
		            System.out.println(j.getSelectedFile().getAbsolutePath());
		            try {
						WebServerManager.configManager.setMaintanancePage(j.getSelectedFile().getAbsolutePath());
					} catch (GivenParameterNotExistingException e1) {
						e1.printStackTrace();
					}
		        } 
			}
		});
		contentPane.add(btnNewButton_2);
		
		 btnNewButton = new JButton("Start Server");
		 
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int portNumber = Integer.parseInt(portNumberInput.getText());
				try {
					WebServerManager.configManager.setPort(portNumber);
					
				} catch (PortOutOfBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UsedPortException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				if(maintananceServer.isSelected()) {
					WebServerManager.configManager.setState("Maintanance");
				}
				

				
				Thread server = new Thread() {
					@Override
					public void run(){ 
						WebServerManager.configure();
					}
				};
				server.start();
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				 webserverrunning = new WebServerRunning(server);
				webserverrunning.setVisible(true);
		 	}
		 });
		 
		
		contentPane.add(btnNewButton);
		
		
		
		
		
	}

}
