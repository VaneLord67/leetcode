package struct;

/**
 * @author CJR
 * @create 2022-02-27-15:15
 */
public class Node<T> {
    public T value;
    public Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public String toString() {
        return this.value.toString();
    }

}
