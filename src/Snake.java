import java.util.ArrayList;

//collide: check if the 'nextNode' overlaps with the snake
//move: update the 'Snake' list according to 'nextNode'(doesn't check for collision
//nextNode: returns the next Node of the 'Snake' list according to the current direction and the position of 'Snake'
//Snake(): initialize a default 'Snake' at the default position.
//setMap: usually called in Map to allow changes to Map in Snake methods.

public class Snake {
    private static final int Default_speed = 15;
    private Directions direction;
    private Node head;
    private Node tail;
    private Map map;
    int speed = Default_speed; //the range of valid speed is set between 1 and 30.


    public Snake(){
        this.head = new Node(4,4, null, null);
        Node node;
        node = new Node(3,4,head, null);
        head.next = node;

        node = new Node(2,4,node, null);
        node.prev.next = node;

        node = new Node(1,4,node, null);
        node.prev.next = node;

        node = new Node(0,4,node, null);
        node.prev.next = node;

        this.tail = node;
    }
    public void move(){
        head.prev = nextNode();
        head.prev.next = head;
        head = head.prev;
        tail = tail.prev == null? head : tail.prev;
        tail.next = null;
    }
    public void setDirection(Directions direction){
        this.direction = direction;
    }
    public Directions getDirection() {
        return direction;
    }
    public Node getHead() {
        return head;
    }
    boolean collide(){
        Node next = nextNode();
        Node node = head;
        if(head == null){
            new ErrorHandler(Error.NULL_HEAD);
        }
        boolean collide = false;

        do{
            if(next.pos_x == node.pos_x && next.pos_y == node.pos_y){
                collide = true;
                break;
            }
            node = node.next;

        }while(node != null);

        return collide;
    }
    Node nextNode(){
        if(map == null){
            new ErrorHandler(Error.NULL_MAP2);
        }
        switch (direction){
            case right: {
                if(head.pos_x < map.getLength() - 1) {
                    return new Node(head.pos_x + 1, head.pos_y, head, null);
                }
                else {
                    return new Node(0, head.pos_y, head, null);
                }
            }
            case left:{
                if(head.pos_x > 0) {
                    return new Node(head.pos_x - 1, head.pos_y, head, null);
                }
                else {
                    return new Node(map.getLength() - 1, head.pos_y, head, null);
                }
            }
            case up:{
                if(head.getPos_y() > 0) {
                    return new Node(head.pos_x, head.pos_y - 1, head, null);
                }
                else {
                    return new Node(head.pos_x, map.getHeight() - 1, head, null);
                }
            }
            case down:{
                if(head.getPos_y() < map.getHeight() - 1) {
                    return new Node(head.pos_x, head.pos_y + 1, head, null);
                } else {
                    return new Node(head.pos_x, 0, head, null);
                }
            }
            default:{
                return null;
            }
        }
    }

    public void setMap(Map map) {
        this.map = map;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void speedUp(){
        setSpeed(speed < 30 ? ++speed : speed);
    }
    public void speedDown(){
        setSpeed(speed > 1 ? --speed : speed);
    }
    public int getSpeed() {
        return speed;
    }
}