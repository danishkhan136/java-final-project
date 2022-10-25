package contactbook;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Font;

public class loginpage extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage frame = new loginpage();
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
	public loginpage() {
		setTitle("Contact book - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username :");
		lblNewLabel.setBounds(39, 107, 104, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(39, 166, 104, 35);
		contentPane.add(lblPassword);
		
		username = new JTextField();
		username.setBounds(136, 114, 172, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(136, 173, 172, 20);
		contentPane.add(pass);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					run();
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/contactbook","root", "");	
					Statement st = conn.createStatement();
					String un=username.getText();
					String pw=pass.getText();
					String username;
					String password;
					int x=0;
					
					  String sql = "Select * from login"; 
					  ResultSet rs = st.executeQuery(sql);
					  while(rs.next()) { 
					  username = rs.getString("username"); 
					  password = rs.getString("password");
					  if(un.equals(username) && pw.equals(password)) { 
						  new choosepage().setVisible(true); 
						  dispose();
						  x=1;
						  break;
					  } 
					 
					  
					  }
					  if(x==1) {
						   }
					  else {
						  JOptionPane.showMessageDialog(null, "Username Password Incorrect!");
					  }
					  
					  
					 
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error while connection to database!");
				}
			}
		});
		btnLogin.setBounds(166, 244, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblAskForAccess = new JLabel("Ask for Access?");
		lblAskForAccess.setForeground(new Color(0, 128, 255));
		lblAskForAccess.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			askforaccess obj = new askforaccess();
			obj.setVisible(true);
			dispose();
			}
		});
		lblAskForAccess.setHorizontalAlignment(SwingConstants.CENTER);
		lblAskForAccess.setBounds(136, 204, 172, 29);
		contentPane.add(lblAskForAccess);
		
		JLabel lblNewLabel_1 = new JLabel("Contact Book");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(60, 25, 268, 71);
		contentPane.add(lblNewLabel_1);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		
	}
}
