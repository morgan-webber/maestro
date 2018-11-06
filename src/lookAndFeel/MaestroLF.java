package lookAndFeel;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MaestroLF {

	// Some basic colors
	public static Color exitBtnColor = new Color(242, 76, 78);
	public static Color minBtnColor = new Color(255, 194, 31);
	public static Color maxBtnColor = new Color(47, 244, 76);
	public static Color defaultBackground = new Color(50, 50, 50);

	// Nordic Ruby Color Palette
	public static Color nordicOrange = new Color(188, 65, 35);
	public static Color nordicBlue = new Color(11, 23, 42);
	public static Color nordicGrey = new Color(70, 57, 64);

	// Fiverr Color Palette
	public static Color fiverrBlue = new Color(55, 72, 89);
	public static Color fiverrBrown = new Color(159, 131, 112);

	// Solarin
	public static Color solarinGrey = new Color(44, 53, 49);
	public static Color solarinBlue = new Color(17, 100, 102);
	public static Color solarinBeige = new Color(217, 176, 140);
	public static Color solarinLightBeige = new Color(255, 200, 154);
	public static Color solarinLightBlue = new Color(209, 232, 226);

	public static Font maestroFont = null;

	// Various dynamic image paths we will use
	public static String dbErrorImage = "res/buttons/db_error_32x32.png";
	public static String dbImage = "res/buttons/db_32x32.png";



	public MaestroLF(){
	    try {
            maestroFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/nasalization-rg.ttf"));
        } catch (IOException|FontFormatException e) {
            e.printStackTrace();
        }


    }

}
