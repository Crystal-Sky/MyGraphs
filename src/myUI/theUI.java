package myUI;
import java.io.*;
import javax.swing.*;
public class theUI {
    public static File getSaveFile()
    {
        JFileChooser r=new JFileChooser();
        if(r.showSaveDialog(r)==JFileChooser.APPROVE_OPTION)
            return r.getSelectedFile();
        else 
            return null;
    }
     public static File getOpenFile()
    {
        JFileChooser r=new JFileChooser();
        if(r.showOpenDialog(r)==JFileChooser.APPROVE_OPTION)
            return r.getSelectedFile();
        else 
            return null;
    }
    public static int getSelected(String[] menu,InputStream in,PrintStream out)
    {   int i;
        do
        {
            i=-1;   
            for(String s:menu)
                out.println("["+(++i)+"] "+s);       
            out.println("请输入操作对应的操作序号：");
            i=inread();
        }while((i<0)||(i>=menu.length));
        return i;
    }
    public static int inread()
    {
        BufferedReader f=new BufferedReader(new InputStreamReader(System.in));
        int i=0;
        try
        {
            String s=f.readLine();
            i=Integer.parseInt(s);
        }
        catch(Exception e){}
        return i;
    }
}
