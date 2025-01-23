package Utils;

import java.util.Optional;

public class Node<T> {
  public T value;
  public Optional<Node<T>> next;

  public Node(T value, Optional<Node<T>> next) {
    this.value = value;
    this.next = next;
  }
}
