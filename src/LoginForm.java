/*
 * LoginForm, shown when program starts
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class LoginForm extends JFrame implements ActionListener {
	JFrame frame = new JFrame();
	//User user= new User();
	// Container container=getContentPane();
    JLabel userLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("RESET");
    JButton signupButton= new JButton("SIGNUP");
    JCheckBox showPassword=new JCheckBox("Show Password");
    boolean loginStatus = false; 
 
    LoginForm() {
    		createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        addActionEvent();
    }
    
    public void createWindow() {
    		frame.setTitle("Misfit");
    		frame.setVisible(true);
    		frame.getContentPane().setLayout(null);
    		frame.setBounds(10, 10, 370, 600);
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setResizable(false);
    }
   

    public void setLocationAndSize() {
    		userLabel.setBounds(50,150,100,30);
    		passwordLabel.setBounds(50,220,100,30);
    		userTextField.setBounds(150,150,150,30);
    		passwordField.setBounds(150,220,150,30);
    		showPassword.setBounds(150,250,150,30);
    		loginButton.setBounds(50,300,100,30);
    		signupButton.setBounds(200,300,100,30);
    		resetButton.setBounds(200,500,100,30);
    }
   
    public void addComponentsToFrame() {
    		frame.add(userLabel);
    		frame.add(passwordLabel);
    		frame.add(userTextField);
    		frame.add(passwordField);
    		frame.add(showPassword);
    		frame.add(loginButton);
    		frame.add(resetButton);
    		frame.add(signupButton);
    }
   
    public void addActionEvent() {
    		//adding Action listener to components
    		loginButton.addActionListener(this);
    		resetButton.addActionListener(this);
    		showPassword.addActionListener(this);
    		signupButton.addActionListener(this);
    }
   
    public void close() {
    		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
   
    @SuppressWarnings("deprecation")
    public boolean loginVerify() {
    		String userText;
	   	String pwdText;
	   	userText = userTextField.getText();
	   	pwdText = passwordField.getText();
	   	if (userText.equalsIgnoreCase("admin") && pwdText.equalsIgnoreCase("admin")) {
	   		return true;
	   	} else {
	   		for (int i = 0; i < Main.admin.getUserList().size(); i++) {   
	   			if (Main.admin.getUserList().get(i).getUsername().equals(userText)
           			&& Main.admin.getUserList().get(i).getPassword().equals(pwdText)) {
	   				return true;
	   			}   	   
	   		}
	   		return false;
	   	}
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
    		//Coding Part of LOGIN button
    		if (e.getSource() == loginButton) {
    			if (loginVerify() == true && userTextField.getText().equalsIgnoreCase("admin")) {
    				JOptionPane.showMessageDialog(this, "Login Successful");
    				frame.dispose();
    				new AdminForm();
    			} else if (loginVerify() == true) {
    				JOptionPane.showMessageDialog(this, "Login Successful");
    				frame.dispose();
    				javax.swing.SwingUtilities.invokeLater(new Runnable() {
    					public void run() {
    						Main.buildGUI();
    					}
    				});
    			} else {
    				JOptionPane.showMessageDialog(this, "Invalid username or password!");
    			}
    		}     
    		if(e.getSource() == signupButton) {  
    			// LoginForm m = new LoginForm();
	        	// m.setVisible(false) 
    			frame.dispose();
    			new SignUpForm();	        	
    		}
    		//Coding Part of RESET button
    		if (e.getSource() == resetButton) {
    			userTextField.setText("");
    			passwordField.setText("");
    		}
    		//Coding Part of showPassword JCheckBox
    		if (e.getSource() == showPassword) {
    			if (showPassword.isSelected()) {
    				passwordField.setEchoChar((char) 0);
    			} else {
    				passwordField.setEchoChar('*');
    			}
	       
    		}
    }
}
