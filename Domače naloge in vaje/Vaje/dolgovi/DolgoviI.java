import java.util.*;
public class DolgoviI {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int stOseb = sc.nextInt();
    int stIzposoj = sc.nextInt();

    int[][] nepobotani = new int[stOseb][stOseb];

    for (int i = 0; i < stIzposoj; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      int denar = sc.nextInt();

      nepobotani[a - 1][b - 1] += denar;
    }
    System.out.println(Arrays.deepToString(nepobotani));

    int[][] pobotani = new int[stOseb][stOseb];
    for (int a = 0; a < nepobotani.length; a++) {
      for (int b = 0; b < nepobotani[a].length; b++) {
        if (nepobotani[a][b] > nepobotani[b][a])
          pobotani[a][b] = nepobotani[a][b] - nepobotani[b][a];
      }
    }
    System.out.println(Arrays.deepToString(pobotani));
  }
}
