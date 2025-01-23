package Utils;

import java.util.Iterator;

public class BinaryTreeClass<T> implements BinaryTree<T> {
  public T root;
  public BinaryTree<T> left;
  public BinaryTree<T> right;
  public T value;

  @Override
  public BinaryTree<T> getLeft() {
    return left;
  }

  @Override
  public BinaryTree<T> getRight() {
    return right;
  }

  @Override
  public T getRoot() {
    return root;
  }

  @Override
  public boolean isEmpty() {
    return left == null && right == null;
  }

  @Override
  public int size() {
    if (isEmpty())
      return 0;

    return 1 + Math.max(
        left == null ? 0 : left.size(),
        right == null ? 0 : right.size());
  }

  @Override
  public void add(T a) {
    BinaryTree<T> topLeft = left;

    if (topLeft.getLeft() != null)
      topLeft = topLeft.getLeft();

    // topLeft.
  }

  @Override
  public T get(int i) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T find(T t) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Iterator<T> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T remove(T element) {
    // TODO Auto-generated method stub
    return null;
  }
}
