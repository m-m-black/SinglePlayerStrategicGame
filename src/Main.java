
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	
	static Administrator admin; // made static so it can be accessed in Menu class
	static JPanel gamePanel;
	
	public static void startGame() {
		buildGUI();
	}
	
	public static void buildGUI() {
		// top level container
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		// main panel within frame
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		contentPane.setPreferredSize(new Dimension(550, 675));
		frame.setContentPane(contentPane);

		// gameplay panel
		gamePanel = new JPanel(new BorderLayout());
		gamePanel.setPreferredSize(new Dimension(550, 550));
		contentPane.add(gamePanel);

		// spacer panel
		JPanel spacerPanel = new JPanel(new BorderLayout());
		spacerPanel.setPreferredSize(new Dimension(550, 35));
		spacerPanel.setBackground(Color.DARK_GRAY);
		contentPane.add(spacerPanel);

		// menu panel
		JPanel menuPanel = new JPanel(new BorderLayout());
		menuPanel.setPreferredSize(new Dimension(550, 90));
		menuPanel.setBackground(Color.WHITE);
		contentPane.add(menuPanel);

		// create Grid and add to gameplay panel
		Grid grid = new Grid();
		gamePanel.add(grid);			
		Menu menu = new Menu();
		Menu.updateTimer();
		menuPanel.add(menu.getMenu());

		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		
		new LoginForm();
		admin = new Administrator("admin", "admin");
		admin.add(new StandardUser("Morgan","123"));
		admin.add(new StandardUser("CHEN","123"));
		
	}

}
