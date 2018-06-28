package lookAndFeel;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class FrameMovementManager implements MouseListener, MouseMotionListener{

	private JFrame myFrame;
	private Point initClickLoc = new Point();
	private Point initFrameLoc = new Point();
	
	public FrameMovementManager(JFrame theFrame) {
		myFrame = theFrame;
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
		// Calculate our new position
		Point mouseDelta = new Point(arg0.getXOnScreen() - initClickLoc.x, arg0.getYOnScreen() - initClickLoc.y); 
		
		int newX = initFrameLoc.x + mouseDelta.x;
		int newY = initFrameLoc.y + mouseDelta.y;
		
		// Set our new position
		myFrame.setLocation(newX, newY);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		initClickLoc = arg0.getLocationOnScreen();
		initFrameLoc = myFrame.getLocationOnScreen();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
