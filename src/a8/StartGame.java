package a8;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGame implements ActionListener {
	
	private JSpotBoard _board;
	private int[][] neighbor_count;
	private static final Color DEFAULT = new Color(0.8f, 0.8f, 0.8f);
	
	public StartGame(JSpotBoard board, int x, int y) {
		_board = board;
		neighbor_count = new int[x][y];
		//System.out.println(board.getSpotAt(1, 1).getBackground());
	}

	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
	
		while (true) {
			for (Spot s: _board) {
				int count = 0;
				int x = s.getSpotX();
				int y = s.getSpotY();
				
				
				//System.out.println(s.getBackground());
			
			
				if (x!=_board.getSpotWidth()-1 && _board.getSpotAt(x+1, y).getBackground()==( Color.BLACK)) {
					count ++;
				} else if (x!=0 && _board.getSpotAt(x-1, y).getBackground()==(Color.BLACK)) {
					count ++;
				} else if (y!=_board.getSpotHeight()-1 && _board.getSpotAt(x, y+1).getBackground()==(Color.BLACK)) {
					count ++;
				} else if (y!=0 && _board.getSpotAt(x, y-1).getBackground()==(Color.BLACK) ){
					count ++;
				} else if (x!=_board.getSpotWidth()-1 && y!=_board.getSpotHeight()-1 && _board.getSpotAt(x+1, y+1).getBackground()==(Color.BLACK)) {
					count ++;
				} else if (x!=_board.getSpotWidth()-1 && y!=0 && _board.getSpotAt(x+1, y-1).getBackground()==( Color.BLACK)) {
					count ++;
				} else if (x!=0 && y!=_board.getSpotHeight()-1 && _board.getSpotAt(x-1, y+1).getBackground()==(Color.BLACK)) {
					count ++;
				} else if (x!=0 && y!=0 && _board.getSpotAt(x-1, y-1).getBackground()==(Color.BLACK)) {
					count ++;
				}
				neighbor_count[x][y] = count;
				
			}
			
			for (Spot s: _board) {
				
				if (s.getBackground()==(Color.BLACK)) {
					if (neighbor_count[s.getSpotX()][s.getSpotY()] <2) {
						s.setBackground(DEFAULT);	
					}  else if (s.getBackground()==(Color.black)) {
						if (neighbor_count[s.getSpotX()][s.getSpotY()] ==2 || neighbor_count[s.getSpotX()][s.getSpotY()] ==3) {
						s.setBackground(Color.BLACK);
						}
					} else if (neighbor_count[s.getSpotX()][s.getSpotY()] >3) {
						s.setBackground(DEFAULT);
					}
				} else {
					if (neighbor_count[s.getSpotX()][s.getSpotY()] == 3) {
						s.setBackground(Color.BLACK);
					}
				}
			}
		
		
		}
	}
}
