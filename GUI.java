import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    private static JPanel welcomePanel;
    private static JButton submitButton;
    private static JLabel credentialsLabel;
    private static JTextField nameField;
    private static String userID = "";
    private static JLabel welcomeLabel;
    private static JLabel instructionLabel;
    private static JLabel nameLabel;
    private static JButton continueToLogin;
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passText;
    private static JButton loginButton;
    private static char[] pin;

    GUI() {

        welcomePanel = new JPanel();

        JFrame frame = new JFrame();
        frame.setTitle("Marie's Bank");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(welcomePanel);

        welcomePanel.setLayout(new FlowLayout());

        welcomeLabel = new JLabel("Welcome to Marie's Bank");
        welcomeLabel.setBounds(10,20,100,100);
        welcomePanel.add(welcomeLabel);

        instructionLabel = new JLabel("Please Enter Your Name to Recieve Your Log In Info");
        instructionLabel.setBounds(30, 20, 100, 100);
        welcomePanel.add(instructionLabel);

        nameLabel = new JLabel("ENTER NAME: ");
        nameLabel.setBounds(10,20,80,25);
        welcomePanel.add(nameLabel);

        nameField = new JTextField(20);
        nameField.setBounds(100,20,165,25);
        welcomePanel.add(nameField);

        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(200,20,100,80);
        submitButton.addActionListener(this);
        welcomePanel.add(submitButton);

        credentialsLabel = new JLabel("");
        credentialsLabel.setBounds(400,80,400,80);
        welcomePanel.add(credentialsLabel);

        continueToLogin = new JButton("Continue To Login");
        continueToLogin.setBounds(100, 50, 100, 100);
        continueToLogin.addActionListener(this);
        welcomePanel.add(continueToLogin);
        continueToLogin.setVisible(false);

        //login portion
        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        welcomePanel.add(userLabel);
        userLabel.setVisible(false);

        userText = new JTextField(25);
        userText.setBounds(100,20,165,25);
        welcomePanel.add(userText);
        userText.setVisible(false);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        welcomePanel.add(passwordLabel);
        passwordLabel.setVisible(false);

        passText = new JPasswordField(21);
        passText.setBounds(100, 50, 165, 25);
        welcomePanel.add(passText);
        passText.setVisible(false);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(200,20,100,80);
        welcomePanel.add(loginButton);
        loginButton.addActionListener(this);
        loginButton.setVisible(false);



        frame.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String user = nameField.getText();

            int length = 3;
            String numberSet = "1234567890";
            char[] id = new char[3];
            for (int i = 0; i < 3; i++) {
                int random = (int) (Math.random() * numberSet.length());
                id[i] = numberSet.charAt(random);
            }
            userID = user.substring(0,2).toUpperCase() + String.valueOf(id);

            System.out.println(userID);

            int length2 = 4;
            pin = new char[4];
            for (int i=0; i < 4; i++){
                int random = (int) (Math.random() * numberSet.length());
                pin[i] = numberSet.charAt(random);
            }

            credentialsLabel.setText("LOGIN CREDENTIALS:     " + "USERID: " + userID + " " + "PIN: " + String.valueOf(pin));

            welcomeLabel.setVisible(false);
            instructionLabel.setVisible(false);
            nameLabel.setVisible(false);
            submitButton.setVisible(false);
            nameField.setVisible(false);
            continueToLogin.setVisible(true);
        }

        if (e.getSource()== continueToLogin) {
            credentialsLabel.setVisible(false);
            continueToLogin.setVisible(false);

            userLabel.setVisible(true);
            userText.setVisible(true);
            passwordLabel.setVisible(true);
            passText.setVisible(true);
            loginButton.setVisible(true);

        }

        if (e.getSource() == loginButton) {

            String user = userText.getText();
            String password = passText.getText();

            if(user.equals(userID) && password.equals(String.valueOf(pin))) {
                System.out.println("CORRECT");
            }
            else {
                System.out.println("INCORRECT LOGIN");
            }
        }
    }
}
