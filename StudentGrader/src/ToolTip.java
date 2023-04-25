import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.ToolTipManager;
import javax.swing.UIManager;

public class ToolTip {
	public static void initialiseToolTip(String Background, String ForeGround) {
		
		Color transparentColor = new Color(255, 255, 255, 0);
		ToolTipManager.sharedInstance().setInitialDelay(50);
		UIManager.put("ToolTip.font", new Font("Consolas", Font.PLAIN, 14));
		UIManager.put("ToolTip.background", Color.decode(Background));
	    UIManager.put("ToolTip.foreground", Color.decode(ForeGround));
	    UIManager.put("ToolTip.border", transparentColor);
	}
}
