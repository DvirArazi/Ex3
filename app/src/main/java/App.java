import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.ToDoubleFunction;

import Utils.BinaryTree;
import Utils.GeoShape;
import Utils.MyList;
import Utils.MyListInterface;
import Utils.Parabula;
import Utils.ShapeFilter;

public class App {

  public static void main(String[] args) {
    // int[][] ans = q1(5, 3);
    // for (int y = 0; y < ans[0].length; y++) {
    // for (int x = 0; x < ans.length; x++) {
    // System.out.print(ans[x][y] + "\t");
    // }
    // System.out.println("");
    // }

    // System.out.println(q2("aaabbbcccxxyaaa"));

    // System.out.println(Q5("to be or not to be", "be"));
    // System.out.println(Q5("aaa", "aa"));

    // System.out.println(Q10(98));

    // for (int i = 0; i < 30; i++) {
    // int minH = (int) Math.ceil(Math.log(i + 1) / Math.log(2)) - 1;
    // System.out.println(i + ", " + minH);
    // }

    // System.out.println(uniqueSub("abracadabra"));

    System.out.println(factorial(3));

    String[] codes = allCodes();
    for (int i = 0; i < codes.length; i++) {
      if (i % 6 == 0)
        System.out.println();
      System.out.print("\"" + codes[i] + "\", ");
    }

    // AppBenchmark.mySortBenchmark();
  }

  // Question 1
  public static int[][] Q1(int n, int m) {
    int[][] matrix = new int[m][n];

    for (int x = 0; x < m; x++) {
      for (int y = 0; y < n; y++) {
        if (x == 0 || y == 0)
          matrix[x][y] = 1;
        else {
          matrix[x][y] = matrix[x - 1][y] + matrix[x][y - 1];
        }
      }
    }

    return matrix;
  }

  // Question 2
  public static String q2(String s) {
    if (s.length() <= 1)
      return s;

    char first = s.charAt(0);
    do
      s = s.substring(1);
    while (s.length() > 0 && first == s.charAt(0));

    return first + q2(s);
  }

  // Question 3
  public static int Q5(String s1, String s2) {
    int count = 0;

    while (s1.length() >= s2.length()) {
      if (s1.startsWith(s2))
        count++;
      s1 = s1.substring(1);
    }

    return count;
  }

  // Question 4a
  // 4a.1
  public static <T> boolean isSet(MyListInterface<T> l) {
    for (int i = 0; i < l.size() - 1; i++) {
      for (int j = i + 1; j < l.size(); j++) {
        if (l.get(i) == l.get(j))
          return false;
      }
    }

    return true;
  }

  // 4a.2
  public static <T> MyListInterface<T> toSet(MyListInterface<T> l) {
    MyListInterface<T> lNew = new MyList<T>();

    for (int i = 0; i < l.size(); i++) {
      adder: {
        for (int j = 0; j < i; j++) {
          if (l.get(i) == l.get(j)) {
            break adder;
          }
        }
        lNew.addAt(l.get(i), lNew.size());
      }
    }

    return lNew;
  }

  // Question 4b
  // 4b.1
  public static <T> MyListInterface<T> intersect(MyListInterface<T> l1, MyListInterface<T> l2) {
    MyListInterface<T> lNew = new MyList<T>();

    for (int i = 0; i < l1.size(); i++)
      if (l2.contains(l1.get(i)))
        lNew.addAt(l1.get(i), lNew.size());

    return lNew;
  }

  // 4b.2
  public static <T> MyListInterface<T> union(MyListInterface<T> l1, MyListInterface<T> l2) {
    MyListInterface<T> lNew = new MyList<T>();

    for (int i = 0; i < l1.size(); i++)
      lNew.addAt(l1.get(i), lNew.size());

    for (int i = 0; i < l2.size(); i++)
      lNew.addAt(l2.get(i), lNew.size());

    return toSet(lNew);
  }

  // Question 5
  public static <T> int Q7(MyListInterface<T> l) {
    // MyList<T> types = new MyList<T>();
    ArrayList<String> types = new ArrayList<>();

    for (int i = 0; i < types.size(); i++) {
      String type = l.get(i).getClass().getSimpleName();
      if (!types.contains(type))
        types.add(type);
    }

    return types.size();
  }

  // Question 6
  public static boolean Q10(int n) {
    int sqrt = (int) Math.floor(Math.sqrt(n));

    int count = 0;
    for (int i = 2; i <= sqrt; i++) {
      if (n % i == 0) {
        System.out.println(i);
        n /= i;

        count++;
      }
    }

    return count == 3;
  }

  static boolean isPrime(int n) {
    int sqrt = (int) Math.floor(Math.sqrt(n));
    for (int i = 2; i <= sqrt; i++) {
      if (sqrt % i == 0)
        return false;
    }

    return true;
  }

  // Question 7
  public static double[] Q12(double[] arr) {
    ArrayList<Double> longest = new ArrayList<Double>();

    ArrayList<Double> temp = new ArrayList<Double>();
    temp.add(arr[0]);

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > arr[i - 1]) {
        temp.add(arr[i]);
        continue;
      }

      if (longest.size() < temp.size())
        longest = temp;

      temp = new ArrayList<Double>();
    }

    if (longest.size() < temp.size())
      longest = temp;

    double[] sub = new double[longest.size()];
    for (int i = 0; i < sub.length; i++) {
      sub[i] = longest.get(i);
    }

    return sub;
  }

  // Question 8.2
  // TODO Need to figure out how I'm expected to test the function
  public static <T> boolean isOfTheSameStructure(BinaryTree<T> bt1, BinaryTree<T> bt2) {
    if (bt1 == null && bt2 == null)
      return true;
    if (bt1 == null || bt2 == null)
      return false;
    return isOfTheSameStructure(bt1.getLeft(), bt2.getLeft()) &&
        isOfTheSameStructure(bt1.getRight(), bt2.getRight());
  }

  // Question 9
  public static <T> int q9(BinaryTree<T> bt1, int min, int max) {
    ArrayList<BinaryTree<T>> trees = new ArrayList<>();
    ArrayList<BinaryTree<T>> treesTemp = new ArrayList<>();

    trees.add(bt1);

    int leafCount = 0;
    for (int i = 0; i < max; i++) {
      for (BinaryTree<T> tree : trees) {
        if (tree != null) {
          if (tree.getLeft() != null)
            treesTemp.add(tree.getLeft());
          if (tree.getRight() != null)
            treesTemp.add(tree.getRight());

          continue;
        }

        if (i >= min) {
          leafCount++;
        }
      }

      trees = treesTemp;
      treesTemp = new ArrayList<>();
    }

    return leafCount;
  }

  // Question 10
  // TODO
  // Unclear how I'm supposed to get the data of each leaf.
  // Is the `getRoot` function supposed to return the value of
  // the current node or of that of the base Node of the tree?
  // public static <T> ArrayList<T> q10(BinaryTree<T> bt1) {
  // ArrayList<T> leaves = new ArrayList<>();
  // if (bt1 == null)
  // return leaves;
  // if (bt1.getLeft() == null && bt1.getRight() == null)
  // {
  // leaves.add(bt1.ge)
  // }
  // if (bt1.getLeft() != null)
  // q10.
  // }

  // Question 11
  public static <T> double q10(BinaryTree<T> bt) {
    int height = getHeight(bt);

    int minHeight = (int) Math.ceil(Math.log(bt.size() + 1) / Math.log(2)) - 1;

    return (double) height / minHeight;
  }

  static <T> int getHeight(BinaryTree<T> tree) {
    if (tree == null)
      return 0;

    return 1 + Math.max(getHeight(tree.getLeft()), getHeight(tree.getRight()));
  }

  // Question 12
  public static String uniqueSub(String s) {
    String sNew = "";

    for (int i = 0; i < s.length(); i++) {
      adder: {
        for (int j = 0; j < s.length(); j++) {
          if (i != j && s.charAt(i) == s.charAt(j)) {
            break adder;
          }
        }
        sNew += s.charAt(i);
      }
    }

    return sNew;
  }

  // Question 13
  // 13.1
  @SuppressWarnings("unchecked")
  public static <T> void mySort(T[] p, Comparator<T> comp) {
    sortHelper(p, (T[]) new Object[p.length], 0, p.length, comp);
  }

  static <T> void sortHelper(T[] p, T[] p2, int s, int e, Comparator<T> comp) {
    int size = e - s;

    if (size == 1)
      return;

    if (size == 2) {
      if (comp.compare(p[s + 1], p[s]) >= 0)
        return;

      T holder = p[s];
      p[s] = p[s + 1];
      p[s + 1] = holder;
      return;
    }

    int mid = (s + e) / 2;

    sortHelper(p, p2, s, mid, comp);
    sortHelper(p, p2, mid, e, comp);

    for (int i = s; i < e; i++)
      p2[i] = p[i];

    int i = s;
    int j = mid;
    int pI = s;
    while (i < mid && j < e) {
      if (comp.compare(p2[i], p2[j]) < 0) {
        p[pI] = p2[i];
        i++;
      } else {
        p[pI] = p2[j];
        j++;
      }

      pI++;
    }

    while (i < mid) {
      p[pI] = p2[i];
      i++;
      pI++;
    }
    while (j < e) {
      p[pI] = p2[j];
      j++;
      pI++;
    }
  }

  // 13.2 - AppBenchmark.java

  // Question 14 - Ellipse.java

  // Question 15 - ParabulaClass.java

  // Question 16
  // 16.1
  static int numberOfRealRoots(Parabula p) {
    double[] params = p.get();
    double a = params[0];
    double b = params[1];
    double c = params[2];
    double inRoot = b * b - 2 * a * c;

    return inRoot > 0 ? 2 : inRoot == 0 ? 1 : 0;
  }

  // 16.2
  static void sort(ArrayList<Parabula> a) {
    ToDoubleFunction<? super Parabula> func = p -> p.f(p.extream(p));
    a.sort(Comparator.comparingDouble(func).reversed());
  }

  // Question 17
  // 17.1 AreaFilter.java
  // 17.2 PointsFilter.java
  // 17.3
  public static GeoShape[] filterShapes(GeoShape[] shapes, ShapeFilter filter) {
    return Arrays
        .stream(shapes)
        .filter(shape -> filter.filter(shape))
        .toArray(GeoShape[]::new);
  }

  // Quesion 18
  // 18.1
  public static String[] allCodes() {
    return Arrays
        .stream(allCodesHelper("12345"))
        .map(code -> code + '#')
        .toArray(String[]::new);
  }

  static String[] allCodesHelper(String digits) {
    if (digits.length() == 1)
      return new String[] { digits.charAt(0) + "" };

    String[] codes = new String[factorial(digits.length())];

    for (int i = 0; i < digits.length(); i++) {
      String subString = digits.substring(0, i) + digits.substring(i + 1);
      String[] subCodes = allCodesHelper(subString);
      for (int j = 0; j < subCodes.length; j++) {
        codes[i * subCodes.length + j] = digits.charAt(i) + subCodes[j];
      }
    }

    return codes;
  }

  static int factorial(int n) {
    for (int i = n - 1; i > 1; i--)
      n *= i;

    return n;
  }

  // 18.2 - AppTest.java testAllCodes

  // Question 19 - Pizza.java
  
}
