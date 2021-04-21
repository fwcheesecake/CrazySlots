import javax.swing.*;
import java.awt.*;

public class CrazyButton extends JButton {
    public CrazyButton(ImageIcon icon) {
        super(icon);

        this.setOpaque(false);
        this.setBackground(Colors.RED);
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setContentAreaFilled(false);
    }
}
