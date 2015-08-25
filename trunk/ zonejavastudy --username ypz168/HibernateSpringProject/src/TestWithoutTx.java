import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.simon.modul.User;
import com.simon.modul.UserDAO;


public class TestWithoutTx {

 /**
  * @param args
  */
 public static void main(String[] args) {
  // TODO Auto-generated method stub
        User user=new User();
        user.setFirstName("first name");
        user.setLastName("last name");
        user.setUsername("user name");
        user.setPassword("password");
        user.setDateCreated(new Long(111111));
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO userdao=(UserDAO)context.getBean("UserDAO");
        //UserDAO userdao=(UserDAO)context.getBean("userDAOProxy");
        userdao.save(user);       
 }
}
