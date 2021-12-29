import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//选手信息界面
public class CompetitorFrame extends JFrame implements ActionListener {
    JButton returnMainFrame;
    ConcreteCompetitorFrame concreteCompetitorFrame;
    JButton edg,fpx,ig,jdg,lng,ra,rng,tes,wbg,we;
    public CompetitorFrame()
    {
        setVisible(true);//设置框架可见
        setResizable(false);
        setTitle("查看战队成员信息");
        setSize(500,500);
        setLocationRelativeTo(null);//居中显示
        setDefaultCloseOperation(EXIT_ON_CLOSE);//当前窗口关闭后程序关闭
        setLayout(null);//关闭默认布局，采用自定义布局
        edg=new JButton("EDG");
        edg.setBounds(50,10,100,50);
        edg.addActionListener(this);
        fpx=new JButton("FPX");
        fpx.setBounds(330,10,100,50);
        fpx.addActionListener(this);
        ig=new JButton("IG");
        ig.setBounds(50,80,100,50);
        ig.addActionListener(this);
        jdg=new JButton("JDG");
        jdg.setBounds(330,80,100,50);
        jdg.addActionListener(this);
        lng=new JButton("LNG");
        lng.setBounds(50,150,100,50);
        lng.addActionListener(this);
        ra=new JButton("RA");
        ra.setBounds(330,150,100,50);
        ra.addActionListener(this);
        rng=new JButton("RNG");
        rng.setBounds(50,220,100,50);
        rng.addActionListener(this);
        tes=new JButton("TES");
        tes.setBounds(330,220,100,50);
        tes.addActionListener(this);
        wbg=new JButton("WBG");
        wbg.setBounds(50,290,100,50);
        wbg.addActionListener(this);
        we=new JButton("WE");
        we.setBounds(330,290,100,50);
        we.addActionListener(this);
        returnMainFrame=new JButton("返回主界面");
        returnMainFrame.setBounds(160,400,150,50);
        returnMainFrame.addActionListener(this);
        ImageIcon imageIcon=new ImageIcon("./狐狸.PNG");
        JLabel label=new JLabel(imageIcon);
        label.setBounds(0,0,500,500);
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel) this.getContentPane();
        j.setOpaque(false);
        ImageIcon imageIcon1=new ImageIcon("战队图标/icon.png");
        this.setIconImage(imageIcon1.getImage());

        add(returnMainFrame);
        add(edg);
        add(fpx);
        add(ig);
        add(jdg);
        add(lng);
        add(ra);
        add(rng);
        add(tes);
        add(wbg);
        add(we);
    }
    class Message
    {
        String clubName;
        String name[]=new String[6];
        String positions[]=new String[6];
        String grades[]=new String[6];
        String recentTimes[]=new String[6];
        public Message()
        {

        }
    }
    public void actionPerformed(ActionEvent event)
    {
        if(event.getActionCommand().equals("返回主界面"))
        {
            this.setVisible(false);
        LoginFrame.mainFrame.setVisible(true);
        }
        else
        {
            try {
                Statement sql = LoginFrame.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                String s="'"+event.getActionCommand()+"'";
                Message message=new Message();
                ResultSet rs=sql.executeQuery("SELECT * FROM 选手信息表 WHERE 战队="+s);
                message.clubName=event.getActionCommand();
                rs.next();
                for(int i=0;i<6;i++)
                {
                    message.name[i]=rs.getString("名称");
                    message.positions[i]=rs.getString("位置");
                    message.grades[i]=rs.getString("韩服分数");
                    message.recentTimes[i]=rs.getString("最近上线时间");
                    rs.next();
                }
                if (this.concreteCompetitorFrame != null)
                    concreteCompetitorFrame.dispose();
                concreteCompetitorFrame = new ConcreteCompetitorFrame(message);
            }
            catch (SQLException ee)
            {
                System.out.println(ee);
            }
        }
    }
}
