package a8;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;



public class SetUpWidget extends JPanel implements ActionListener{
	private JTextField x;
	private JTextField y;
	private JButton add_song_button;
	
	
	public SetUpWidget() {
		
		x = new JTextField(3);
		add(new JLabel("Width: "));		
		x.setText("10");
		add(x);
		
		y = new JTextField(3);
		add(new JLabel("height: "));
		y.setText("10");
		add(y);
		
		add_song_button = new JButton("Create");
		add_song_button.setActionCommand("Create");
		add(add_song_button);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		int x = Integer.parseInt(this.x.getText());
		int y = Integer.parseInt(this.y.getText());
		
		if (x<10 || x > 500 || y < 10 || y > 500) {
			throw new RuntimeException("input out of range.");
		}
		
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Game of life");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Create panel for content. Uses BorderLayout. */
		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		main_frame.setContentPane(top_panel);

		/* Create ExampleWidget component and put into center
		 * of content panel.
		 */
		
		GameOfLifeWidget ttt = new GameOfLifeWidget(x,y);
		top_panel.add(ttt, BorderLayout.CENTER);


		/* Pack main frame and make visible. */
		
		main_frame.pack();
		main_frame.setVisible(true);
		
		this.x.setText("10");
		this.y.setText("10");
	}
	
	public int getX() {
		return Integer.parseInt(x.getText());
	}
	
	public int getY() {
		return Integer.parseInt(y.getText());
	}
	
}
