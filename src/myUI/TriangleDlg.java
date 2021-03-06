package myUI;
import mygraphs.*;
import java.awt.Container;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
public class TriangleDlg extends JDialog
{
    Shape graph=null;
    private JButton jButton1=new JButton("新建");
    private JButton jButton2=new JButton("取消");
    private JLabel []label={new JLabel("顶点A的x坐标："),new JLabel("顶点A的y坐标："),new JLabel("顶点B的x坐标："),
        new JLabel("顶点B的y坐标："),new JLabel("顶点C的x坐标："),new JLabel("顶点C的y坐标：")};
    private JTextField []text={new JTextField("60",8),new JTextField("60",8),new JTextField("300",8),
        new JTextField("200",8),new JTextField("200",8),new JTextField("250",8)};
    public TriangleDlg(JFrame parent)
    {
        super(parent,"设置三角形的属性",true);
        setSize(400,200);
        int x=(int)(parent.getLocationOnScreen().x+parent.getWidth()*0.3);
        int y=(int)(parent.getLocationOnScreen().y+parent.getHeight()*0.2);
        setLocation(x, y);
        init();
    }
    public void init()
    {
        Container c=getContentPane();
        GridBagLayout gr=new GridBagLayout();
        c.setLayout(gr);
        int [] gx={1,7,1,7,1,7,1,7,1,7,1,7,1,7};
        int [] gy={1,1,15,15,20,20,25,25,30,30,35,35,40,40};
        int [] gw={1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int [] gh={1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        GridBagConstraints gc=new GridBagConstraints();
        for(int i=0,j=0;i<6;i++,j++)        
        {
            gc.gridx=gx[j];
            gc.gridy=gy[j];
            gc.gridwidth=gw[j];
            gc.gridheight=gh[j];
            gr.setConstraints(label[i],gc);
            c.add(label[i]);
            j++;
            gc.gridx=gx[j];
            gc.gridy=gy[j];
            gc.gridwidth=gw[j];
            gc.gridheight=gh[j];
            gr.setConstraints(text[i],gc);
            c.add(text[i]);
        }
        gc.gridx=gx[12];
        gc.gridy=gy[12];
        gc.gridwidth=gw[12];
        gc.gridheight=gh[12];
        gr.setConstraints(jButton1,gc);
        jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {                                         
                int x1=Integer.parseInt(text[0].getText());
                int x2=Integer.parseInt(text[2].getText());
                int x3=Integer.parseInt(text[4].getText());
                int y1=Integer.parseInt(text[1].getText());
                int y2=Integer.parseInt(text[3].getText());
                int y3=Integer.parseInt(text[5].getText());
                point A=new point(x1,y1);
                point B=new point(x2,y2);
                point C=new point(x3,y3);
                graph=new Triangle(A,B,C);
                dispose();
            } 
        });
        c.add(jButton1);
        gc.gridx=gx[13];
        gc.gridy=gy[13];
        gc.gridwidth=gw[13];
        gc.gridheight=gh[13];
        gr.setConstraints(jButton2,gc);
        jButton2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {                                         
                dispose();
            } 
        });
        c.add(jButton2);  
    }
    public static Shape getTriangle(JFrame f) 
    {
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) 
        {
            java.util.logging.Logger.getLogger(TriangleDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) 
        {
            java.util.logging.Logger.getLogger(TriangleDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) 
        {
            java.util.logging.Logger.getLogger(TriangleDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(TriangleDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        TriangleDlg dialog = new TriangleDlg(f);
        dialog.setVisible(true);
        return dialog.graph;
    }
}
