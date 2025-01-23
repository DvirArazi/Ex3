import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

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
}