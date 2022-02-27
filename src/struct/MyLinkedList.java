package struct;

/**
 * @author CJR
 * @create 2022-02-27-15:14
 */
public class MyLinkedList<T> {

    private Node<T> head;
    private int size;

    public MyLinkedList() {
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public boolean add(T value, int pos) {
        if (pos < 0 || pos > size) {
            return false;
        }
        Node<T> newNode = new Node<>(value);
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            this.size++;
            return true;
        }
        Node<T> tmp = head;
        for (int i = 0; i < pos - 1; i++) {
            tmp = tmp.next;
        }
        newNode.next = tmp.next;
        tmp.next = newNode;
        this.size++;
        return true;
    }

    public boolean remove(int pos) {
        if (pos < 0 || pos > size) {
            return false;
        }
        Node<T> tmp = head;
        for (int i = 0; i < pos - 1; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        this.size--;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> tmp = this.head;
        sb.append(tmp.value).append(" ");
        for (int i = 0; i < this.size - 1; i++) {
            tmp = tmp.next;
            sb.append(tmp.value).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(5, 0);
        linkedList.add(1, 0);
        linkedList.add(2, 0);
        linkedList.add(3, 1);
        linkedList.add(4, 2);
        System.out.println(linkedList);
        linkedList.remove(3);
        System.out.println(linkedList);
    }
}
