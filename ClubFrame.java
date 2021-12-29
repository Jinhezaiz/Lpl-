
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


//战队信息总界面
public class ClubFrame extends JFrame implements ActionListener {
    ConcreteClubFrame concreClubFrame;
    JButton returnMainFrame;
    JButton edg,fpx,ig,jdg,lng,ra,rng,tes,wbg,we;
    public ClubFrame()
    {
        setVisible(true);//设置框架可见
        setResizable(false);
        setTitle("战队信息");
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
    public void actionPerformed(ActionEvent event)
    {
        if(event.getActionCommand().equals("返回主界面"))
        {
            this.setVisible(false);
            LoginFrame.mainFrame.setVisible(true);
        }
        else
        {
            if(this.concreClubFrame!=null)
            this.concreClubFrame.dispose();
            String clubname="'"+event.getActionCommand()+"'";
            String historyGrade;
            String hornor;
            String wholeName;
            try
            {
                Statement sql=LoginFrame.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                ResultSet rs=sql.executeQuery("SELECT * FROM 战队表 WHERE 战队名称="+clubname);
                rs.next();
                wholeName=rs.getString("战队全称");
                historyGrade=rs.getString("历史战绩");
                hornor=rs.getString("所获荣誉");
                this.concreClubFrame=new ConcreteClubFrame(event.getActionCommand(),wholeName,historyGrade,hornor);
            }
            catch (SQLException ee)
            {
                System.out.println(ee);
            }
        }
    }
}
