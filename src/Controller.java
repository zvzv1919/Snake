import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements Runnable {
    private JFrame frame;
    private Driver driver;
    private Thread game;


    public Controller(){
    }

    public void run(){
        frame = new JFrame();


        JPanel buttonPane = new JPanel();
        JPanel board = new JPanel();
        GamePanel gamePanel = new GamePanel();
        driver = new Driver(gamePanel);

        //frame contains: board contains: buttonPane, gamePanel.
        JButton upButton = new JButton("up");
        JButton downButton = new JButton("down");
        JButton leftButton = new JButton("left");
        JButton rightButton = new JButton("right");
        JButton speedUpButton = new JButton("speedUp");
        JButton speedDownButton = new JButton("speedDown");
        JButton restartButton = new JButton("restart");

        upButton.addActionListener(new ChangeDirection(Directions.up));
        downButton.addActionListener(new ChangeDirection(Directions.down));
        leftButton.addActionListener(new ChangeDirection(Directions.left));
        rightButton.addActionListener(new ChangeDirection(Directions.right));
        speedUpButton.addActionListener(new ChangeSpeed(1));
        speedDownButton.addActionListener(new ChangeSpeed(0));
        restartButton.addActionListener(new Restart());

        buttonPane.add(upButton);
        buttonPane.add(downButton);
        buttonPane.add(leftButton);
        buttonPane.add(rightButton);
        buttonPane.add(speedUpButton);
        buttonPane.add(speedDownButton);
        buttonPane.add(restartButton);

        board.add(buttonPane);
        board.add(gamePanel);
        frame.add(board);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setVisible(true);

        game = new Thread(driver);
        driver.setGame(game);
        game.start();
    }

    private class ChangeDirection implements ActionListener{
        Directions newDir;
        ChangeDirection(Directions i){
            this.newDir = i;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!isBackward(newDir)) {
                driver.getSnake().setDirection(newDir);
            }
        }

        public boolean isBackward(Directions newDir){
            Directions oldDir = driver.getSnake().getDirection();
            switch (oldDir){
                case up:{
                    if(newDir == Directions.down){
                        return true;
                    }
                    break;
                }
                case down:{
                    if(newDir == Directions.up){
                        return true;
                    }
                    break;
                }
                case left:{
                    if(newDir == Directions.right){
                        return true;
                    }
                    break;
                }
                case right:{
                    if(newDir == Directions.left){
                        return true;
                    }
                    break;
                }
            }
            return false;
        }
    }
    private class ChangeSpeed implements ActionListener{
        int up;
        ChangeSpeed(int up){this.up = up;};
        public void actionPerformed(ActionEvent e){
            if(up == 1){
                driver.getSnake().speedUp();
            }
            else {
                driver.getSnake().speedDown();
            }
        }
    }
    private class Restart implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            game = new Thread(driver);
            driver.setGame(game);
            game.start();
        }
    }
}
