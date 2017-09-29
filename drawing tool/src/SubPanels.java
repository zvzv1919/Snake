/**
 * Created by Felicity on 7/19/17.
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.*;

public class SubPanels {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SubPanel Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel pane1 = new JPanel();
        JPanel pane2 = new JPanel();

        Canvases c = new Canvases();
        c.setBounds(0,0,200,200);

        Border b1 = BorderFactory.createLineBorder(Color.CYAN);

        Border b2 = BorderFactory.createTitledBorder(b1, "Sub Panel", 1,
                1, null, Color.magenta);

        pane1.setBorder(b1);
        pane2.setBorder(b2);

        addButtons(pane2, 5);
        addButtons(pane1, 2);
        pane1.add(pane2);
        pane1.add(c);
        c.addMouseListener(new painter(c));

        addButtons(pane1, 3);


        frame.add(pane1);
        frame.pack();
        frame.setVisible(true);
    }
    static int counter = 0;

    static void addButtons(JPanel pane, int count) {
        for (int i = 1; i <= count; i++)
            pane.add(new JButton("Button " + ++counter));
    }
}