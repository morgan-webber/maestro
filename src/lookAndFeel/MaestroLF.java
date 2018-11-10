package lookAndFeel;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MaestroLF {

	// Nordic Ruby Color Palette
    public static Color maestroTitleBar = new Color(43, 42, 50);
	public static Color maestroMainBackground = new Color(43, 43, 43);
    public static Color maestroCardBackground = new Color(49, 51, 53);
    public static Color maestroWhite = new Color(254, 254, 254);
    public static Color maestroGrey = new Color(169, 169, 173);
    public static Color maestroDarkGreen = new Color(0, 93, 87);
    public static Color maestroGreen = new Color(0, 185, 130);
    public static Color nordicOrange = new Color(188, 65, 35);
    public static Color maestroOrange = new Color(255, 105, 89);
    public static Color maestroYellow = new Color(252, 209, 83);
    public static Color maestroPurple = new Color(183, 76, 249);
    public static Color maestroBlue = new Color(116, 219, 253);

	// Fiverr Color Palette
	public static Color fiverrBlue = new Color(55, 72, 89);

	public static Font nasalizationFont = null;
    public static Font robotoFontRegular = null;
    public static Font robotoFontBold = null;
    public static Font openSansFontRegular = null;

	// Various dynamic image paths we will use
	public static String dbErrorImage = "res/buttons/db_error_32x32.png";
	public static String dbImage = "res/buttons/db_32x32.png";

	public MaestroLF(){
	    try {
            nasalizationFont = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/nasalization-rg.ttf"));

            // Roboto
            robotoFontRegular = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/roboto/RobotoCondensed-Regular.ttf"));
            robotoFontBold = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/roboto/RobotoCondensed-Bold.ttf"));

            // Open Sans
            openSansFontRegular = Font.createFont(Font.TRUETYPE_FONT, new File("res/font/opensans/OpenSans-Regular.ttf"));

        } catch (IOException|FontFormatException e) {
            e.printStackTrace();
        }


    }

}
