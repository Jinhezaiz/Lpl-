import com.mysql.cj.jdbc.StatementImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpFrame extends JFrame implements ActionListener {
    LoginFrame loginFrame;
    JTextField tid,tpassword,surepassword,id,errorMessage;
    JPasswordField password,repeatedPasswprd;
    JButton signUp;
    ImageIcon imageIcon;
    public  SignUpFrame(LoginFrame loginFrame)
    {
        ImageIcon imageIcon1=new ImageIcon("ս��ͼ��/icon.png");
        this.setIconImage(imageIcon1.getImage());
        this.loginFrame=loginFrame;
        imageIcon=new ImageIcon("�û�ע��.PNG");
        JLabel label=new JLabel(imageIcon);
        label.setBounds(0,0,500,500);
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel) this.getContentPane();
        j.setOpaque(false);

        setVisible(true);//���ÿ�ܿɼ�
        setResizable(false);
        setTitle("�û�ע��");
        setBounds(800,270,500,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//��ǰ���ڹرպ����ر�
        setLayout(null);//�ر�Ĭ�ϲ��֣������Զ��岼��

        tid=new JTextField("�˺�:");
        tpassword=new JTextField("����:");
        tid.setBounds(100,150,35,20);
        tpassword.setBounds(100,190,35,20);
        surepassword=new JTextField("ȷ������:");
        surepassword.setBounds(100,230,60,20);
        errorMessage=new JTextField();
        errorMessage.setBounds(20,400,300,50);
        errorMessage.setVisible(false);
        add(errorMessage);
        add(tid);
        add(tpassword);
        add(surepassword);
        tid.requestFocus();
        tpassword.requestFocus();

        id=new JTextField();
        password=new JPasswordField();
        id.setBounds(140,150,200,20);
        password.setBounds(140,190,200,20);
        repeatedPasswprd=new JPasswordField();
        repeatedPasswprd.setBounds(165,230,200,20);
        add(id);
        add(password);
        add(repeatedPasswprd);
        id.requestFocus();
        password.requestFocus();
        repeatedPasswprd.requestFocus();

        signUp=new JButton("���ע��");
        signUp.setBounds(150,300,150,50);
        signUp.addActionListener(this);
        add(signUp);
    }
    public void actionPerformed(ActionEvent e)
    {
      String inputid=id.getText();
      String inputpassword=new String(password.getPassword());
      String inputSurePassword=new String(repeatedPasswprd.getPassword());
      boolean b1=inputid.equals("");
      boolean b2=inputpassword.equals("");
      boolean b3=inputSurePassword.equals("");
      if(b1||b2||b3)
      {
          errorMessage.setText("�˺Ż������ʽ����");
          errorMessage.setVisible(true);
      }
      else
      {
          try {
              Statement sql = LoginFrame.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
              String s1 = new String("'" + inputid + "'");
              String s2=new String("'" + inputpassword + "'");
              ResultSet  rs = sql.executeQuery("SELECT * FROM  �û��� WHERE �û���=" + s1);
              rs.last();
              if (rs.getRow() == 1) {
                  this.errorMessage.setVisible(true);
                  errorMessage.setText("�û��Ѵ���");
              }
              else
              {
                  if(inputpassword.equals(inputSurePassword))
                  {
                   Statement sql2=LoginFrame.con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                   sql2.executeUpdate("INSERT INTO �û��� VALUES ("+s1+","+s2+")");
                   rs = sql.executeQuery("SELECT * FROM  �û��� WHERE �û���=" + s1);
                   rs.last();
                   if(rs.getRow()==1)
                   {
                       errorMessage.setVisible(true);
                       errorMessage.setText("�˺�ע��ɹ�");
                       loginFrame.id.setText(inputid);
                       loginFrame.password.setText(inputpassword);
                       this.dispose();
                   }
                  }
                  else
                  {
                      errorMessage.setVisible(true);
                      errorMessage.setText("������������벻һ��");
                  }
              }
          }
          catch (SQLException ee)
          {
              System.out.println(ee);
          }
      }
    }
}
