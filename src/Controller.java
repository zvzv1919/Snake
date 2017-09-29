import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements Runnable {
    Map map;
    JFrame frame;

    public Controller(Map map){
        this.map = map;
        run();
    }

    public void run(){
        frame = new JFrame();

        JPanel buttonPane = new JPanel();
        JPanel board = new JPanel();

        //frame contains: board contains: buttonPane, map.getPenal.
        JButton upButton = new JButton("up");
        JButton downButton = new JButton("down");
        JButton leftButton = new JButton("left");
        JButton rightButton = new JButton("right");
        JButton speedUpButton = new JButton("speedUp");
        JButton speedDownButton = new JButton("speedDown");
        JButton restartButton = new JButton("restart");

        upButton.addActionListener(new ChangeDirection(1));
        downButton.addActionListener(new ChangeDirection(2));
        leftButton.addActionListener(new ChangeDirection(3));
        rightButton.addActionListener(new ChangeDirection(4));
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
        board.add(map.getPanel());
        frame.add(board);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private class ChangeDirection implements ActionListener{
        int newDir;
        ChangeDirection(int i){
            this.newDir = i;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            map.getSnake().setDirection(newDir);
        }
    }
    private class ChangeSpeed implements ActionListener{
        int up;
        ChangeSpeed(int up){this.up = up;};
        public void actionPerformed(ActionEvent e){
            if(up == 1){
                map.getSnake().speedUp();
            }
            else {
                map.getSnake().speedDown();
            }
        }
    }
    private class Restart implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            Main.driver.run();
        }
    }
}
