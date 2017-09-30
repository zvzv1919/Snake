import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private static final int DEFAULT_LENGTH = 40;
    private static final int DEFAULT_HEIGHT = 30;

    private Map map;

    //GamePanel(): A GamePanel of DEFAULT SIZE.
    public GamePanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        int width = 10 * DEFAULT_LENGTH;
        int height = 10 * DEFAULT_HEIGHT;
        return new Dimension(width,height);
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

    public void setMap(Map map) {
        this.map = map;
    }
}
