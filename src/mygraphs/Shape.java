package mygraphs;
import java.awt.*;
abstract public class Shape {
    double Perimeter;
    double Area;
    public abstract double get_Area();
    public abstract double get_Perimeter();
    public abstract String toShortString();
    public abstract void paint(Graphics g);
}
