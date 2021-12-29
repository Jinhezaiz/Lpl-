import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

//观看直播界面
public class WatchingGamesFrame extends JFrame implements ActionListener {
   JButton returnMainFrame;
    JButton livegame,highlights;

    public WatchingGamesFrame()
    {
        setVisible(true);//设置框架可见
        setResizable(false);
        setTitle("实时直播");
        setSize(500,500);
        setLocationRelativeTo(null);//居中显示
        setDefaultCloseOperation(EXIT_ON_CLOSE);//当前窗口关闭后程序关闭
        setLayout(null);//关闭默认布局，采用自定义布局
        ImageIcon imageIcon=new ImageIcon("./狐狸.PNG");
        JLabel label=new JLabel(imageIcon);
        label.setBounds(0,0,500,500);
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel) this.getContentPane();
        j.setOpaque(false);
        ImageIcon imageIcon1=new ImageIcon("战队图标/icon.png");
        this.setIconImage(imageIcon1.getImage());

        livegame=new JButton("实时比赛观看");
        livegame.setBounds(190,100,150,50);
        highlights=new JButton("观看赛事精彩集锦");
        highlights.setBounds(190,200,150,50);
        livegame.addActionListener(this);
        highlights.addActionListener(this);


        returnMainFrame=new JButton("返回主界面");
        returnMainFrame.setBounds(190,300,150,50);
        returnMainFrame.addActionListener(this);

        add(returnMainFrame);
        add(livegame);
        add(highlights);
    }
    public void actionPerformed(ActionEvent event)
    {

        if (event.getActionCommand().equals("返回主界面"))
        {
            this.setVisible(false);
            LoginFrame.mainFrame.setVisible(true);
        }
        else if (event.getActionCommand().equals("实时比赛观看"))
        {
            try {
                String url = "https://lpl.qq.com/es/live.shtml";
                //创建一个URI实例
                URI uri = URI.create(url);
                // getDesktop()返回当前浏览器上下文的 Desktop 实例。
                //Desktop 类允许 Java 应用程序启动已在本机桌面上注册的关联应用程序，以处理 URI 或文件。
                Desktop dp = Desktop.getDesktop();
                //判断系统桌面是否支持要执行的功能
                if(dp.isSupported(Desktop.Action.BROWSE)){
                    //启动默认浏览器来显示 URI
                    dp.browse(uri);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (event.getActionCommand().equals("观看赛事精彩集锦"))
        {
            try {
                String url = "https://lpl.qq.com/es/video.shtml";
                //创建一个URI实例
                URI uri = URI.create(url);
                // getDesktop()返回当前浏览器上下文的 Desktop 实例。
                //Desktop 类允许 Java 应用程序启动已在本机桌面上注册的关联应用程序，以处理 URI 或文件。
                Desktop dp = Desktop.getDesktop();
                //判断系统桌面是否支持要执行的功能
                if(dp.isSupported(Desktop.Action.BROWSE)){
                    //启动默认浏览器来显示 URI
                    dp.browse(uri);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
