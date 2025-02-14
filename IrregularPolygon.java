import java.awt.geom.*; // for Point2D.Double
import java.awt.geom.Point2D.Double;
import java.util.ArrayList; // for ArrayList
import java.util.concurrent.TimeUnit;

import gpdraw.*; // for DrawingTool


public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint) // "irregularPolygon.add(Double)" so it's a single double value that gets added, im assuming it's both
    //my main question though is about the object itself, what object am i trying to add too? as poly cannot be accsesed 
    {
        // TODO: Add a point to the IrregularPolygon.
        myPolygon.add(aPoint);
       
    }

    public double perimeter() {
        Point2D.Double current;
        Point2D.Double next;
        double dist = 0.0;
        for(int j = 0; j < myPolygon.size(); j++){

            if (j < myPolygon.size()-1){
                current = myPolygon.get(j);
                next = myPolygon.get(j+1);
            }
            else{
                current = myPolygon.get(j);
                next = myPolygon.get(0);
            }
           
            dist += current.distance(next);
            
        } 
           
        return dist;
    }

    public double area() {
        double res = 0.0;
        double temp = 0.0;
        Point2D.Double current;
        Point2D.Double next;
        for(int j = 0; j < myPolygon.size();j++){
            if (j < myPolygon.size()-1){
                current = myPolygon.get(j);
                next = myPolygon.get(j+1);
            }
            else{
                current = myPolygon.get(j);
                next = myPolygon.get(0);
            }
            temp = current.getX() * next.getY();
            res += temp;
        }
        for(int j = 0; j < myPolygon.size();j++){
            if (j < myPolygon.size()-1){
                current = myPolygon.get(j);
                next = myPolygon.get(j+1);
            }
            else{
                current = myPolygon.get(j);
                next = myPolygon.get(0);
            }
            temp = current.getY() * next.getX();
            res -= temp;
        }
        res *= 0.5;
        return Math.abs(res);
    }

    public void draw()
    {
        // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
        try {
            // TODO: Draw the polygon.
            // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
            DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
            pen.move(50, 50);
        } catch (java.awt.HeadlessException e) {
            System.out.println("Exception: No graphics support available.");
        }
    }
}
