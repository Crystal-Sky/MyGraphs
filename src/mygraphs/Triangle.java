package mygraphs;
import java.io.*;
import java.awt.*;
public class Triangle extends Shape implements java.io.Serializable
{
    point [] T;
    int a,b,c;
    public Triangle(point A,point B,point C)
    {
        T=new point[3];
        T[0]=new point (A.x,A.y);
        T[1]=new point (B.x,B.y);
        T[2]=new point (C.x,C.y);
        c=(int)(Math.sqrt(Math.pow((A.x-B.x),2)+Math.pow((A.y-B.y),2)));
        b=(int)(Math.sqrt(Math.pow((A.x-C.x),2)+Math.pow((A.y-C.y),2)));
        a=(int)(Math.sqrt(Math.pow((B.x-C.x),2)+Math.pow((B.y-C.y),2)));
    }
    public Triangle(String s)
    {   String[]ss;
        if((s!=null)&&(!s.isEmpty())&&(s.startsWith("T"))&&((ss=s.split(",")).length==6))
        {
            int x1,x2,x3,y1,y2,y3;
            x1=Integer.parseInt(ss[0].substring(1));
            y1=Integer.parseInt(ss[1]);
            x2=Integer.parseInt(ss[2]);
            y2=Integer.parseInt(ss[3]);
            x3=Integer.parseInt(ss[4]);
            y3=Integer.parseInt(ss[5]);   
            T=new point[3];
            T[0]=new point(x1,y1);
            T[1]=new point(x2,y2);
            T[2]=new point(x3,y3);
        }
    }
    public double get_Area()
    {
        double p=(a+b+c)/2.0;
        Area=Math.sqrt(p*(p-a)*(p-b)*(p-c));
        return Area;
    }
    public double get_Perimeter()
    {
        Perimeter=a+b+c;
        return Perimeter;
    }
    public String toString()
    {
        return "Triangle x1="+T[0].x+",y1="+T[0].y+",x2="+T[1].x+",y2="+T[1].y+",x3="+T[2].x+",y3"+T[2].y;
    }
    public String toShortString()
    {
        return "T"+T[0].x+","+T[0].y+","+T[1].x+","+T[1].y+","+T[2].x+","+T[2].y;
    }
    public void paint(Graphics g)
    {
        int xPoints[]={T[0].x,T[1].x,T[2].x};
        int yPoints[]={T[0].y,T[1].y,T[2].y};
        g.setColor(Color.ORANGE);
        g.drawPolygon(xPoints, yPoints,3);
    }
}