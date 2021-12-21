import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField gender;
    private JTextField username;
    private JTextField mob;
    private JTextField course;
    private JTextField address;
    private JTextField dob;
    private JPasswordField passwordField;
    private JButton btnNewButton;

    //MySQL conf
    String user = "root";
    String passwd = "yograj"; 

    //Application
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegistration frame = new UserRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //Frame

    public UserRegistration() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 750);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Student Registration");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(325, 52, 360, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblGender.setBounds(58, 405, 124, 36);
        contentPane.add(lblGender);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbladdress.setBounds(58, 486, 124, 36);
        contentPane.add(lbladdress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 151, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(214, 235, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 320, 228, 50);
        contentPane.add(email);
        email.setColumns(10);

        gender = new JTextField();
        gender.setFont(new Font("Tahoma", Font.PLAIN, 32));
        gender.setBounds(214, 405, 228, 50);
        contentPane.add(gender);
        gender.setColumns(10);

        address = new JTextField();
        address.setFont(new Font("Tahoma", Font.PLAIN, 32));
        address.setBounds(214, 490, 228, 50);
        contentPane.add(address);
        address.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 329, 139, 26);
        contentPane.add(lblMobileNumber);

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblcourse.setBounds(542, 413, 413, 26);
        contentPane.add(lblcourse);

        JLabel lbldob = new JLabel("DOB");
        lbldob.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lbldob.setBounds(542, 494, 413, 26);
        contentPane.add(lbldob);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(707, 151, 228, 50);
        contentPane.add(username);
        username.setColumns(10);        

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(707, 235, 228, 50);
        contentPane.add(passwordField);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mob.setBounds(707, 320, 228, 50);
        contentPane.add(mob);
        mob.setColumns(10);

        course = new JTextField();
        course.setFont(new Font("Tahoma", Font.PLAIN, 32));
        course.setBounds(707, 405, 228, 50);
        contentPane.add(course);
        course.setColumns(10);

        dob = new JTextField();
        dob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        dob.setBounds(707, 490, 228, 50);
        contentPane.add(dob);
        dob.setColumns(10);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String emailId = email.getText();
                String Gender = gender.getText();
                String userName = username.getText();
                String mobileNumber = mob.getText();
                int len = mobileNumber.length();
                String password = passwordField.getText();
                String Course = course.getText();
                String Address = address.getText();
                String Dob = dob.getText();

                String msg = "" + firstName;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_registration", user, passwd);

                    String query = "INSERT INTO users values('" + firstName + "','" + lastName + "','" + userName + "','" +
                        password + "','" + emailId + "','" + mobileNumber + "','" + Gender + "','" + Course + "','" + Address + "','" + Dob + "')";

                    Statement stat = connection.createStatement();
                    int x = stat.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 600, 259, 74);
        contentPane.add(btnNewButton);
    }
}