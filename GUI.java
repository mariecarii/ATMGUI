import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JPanel welcomePanel;
    JButton submitButton;
    JLabel credentialsLabel;
    JTextField nameField;
    private String userID = "";
    JLabel welcomeLabel;
    JLabel instructionLabel;
    JLabel nameLabel;
    JButton continueToLogin;

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
            char[] pin = new char[4];
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
            System.out.println("it works!");
            credentialsLabel.setVisible(false);
        }
    }
}
