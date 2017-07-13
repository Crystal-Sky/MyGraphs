package mygraphs;
public class point implements java.io.Serializable 
{
    public int x;
    public int y;
    public point(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public String toString()
    {
        return "Point("+x+","+y+")";
    }
}
