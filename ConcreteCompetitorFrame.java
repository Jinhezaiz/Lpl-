import javax.swing.*;
import java.awt.*;



public class ConcreteCompetitorFrame extends JFrame{
    JLabel []competitorsTexts=new JLabel[6];//�ñ�ǩ��ʾѡ�ֵ�id����λ��
    JLabel []competitorsImageIcons=new JLabel[6];//�ñ�ǩ��ʾѡ�ֵ���Ƭ
    JLabel []competitorsGradesAndRecentTimes=new JLabel[6];//�ñ�ǩ��ʾѡ�ֵĺ����������������ʱ��
    public ConcreteCompetitorFrame(CompetitorFrame.Message m)
    {
        ImageIcon imageIcon1=new ImageIcon("ս��ͼ��/icon.png");
        this.setIconImage(imageIcon1.getImage());
        this.setIconImage(new ImageIcon("ս��ͼ��/"+m.clubName+".png").getImage());
        setVisible(true);//���ÿ�ܿɼ�
        setResizable(false);
        setTitle(m.clubName +"ս�Ӷ�Ա��Ϣ");
        setSize(840,800);//���ô��ڴ�С
        setLocationRelativeTo(null);//������ʾ
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//��ǰ���ڹرպ����ر�
        setLayout(null);//�ر�Ĭ�ϲ��֣������Զ��岼��

        //����ѡ�ֵ�id��λ��
        Font font=new Font("����",Font.BOLD,20);
        for(int i=0;i<competitorsTexts.length;i++)
        {
            competitorsTexts[i]=new JLabel();
            competitorsTexts[i].setBounds(40,70+110*i,180,50);
            competitorsTexts[i].setFont(font);
            competitorsTexts[i].setText(m.positions[i]+":"+m.name[i]);
            add(competitorsTexts[i]);
        }



        //����ѡ�ֵ���Ƭ
        for(int i=0;i<competitorsImageIcons.length;i++)
        {
            competitorsImageIcons[i]=new JLabel(new ImageIcon("ս����ԱͼƬ/"+m.clubName+"/"+m.name[i]+".jpg"));
            competitorsImageIcons[i].setBounds(220,competitorsTexts[i].getY()-25,100,100);
            add(competitorsImageIcons[i]);
        }


        //����ѡ�ֵķ������������ʱ��
        for(int i=0;i<competitorsGradesAndRecentTimes.length;i++)
        {
            competitorsGradesAndRecentTimes[i]=new JLabel();
            competitorsGradesAndRecentTimes[i].setFont(font);
            competitorsGradesAndRecentTimes[i].setBounds(330,70+110*i,500,50);
            competitorsGradesAndRecentTimes[i].setText("��������:"+m.grades[i]+"  �������:"+m.recentTimes[i]);
            add(competitorsGradesAndRecentTimes[i]);
        }

    }
}

