import static java.lang.Thread.sleep;

//The main process of the game with pre-determined parameters
public class Driver implements Runnable {
    Map map;
    Snake snake;
    GamePanel gamePanel;
    private Thread game;    //Used to stop the current thread

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
            //map.printMap();
            try {
                sleep(snake.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (Thread.currentThread() == game);
    }

    //initializes the map
    public void initialize(){
        map = new Map(gamePanel);
        gamePanel.setMap(map);
        snake = map.getSnake();
        snake.setDirection(Directions.right);
    }

    public Map getMap() {
        return map;
    }
    public Snake getSnake() {
        return snake;
    }
    public void setGame(Thread game) {
        this.game = game;
    }
}