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
public class SquareDlg extends JDialog
{
    Shape graph=null;
    private JButton jButton1=new JButton("新建");
    private JButton jButton2=new JButton("取消");
    private JLabel []label={new JLabel("端点A的x坐标："),new JLabel("端点A的y坐标："),new JLabel("正方形的边长：")};
    private JTextField []text={new JTextField("50",8),new JTextField("50",8),new JTextField("300",8)};
    public SquareDlg(JFrame parent)
    {
        super(parent,"设置正方形的属性",true);
        setSize(250,150);
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
        int [] gx={1,7,1,7,1,7,1,7};
        int [] gy={1,1,15,15,20,20,25,25};
        int [] gw={1,1,1,1,1,1,1,1};
        int [] gh={1,1,1,1,1,1,1,1};
        GridBagConstraints gc=new GridBagConstraints();
        for(int i=0,j=0;i<3;i++,j++)        
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
        gc.gridx=gx[6];
        gc.gridy=gy[6];
        gc.gridwidth=gw[6];
        gc.gridheight=gh[6];
        gr.setConstraints(jButton1,gc);
        jButton1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent evt) 
            {                                         
                int x1=Integer.parseInt(text[0].getText());
                int y1=Integer.parseInt(text[1].getText());
                int edge=Integer.parseInt(text[2].getText());
                graph=new Square(x1,y1,edge);
                dispose();
            } 
        });
        c.add(jButton1);
        gc.gridx=gx[7];
        gc.gridy=gy[7];
        gc.gridwidth=gw[7];
        gc.gridheight=gh[7];
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
    public static Shape getSquare(JFrame f) 
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
            java.util.logging.Logger.getLogger(SquareDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) 
        {
            java.util.logging.Logger.getLogger(SquareDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) 
        {
            java.util.logging.Logger.getLogger(SquareDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(SquareDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        SquareDlg dialog = new SquareDlg(f);
        dialog.setVisible(true);
        return dialog.graph;
    }
}
