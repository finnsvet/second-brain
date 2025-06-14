public class fourSix {
  private static double[] polarCordinates(Double radius, Double angle) {
    return new double[] {radius * Math.cos(angle), radius * Math.sin(angle)};
  }
  private static double lawOfCosine(double a, double b, double c) {
    // returns angle opposite to side C
    return Math.toDegrees( Math.acos( (a*a + b*b - c*c)/(2*a*b) ) );
  }
  public static void main(String[] args) {
    // init
    double radius = 40.0;
    double pointAng1 = Math.random() * 2*Math.PI;
    double pointAng2 = Math.random() * 2*Math.PI;
    double pointAng3 = Math.random() * 2*Math.PI;

    // using polar cordinates we have:
    double[] pointA = polarCordinates(radius, pointAng1);
    double[] pointB = polarCordinates(radius, pointAng2);
    double[] pointC = polarCordinates(radius, pointAng3);
    
    // find the distance between points
    double c = Math.sqrt( Math.pow(pointA[0] - pointB[0], 2) + Math.pow(pointA[1] - pointB[1], 2) ); 
    double b = Math.sqrt( Math.pow(pointA[0] - pointC[0], 2) + Math.pow(pointA[1] - pointC[1], 2) ); 
    double a = Math.sqrt( Math.pow(pointB[0] - pointC[0], 2) + Math.pow(pointB[1] - pointC[1], 2) );

    // find the angle between them using Law of Cosines
    double A = lawOfCosine(b, c, a);
    double B = lawOfCosine(c, a, b);
    double C = lawOfCosine(a, b, c);

    //print
    System.out.printf( "Circle radius: %.2f, center: {0, 0}\n", radius);
    System.out.printf( "Point: %1c, Cordinates: {%4.2f, %4.2f}, Angle: %.2f \n", 'A', pointA[0], pointA[1], A );
    System.out.printf( "Point: %1c, Cordinates: {%4.2f, %4.2f}, Angle: %.2f \n", 'B', pointB[0], pointB[1], B );
    System.out.printf( "Point: %1c, Cordinates: {%4.2f, %4.2f}, Angle: %.2f \n", 'C', pointC[0], pointC[1], C );
  }
}
