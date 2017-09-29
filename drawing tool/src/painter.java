import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Felicity on 7/19/17.
 */
public class painter extends MouseAdapter {
    Canvases canvases;
    public painter(Canvases canvases){
        this.canvases = canvases;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        canvases.x = e.getX();
        canvases.y = e.getY();
        canvases.color = DrawingTool.color;
        canvases.shape = DrawingTool.shape;
        canvases.repaint();

    }
}
