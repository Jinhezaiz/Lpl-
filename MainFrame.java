import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//主界面
public class MainFrame extends JFrame implements ActionListener {
    private JButton clubMessage;//点击该按钮，查看各俱乐部信息
    private  JButton competitor;//点击该按钮，查看选手信息
    private JButton  watchingGames;//点击该按钮，查看实时比赛

    MainFrame()
    {   setVisible(true);//设置框架可见
        setResizable(false);
        setTitle("LPL实时观赛系统");
        setSize(500,500);
        setLocationRelativeTo(null);//居中显示
        setDefaultCloseOperation(EXIT_ON_CLOSE);//当前窗口关闭后程序关闭
        setLayout(null);//关闭默认布局，采用自定义布局
        clubMessage=new JButton("战队简介");
        competitor=new JButton("选手信息");
        watchingGames=new JButton("实时直播");
        clubMessage.setBounds(190,50,100,50);
        competitor.setBounds(190,150,100,50);
        watchingGames.setBounds(190,250,100,50);
        add(clubMessage);
        add(competitor);
        add(watchingGames);
        clubMessage.addActionListener(this);
        competitor.addActionListener(this);
        watchingGames.addActionListener(this);
        ImageIcon imageIcon=new ImageIcon("./狐狸.PNG");
        JLabel label=new JLabel(imageIcon);
        label.setBounds(0,0,500,500);
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel) this.getContentPane();
        j.setOpaque(false);
        ImageIcon imageIcon1=new ImageIcon("战队图标/icon.png");
        this.setIconImage(imageIcon1.getImage());

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("战队简介"))
        {
            this.setVisible(false);
            LoginFrame.clubFrame=new ClubFrame();
        }
        if(e.getActionCommand().equals("选手信息"))
        {
            this.setVisible(false);
            LoginFrame.competitorFrame=new CompetitorFrame();
        }
        if(e.getActionCommand().equals("实时直播"))
        {
            this.setVisible(false);
            LoginFrame.watchingGamesFrame=new WatchingGamesFrame();
        }
    }
}