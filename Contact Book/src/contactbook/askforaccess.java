package contactbook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class askforaccess extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField reason;
	private JTextField username;
	private JPasswordField password;
	private JLabel lblNewLabel;
	private JLabel lblWhyDoYou;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					askforaccess frame = new askforaccess();
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
	public askforaccess() {
		setTitle("Contact book - Request access");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setBounds(180, 72, 155, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		reason = new JTextField();
		reason.setBounds(180, 103, 155, 46);
		contentPane.add(reason);
		reason.setColumns(10);
		
		username = new JTextField();
		username.setBounds(180, 160, 155, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(180, 199, 155, 20);
		contentPane.add(password);
		
		JButton btnNewButton = new JButton("Request access");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/contactbook","root", "");	
					Statement st = conn.createStatement();
					if(name.getText().isEmpty()||reason.getText().isEmpty()||username.getText().isEmpty()||password.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Enter all the values!");
					}
					else {
						String sql = "insert into request values(?,?,?,?)";
						PreparedStatement ptstmt= conn.prepareStatement(sql);
						ptstmt.setString(1,name.getText());
						ptstmt.setString(2,reason.getText());
						ptstmt.setString(3,username.getText());
						ptstmt.setString(4,password.getText());
						ptstmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Your request has been recieved!");
					}
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnNewButton.setBounds(263, 227, 142, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(37, 75, 133, 14);
		contentPane.add(lblNewLabel);
		
		lblWhyDoYou = new JLabel("Why do you want access?");
		lblWhyDoYou.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWhyDoYou.setBounds(10, 119, 160, 14);
		contentPane.add(lblWhyDoYou);
		
		lblUsername = new JLabel("Username: ");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(37, 163, 133, 14);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(37, 202, 133, 14);
		contentPane.add(lblPassword);
		
		lblNewLabel_1 = new JLabel("Enter information to requst access for contactbook from owners");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 11, 440, 50);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			new loginpage().setVisible(true);
			dispose();
			}
		});
		btnNewButton_1.setBounds(24, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
