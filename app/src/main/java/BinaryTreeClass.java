import java.util.Iterator;

import Utils.BinaryTree;

public class BinaryTreeClass<T> implements BinaryTree<T> {
  private BinaryTree<T> left;
  private BinaryTree<T> right;
  private T value;

  public BinaryTreeClass(BinaryTree<T> left, BinaryTree<T> right, T value) {
    this.left = left;
    this.right = right;
    this.value = value;
  }

  @Override
  public void add(Object a) {
    throw new UnsupportedOperationException();
  }

  @Override
  public T find(Object t) {
    throw new UnsupportedOperationException();
  }

  @Override
  public T get(int i) {
    throw new UnsupportedOperationException();
  }

  @Override
  public BinaryTree<T> getLeft() {
    return left;
  }

  @Override
  public BinaryTree<T> getRight() {
    return right;
  }

  public T getValue() {
    return value;
  }

  public boolean isLeaf() {
    return left == null && right == null;
  }

  @Override
  public T getRoot() {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean isEmpty() {
    return left == null && right == null && value == null;
  }

  @Override
  public Iterator<T> iterator() {
    throw new UnsupportedOperationException();
  }

  @Override
  public T remove(Object element) {
    throw new UnsupportedOperationException();
  }

  @Override
  public int size() {
    if (this.isEmpty())
      return 0;
    int leftSize = (left != null) ? left.size() : 0;
    int rightSize = (right != null) ? right.size() : 0;
    return 1 + leftSize + rightSize;
  }
}
