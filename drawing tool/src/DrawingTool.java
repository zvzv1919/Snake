import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Felicity on 7/19/17.
 */
public class DrawingTool {
    static Color color = Color.red;
    static String shape = "circle";
    public static void main(String[] args) {
        Canvases canvases = new Canvases();
        canvases.setBounds(0,0,600,600);
        canvases.addMouseListener(new painter(canvases));
        canvases.setBackground(Color.white);
        JFrame frame = new JFrame();

        JPanel pane1 = new JPanel(new GridLayout(0,5));
        JPanel pane2 = new JPanel(new GridLayout(0,5));
        JPanel pane3 = new JPanel();
        JPanel pane4 = new JPanel();

        JButton red = new JButton("red");
        JButton blue = new JButton("blue");

        JButton rectangle = new JButton("rect");
        JButton circle = new JButton("circle");

        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.red;
            }
        });
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.blue;
            }
        });

        rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = "rectangle";
            }
        });
        circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = "circle";
            }
        });

        pane1.add(red);
        pane1.add(blue);
        pane2.add(rectangle);
        pane2.add(circle);
        pane4.add(canvases);
        pane4.setBorder(BorderFactory.createLineBorder(color.black));

        pane3.add(pane1);
        pane3.add(pane2);
        pane3.add(pane4);


        frame.add(pane3);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }




}
