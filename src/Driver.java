import static java.lang.Thread.sleep;

//The main process of the game with pre-determined parameters
public class Driver implements Runnable {
    Map map;
    Snake snake;
    GamePanel gamePanel;

    public Driver(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    public void run(){

        initialize();

        do{
            if(map.getSnake().collide()){
                map.getGamePanel().repaint();
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

    //initializes the map
    public void initialize(){
        map = new Map(gamePanel);
        gamePanel.setMap(map);
        snake = map.getSnake();
        snake.setDirection(4);
    }

    public Map getMap() {
        return map;
    }
    public Snake getSnake() {
        return snake;
    }
}