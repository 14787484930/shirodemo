package shirodemo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //创建SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //得到SecurityManager实例，并绑定到SecurityUtil
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //得到Subject用户名及密码创建token
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","1234561");

        try{
            subject.login(token);
            if(subject.isAuthenticated()) {
                System.out.println("认证成功！");
            }else{
                System.out.println("认证失败！");
            }
         }catch (Exception e){
            System.out.println("认证失败！");
        }


        //System.out.println( "Hello World!" );
    }
}
