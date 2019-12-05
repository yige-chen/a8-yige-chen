package a8;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Torus implements ActionListener {
	
	private boolean t;
	public Torus() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (t) {
			t = false;
		} else {
			t = true;
		}
		
	}
	
	public boolean getTorus() {
		return t;
	}
}
