package a8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SizePlus implements ActionListener {
	
	private JSpotBoard _board;
	private JTextField _x;
	private JTextField _y;
	private JTextField _up;
	private JTextField _down;
	
	public SizePlus(JTextField x, JTextField y, JTextField upper, JTextField lower ) {
		_x = x;
		_y = y;
		_up = upper;
		_down = lower;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Game of life");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Create panel for content. Uses BorderLayout. */
		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		main_frame.setContentPane(top_panel);

		/* Create ExampleWidget component and put into center
		 * of content panel.


		/* Create ExampleWidget component and put into center
		 * of content panel.
		 */
		if (Integer.parseInt(_up.getText()) == 3 && Integer.parseInt(_down.getText()) == 2) {
			GameOfLifeWidget ttt = new GameOfLifeWidget(Integer.parseInt(_x.getText()), Integer.parseInt(_y.getText()));
			top_panel.add(ttt);
		} else {
			GameOfLifeWidget ttt = new GameOfLifeWidget(Integer.parseInt(_x.getText()), Integer.parseInt(_y.getText()), Integer.parseInt(_up.getText()), Integer.parseInt(_down.getText()));
			top_panel.add(ttt);
		}
		
		

		/* Pack main frame and make visible. */
		
		main_frame.pack();
		main_frame.setVisible(true);	
		
	}

}
