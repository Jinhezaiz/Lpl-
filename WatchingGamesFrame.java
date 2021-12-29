import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

//�ۿ�ֱ������
public class WatchingGamesFrame extends JFrame implements ActionListener {
   JButton returnMainFrame;
    JButton livegame,highlights;

    public WatchingGamesFrame()
    {
        setVisible(true);//���ÿ�ܿɼ�
        setResizable(false);
        setTitle("ʵʱֱ��");
        setSize(500,500);
        setLocationRelativeTo(null);//������ʾ
        setDefaultCloseOperation(EXIT_ON_CLOSE);//��ǰ���ڹرպ����ر�
        setLayout(null);//�ر�Ĭ�ϲ��֣������Զ��岼��
        ImageIcon imageIcon=new ImageIcon("./����.PNG");
        JLabel label=new JLabel(imageIcon);
        label.setBounds(0,0,500,500);
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel) this.getContentPane();
        j.setOpaque(false);
        ImageIcon imageIcon1=new ImageIcon("ս��ͼ��/icon.png");
        this.setIconImage(imageIcon1.getImage());

        livegame=new JButton("ʵʱ�����ۿ�");
        livegame.setBounds(190,100,150,50);
        highlights=new JButton("�ۿ����¾��ʼ���");
        highlights.setBounds(190,200,150,50);
        livegame.addActionListener(this);
        highlights.addActionListener(this);


        returnMainFrame=new JButton("����������");
        returnMainFrame.setBounds(190,300,150,50);
        returnMainFrame.addActionListener(this);

        add(returnMainFrame);
        add(livegame);
        add(highlights);
    }
    public void actionPerformed(ActionEvent event)
    {

        if (event.getActionCommand().equals("����������"))
        {
            this.setVisible(false);
            LoginFrame.mainFrame.setVisible(true);
        }
        else if (event.getActionCommand().equals("ʵʱ�����ۿ�"))
        {
            try {
                String url = "https://lpl.qq.com/es/live.shtml";
                //����һ��URIʵ��
                URI uri = URI.create(url);
                // getDesktop()���ص�ǰ����������ĵ� Desktop ʵ����
                //Desktop ������ Java Ӧ�ó����������ڱ���������ע��Ĺ���Ӧ�ó����Դ��� URI ���ļ���
                Desktop dp = Desktop.getDesktop();
                //�ж�ϵͳ�����Ƿ�֧��Ҫִ�еĹ���
                if(dp.isSupported(Desktop.Action.BROWSE)){
                    //����Ĭ�����������ʾ URI
                    dp.browse(uri);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (event.getActionCommand().equals("�ۿ����¾��ʼ���"))
        {
            try {
                String url = "https://lpl.qq.com/es/video.shtml";
                //����һ��URIʵ��
                URI uri = URI.create(url);
                // getDesktop()���ص�ǰ����������ĵ� Desktop ʵ����
                //Desktop ������ Java Ӧ�ó����������ڱ���������ע��Ĺ���Ӧ�ó����Դ��� URI ���ļ���
                Desktop dp = Desktop.getDesktop();
                //�ж�ϵͳ�����Ƿ�֧��Ҫִ�еĹ���
                if(dp.isSupported(Desktop.Action.BROWSE)){
                    //����Ĭ�����������ʾ URI
                    dp.browse(uri);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
