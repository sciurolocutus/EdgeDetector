package edgedetector.util;

public class Hypotenuse {

  public static int L1(int x, int y) {
    return (int) Math.sqrt(x*x + y*y);
  }

  /**
   * This is supposed to be a different, more accurate way
   *  to calculate the norm (hypotenuse) of a right triangle
   *  given side lengths x and y, but I honestly can't think
   *  of any way to squeeze out more accuracy short of
   *  changing the return type to double.
   */
  public static int L2(int x, int y) {
    return L1(x, y);
  }
}
