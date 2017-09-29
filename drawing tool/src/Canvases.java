/**
 * Created by Felicity on 7/19/17.
 */
import javax.swing.JFrame;
import java.awt.*;

public class Canvases extends Canvas{
   /* Canvases(Model model) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640, 480);
        frame.add(this);
        frame.setVisible(true);
    }*/
   public int x;
   public int y;
   public Color color;
   public String shape;


    public void paint(Graphics g) {
        /*int x = 0;
        int y = model.getY();
        int width = model.getWidth();
        int height = model.getHeight();*/
        if(shape.equals("circle")){
            g.setColor(color);
            g.fillOval(x, y, 10, 10);
        }
        else{
            g.setColor(color);
            g.fillRect(x, y, 10, 10);
        }

    }


}
