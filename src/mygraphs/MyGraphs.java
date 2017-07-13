package mygraphs;
import java.awt.Graphics;
import java.util.*; 
import java.io.*;
public class MyGraphs 
{
    Vector<Shape> mygraph=new Vector<Shape>();    
    public void displayAll(Graphics g)
    {
        for(Shape x:mygraph)
            x.paint(g);
    }
    public void displayAll(PrintStream sout)
    { int i=0;
    sout.println("***所有图形对象的数量是："+mygraph.size()+"****");
      for(Shape s:mygraph)
         sout.println("["+(i++)+"]"+s);  
    sout.println("****************以上为全部图形对象************");
    }
    public void displayAll(OutputStream out,int mode)
    {
          PrintStream sout=new PrintStream(out);
          for(Shape s:mygraph)
          sout.println(s.toShortString());  
    }
    public void toObject(ObjectOutputStream o)
    {
        for(Shape s:mygraph)
            try
            {
                o.writeObject(s);
                o.flush();
            }
            catch(IOException e){}
    }
    public void add(Shape obj)
    {
        mygraph.add(obj);
    }    
    public void remove(int index)
    {
        mygraph.remove(index);
    }
    public void getname(String []name)
    {
        int i=0;
        for(Shape s:mygraph)
        {            
            name[i]=s.toString();
            i++;
        }
    }
    public int gCount()
    {
        return mygraph.size();
    }
}
