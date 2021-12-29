
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


//ս����Ϣ�ܽ���
public class ClubFrame extends JFrame implements ActionListener {
    ConcreteClubFrame concreClubFrame;
    JButton returnMainFrame;
    JButton edg,fpx,ig,jdg,lng,ra,rng,tes,wbg,we;
    public ClubFrame()
    {
        setVisible(true);//���ÿ�ܿɼ�
        setResizable(false);
        setTitle("ս����Ϣ");
        setSize(500,500);
        setLocationRelativeTo(null);//������ʾ
        setDefaultCloseOperation(EXIT_ON_CLOSE);//��ǰ���ڹرպ����ر�
        setLayout(null);//�ر�Ĭ�ϲ��֣������Զ��岼��
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
        returnMainFrame=new JButton("����������");
        returnMainFrame.setBounds(160,400,150,50);
        returnMainFrame.addActionListener(this);
        ImageIcon imageIcon=new ImageIcon("./����.PNG");
        JLabel label=new JLabel(imageIcon);
        label.setBounds(0,0,500,500);
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel) this.getContentPane();
        j.setOpaque(false);
        ImageIcon imageIcon1=new ImageIcon("ս��ͼ��/icon.png");
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
        if(event.getActionCommand().equals("����������"))
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
                ResultSet rs=sql.executeQuery("SELECT * FROM ս�ӱ� WHERE ս������="+clubname);
                rs.next();
                wholeName=rs.getString("ս��ȫ��");
                historyGrade=rs.getString("��ʷս��");
                hornor=rs.getString("��������");
                this.concreClubFrame=new ConcreteClubFrame(event.getActionCommand(),wholeName,historyGrade,hornor);
            }
            catch (SQLException ee)
            {
                System.out.println(ee);
            }
        }
    }
}
