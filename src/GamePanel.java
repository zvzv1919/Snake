import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Map map;
    public GamePanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    public Dimension getPreferredSize() {
        int width = 400;
        int height = 300;
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
