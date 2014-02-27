package sqrt_x;

public class Test {
  public static void main(String... s) {
    Test test = new Test();
    int y = test.sqrt(2147395599);
    System.out.println(y);
  }

  public int sqrt(int x) {
    if (46340 * 46340 < x)
      return 46340;
    int low = 0;
    int high = x < 46340 ? x + 1 : 46340;
    int mid;
    while (high > low + 1) {
      mid = (high + low) / 2;
      if (mid * mid > x) {
        high = mid;
      } else {
        low = mid;
      }
    }
    return low;
  }
}
