package launcher;

import forms.AppFrame;
import lookAndFeel.MaestroLF;
import org.jdesktop.swingx.border.DropShadowBorder;

import java.awt.*;

import javax.swing.*;

public class Maestro {

	public static void main(String args[]) {
		
		
//		AppFrame window = new AppFrame();
//		window.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.getFrame().setVisible(true);

        // We can use this look/feel library for reference anywhere in the program
        MaestroLF lf = new MaestroLF();

		// Launch our app frame
		JFrame frame = new JFrame("Maestro");
		frame.setUndecorated(true);
		frame.setResizable(true);
		frame.setContentPane(new AppFrame(frame).getPanelContent());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create our neat drop shadow border
		DropShadowBorder shadowBorder = new DropShadowBorder();
		shadowBorder.setShadowSize(5);
		shadowBorder.setShadowColor(Color.black);
		shadowBorder.setShowBottomShadow(true);
		shadowBorder.setShowTopShadow(true);
		shadowBorder.setShowLeftShadow(true);
		shadowBorder.setShowRightShadow(true);
		frame.getRootPane().setBorder(shadowBorder);
		frame.getRootPane().setBackground(new Color(60,60,60));

		frame.pack();
		frame.setVisible(true);
	}
	
}
