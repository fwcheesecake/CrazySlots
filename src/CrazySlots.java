import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CrazySlots extends JFrame implements ActionListener {
    //Private members
    private final JLayeredPane contentPane;

    private final JLabel titleLabel;
    private final CrazyButton playButton;

    private final JPanel slotsDisplayParent;
    private final SlotsDisplay slotsDisplay1;
    private final SlotsDisplay slotsDisplay2;
    private final SlotsDisplay slotsDisplay3;

    private final Runnable machineSpin = new Runnable() {
        @Override
        public void run() {
            Random rand = new Random(System.nanoTime());
            int spinTime = 2; //+ rand.nextInt(4);

            int slotPosition1 = rand.nextInt(slotsIcons.length);
            int slotPosition2 = rand.nextInt(slotsIcons.length);
            int slotPosition3 = rand.nextInt(slotsIcons.length);

            for (int i = 0; i < spinTime * 20; i++) {
                slotsDisplay1.slot1.setIcon(
                        slotsIcons[getPos(slotPosition1 - 1)]);
                slotsDisplay1.slot2.setIcon(
                        slotsIcons[getPos(slotPosition1)]);
                slotsDisplay1.slot3.setIcon(
                        slotsIcons[getPos(slotPosition1 + 1)]);

                slotsDisplay2.slot1.setIcon(
                        slotsIcons[getPos(slotPosition2 - 1)]);
                slotsDisplay2.slot2.setIcon(
                        slotsIcons[getPos(slotPosition2)]);
                slotsDisplay2.slot3.setIcon(
                        slotsIcons[getPos(slotPosition2 + 1)]);

                slotsDisplay3.slot1.setIcon(
                        slotsIcons[getPos(slotPosition3 - 1)]);
                slotsDisplay3.slot2.setIcon(
                        slotsIcons[getPos(slotPosition3)]);
                slotsDisplay3.slot3.setIcon(
                        slotsIcons[getPos(slotPosition3 + 1)]);

                slotPosition1 = getPos(slotPosition1 + 1);
                slotPosition2 = getPos(slotPosition2 + 1);
                slotPosition3 = getPos(slotPosition3 + 1);

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(slotPosition1 == slotPosition2 &&
                    slotPosition2 == slotPosition3) {
                System.out.println("Ganaste");
            }
        }
    };

    private int getPos(int slotPosition) {
        return (slotPosition < 0) ? slotsIcons.length - 1 : slotPosition % slotsIcons.length;
    }

    //Public members
    public static ImageIcon[] slotsIcons = {
            new ImageIcon(CrazySlots.class.getResource(
                    "/media/images/slot 1.png")),
            new ImageIcon(CrazySlots.class.getResource(
                    "/media/images/slot 2.png")),
            new ImageIcon(CrazySlots.class.getResource(
                    "/media/images/slot 3.png")),
            new ImageIcon(CrazySlots.class.getResource(
                    "/media/images/slot 4.png")),
            new ImageIcon(CrazySlots.class.getResource(
                    "/media/images/slot 5.png")),
            new ImageIcon(CrazySlots.class.getResource(
                    "/media/images/slot 6.png")),
            new ImageIcon(CrazySlots.class.getResource(
                    "/media/images/slot 7.png")),
            new ImageIcon(CrazySlots.class.getResource(
                    "/media/images/slot 8.png")),
            new ImageIcon(CrazySlots.class.getResource(
                    "/media/images/slot 9.png")),
            new ImageIcon(CrazySlots.class.getResource(
                    "/media/images/slot 10.png")),
            new ImageIcon(CrazySlots.class.getResource(
                    "/media/images/slot 11.png")),
            new ImageIcon(CrazySlots.class.getResource(
                    "/media/images/slot 12.png"))
    };

    public CrazySlots() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLayout(new GridLayout(1, 1));

        contentPane = new JLayeredPane();
        contentPane.setOpaque(true);
        contentPane.setBackground(Colors.RED);

        titleLabel = new JLabel(new ImageIcon(getClass().getResource(
                "/media/images/Title.png"
        )));
        titleLabel.setBounds(0, 0, 1920, 586);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        contentPane.add(titleLabel, Integer.valueOf(1));

        playButton = new CrazyButton(new ImageIcon(getClass().getResource(
                "/media/images/crazySlots.png"
        )));
        playButton.setBounds(752, 189, 420, 420);
        playButton.addActionListener(this);
        contentPane.add(playButton, Integer.valueOf(2));

        slotsDisplayParent = new JPanel();
        slotsDisplayParent.setOpaque(false);
        slotsDisplayParent.setLayout(new GridLayout(1, 3, 15, 0));
        slotsDisplayParent.setBounds(93, 505, 1734, 533);

        slotsDisplay1 = new SlotsDisplay();
        slotsDisplayParent.add(slotsDisplay1);

        slotsDisplay2 = new SlotsDisplay();
        slotsDisplayParent.add(slotsDisplay2);

        slotsDisplay3 = new SlotsDisplay();
        slotsDisplayParent.add(slotsDisplay3);

        contentPane.add(slotsDisplayParent, Integer.valueOf(1));

        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setTitle("Crazy Slots Machine");

        this.setVisible(true);

        ImageIcon applicationIcon = new ImageIcon(getClass().getResource("/media/images/crazySlots@2x.png"));
        this.setIconImage(applicationIcon.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        Thread machineFunctionallity = new Thread(machineSpin);
        machineFunctionallity.start();
    }
}