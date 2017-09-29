import javax.swing.*;
import java.awt.*;

public class Map {
    private static final int DEFAULT_LENGTH = 40;
    private static final int DEFAULT_HEIGHT = 30;
    private char[][] map;
    private Snake snake;

    private MyPanel panel;

    //'*' represents snake; '!' represents apple; '|' represents walls
    //x direction: |-->; y direction: 丁
    //!!! Must set Snake.map and panel.map in each constructor.
    //!!! Must initialize the snake and panel in each constructor.
    //Map(Snake): Generates an empty map of DEFAULT SIZE that contains only the snake.
    //Map(): Generates an empty map of DEFAULT SIZE with a default snake.
    //blank(int[][]): set every entry of the passed array to ' '.
    //printMap: print the current Map on the screen(visulize).
    //updateMap: update the map to cover changes in 'snake'. Also repaints the panel.


    public Map(Snake snake1) {
        snake = snake1;
        panel = new MyPanel();

        Node node = snake.getHead();
        if(node == null){
            new ErrorHandler(Error.NULL_HEAD);
        }
        map = new char[DEFAULT_LENGTH][DEFAULT_HEIGHT];
        blank(map);
        do{
            map[node.getPos_x()][node.getPos_y()] = '*';
            node = node.next;
        }while(node != null);
        snake.setMap(this);
        panel.setMap(this);
    }
    public Map(){
        this(new Snake());
    }
    private void blank(char[][] map){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = ' ';
            }
        }
    }
    public void printMap(){
        if(map == null){
            new ErrorHandler(Error.NULL_MAP);
        }
        int i = 0;
        int j = 0;
        do{
            i = 0;
            System.out.printf("\n");
            do{
                System.out.printf("%c", map[i][j]);
                i++;
            }while(i < map.length);

            j++;
        } while (j < map[0].length);
        System.out.printf("\n");
    }
    public void updateMap(){
        blank(map);
        Node node = snake.getHead();
        do{
            map[node.getPos_x()][node.getPos_y()] = '*';
            node = node.next;
        }while(node != null);

        //panel.printMap(map);
        panel.repaint();
    }


    public Snake getSnake() {
        return snake;
    }
    public char[][] getMap() {
        return map;
    }
    public int getHeight() {
        return map[0].length;
    }
    public int getLength() {
        return map.length;
    }
    public JPanel getPanel() {
        return panel;
    }
}

