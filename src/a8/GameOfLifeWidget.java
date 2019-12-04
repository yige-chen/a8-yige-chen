package a8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JSpotBoard;
import Spot;
import SpotListener;
import ExampleWidget.Player;

public class GameOfLifeWidget extends JPanel implements  SpotListener{
		
		private JSpotBoard _board;		/* SpotBoard playing area. */
		private JLabel _message;		/* Label for messages. */
  /* Needed to reset the background of the secret spot. */
		private static final Color DEFAULT = new Color(0.8f, 0.8f, 0.8f);
	/* Identifies who has next turn. */
		
		public GameOfLifeWidget(int x, int y) {
			
			/* Create SpotBoard and message label. */
			
			_board = new JSpotBoard(x,y);
			
			for(Spot s: _board) {
				s.setBackground(DEFAULT);
			}
			_message = new JLabel();
			
			/* Set layout and place SpotBoard at center. */
			
			setLayout(new BorderLayout());
			add(_board, BorderLayout.CENTER);
	
			/* Create subpanel for message area and reset button. */
			
			JPanel reset_message_panel = new JPanel();
			reset_message_panel.setLayout(new BorderLayout());
	
			/* Reset button. Add ourselves as the action listener. */
			ResetGame reset = new ResetGame(_board);
			StartGame start = new StartGame(_board,x,y);
			
			JButton reset_button = new JButton("Restart");
			JButton start_button = new JButton("Start");
			//JButton stop_button = new JButton("Stop");
			
			reset_button.addActionListener(reset);
			start_button.addActionListener(start);
			//stop_button.addActionListener(this);
			reset_message_panel.add(reset_button, BorderLayout.EAST);
			reset_message_panel.add(start_button, BorderLayout.WEST);
			//reset_message_panel.add(stop_button, BorderLayout.EAST);
			reset_message_panel.add(_message, BorderLayout.CENTER);
	
			/* Add subpanel in south area of layout. */
			
			add(reset_message_panel, BorderLayout.SOUTH);
			
	
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
			
			s.setBackground(Color.BLACK);
		}
	
		@Override
		public void spotEntered(Spot s) {
			/* Highlight spot if game still going on. */
			
			if (s.getBackground() == Color.BLACK) {
				return;
			}
			s.highlightSpot();
		}
	
		@Override
		public void spotExited(Spot s) {
			/* Unhighlight spot. */
			
			s.unhighlightSpot();
		}
}
