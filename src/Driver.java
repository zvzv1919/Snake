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
        map.updateMap();

        do{
            if(map.getSnake().collide()){
                gamePanel.repaint();
                break;
            }
            //snake.move();//Later, update the map here

            //map.printMap();
            try {
                sleep(snake.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            move();
            map.updateMap();
        }while (true);
    }

    //initializes the map
    public void initialize(){
        map = new Map(gamePanel);
        gamePanel.setMap(map);
        snake = map.getSnake();
        snake.setDirection(4);
        map.generateApple();
    }

    //move: update the 'Snake' list according to 'nextNode'(doesn't check for collision)
    public void move(){
        if(!map.eats()) {
            snake.getHead().setPrev(snake.nextNode());
            snake.getHead().getPrev().setNext(snake.getHead());
            snake.setHead(snake.getHead().getPrev());
            snake.setTail(snake.getTail().getPrev() == null ? snake.getHead() : snake.getTail().getPrev());
            snake.getTail().setNext(null);
        }
        else {
            snake.getHead().setPrev(snake.nextNode());
            snake.getHead().getPrev().setNext(snake.getHead());
            snake.setHead(snake.getHead().getPrev());
            map.generateApple();
        }
    }
    public Snake getSnake() {
        return snake;
    }
}