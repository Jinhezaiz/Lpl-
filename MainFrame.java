import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//������
public class MainFrame extends JFrame implements ActionListener {
    private JButton clubMessage;//����ð�ť���鿴�����ֲ���Ϣ
    private  JButton competitor;//����ð�ť���鿴ѡ����Ϣ
    private JButton  watchingGames;//����ð�ť���鿴ʵʱ����

    MainFrame()
    {   setVisible(true);//���ÿ�ܿɼ�
        setResizable(false);
        setTitle("LPLʵʱ����ϵͳ");
        setSize(500,500);
        setLocationRelativeTo(null);//������ʾ
        setDefaultCloseOperation(EXIT_ON_CLOSE);//��ǰ���ڹرպ����ر�
        setLayout(null);//�ر�Ĭ�ϲ��֣������Զ��岼��
        clubMessage=new JButton("ս�Ӽ��");
        competitor=new JButton("ѡ����Ϣ");
        watchingGames=new JButton("ʵʱֱ��");
        clubMessage.setBounds(190,50,100,50);
        competitor.setBounds(190,150,100,50);
        watchingGames.setBounds(190,250,100,50);
        add(clubMessage);
        add(competitor);
        add(watchingGames);
        clubMessage.addActionListener(this);
        competitor.addActionListener(this);
        watchingGames.addActionListener(this);
        ImageIcon imageIcon=new ImageIcon("./����.PNG");
        JLabel label=new JLabel(imageIcon);
        label.setBounds(0,0,500,500);
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel) this.getContentPane();
        j.setOpaque(false);
        ImageIcon imageIcon1=new ImageIcon("ս��ͼ��/icon.png");
        this.setIconImage(imageIcon1.getImage());

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("ս�Ӽ��"))
        {
            this.setVisible(false);
            LoginFrame.clubFrame=new ClubFrame();
        }
        if(e.getActionCommand().equals("ѡ����Ϣ"))
        {
            this.setVisible(false);
            LoginFrame.competitorFrame=new CompetitorFrame();
        }
        if(e.getActionCommand().equals("ʵʱֱ��"))
        {
            this.setVisible(false);
            LoginFrame.watchingGamesFrame=new WatchingGamesFrame();
        }
    }
}