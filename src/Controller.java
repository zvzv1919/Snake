import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class Controller implements Runnable {
    JFrame frame;
    Driver driver;
    Thread game;


    public Controller(){
    }

    //call changeDirections instead of making changes to directions directly to avoid bugs.
    //!! please move changeDirections to Snake Class later

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

        board.setFocusable(true);
        board.addKeyListener(new KeyCtrl());
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
            changeDirection(newDir);
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
            restart();
        }
    }

    private class KeyCtrl implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()){
                case VK_LEFT: {
                    changeDirection(Directions.left);
                    break;
                }
                case VK_RIGHT:{
                    changeDirection(Directions.right);
                    break;
                }
                case VK_UP:{
                    changeDirection(Directions.up);
                    break;
                }
                case VK_DOWN:{
                    changeDirection(Directions.down);
                    break;
                }
                case VK_ESCAPE:{
                    System.exit(1);
                }
                case VK_R:{
                    restart();
                    break;
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    public boolean isBackward(Directions newDir){
        switch (driver.getSnake().getDirection()){
            case right:{
                if(newDir == Directions.left){
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
            case down:{
                if(newDir == Directions.up){
                    return true;
                }
                break;
            }
            case up:{
                if(newDir == Directions.down){
                    return true;
                }
                break;
            }
        }
        return false;
    }
    public void changeDirection(Directions newDir){
        if(!isBackward(newDir)){
            driver.getSnake().setTempDirection(newDir);
        }
    }
    public void restart(){
        game = new Thread(driver);
        driver.setGame(game);
        game.start();
    }

}
