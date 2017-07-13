package myUI;
import mygraphs.*;
import java.util.*;
import java.io.*;
import java.awt.Container;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
public class ReadDlg extends JDialog
{
    MyGraphs graph=null;
    private JButton jButton1=new JButton("通过字节流读取txt文件");
    private JButton jButton2=new JButton("通过对象流读取bin文件");
    private JButton jButton3=new JButton("取消");
    public ReadDlg(JFrame parent,MyGraphs graph)
    {
        super(parent,"读取图形",true);
        this.graph=graph;
        setSize(250,150);
        int x=(int)(parent.getLocationOnScreen().x+parent.getWidth()*0.3);
        int y=(int)(parent.getLocationOnScreen().y+parent.getHeight()*0.2);
        setLocation(x, y);
        init();
    }
    public void init()
    {
        jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                File f;
                JFileChooser r=new JFileChooser();
                if(r.showOpenDialog(r)==JFileChooser.APPROVE_OPTION)
                    f=r.getSelectedFile();
                else 
                    f=null;
                if(f!=null)
                {
                    try
                    {
                        Scanner ss=new Scanner(new FileInputStream(f));
                        String s=null;
                        while(ss.hasNext())
                        { 
                            s=ss.next();
                            if(s.startsWith("C"))
                                graph.add(new Circle(s));
                            if(s.startsWith("S"))
                                graph.add(new Square(s));
                            if(s.startsWith("L"))
                                graph.add(new Line(s));                                
                            if(s.startsWith("T"))
                                graph.add(new Triangle(s));
                        }
                        ss.close();
                    }
                    catch(IOException h){}                    
                    dispose();
                }      
            }
        });
        jButton2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                File f;
                JFileChooser r=new JFileChooser();
                if(r.showOpenDialog(r)==JFileChooser.APPROVE_OPTION)
                    f=r.getSelectedFile();
                else 
                    f=null;
                if(f!=null)
                {
                    try
                    {
                        ObjectInputStream ss=new ObjectInputStream(new FileInputStream(f));    
                        Shape s=(Shape)ss.readObject();                                                
                        while(s!=null)
                        {
                            graph.add(s);
                            s=(Shape)ss.readObject();                                                
                        }
                        ss.close();
                    }
                    catch(Exception h){}
                    dispose();
                }
            }
        });
        jButton3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
        Container c=getContentPane();
        c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
        c.add(jButton1);
        c.add(jButton2);
        c.add(jButton3);       
    }
}
