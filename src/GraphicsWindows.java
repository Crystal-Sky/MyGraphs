import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import mygraphs.*;
import myUI.*;
import javax.swing.*;
public class GraphicsWindows
{
    static MyGraphs test=new MyGraphs();
    static JFrame shapef=new JFrame("绘图工具")
    {
       {
        setBounds(100,100,620,500);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(new JPanel()
        {  
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);        
                this.setBackground(Color.WHITE);
                test.displayAll(g);
            }
        });
        getContentPane().add(new GtypePanel(test),BorderLayout.NORTH);
        }
    };
    public static void main(String[] args)
    {       
        shapef.setVisible(true);
        TestGraphs e=new TestGraphs();
        e.Showing();
    }
}