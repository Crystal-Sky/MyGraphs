package myUI;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar.Separator;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import mygraphs.*;
public class GtypePanel extends JToolBar
{
    
    public MyGraphs t;
    int contype=0;                 
    private ButtonGroup buttonGroup1;
    private JButton jButton1=new JButton("新建");
    private JButton jButton2=new JButton("删除");
    private JButton jButton4=new JButton("保存到文件");
    private JButton jButton3=new JButton("从文件读取");
    private JComboBox jComt;
    private Separator jSeparator1=new Separator();
    private Separator jSeparator2=new Separator();
    private Separator []jSeparator={new Separator(),new Separator(),new Separator(),new Separator(),new Separator()};
    private JToggleButton []jToggleButton={
        new JToggleButton("清空"),new JToggleButton("圆形"),
        new JToggleButton("直线"),new JToggleButton("正方形"),
        new JToggleButton("三角形")};
    public GtypePanel(MyGraphs test)
    {
        this.t=test;
        init();        
    }
    public void init()
    {
        buttonGroup1=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            buttonGroup1.add(jToggleButton[i]);
        }
        jToggleButton[0].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {          
                contype=0;
                int n=t.gCount();
                for(int i=0;i<n;i++)
                {
                    t.remove(0);
                    jComt.removeItemAt(0);
                }
                getParent().repaint();
            }
        });
        jToggleButton[1].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {          
                contype=1;
            }
        });
        jToggleButton[2].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {     
                contype=2;
            }
        });
        jToggleButton[3].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {            
                contype=3;
            }
        });
        jToggleButton[4].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {            
                contype=4;
            }
        });
        jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                switch(contype)
                {
                    case 0:JOptionPane.showMessageDialog(getParent(), "没有设置图形类型！");break;
                    case 1:                        
                        Shape c=CircleDlg.getCircle((javax.swing.JFrame)(getRootPane().getParent()));
                    if(c!=null) 
                    {
                        t.add(c);
                        String C=c.toString();
                        jComt.addItem(C);
                        jComt.updateUI();
                        getRootPane().getParent().repaint();
                    }
                    break;
                    case 2:
                        Shape l=LineDlg.getLine((javax.swing.JFrame)(getRootPane().getParent()));
                    if(l!=null) 
                    {
                        t.add(l); 
                        String L=l.toString();
                        jComt.addItem(L);
                        jComt.updateUI();
                        getRootPane().getParent().repaint();
                    }
                    break;
                    case 3:
                        Shape s=SquareDlg.getSquare((javax.swing.JFrame)(getRootPane().getParent()));
                    if(s!=null) 
                    {
                        t.add(s);
                        String S=s.toString();
                        jComt.addItem(S);
                        jComt.updateUI();
                        getRootPane().getParent().repaint();
                    }
                    break;                        
                    case 4:
                        Shape tt=TriangleDlg.getTriangle((javax.swing.JFrame)(getRootPane().getParent()));
                    if(tt!=null) 
                    {
                        t.add(tt);
                        String T=tt.toString();
                        jComt.addItem(T);
                        jComt.updateUI();
                        getRootPane().getParent().repaint();
                    }
                    break;
                    default:break;
                }
            }
        });
        jButton2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int u=jComt.getSelectedIndex();
                if(u!=-1)
                {
                    t.remove(u);
                    jComt.removeItemAt(u);
                }
                if(t.gCount()==0)
                    jComt.setSelectedIndex(-1);
                else if(u<t.gCount())
                    jComt.setSelectedIndex(u);
                getParent().repaint();
            }
        });
        jButton3.addActionListener(new ActionListener()     
        {
            public void actionPerformed(ActionEvent e)
            {
                ReadDlg r=new ReadDlg((javax.swing.JFrame)(getRootPane().getParent()),t);
                r.setVisible(true);
                String [] n=new String[t.gCount()];
                t.getname(n);   
                jComt.removeAllItems();
                for(int i=0;i<t.gCount();i++)
                {
                    jComt.addItem(n[i]);
                    jComt.updateUI();
                }
                getRootPane().getParent().repaint();
            }
        });
        jButton4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                SaveDlg x=new SaveDlg((javax.swing.JFrame)(getRootPane().getParent()),t);
                x.setVisible(true);
            }
        });
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel shape1=new JPanel();
        shape1.setLayout(new BoxLayout(shape1,BoxLayout.X_AXIS));
        for(int i=0;i<5;i++)
        {            
            shape1.add(jToggleButton[i]);
            shape1.add(jSeparator[i]);
        }
        shape1.add(jButton3);
        shape1.add(jSeparator1);
        shape1.add(jButton4);
        JPanel shape3=new JPanel();             
        shape3.setLayout(new BoxLayout(shape3,BoxLayout.X_AXIS));
        jComt=new JComboBox(); 
        shape3.add(jButton1);
        shape3.add(jComt);    
        shape3.add(jButton2);
        this.add(shape1);
        this.add(shape3);
    }                                                                                                                                                                                    
}
