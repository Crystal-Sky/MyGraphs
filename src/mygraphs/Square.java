package mygraphs;
import java.io.*;
import java.awt.*;
public class Square extends Shape implements java.io.Serializable 
{
    int edge;
    point A;
    public Square(int x,int y,int edge)
    {
        A=new point(x,y);
        this.edge=edge;
    }
    public Square(String s)
    {   String[]ss;
        if((s!=null)&&(!s.isEmpty())&&(s.startsWith("S"))&&((ss=s.split(",")).length==3))
        {
            edge=Integer.parseInt(ss[0].substring(1));
            int x=Integer.parseInt(ss[1]);
            int y=Integer.parseInt(ss[2]);
            A=new point(x,y);
        }
    }
    public double get_Area()
    {
        Area=Math.pow(edge, 2);
        return Area;
    }
    public double get_Perimeter()
    {
        Perimeter=edge*4;
        return Perimeter;
    }
    public String toString()
    {
        return "Square edge="+edge+",x="+A.x+",y="+A.y;
    }
    public String toShortString()
    {
        return "S"+edge+","+A.x+","+A.y;
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.drawRect(A.x, A.y,edge,edge);
    }
}
