import mygraphs.*;
import myUI.*;
import java.util.*;
import java.io.*;
import java.io.PushbackInputStream;
class TestGraphs 
{
    static MyGraphs test=new MyGraphs();
    public TestGraphs()
    {}
    public void Showing()
    {
        String[] t0={"显示所有图形对象",
                     "增加新图形对象",
                     "删除图形对象",
                     "保存图形对象到文件",
                     "文件读入图形对象",
                     "退出程序"
                     };        
        boolean tagquit=false;
        while(!tagquit){
        switch(theUI.getSelected(t0,System.in,System.out))
                {
                    case 0:
                          test.displayAll(System.out);
                          break;
                    case 1:
                          addOperate();
                          break;
                    case 2:
                          delOperate();
                          break;
                    case 3:
                          saveOperate();
                          break;
                    case 4:
                          openOperate();
                          break;
                    case 5:
                          tagquit=true;
                          break;
                }
        }
        System.exit(0);
    }
 public static void addOperate()
{
        String[] td={"圆形类",
                      "正方形类",
                      "三角形类",
                      "直线类",
                      "返回上一个菜单"};
        boolean tagquit=false;
        while(!tagquit)
        {
         switch(theUI.getSelected(td,System.in,System.out))
          {
            case 0:
                    System.out.println("输入圆心的x坐标：");
                    int x=theUI.inread();
                    System.out.println("输入圆心的y坐标：");
                    int y=theUI.inread();
                    System.out.println("输入圆的半径：");
                    int r=theUI.inread();                   
                    test.add(new Circle(x,y,r));
                    break;
            case 1:
                    System.out.println("输入正方形的边长：");
                    int edge=theUI.inread();
                    System.out.println("输入A端点的x坐标：");
                    x=theUI.inread();
                    System.out.println("输入A端点的y坐标：");
                    y=theUI.inread();
                    test.add(new Square(x,y,edge));
                    break;
            case 2:
                    System.out.println("输入三角形A端点的x坐标：");
                    x=theUI.inread();
                    System.out.println("输入三角形A端点的y坐标：");
                    y=theUI.inread();
                    point A=new point(x,y);
                    System.out.println("输入三角形B端点的x坐标：");
                    x=theUI.inread();
                    System.out.println("输入三角形B端点的y坐标：");
                    y=theUI.inread();
                    point B=new point(x,y);
                    System.out.println("输入三角形C端点的x坐标：");
                    x=theUI.inread();
                    System.out.println("输入三角形C端点的y坐标：");
                    y=theUI.inread();
                    point C=new point(x,y);
                    test.add(new Triangle(A,B,C));
                    break;
            case 3:
                    System.out.println("输入直线A端点的x坐标：");
                    x=theUI.inread();
                    System.out.println("输入直线A端点的y坐标：");
                    y=theUI.inread();
                    System.out.println("输入直线B端点的x坐标：");
                    int x2=theUI.inread();
                    System.out.println("输入直线B端点的y坐标：");
                    int y2=theUI.inread();
                    test.add(new Line(x,y,x2,y2));
                    break;
            case 4:  
                tagquit=true;
                break;
          }
        }
    }
public static void delOperate()
{
        int t;
        boolean tagquit=false;
        do{
            if(test.gCount()==0)
            {
                System.out.println("该图形库为空，不存在图形对象，不能删除对象！");
                return;
            }
            test.displayAll(System.out);
            System.out.println("输入序号删除以上图像从[0]到["+(test.gCount()-1)+"]");        
            System.out.println("输入"+test.gCount()+" 返回上一层菜单");
            t=theUI.inread();
            if(t==(test.gCount())) tagquit=true;
            else if((t>=0)&&(t<test.gCount()))
                test.remove(t);
         }while(!tagquit);
    }
public static void saveOperate()
{
     String[] t01={"通过字节流保存为TXT文件（格式类似C12,34,48）",
                   "通过对象流保存为二进制文件",
                   "返回上一层菜单"};
        boolean tagquit=false;
        while(!tagquit)
        {
           switch(theUI.getSelected(t01,System.in,System.out))
          {
            case 0: File f=theUI.getSaveFile();
                    if(f!=null)
                    {
                    try
                    {
                      PrintStream ss=new PrintStream(new FileOutputStream(f));
                      test.displayAll(ss,0);
                      ss.close();
                    }
                    catch(IOException e){}
                    }
                    break;
            case 1:f=theUI.getSaveFile();
                    if(f!=null)
                    {                       
                        try
                        {
                            ObjectOutputStream ss=new ObjectOutputStream(new FileOutputStream(f));
                            test.toObject(ss);
                            ss.close();
                        }
                        catch(IOException e){}
                    }
                    break;
            case 2:  
                    tagquit=true;
                    break;
          }
      }
    }
public static void openOperate()
{
     String[] t02={"通过字节流读取TXT文件（格式类似C12,34,48",
                   "通过对象流读取二进制文件",
                   "返回上一层菜单"};
        boolean tagquit=false;
        while(!tagquit)
        {
           switch(theUI.getSelected(t02,System.in,System.out))
          {
            case 0: 
                    File f=theUI.getOpenFile();
                    if(f!=null)
                    {
                     try
                     {
                      Scanner ss=new Scanner(new FileInputStream(f));
                      String s=null;
                      while(ss.hasNext())
                        { s=ss.next();
                          if(s.startsWith("C"))
                          test.add(new Circle(s));
                          if(s.startsWith("S"))
                              test.add(new Square(s));
                          if(s.startsWith("L"))
                              test.add(new Line(s));
                          if(s.startsWith("T"))
                              test.add(new Triangle(s));
                        }
                      test.displayAll(System.out);
                      ss.close();
                     }
                    catch(IOException e){}
                    }                     
                    break;
            case 1:f=theUI.getOpenFile();
                    if(f!=null)
                    {
                        try
                        {
                            ObjectInputStream ss=new ObjectInputStream(new FileInputStream(f));                            
                            Shape s=(Shape)(ss.readObject());
                            while(s!=null)
                            {
                                test.add(s);
                                s=(Shape)ss.readObject();                                                
                            }
                            ss.close();
                            test.displayAll(System.out);
                        }
                        catch(Exception e){}
                    }
                    break;
            case 2:  
                    tagquit=true;
                    break;
          }
      }
    }
}

