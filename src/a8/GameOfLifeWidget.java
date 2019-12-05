package a8;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import a8.JSpotBoard;
import a8.Spot;
import a8.SpotListener;


public class GameOfLifeWidget extends JPanel implements  SpotListener{
		
		private JSpotBoard _board;		/* SpotBoard playing area. */
		private JLabel _message;		/* Label for messages. */
  /* Needed to reset the background of the secret spot. */
		private static final Color DEFAULT = new Color(0.8f, 0.8f, 0.8f);
	/* Identifies who has next turn. */
		
		public GameOfLifeWidget(int _x, int _y) {
			
			/* Create SpotBoard and message label. */
			
			
			_message = new JLabel();
			
			/* Set layout and place SpotBoard at center. */
			
			setLayout(new BorderLayout());
			
			_board = new JSpotBoard(_x,_y);
			
			for(Spot s: _board) {
				s.setBackground(DEFAULT);
			}
			
			add(_board, BorderLayout.CENTER);
	
			/* Create subpanel for message area and reset button. */
			
			JPanel reset_message_panel = new JPanel();
			reset_message_panel.setLayout(new BorderLayout());
			
	
			/* Reset button. Add ourselves as the action listener. */
			ResetGame reset = new ResetGame(_board);
			StartGame start = new StartGame(_board,_board.getSpotWidth(), _board.getSpotHeight());
			RandomFill random = new RandomFill(_board);
			
			
			JButton reset_button = new JButton("Restart");
			JButton start_button = new JButton("Advance");
			JButton random_button  = new JButton("Random fill");
			
			//JButton stop_button = new JButton("Stop");
			
			reset_button.addActionListener(reset);
			start_button.addActionListener(start);
			random_button.addActionListener(random);
			
			reset_message_panel.add(reset_button, BorderLayout.EAST);
			reset_message_panel.add(start_button, BorderLayout.WEST);
			reset_message_panel.add(random_button, BorderLayout.CENTER);
			
			/* Add subpanel in south area of layout. */
			
			add(reset_message_panel, BorderLayout.SOUTH);
			
			JPanel upper_panel = new JPanel();
			
			upper_panel.setLayout(new BorderLayout());
			
			JPanel upper_panel_1 = new JPanel();
			upper_panel_1.setLayout(new BorderLayout());
			JPanel upper_panel_2 = new JPanel();
			upper_panel_2.setLayout(new BorderLayout());
			
			JTextField x = new JTextField(3);
			upper_panel_1.add(new JLabel("Width (10~500): "), BorderLayout.WEST);		
			x.setText("10");
			upper_panel_1.add(x,  BorderLayout.EAST);
			
			JTextField y= new JTextField(3);
			upper_panel_2.add(new JLabel("Height (10~500): "), BorderLayout.WEST);		
			y.setText("10");
			upper_panel_2.add(y,  BorderLayout.EAST);
			
			upper_panel.add(upper_panel_1, BorderLayout.NORTH);
			upper_panel.add(upper_panel_2, BorderLayout.CENTER);
			
			SizePlus size = new SizePlus(x,y);
			
			JButton size_button1  = new JButton("New Game In Another Size");
			
			
			size_button1.addActionListener(size);
			
			upper_panel.add(size_button1, BorderLayout.SOUTH);
		
			add(upper_panel, BorderLayout.NORTH);
			/* Add ourselves as a spot listener for all of the
			 * spots on the spot board.
			 */
			_board.addSpotListener(this);
	
			/* Reset game. */
			resetGame();
			
		}
	
		/* resetGame
		 * 
		 * Resets the game by clearing all the spots on the board,
		 * picking a new secret spot, resetting game status fields, 
		 * and displaying start message.
		 * 
		 */
		private void resetGame() {
			/* Clear all spots on board. Uses the fact that SpotBoard
			 * implements Iterable<Spot> to do this in a for-each loop.
			 */
	
			for (Spot s : _board) {
				s.clearSpot();
			}
	
			/* Reset the background of the old secret spot.
			 * Check _secret_spot for null first because call to 
			 * resetGame from constructor won't have a secret spot 
			 * chosen yet.
			 */
			
			_message.setText("Welcome to the Game of life.");
		}
	
	
		/* Implementation of SpotListener below. Implements game
		 * logic as responses to enter/exit/click on spots.
		 */
		
		@Override
		public void spotClicked(Spot s) {
			
			/* If game already won, do nothing. */
	
	
			/* Set up player and next player name strings,
			 * and player color as local variables to
			 * be used later.
			 */
			if (s.getBackground().equals(DEFAULT)) {
				s.setBackground(Color.BLACK);
			} else {
				s.setBackground(DEFAULT);
			}
			
			
		}
	
		@Override
		public void spotEntered(Spot s) {
			/* Highlight spot if game still going on. */
			s.highlightSpot();
		}
		
		@Override
		public void spotExited(Spot s) {
			/* Unhighlight spot. */
			
			s.unhighlightSpot();
		}
	
		
		
}
