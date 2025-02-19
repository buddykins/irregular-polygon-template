import java.awt.geom.*; // for Point2D.Double
import java.util.Arrays;

public class TestSuite {
    // Run a bunch of basic tests on IrregularPolygon
    public static void run()
    {
        System.out.println("Starting TestSuite");
        boolean pass = true;

        double[][] singlePoint = { { 0, 0 } };
        pass &= basicTest("Single Point", singlePoint, 0, 0);

        double[][] squarePoints = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 0 } };
        pass &= basicTest("Unit Square", squarePoints, 4, 1);

        double[][] parallelogramPoints = { { 20, 10 }, { 70, 20 }, { 50, 50 }, { 0, 40 } };
        pass &= basicTest("Parallelogram", parallelogramPoints, 174.0914, 1700);

        double[][] bowtiePoints = { { 0, 0 }, { 100, 50 }, { 100, 0 }, { 0, 50 } };
        pass &= basicTest("Bowtie", bowtiePoints, 323.6067, 0.0);

        if (pass == true)
        {
            System.out.println("--- TEST PASSED! Congrats! ---");
        }
        else
        {
            System.out.println("--- TEST FAILED! :( ---");
        }
    }

    public static boolean basicTest(String description, double[][] points, double expectedPerimeter, double expectedArea)
    {
        IrregularPolygon poly = new IrregularPolygon();
        for (double[] point : points)
        { //keep note of this
            //System.out.println("  Adding point: " + Arrays.toString(point));
            poly.add(new Point2D.Double(point[0], point[1])); // point[0], point[1] seem to make the point 0,1. how would i add this to a shape?
            // the .add is what im trying to make, and it seems to almost make a whole new point2d, i wonder if i could point2d.clone itself plus the new point
        }
        poly.draw();

        double perimeter = poly.perimeter();
        double area = poly.area();

        boolean perimeterCorrect = compareDoubles(perimeter, expectedPerimeter);
        boolean areaCorrect = compareDoubles(area, expectedArea);

        if (perimeterCorrect && areaCorrect)
        {
            System.out.println("PASS: " + description);
            return true;
        }
        else
        {
            System.out.println("FAIL: " + description);
            if (!perimeterCorrect) {
                System.out.println(" Perimeter should be: " + expectedPerimeter + " not: " + perimeter);
            }
            if (!areaCorrect) {
                System.out.println(" Area should be: " + expectedArea + " not: " + area);
            }
            return false;
        }
    }

    private static boolean compareDoubles(Double a, Double b)
    {
        if (Math.abs(a - b) < 0.001) {
            return true;
        }
        else
        {
            return false;
        }
    }
}
