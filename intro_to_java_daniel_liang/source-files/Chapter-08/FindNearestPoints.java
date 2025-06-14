import java.util.Arrays;

public class FindNearestPoints {

  public static void main(String[] args) {
    double[][] points = {
      { -1.0, 3.0 },
      { -1.0, -1.0 },
      { 1.0, 1.0 },
      { 2.0, 0.5 },
      { 2.0, -1.0 },
      { 3.0, 3.0 },
      { 4.0, 2.0 },
      { 4.0, -0.5 },
    };
    double closestDist = distance(points[0], points[1]);
    double[][] closestPoints = new double[2][2];
    closestPoints[0] = points[0];
    closestPoints[1] = points[1];

    for (int p1 = 0; p1 < points.length; ++p1) {
      for (int p2 = p1 + 1; p2 < points.length; ++p2) {
        double currentDist = distance(points[p1], points[p2]);
        if (currentDist < closestDist) {
          closestDist = currentDist;
          closestPoints[0] = points[p1];
          closestPoints[1] = points[p2];
        }
      }
    }

    System.out.printf(
      "The closest points are %s and %s\n",
      Arrays.toString(closestPoints[0]),
      Arrays.toString(closestPoints[1])
    );
  }

  public static double distance(double[] p1, double[] p2) {
    return Math.sqrt(
      Math.pow((p1[0] - p2[0]), 2) + Math.pow((p1[1] - p2[1]), 2)
    );
  }
}
