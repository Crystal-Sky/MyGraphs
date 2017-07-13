package mygraphs;
import java.io.*;
import java.awt.*;
public class Circle extends Shape implements java.io.Serializable
{
    public int Radius;
    point O;
    public Circle(int x,int y,int Radius)
    {
        O=new point(x,y);
        this.Radius=Radius;
    }
    public Circle(String s)
    {   
        String[]ss;
        if((s!=null)&&(!s.isEmpty())&&(s.startsWith("C"))&&((ss=s.split(",")).length==3))
        {
            Radius=Integer.parseInt(ss[0].substring(1));
            int x=Integer.parseInt(ss[1]);
            int y=Integer.parseInt(ss[2]);
            O=new point(x,y);
        }
    }
    public double get_Area()
    {
        Area=3.14*Radius*Radius;
        return Area;
    }
    public double get_Perimeter()
    {
        Perimeter=2*3.14*Radius;
        return Perimeter;
    }
    public String toString()
    {
        return "Circle Radius="+Radius+",x="+O.x+",y="+O.y;
    }
    public String toShortString()
    {
        return "C"+Radius+","+O.x+","+O.y;
    }
    public void paint(Graphics g)
    {
       g.setColor(Color.RED);       
       g.drawOval(O.x-Radius, O.y-Radius,2*Radius, 2*Radius);
    }
}
