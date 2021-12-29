import javax.swing.*;
import java.awt.*;



public class ConcreteCompetitorFrame extends JFrame{
    JLabel []competitorsTexts=new JLabel[6];//该标签显示选手的id及其位置
    JLabel []competitorsImageIcons=new JLabel[6];//该标签显示选手的照片
    JLabel []competitorsGradesAndRecentTimes=new JLabel[6];//该标签显示选手的韩服分数及最近上线时间
    public ConcreteCompetitorFrame(CompetitorFrame.Message m)
    {
        ImageIcon imageIcon1=new ImageIcon("战队图标/icon.png");
        this.setIconImage(imageIcon1.getImage());
        this.setIconImage(new ImageIcon("战队图标/"+m.clubName+".png").getImage());
        setVisible(true);//设置框架可见
        setResizable(false);
        setTitle(m.clubName +"战队队员信息");
        setSize(840,800);//设置窗口大小
        setLocationRelativeTo(null);//居中显示
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//当前窗口关闭后程序关闭
        setLayout(null);//关闭默认布局，采用自定义布局

        //设置选手的id和位置
        Font font=new Font("楷体",Font.BOLD,20);
        for(int i=0;i<competitorsTexts.length;i++)
        {
            competitorsTexts[i]=new JLabel();
            competitorsTexts[i].setBounds(40,70+110*i,180,50);
            competitorsTexts[i].setFont(font);
            competitorsTexts[i].setText(m.positions[i]+":"+m.name[i]);
            add(competitorsTexts[i]);
        }



        //设置选手的照片
        for(int i=0;i<competitorsImageIcons.length;i++)
        {
            competitorsImageIcons[i]=new JLabel(new ImageIcon("战队人员图片/"+m.clubName+"/"+m.name[i]+".jpg"));
            competitorsImageIcons[i].setBounds(220,competitorsTexts[i].getY()-25,100,100);
            add(competitorsImageIcons[i]);
        }


        //设置选手的分数及最近上线时间
        for(int i=0;i<competitorsGradesAndRecentTimes.length;i++)
        {
            competitorsGradesAndRecentTimes[i]=new JLabel();
            competitorsGradesAndRecentTimes[i].setFont(font);
            competitorsGradesAndRecentTimes[i].setBounds(330,70+110*i,500,50);
            competitorsGradesAndRecentTimes[i].setText("韩服分数:"+m.grades[i]+"  最近上线:"+m.recentTimes[i]);
            add(competitorsGradesAndRecentTimes[i]);
        }

    }
}

