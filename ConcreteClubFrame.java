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
        ImageIcon imageIcon1=new ImageIcon("ս��ͼ��/icon.png");
        this.setIconImage(imageIcon1.getImage());
        setVisible(true);//���ÿ�ܿɼ�
        setResizable(false);
        setTitle("�û���¼");
        setBounds(710,270,500,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//��ǰ���ڹرպ����ر�
        setLayout(null);//�ر�Ĭ�ϲ��֣������Զ��岼��
        this.setTitle(clubName);
        imageIcon=new ImageIcon("ս��ͼ��/"+clubName+".png");
        this.setIconImage(imageIcon.getImage());
        clubimage=new JLabel(imageIcon);
        clubimage.setBounds(25,5,150,150);
        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);
        add(clubimage);

        twholeName=new JTextField("ս��ȫ��:");
        twholeName.setBounds(200,5,100,40);
        twholeName.setEditable(false);
        add(twholeName);
        this.wholeName=new JTextField(wholeName);
        this.wholeName.setBounds(305,5,120,40);
        add(this.wholeName);

        thistoryGrade=new JTextField("��ʷս��:");
        thistoryGrade.setBounds(200,80,100,40);
        thistoryGrade.setEditable(false);
        add(thistoryGrade);
        this.historyGrade=new JTextField(historyGrade);
        this.historyGrade.setBounds(305,80,120,40);
        add(this.historyGrade);

        this.hornor=new JTextArea("��������:\n"+hornor);
        this.hornor.setLineWrap(true);
        Font  font=new Font("����",Font.BOLD,30);
        this.hornor.setFont(font);
        this.hornor.setBounds(25,170,450,320);
        JScrollPane scrollPane=new JScrollPane(this.hornor);
        scrollPane.setBounds(25,170,450,320);
        add(scrollPane);
    }
}
