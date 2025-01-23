// Question 13
// 13.2
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class AppBenchmark {
  public static void main(String[] args) {
    mySortBenchmark();
  }

  public static void mySortBenchmark() {
    Random random = new Random();
    Integer[] arr0;
    Integer[] arr1;
    long sortStart;

    for (int itemsC : new int[] { 100, 1000, 10000 }) {
      arr0 = new Integer[itemsC];
      for (int i = 0; i < arr0.length; i++)
        arr0[i] = random.nextInt();
      arr1 = arr0.clone();

      sortStart = System.nanoTime();
      Arrays.sort(arr0);
      System.out.println("sort   | " + itemsC + " items: " + (System.nanoTime() - sortStart) + " nanoseconds");

      sortStart = System.nanoTime();
      App.mySort(arr1, Comparator.naturalOrder());
      System.out.println("mySort | " + itemsC + " items: " + (System.nanoTime() - sortStart) + " nanoseconds");
    }
  }
}