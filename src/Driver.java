import static java.lang.Thread.sleep;

public class Driver implements Runnable {
    Map map;
    Snake snake;

    public void run(){

        initialize();
        Controller controller = new Controller(map);

        do{
            if(map.getSnake().collide()){
                map.getPanel().repaint();
                break;
            }
            map.getSnake().move();//Later, update the map here
            map.updateMap();
            map.printMap();
            try {
                sleep(snake.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (true);

    }

    public void initialize(){
        map = new Map();
        snake = map.getSnake();
        snake.setDirection(4);
    }
}