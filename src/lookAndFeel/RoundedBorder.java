package lookAndFeel;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.Border;

public class RoundedBorder implements Border{

	private int radius;
	
	public RoundedBorder(int radius){
		
	}

	@Override
	public Insets getBorderInsets(Component arg0) {
		// TODO Auto-generated method stub
		return new Insets(radius+1, radius+1, radius+2, radius);
	}

	@Override
	public boolean isBorderOpaque() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void paintBorder(Component arg0, Graphics arg1, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		arg1.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
	}
	
}
