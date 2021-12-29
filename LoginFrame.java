
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;

//�û���¼����
public class LoginFrame extends JFrame implements ActionListener {
    private JButton signIn,signUp;//��¼��ť��ע�ᰴť
    static Connection con;//���ݿ����� ����
    JTextField tid,tpassword,id,errorPassword;
    JPasswordField password;
    ImageIcon imageIcon;//���ڱ���ͼ
    public static MainFrame mainFrame;
    public static ClubFrame clubFrame;
    public static CompetitorFrame competitorFrame;
    public static  WatchingGamesFrame watchingGamesFrame;
    public static SignUpFrame signUpFrame;
    //ͨ��getSqlConnection��������mysql���ݿ⣬
    // sqlid����Ϊ�û�����sqlpasswordΪ����,portΪ�˿ںţ�ipΪip��ַ,databaseNameΪ���ݿ�����
    public static Connection getSqlConnection(String sqlid,String sqlpassword,int port,String ip,String databaseName)
    {
        try
        {Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException ee)
        {
            System.out.println("���ݿ���������ʧ��"+ee.toString());
        }
        String url="jdbc:mysql://"+ip+":"+port+"/"+databaseName+"?useSSl=true&characterEncoding=utf-8";
        Connection con=null;
       try
       { con=DriverManager.getConnection(url,sqlid,sqlpassword);}
       catch (SQLException e)
       {
           System.out.println(e.toString());
       }
       return  con;
    }
    public LoginFrame()
    {
        con=getSqlConnection("guest","wangmumu321",50791,"g463767c04.qicp.vip","lol");
        setVisible(true);//���ÿ�ܿɼ�
        setResizable(false);
        setTitle("�û���¼");
        setSize(500,500);
        setLocationRelativeTo(null);//������ʾ
        setDefaultCloseOperation(EXIT_ON_CLOSE);//��ǰ���ڹرպ����ر�
        setLayout(null);//�ر�Ĭ�ϲ��֣������Զ��岼��
        imageIcon=new ImageIcon("./����.PNG");
        JLabel label=new JLabel(imageIcon);
        label.setBounds(0,0,500,500);
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel) this.getContentPane();
        j.setOpaque(false);



        tid=new JTextField("�˺�:");
        tpassword=new JTextField("����:");
        tid.setBounds(100,200,35,20);
        tpassword.setBounds(100,240,35,20);
        errorPassword=new JTextField();
        errorPassword.setBounds(20,400,300,50);
        errorPassword.setVisible(false);
        add(errorPassword);
        add(tid);
        add(tpassword);
        tid.requestFocus();
        tpassword.requestFocus();

        id=new JTextField();
        password=new JPasswordField();
        id.setBounds(140,200,200,20);
        password.setBounds(140,240,200,20);
        add(id);
        add(password);
        id.requestFocus();
        password.requestFocus();

        signIn=new JButton("��¼");
        signUp=new JButton("ע��");
        signIn.setBounds(50,300,150,50);
        signUp.setBounds(300,300,150,50);
        signIn.addActionListener(this);
        signUp.addActionListener(this);
        add(signUp);
        add(signIn);
        signUp.requestFocus();
        signIn.requestFocus();
        ImageIcon imageIcon1=new ImageIcon("ս��ͼ��/icon.png");
        this.setIconImage(imageIcon1.getImage());



    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("��¼"))
        {

            String inputId,inputPassword;
            Statement sql1;
            ResultSet rs1;
            inputId=this.id.getText();
            inputPassword=new String(this.password.getPassword());
            try {
                 sql1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                 String s1=new String("'"+inputId+"'");
                 rs1=sql1.executeQuery("SELECT * FROM  �û��� WHERE �û���="+s1);
                 rs1.last();
                 if(rs1.getRow()==0)
                 {
                     this.errorPassword.setVisible(true);
                     errorPassword.setText("�û�������");
                 }
                 else
                 {
                     rs1.absolute(1);
                     String truePassword=rs1.getString("����");
                     if(truePassword.equals(inputPassword))
                     {
                         this.setVisible(false);
                         LoginFrame.mainFrame=new MainFrame();
                     }
                     else
                     {
                         errorPassword.setVisible(true);
                         errorPassword.setText("�������");
                     }
                 }

            }
            catch (SQLException eee)
            {
                System.out.println(eee.toString());
            }
        }
        if(e.getActionCommand().equals("ע��"))
        {
            if(LoginFrame.signUpFrame==null)
            LoginFrame.signUpFrame=new SignUpFrame(this);
        }

    }
    public static void main(String args[])
    {
        LoginFrame frame=new LoginFrame();
    }
}
