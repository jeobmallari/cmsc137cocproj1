import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.BoundedRangeModel;
import javax.swing.filechooser.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Color;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import javax.swing.UIManager;

public class sample{

	JFrame frmClashOfClans;
	JTextField txtEnterVillageName;
	JTextField txtEnterPassword;
	JTextField txtEnterVillageName2;
	JTextField txtEnterPassword2;
	JTextField txtConfirmPassword;
	JTextField villageName;
	JTextField numOfTrophies;
	JTextField chatField;
	JTextArea chatArea;
	JButton sendBtn;
	JScrollPane pane;
	JPanel panel_2;
	JPanel panel_1;
	DatagramPacket out;
	DatagramPacket dp;
	DatagramSocket s;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sample window = new sample();
					window.frmClashOfClans.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public sample() throws Exception{
		initialize();
		//chat();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize () throws IOException{
		 
		frmClashOfClans = new JFrame();
		frmClashOfClans.setTitle("CLASH OF CLANS");
		frmClashOfClans.setBounds(100, 100, 840, 588);
		frmClashOfClans.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClashOfClans.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 824, 549);
		frmClashOfClans.getContentPane().add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		JPanel signup = new JPanel();

		JPanel login = new JPanel();
		mainPanel.add(login, "name_210115789996997");
		login.setLayout(null);
		
		txtEnterVillageName = new JTextField();
		txtEnterVillageName.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEnterVillageName.setBackground(UIManager.getColor("Label.background"));
		txtEnterVillageName.setText("Enter village name");
		txtEnterVillageName.setBounds(270, 313, 256, 32);
		txtEnterVillageName.setOpaque(true);
		login.add(txtEnterVillageName);
		txtEnterVillageName.setColumns(10);
		
		txtEnterPassword = new JTextField();
		txtEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEnterPassword.setText("Enter password");
		txtEnterPassword.setBounds(270, 356, 256, 32);
		txtEnterPassword.setOpaque(true);
		login.add(txtEnterPassword);
		txtEnterPassword.setColumns(10);

		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtConfirmPassword.setText("Enter password");
		txtConfirmPassword.setBounds(270, 356, 256, 32);
		txtConfirmPassword.setOpaque(true);
		txtConfirmPassword.setColumns(10);

		ImageIcon icon = new ImageIcon("../img/signup_btn.jpg");
		Image img = icon.getImage() ;  
   		Image newimg = img.getScaledInstance(120,30,java.awt.Image.SCALE_SMOOTH) ;  
  		icon = new ImageIcon(newimg);
		JButton btnSignUp = new JButton("");
		btnSignUp.setIcon(icon);
		btnSignUp.setBounds(405, 448, 121, 32);
		login.add(btnSignUp);
		

		ImageIcon icon2 = new ImageIcon("../img/login_btn.jpg");
		Image img2 = icon2.getImage() ;  
   		Image newimg2 = img2.getScaledInstance(100,31,java.awt.Image.SCALE_SMOOTH) ;  
  		icon2 = new ImageIcon(newimg2);
		JButton btnLogin = new JButton("");
		btnLogin.setIcon(icon2);
		btnLogin.setBackground(new Color(240, 240, 240));
		btnLogin.setBounds(270, 448, 100, 32);
		login.add(btnLogin);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\DATA\\Desktop\\clash of clans\\coc_logo_2013.png"));
		label_1.setBounds(217, 42, 539, 201);
		login.add(label_1);

		JLabel lblNewLabel2 = new JLabel("");
		lblNewLabel2.setIcon(new ImageIcon("../img/home_bg.jpg"));
		lblNewLabel2.setBounds(0, 0, 824, 549);
		signup.add(lblNewLabel2);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c2 = (CardLayout)(mainPanel.getLayout());
				c2.next(mainPanel);
			}
		});

/*
		mainPanel.add(signup, "name_210125486665742");
		signup.setLayout(null);
		
		txtEnterVillageName2 = new JTextField();
		txtEnterVillageName2.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEnterVillageName2.setBackground(UIManager.getColor("Label.background"));
		txtEnterVillageName2.setText("Enter village name");
		txtEnterVillageName2.setBounds(270, 313, 256, 32);
		txtEnterVillageName2.setOpaque(true);
		signup.add(txtEnterVillageName2);
		txtEnterVillageName2.setColumns(10);
		
		txtEnterPassword2 = new JTextField();
		txtEnterPassword2.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtEnterPassword2.setText("Enter password");
		txtEnterPassword2.setBounds(270, 356, 256, 32);
		txtEnterPassword2.setOpaque(true);
		signup.add(txtEnterPassword2);
		txtEnterPassword2.setColumns(10);

		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtConfirmPassword.setText("Enter password");
		txtConfirmPassword.setBounds(270, 356, 256, 32);
		txtConfirmPassword.setOpaque(true);
		signup.add(txtConfirmPassword);
		txtConfirmPassword.setColumns(10);

	*/	
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..\\img\\home_bg.jpg"));
		lblNewLabel.setBounds(0, 0, 824, 549);
		login.add(lblNewLabel);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)(mainPanel.getLayout());
				cl.next(mainPanel);
			}
		});
		
		JPanel home = new JPanel();
		mainPanel.add(home, "name_210125486665742");
		home.setLayout(null);
		
		JPanel left = new JPanel();
		left.setBackground(Color.BLACK);
		left.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		left.setBounds(10, 11, 533, 527);
		home.add(left);
		left.setLayout(null);
		
		JPanel header = new JPanel();
		header.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		header.setBounds(10, 11, 513, 50);
		left.add(header);
		header.setLayout(null);
		
		villageName = new JTextField();
		villageName.setFont(new Font("Tahoma", Font.BOLD, 14));
		villageName.setEditable(false);
		villageName.setText("VILLAGE NAME");
		villageName.setBounds(10, 11, 226, 28);
		header.add(villageName);
		villageName.setColumns(10);
		
		numOfTrophies = new JTextField();
		numOfTrophies.setEditable(false);
		numOfTrophies.setText("Number of trophies");
		numOfTrophies.setBounds(275, 12, 112, 28);
		header.add(numOfTrophies);
		numOfTrophies.setColumns(10);
		
		JButton attack = new JButton("ATTACK");
		attack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		attack.setBounds(414, 11, 89, 28);
		header.add(attack);
		
		JPanel panel = new JPanel();
		panel.setBounds(246, 11, 36, 28);
		header.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\DATA\\Desktop\\Trophy.png"));
		label.setBounds(10, 0, 36, 28);
		panel.add(label);
		
		JPanel game = new JPanel();
		game.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		game.setBounds(10, 72, 513, 444);
		left.add(game);

		JLabel lblNewLabel3 = new JLabel("");
		lblNewLabel3.setIcon(new ImageIcon("../img/th.png"));
		lblNewLabel3.setBounds(10, 72, 513, 444);
		game.add(lblNewLabel3);
		
		JPanel right = new JPanel();
		right.setBackground(Color.BLACK);
		right.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		right.setBounds(553, 11, 261, 527);
		home.add(right);
		right.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 241, 254);
		right.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBounds(10, 276, 241, 240);
		right.add(panel_2);
		panel_2.setLayout(null);

		chatArea = new JTextArea();
		chatArea.setEditable(false);
		chatArea.setBounds(10, 11, 221, 162);

		JScrollPane scrollPane = new JScrollPane(chatArea);
		panel_2.add(chatArea);
	    panel_2.add(scrollPane, BorderLayout.CENTER);

		
		chatField = new JTextField();
		chatField.setBounds(10, 182, 145, 47);
		panel_2.add(chatField);
		chatField.setColumns(10);
		
		sendBtn = new JButton("Send");
		sendBtn.setBounds(165, 184, 66, 45);
		//sendBtn.addActionListener(this);
		panel_2.add(sendBtn);
	}
}
