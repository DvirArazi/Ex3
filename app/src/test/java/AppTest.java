import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import Utils.BinaryTree;

public class AppTest {
  @Test
  public void testIsOfTheSameStructure() {
    assertEquals(1, 2);
  }

  @Test
  public void mySortTest() {
    Integer[] first = new Integer[] { 1 };
    Integer[] second = new Integer[] { 1 };
    App.mySort(second, Comparator.naturalOrder());
    assertArrayEquals(first, second);

    first = new Integer[] { 1, 2 };
    second = new Integer[] { 2, 1 };
    App.mySort(second, Comparator.naturalOrder());
    assertArrayEquals(first, second);

    first = new Integer[] { 1, 2, 3 };
    second = new Integer[] { 2, 3, 1 };
    App.mySort(second, Comparator.naturalOrder());
    assertArrayEquals(first, second);

    first = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 };
    second = new Integer[] { 3, 7, 8, 5, 4, 2, 6, 1 };
    App.mySort(second, Comparator.naturalOrder());
    assertArrayEquals(first, second);
  }

  // 18.2
  @Test
  public void testAllCodes() {
    assertArrayEquals(
        App.allCodes(),
        new String[] {
            "12345#", "12354#", "12435#", "12453#", "12534#", "12543#",
            "13245#", "13254#", "13425#", "13452#", "13524#", "13542#",
            "14235#", "14253#", "14325#", "14352#", "14523#", "14532#",
            "15234#", "15243#", "15324#", "15342#", "15423#", "15432#",
            "21345#", "21354#", "21435#", "21453#", "21534#", "21543#",
            "23145#", "23154#", "23415#", "23451#", "23514#", "23541#",
            "24135#", "24153#", "24315#", "24351#", "24513#", "24531#",
            "25134#", "25143#", "25314#", "25341#", "25413#", "25431#",
            "31245#", "31254#", "31425#", "31452#", "31524#", "31542#",
            "32145#", "32154#", "32415#", "32451#", "32514#", "32541#",
            "34125#", "34152#", "34215#", "34251#", "34512#", "34521#",
            "35124#", "35142#", "35214#", "35241#", "35412#", "35421#",
            "41235#", "41253#", "41325#", "41352#", "41523#", "41532#",
            "42135#", "42153#", "42315#", "42351#", "42513#", "42531#",
            "43125#", "43152#", "43215#", "43251#", "43512#", "43521#",
            "45123#", "45132#", "45213#", "45231#", "45312#", "45321#",
            "51234#", "51243#", "51324#", "51342#", "51423#", "51432#",
            "52134#", "52143#", "52314#", "52341#", "52413#", "52431#",
            "53124#", "53142#", "53214#", "53241#", "53412#", "53421#",
            "54123#", "54132#", "54213#", "54231#", "54312#", "54321#",
        });
  }

  @Test
  public void isOfTheSameStructureTest() {
    assertTrue(App.isOfTheSameStructure(null, null));

    BinaryTree<Integer> tree0 = new BinaryTreeClass<>(null, null, 1);
    assertFalse(App.isOfTheSameStructure(tree0, null));
    assertFalse(App.isOfTheSameStructure(null, tree0));

    BinaryTree<Integer> leftA1 = new BinaryTreeClass<>(null, null, 2);
    BinaryTree<Integer> rightA1 = new BinaryTreeClass<>(null, null, 3);
    BinaryTree<Integer> treeA1 = new BinaryTreeClass<>(leftA1, rightA1, 1);
    BinaryTree<Integer> leftA2 = new BinaryTreeClass<>(null, null, 5);
    BinaryTree<Integer> rightA2 = new BinaryTreeClass<>(null, null, 6);
    BinaryTree<Integer> treeA2 = new BinaryTreeClass<>(leftA2, rightA2, 4);
    assertTrue(App.isOfTheSameStructure(treeA1, treeA2));

    BinaryTree<Integer> leftB1 = new BinaryTreeClass<>(null, null, 2);
    BinaryTree<Integer> treeB1 = new BinaryTreeClass<>(leftB1, null, 1);
    BinaryTree<Integer> leftB2 = new BinaryTreeClass<>(null, null, 5);
    BinaryTree<Integer> rightB2 = new BinaryTreeClass<>(null, null, 6);
    BinaryTree<Integer> treeB2 = new BinaryTreeClass<>(leftB2, rightB2, 4);
    assertFalse(App.isOfTheSameStructure(treeB1, treeB2));

    BinaryTree<Integer> leftC1 = new BinaryTreeClass<>(new BinaryTreeClass<>(null, null, 2), null, 3);
    BinaryTree<Integer> rightC1 = new BinaryTreeClass<>(null, new BinaryTreeClass<>(null, null, 4), 5);
    BinaryTree<Integer> treeC1 = new BinaryTreeClass<>(leftC1, rightC1, 1);
    BinaryTree<Integer> leftC2 = new BinaryTreeClass<>(new BinaryTreeClass<>(null, null, 6), null, 7);
    BinaryTree<Integer> rightC2 = new BinaryTreeClass<>(null, new BinaryTreeClass<>(null, null, 8), 9);
    BinaryTree<Integer> treeC2 = new BinaryTreeClass<>(leftC2, rightC2, 10);
    assertTrue(App.isOfTheSameStructure(treeC1, treeC2));

    BinaryTree<Integer> leftD1 = new BinaryTreeClass<>(new BinaryTreeClass<>(null, null, 2), null, 3);
    BinaryTree<Integer> rightD1 = new BinaryTreeClass<>(null, new BinaryTreeClass<>(null, null, 4), 5);
    BinaryTree<Integer> treeD1 = new BinaryTreeClass<>(leftD1, rightD1, 1);
    BinaryTree<Integer> leftD2 = new BinaryTreeClass<>(null, null, 6);
    BinaryTree<Integer> rightD2 = new BinaryTreeClass<>(null, new BinaryTreeClass<>(null, null, 8), 9);
    BinaryTree<Integer> treeD2 = new BinaryTreeClass<>(leftD2, rightD2, 10);
    assertFalse(App.isOfTheSameStructure(treeD1, treeD2));
  }

  @Test
    void testQ10Function() {
        assertFalse(App.Q10(1));
        assertTrue(App.Q10(30));
        assertTrue(App.Q10(105));
        assertFalse(App.Q10(6));
        assertFalse(App.Q10(2310));
        assertFalse(App.Q10(0));
        assertFalse(App.Q10(2));
    }
}