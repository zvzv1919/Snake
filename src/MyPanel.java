import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    private String mapString;
    private Map map;
    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    public Dimension getPreferredSize() {
        int width = map.getLength() * 10;
        int height = map.getHeight() * 10;
        return new Dimension(width,height);
    }
    public void setMap(Map map) {
        this.map = map;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(map == null) {
            new ErrorHandler(Error.NULL_MAP);
        }
        else if(map.getSnake().collide()){
            g.drawString("Game Over!!", 2 * map.getLength(), 5 * map.getHeight());
        }
        int i = 0;
        int j = 0;
        do{
            i = 0;
            do{
                if(map.getMap()[i][j] == '*'){
                    g.drawOval(10 * i, 10 * j, 10, 10);
                }
                i++;
            }while(i < map.getMap().length);

            j++;
        } while (j < map.getMap()[0].length);
    }


}
