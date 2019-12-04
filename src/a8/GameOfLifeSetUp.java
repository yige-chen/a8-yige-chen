package a8;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameOfLifeSetUp {
	public static void main(String[] args) {
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Game Of Life Set Up");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		main_frame.setContentPane(top_panel);
		
		SetUpWidget setup = new SetUpWidget();
		main_frame.setContentPane(setup);
		
		main_frame.pack();
		main_frame.setVisible(true);
	}

}
