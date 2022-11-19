


public class Node<T extends Comparable <T>> {

    private Node<T> antes;
    private T info;
    private Node<T> prox;

    public Node(T valor) {
        this.info = valor;
    }

    public Node<T> getAntes() {
        return antes;
    }

    public void setAntes(Node<T> ant) {
        this.antes = ant;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getProx() {
        return prox;
    }

    public void setProx(Node<T> prox) {
        this.prox = prox;
    }


}
