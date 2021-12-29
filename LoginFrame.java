
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;

//用户登录界面
public class LoginFrame extends JFrame implements ActionListener {
    private JButton signIn,signUp;//登录按钮与注册按钮
    static Connection con;//数据库链接 对象
    JTextField tid,tpassword,id,errorPassword;
    JPasswordField password;
    ImageIcon imageIcon;//窗口背景图
    public static MainFrame mainFrame;
    public static ClubFrame clubFrame;
    public static CompetitorFrame competitorFrame;
    public static  WatchingGamesFrame watchingGamesFrame;
    public static SignUpFrame signUpFrame;
    //通过getSqlConnection方法链接mysql数据库，
    // sqlid参数为用户名，sqlpassword为密码,port为端口号，ip为ip地址,databaseName为数据库名字
    public static Connection getSqlConnection(String sqlid,String sqlpassword,int port,String ip,String databaseName)
    {
        try
        {Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException ee)
        {
            System.out.println("数据库驱动加载失败"+ee.toString());
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
        setVisible(true);//设置框架可见
        setResizable(false);
        setTitle("用户登录");
        setSize(500,500);
        setLocationRelativeTo(null);//居中显示
        setDefaultCloseOperation(EXIT_ON_CLOSE);//当前窗口关闭后程序关闭
        setLayout(null);//关闭默认布局，采用自定义布局
        imageIcon=new ImageIcon("./狐狸.PNG");
        JLabel label=new JLabel(imageIcon);
        label.setBounds(0,0,500,500);
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        JPanel j=(JPanel) this.getContentPane();
        j.setOpaque(false);



        tid=new JTextField("账号:");
        tpassword=new JTextField("密码:");
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

        signIn=new JButton("登录");
        signUp=new JButton("注册");
        signIn.setBounds(50,300,150,50);
        signUp.setBounds(300,300,150,50);
        signIn.addActionListener(this);
        signUp.addActionListener(this);
        add(signUp);
        add(signIn);
        signUp.requestFocus();
        signIn.requestFocus();
        ImageIcon imageIcon1=new ImageIcon("战队图标/icon.png");
        this.setIconImage(imageIcon1.getImage());



    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("登录"))
        {

            String inputId,inputPassword;
            Statement sql1;
            ResultSet rs1;
            inputId=this.id.getText();
            inputPassword=new String(this.password.getPassword());
            try {
                 sql1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                 String s1=new String("'"+inputId+"'");
                 rs1=sql1.executeQuery("SELECT * FROM  用户表 WHERE 用户名="+s1);
                 rs1.last();
                 if(rs1.getRow()==0)
                 {
                     this.errorPassword.setVisible(true);
                     errorPassword.setText("用户不存在");
                 }
                 else
                 {
                     rs1.absolute(1);
                     String truePassword=rs1.getString("密码");
                     if(truePassword.equals(inputPassword))
                     {
                         this.setVisible(false);
                         LoginFrame.mainFrame=new MainFrame();
                     }
                     else
                     {
                         errorPassword.setVisible(true);
                         errorPassword.setText("密码错误");
                     }
                 }

            }
            catch (SQLException eee)
            {
                System.out.println(eee.toString());
            }
        }
        if(e.getActionCommand().equals("注册"))
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
