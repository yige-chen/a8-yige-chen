package a8;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetGame implements ActionListener {
	
	private JSpotBoard _board;
	public ResetGame(JSpotBoard board) {
		_board = board;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (Spot s : _board) {
			s.setBackground(new Color(0.8f, 0.8f, 0.8f));;
		}
		
	}
}
