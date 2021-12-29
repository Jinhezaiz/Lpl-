import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ConcreteClubFrame extends JFrame {
    JLabel clubimage;
    JTextField twholeName,wholeName,thistoryGrade,historyGrade;
    JTextArea hornor;
    ImageIcon imageIcon;
    public  ConcreteClubFrame(String clubName,String wholeName,String historyGrade,String hornor)
    {
        ImageIcon imageIcon1=new ImageIcon("战队图标/icon.png");
        this.setIconImage(imageIcon1.getImage());
        setVisible(true);//设置框架可见
        setResizable(false);
        setTitle("用户登录");
        setBounds(710,270,500,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//当前窗口关闭后程序关闭
        setLayout(null);//关闭默认布局，采用自定义布局
        this.setTitle(clubName);
        imageIcon=new ImageIcon("战队图标/"+clubName+".png");
        this.setIconImage(imageIcon.getImage());
        clubimage=new JLabel(imageIcon);
        clubimage.setBounds(25,5,150,150);
        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);
        add(clubimage);

        twholeName=new JTextField("战队全称:");
        twholeName.setBounds(200,5,100,40);
        twholeName.setEditable(false);
        add(twholeName);
        this.wholeName=new JTextField(wholeName);
        this.wholeName.setBounds(305,5,120,40);
        add(this.wholeName);

        thistoryGrade=new JTextField("历史战绩:");
        thistoryGrade.setBounds(200,80,100,40);
        thistoryGrade.setEditable(false);
        add(thistoryGrade);
        this.historyGrade=new JTextField(historyGrade);
        this.historyGrade.setBounds(305,80,120,40);
        add(this.historyGrade);

        this.hornor=new JTextArea("所获荣誉:\n"+hornor);
        this.hornor.setLineWrap(true);
        Font  font=new Font("黑体",Font.BOLD,30);
        this.hornor.setFont(font);
        this.hornor.setBounds(25,170,450,320);
        JScrollPane scrollPane=new JScrollPane(this.hornor);
        scrollPane.setBounds(25,170,450,320);
        add(scrollPane);
    }
}
