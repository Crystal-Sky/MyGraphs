package mygraphs;
import java.io.*;
import java.awt.*;
public class Line extends Shape implements java.io.Serializable
{
    point O1,O2;
    public Line(int x1,int y1,int x2,int y2)
    {
        O1=new point(x1,y1);
        O2=new point(x2,y2);
    }
    public Line(String s)
    {   
        String[]ss;
        if((s!=null)&&(!s.isEmpty())&&(s.startsWith("L"))&&((ss=s.split(",")).length==4))
        {
            int x1=Integer.parseInt(ss[0].substring(1));
            int y1=Integer.parseInt(ss[1]);
            int x2=Integer.parseInt(ss[2]);
            int y2=Integer.parseInt(ss[3]);
            O1=new point(x1,y1);
            O2=new point(x2,y2);
        }
    }
    public double get_Area()
    {
        Area=0;
        return Area;
    }
    public double get_Perimeter()
    {
        double l=Math.pow(O1.x-O2.x, 2)+Math.pow(O1.y-O1.y, 2);
        Perimeter=Math.sqrt(l);
        return Perimeter;
    }
    public String toString()
    {
        return "Line "+"x1="+O1.x+",y1="+O1.y+",x2="+O2.x+",y2="+O2.y;
    }
    public String toShortString()
    {
        return "L"+O1.x+","+O1.y+","+O2.x+","+O2.y;
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.drawLine(O1.x, O1.y,O2.x,O2.y);
    }
}
