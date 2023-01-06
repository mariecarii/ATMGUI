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
    private static JLabel incorrectLogin;
    private static JLabel chooseAction;
    public static JButton depositButton;
    public static JButton wihdrawButton;
    public static JButton quitButton;
    public static JButton previousButton;
    public static JButton mainMenu;
    public JLabel balance;
    private static JTextField amount;
    private static JLabel howMuch;
    private static JButton enterDeposit;
    private static int balanceNumber = 0;
    private static JButton enterWithdraw;
    public static int previousTransAmount = 0;


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

        incorrectLogin = new JLabel("");
        incorrectLogin.setBounds(200, 200, 100, 80);
        welcomePanel.add(incorrectLogin);
        incorrectLogin.setVisible(false);


        //set balance
        balance = new JLabel("Balance: $" + balanceNumber);
        balance.setBounds(50,250,10,80);
        welcomePanel.add(balance);
        balance.setVisible(false);



        //ask question
        howMuch = new JLabel("How Much?");
        howMuch.setBounds(50,50,100,80);
        welcomePanel.add(howMuch);
        howMuch.setVisible(false);



        //take amount
        amount = new JTextField(20);
        amount.setBounds(50, 260, 100, 80);
        welcomePanel.add(amount);
        amount.setVisible(false);

        //ENTER BUTTON for deposit
        enterDeposit = new JButton("ENTER");
        enterDeposit.setBounds(50,200, 100, 80);
        welcomePanel.add(enterDeposit);
        enterDeposit.addActionListener(this);
        enterDeposit.setVisible(false);

        //ENTER BUTTON for withdraw
        enterWithdraw = new JButton("ENTER");
        enterWithdraw.setBounds(50,200,100,80);
        welcomePanel.add(enterWithdraw);
        enterWithdraw.addActionListener(this);
        enterWithdraw.setVisible(false);

        //account functions
        chooseAction = new JLabel("Choose Action: ");
        chooseAction.setBounds(50,50,100,80);
        welcomePanel.add(chooseAction);
        chooseAction.setVisible(false);

        depositButton = new JButton("A. DEPOSIT");
        depositButton.setBounds(50,70,100,80);
        welcomePanel.add(depositButton);
        depositButton.addActionListener(this);
        depositButton.setVisible(false);

        wihdrawButton = new JButton("B. WITHDRAW");
        wihdrawButton.setBounds(50,90,100,80);
        welcomePanel.add(wihdrawButton);
        wihdrawButton.addActionListener(this);
        wihdrawButton.setVisible(false);

        previousButton = new JButton("C. SEE PREVIOUS TRANSACTION");
        previousButton.setBounds(50,130,100,80);
        welcomePanel.add(previousButton);
        previousButton.addActionListener(this);
        previousButton.setVisible(false);

        quitButton = new JButton("D. QUIT");
        quitButton.setBounds(50,110,100,80);
        welcomePanel.add(quitButton);
        quitButton.addActionListener(this);
        quitButton.setVisible(false);

        // main menu button
        mainMenu = new JButton("MAIN MENU");
        mainMenu.setBounds(50,200,100,80);
        welcomePanel.add(mainMenu);
        mainMenu.addActionListener(this);
        mainMenu.setVisible(false);

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
                userLabel.setVisible(false);
                userText.setVisible(false);
                passwordLabel.setVisible(false);
                passText.setVisible(false);
                loginButton.setVisible(false);

                chooseAction.setVisible(true);
                depositButton.setVisible(true);
                wihdrawButton.setVisible(true);
                previousButton.setVisible(true);
                quitButton.setVisible(true);
            }
            else {
                incorrectLogin.setVisible(true);
                incorrectLogin.setText("INCORRECT LOGIN INFO");
            }


        }
        if (e.getSource() == depositButton) {
            chooseAction.setVisible(false);
            depositButton.setVisible(false);
            wihdrawButton.setVisible(false);
            previousButton.setVisible(false);

            balance.setVisible(true);
            howMuch.setVisible(true);
            amount.setVisible(true);
            enterDeposit.setVisible(true);

        }

        if (e.getSource() == enterDeposit) {
                String amountOfMoney = amount.getText();
                Integer amountOfMoney2 = Integer.parseInt(amountOfMoney);
                previousTransAmount = amountOfMoney2;
                Integer total = amountOfMoney2 + balanceNumber;
                balance.setText("Balance: $" + total);

                howMuch.setVisible(false);
                amount.setVisible(false);
                enterDeposit.setVisible(false);

                mainMenu.setVisible(true);
        }

        if (e.getSource() == wihdrawButton) {
            chooseAction.setVisible(false);
            depositButton.setVisible(false);
            wihdrawButton.setVisible(false);
            previousButton.setVisible(false);

            balance.setVisible(true);
            howMuch.setVisible(true);
            amount.setVisible(true);
            enterWithdraw.setVisible(true);

        }

        if (e.getSource() == enterWithdraw) {
            String amountOfMoney = amount.getText();
            Integer amountOfMoney2 = Integer.parseInt(amountOfMoney);
            previousTransAmount = -(amountOfMoney2);
            Integer total = balanceNumber - amountOfMoney2;
            balance.setText("Balance: $" + total);

            howMuch.setVisible(false);
            amount.setVisible(false);
            enterWithdraw.setVisible(false);

            mainMenu.setVisible(true);
        }

        if (e.getSource() == previousButton) {
            if (previousTransAmount < 0 ) {
                balance.setText("You withdrew: $" +previousTransAmount );
            }
            else if (previousTransAmount > 0) {
                balance.setText("You deposited: $" + previousTransAmount);
            }
            else {
                balance.setText("No previous transactions");
            }
            balance.setVisible(true);
            chooseAction.setVisible(false);
            depositButton.setVisible(false);
            wihdrawButton.setVisible(false);
            previousButton.setVisible(false);

            mainMenu.setVisible(true);
        }

        if (e.getSource() == mainMenu) {
            balance.setVisible(false);

            chooseAction.setVisible(true);
            depositButton.setVisible(true);
            wihdrawButton.setVisible(true);
            previousButton.setVisible(true);
            mainMenu.setVisible(false);

        }
        if (e.getSource() == quitButton) {
                System.exit(0);
        }



    }
}
