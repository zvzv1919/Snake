public class Node {
    int pos_x;
    int pos_y;
    Node prev;
    Node next;

    public Node(int pos_x, int pos_y, Node prev, Node next) {
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.next = next;
        this.prev = prev;
    }


    public int getPos_y() {
        return pos_y;
    }
    public int getPos_x() {
        return pos_x;
    }
    public Node getNext() {
        return next;
    }
    public Node getPrev() {
        return prev;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }
    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    public boolean coincide(Node node){
        if(this.pos_x == node.pos_x && this.pos_y == node.pos_y){
            return true;
        }
        else {
            return false;
        }
    }
}
