在model包下生成了三个类和一个映射文件。AbstractUser是User的抽象类，在此需要说明一点的是，在标准的spring应用中UserDAO应该是一个接口，而不是一个具体的类，而myeclipse将数据库操作方法直接写到了 UserDAO中，另外，按照标准写法，DAO实现类要实现DAO接口，并且要包括SessionFactory的变量声明，但是生成的代码中 UserDAO直接实现了HibernateDaoSupport类，需要特别注意。所以，如果你需要标准写法，可以将UserDAO中的方法提取出来，只保留方法声明，然后再间一个impl目录，将该DAO的实现类放在该impl中，按照管理将该类命名为UserDAOImpl，另外一点最好将DAO和它的实现类移到dao包中，结构和model包中的相同。

在这个例子中暂且将生成的文件都放到model中。

此时我们可以写一个测试程序将一条记录插入到user表中，当然这个测试程序并没有用事务控制，后面我们还会介绍，测试程序如下：

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.simon.model.UserDAO;
import com.simon.model.User;
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
        userdao.save(user);       
 }
}

现在的问题是增加事务处理功能，跟我继续，这时候源程序不需要修改，只需要修改applicationContext.xml配置文件，首先增加事务管理器,因为事务管理器也需要使用数据库，所以需要引入sessionFactory

如下：

 <bean id="myTransactionManager"  class="org.springframework.orm.hibernate3.HibernateTransactionManager">
 <property name="sessionFactory">
 <ref bean="sessionFactory" />
 </property>
 </bean> 

继续增加如下配置信息：

<bean id="userDAOProxy" class="org.springframework.transaction.interceptor.TransactionProxyFactoryBean">
  <property name="proxyTargetClass">
   <value>true</value>
  </property>
  <property name="transactionManager">
   <ref bean="myTransactionManager" />
  </property>
  <property name="target">
   <ref local="UserDAO" />
  </property>
  <property name="transactionAttributes">
   <props>
    <!-- 这里的方法签名可以精确到方法, 先懒惰一下全配置上 -->
    <prop key="*">PROPAGATION_REQUIRED</prop>
   </props>
  </property>
 </bean>

 

注意以上红色部分：  注意这个属性,必须为 true，使用CGLIB时才不用强制编写DAO接口，也就是由于myeclipse并没有为我们生成DAO接口，而是生成了一个数据库实现类，为了使spring 不强迫我们必须定义一个DAO接口，只需要将这个proxyTargetClass属性定义为true，这点非常重要，程序出错很有可能和这个属性设置错误有关。

下面再写一个测试程序，和上面的测试程序基本相同，唯一不同是将上面的

UserDAO userdao=(UserDAO)context.getBean("userDAO");

换成

UserDAO userdao=(UserDAO)context.getBean("userDAOProxy");

执行，一切ok，数据正确的插入到数据库中。