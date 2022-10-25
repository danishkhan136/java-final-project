package contactbook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class savecontact extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField phno;
	private JTextField address;
	private JTextField email;
	private JTextField nick;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					savecontact frame = new savecontact();
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
	public savecontact() {
		setTitle("Contact book - Save Contact");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter contact information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 414, 65);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_0 = new JLabel("First name: ");
		lblNewLabel_1_0.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_0.setBounds(10, 105, 92, 14);
		contentPane.add(lblNewLabel_1_0);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last name: ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(10, 146, 92, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone number: ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setBounds(10, 186, 92, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address: ");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setBounds(10, 225, 92, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email: ");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setBounds(10, 267, 92, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Nickname: ");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setBounds(10, 311, 92, 14);
		contentPane.add(lblNewLabel_1_5);
		
		fname = new JTextField();
		fname.setBounds(112, 102, 204, 20);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(112, 143, 204, 20);
		contentPane.add(lname);
		
		phno = new JTextField();
		phno.setColumns(10);
		phno.setBounds(112, 183, 204, 20);
		contentPane.add(phno);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(112, 222, 204, 20);
		contentPane.add(address);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(112, 264, 204, 20);
		contentPane.add(email);
		
		nick = new JTextField();
		nick.setColumns(10);
		nick.setBounds(112, 308, 204, 20);
		contentPane.add(nick);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new choosepage().setVisible(true);
			dispose();			}
		});
		btnBack.setBounds(36, 343, 120, 23);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("Save Contact");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/contactbook","root", "");	
				Statement st = conn.createStatement();

				if(fname.getText().isEmpty()||lname.getText().isEmpty()||phno.getText().isEmpty()||address.getText().isEmpty()||email.getText().isEmpty()||nick.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Enter all values!");	
				}
				else {
					String sql = "insert into contacts values(?,?,?,?,?,?)";
					PreparedStatement ptstmt= conn.prepareStatement(sql);
					ptstmt.setString(1,fname.getText());
					ptstmt.setString(2,lname.getText());
					ptstmt.setString(3,phno.getText());
					ptstmt.setString(4,address.getText());
					ptstmt.setString(5,email.getText());
					ptstmt.setString(6,nick.getText());
					ptstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Contact saved!");
				}
			}
			catch(Exception ex) {
				JOptionPane.showConfirmDialog(null, ex);
			}
			}
		});
		btnNewButton.setBounds(236, 343, 126, 23);
		contentPane.add(btnNewButton);
	}

}
