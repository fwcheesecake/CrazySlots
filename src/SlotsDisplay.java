import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SlotsDisplay extends JPanel {
    public final JLabel slot1;
    public final JLabel slot2;
    public final JLabel slot3;

    public SlotsDisplay() {
        this.setBackground(Colors.PURPLE);
        this.setLayout(new GridLayout(3, 1, 0, 10));

        slot1 = new JLabel(CrazySlots.slotsIcons[0]);
        slot2 = new JLabel(CrazySlots.slotsIcons[1]);
        slot3 = new JLabel(CrazySlots.slotsIcons[2]);

        this.add(slot1);
        this.add(slot2);
        this.add(slot3);
    }
}
