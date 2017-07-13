package myUI;
import mygraphs.*;
import java.io.*;
import java.awt.Container;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
public class SaveDlg extends JDialog
{
    MyGraphs graph=null;
    private JButton jButton1=new JButton("通过字节流保存为txt文件");
    private JButton jButton2=new JButton("通过对象流保存为bin文件");
    private JButton jButton3=new JButton("取消");
    public SaveDlg(JFrame parent,MyGraphs g)
    {
        super(parent,"保存图形",true);
        graph=g;
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
                if(r.showSaveDialog(r)==JFileChooser.APPROVE_OPTION)
                    f=r.getSelectedFile();
                else 
                    f=null;
                if(f!=null)
                {
                    try
                    {
                        PrintStream ss=new PrintStream(new FileOutputStream(f));
                        graph.displayAll(ss,1);
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
                if(r.showSaveDialog(r)==JFileChooser.APPROVE_OPTION)
                    f=r.getSelectedFile();
                else 
                    f=null;
                if(f!=null)
                {
                    try
                    {
                        ObjectOutputStream ss=new ObjectOutputStream(new FileOutputStream(f));                            
                        graph.toObject(ss);
                        ss.close();
                    }
                    catch(IOException h){}
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
