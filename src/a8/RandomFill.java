package a8;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RandomFill implements ActionListener {
	
	private JSpotBoard _board;
	public RandomFill(JSpotBoard board) {
		_board = board;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		boolean check = true;
		for (Spot s : _board) {
			if (s.getBackground().equals(Color.BLACK)) {
				check = false;
			}
		}
		if (check) {
			for (Spot s : _board) {
				if (Math.random()>0.5) {
					s.setBackground(Color.BLACK);
				}
			}
		}
		
	}

}
