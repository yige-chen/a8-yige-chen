package a8;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class StartGame implements ActionListener {
	
	private JSpotBoard _board;
	private int[][] neighbor_count;
	private static final Color DEFAULT = new Color(0.8f, 0.8f, 0.8f);
	private int _x;
	private int _y;
	private int _up;
	private int _down;
	private boolean check;
	
	
	public StartGame(JSpotBoard board, int x, int y) {
		_board = board;
		neighbor_count = new int[x][y];
		//System.out.println(board.getSpotAt(1, 1).getBackground());
		_x = x;
		_y = y;
		check = true;
	}
	
	public StartGame(JSpotBoard board, int x, int y, int up,  int down) {
		_board = board;
		neighbor_count = new int[x][y];
		//System.out.println(board.getSpotAt(1, 1).getBackground());
		_x = x;
		_y = y;
		_up = up;
		_down = down;
		check = false;
		
	}

	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		if (check) {
			this.advance();
		} else {
			this.advance2();
		}
		
	
			/*try
			{
			    Thread.sleep(1000);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}*/
	
		//this.actionPerformed(e);
		
	}
	
	public void advance() {
		for (Spot s: _board) {
			int count = 0;
			int x = s.getSpotX();
			int y = s.getSpotY();
				
				
				//System.out.println(s.getBackground());
			
			
			if (x!=_x-1 ) {
				if (_board.getSpotAt(x+1, y).getBackground().equals((Color.BLACK))) {
					count ++;
				}
			} 
			if (x!=0 ) { 
				if( _board.getSpotAt(x-1, y).getBackground().equals((Color.BLACK))) {
					count ++;
				}
			} 
			if (y!=_y-1 ) { 
				if( _board.getSpotAt(x, y+1).getBackground().equals((Color.BLACK))) {
					count ++;
				}
			} 
			if (y!=0 ) { 
				if( _board.getSpotAt(x, y-1).getBackground().equals((Color.BLACK)) ){
					count ++;
				}		
			}
			if (x!=_x -1 && y!=_y-1 ) { 
				if( _board.getSpotAt(x+1, y+1).getBackground().equals((Color.BLACK))) {
					count ++;
				}
			} 
			if (x!=_x-1 && y!=0 ) { 
				if( _board.getSpotAt(x+1, y-1).getBackground().equals((Color.BLACK))) {
					count ++;
				}
			} 
			if (x!=0 && y!=_y-1 ) { 
				if( _board.getSpotAt(x-1, y+1).getBackground().equals((Color.BLACK))) {
					count ++;
				}
			} 
			if (x!=0 && y!=0 ) { 
				if( _board.getSpotAt(x-1, y-1).getBackground().equals((Color.BLACK))) {
					count ++;
				}
			}
			neighbor_count[x][y] = count;
				
		}
			
		for (Spot s: _board) {
				
			if (s.getBackground().equals(Color.BLACK)) {
				if (neighbor_count[s.getSpotX()][s.getSpotY()] <2 || neighbor_count[s.getSpotX()][s.getSpotY()] >3) {
					s.setBackground(DEFAULT);	
				} 
					//if (neighbor_count[s.getSpotX()][s.getSpotY()] ==2 || neighbor_count[s.getSpotX()][s.getSpotY()] ==3) {
						//s.setBackground(Color.BLACK);
					//}
			} else {
				if (neighbor_count[s.getSpotX()][s.getSpotY()] ==3) {
					s.setBackground(Color.BLACK);
				}
			}
			
		}
		
	}
	
	public void advance2() {
		for (Spot s: _board) {
			int count = 0;
			int x = s.getSpotX();
			int y = s.getSpotY();
				
				
				//System.out.println(s.getBackground());
			
			
			if (x!=_x-1 ) {
				if (_board.getSpotAt(x+1, y).getBackground().equals((Color.BLACK))) {
					count ++;
				}
			} 
			if (x!=0 ) { 
				if( _board.getSpotAt(x-1, y).getBackground().equals((Color.BLACK))) {
					count ++;
				}
			} 
			if (y!=_y-1 ) { 
				if( _board.getSpotAt(x, y+1).getBackground().equals((Color.BLACK))) {
					count ++;
				}
			} 
			if (y!=0 ) { 
				if( _board.getSpotAt(x, y-1).getBackground().equals((Color.BLACK)) ){
					count ++;
				}		
			}
			if (x!=_x -1 && y!=_y-1 ) { 
				if( _board.getSpotAt(x+1, y+1).getBackground().equals((Color.BLACK))) {
					count ++;
				}
			} 
			if (x!=_x-1 && y!=0 ) { 
				if( _board.getSpotAt(x+1, y-1).getBackground().equals((Color.BLACK))) {
					count ++;
				}
			} 
			if (x!=0 && y!=_y-1 ) { 
				if( _board.getSpotAt(x-1, y+1).getBackground().equals((Color.BLACK))) {
					count ++;
				}
			} 
			if (x!=0 && y!=0 ) { 
				if( _board.getSpotAt(x-1, y-1).getBackground().equals((Color.BLACK))) {
					count ++;
				}
			}
			neighbor_count[x][y] = count;
				
		}
			
		for (Spot s: _board) {
				
			if (s.getBackground().equals(Color.BLACK)) {
				if (neighbor_count[s.getSpotX()][s.getSpotY()] <_down || neighbor_count[s.getSpotX()][s.getSpotY()] >_up) {
					s.setBackground(DEFAULT);	
				} 
					//if (neighbor_count[s.getSpotX()][s.getSpotY()] ==2 || neighbor_count[s.getSpotX()][s.getSpotY()] ==3) {
						//s.setBackground(Color.BLACK);
					//}
			} else {
				if (neighbor_count[s.getSpotX()][s.getSpotY()] >=_down || neighbor_count[s.getSpotX()][s.getSpotY()] <=_up) {
					s.setBackground(Color.BLACK);
				}
			}
			
		}
		
	}
}
