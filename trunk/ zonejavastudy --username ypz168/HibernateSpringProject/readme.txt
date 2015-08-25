��model�����������������һ��ӳ���ļ���AbstractUser��User�ĳ����࣬�ڴ���Ҫ˵��һ����ǣ��ڱ�׼��springӦ����UserDAOӦ����һ���ӿڣ�������һ��������࣬��myeclipse�����ݿ��������ֱ��д���� UserDAO�У����⣬���ձ�׼д����DAOʵ����Ҫʵ��DAO�ӿڣ�����Ҫ����SessionFactory�ı����������������ɵĴ����� UserDAOֱ��ʵ����HibernateDaoSupport�࣬��Ҫ�ر�ע�⡣���ԣ��������Ҫ��׼д�������Խ�UserDAO�еķ�����ȡ������ֻ��������������Ȼ���ټ�һ��implĿ¼������DAO��ʵ������ڸ�impl�У����չ�����������ΪUserDAOImpl������һ����ý�DAO������ʵ�����Ƶ�dao���У��ṹ��model���е���ͬ��

��������������ҽ����ɵ��ļ����ŵ�model�С�

��ʱ���ǿ���дһ�����Գ���һ����¼���뵽user���У���Ȼ������Գ���û����������ƣ��������ǻ�����ܣ����Գ������£�

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

���ڵ������������������ܣ����Ҽ�������ʱ��Դ������Ҫ�޸ģ�ֻ��Ҫ�޸�applicationContext.xml�����ļ��������������������,��Ϊ���������Ҳ��Ҫʹ�����ݿ⣬������Ҫ����sessionFactory

���£�

 <bean id="myTransactionManager"  class="org.springframework.orm.hibernate3.HibernateTransactionManager">
 <property name="sessionFactory">
 <ref bean="sessionFactory" />
 </property>
 </bean> 

������������������Ϣ��

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
    <!-- ����ķ���ǩ�����Ծ�ȷ������, ������һ��ȫ������ -->
    <prop key="*">PROPAGATION_REQUIRED</prop>
   </props>
  </property>
 </bean>

 

ע�����Ϻ�ɫ���֣�  ע���������,����Ϊ true��ʹ��CGLIBʱ�Ų���ǿ�Ʊ�дDAO�ӿڣ�Ҳ��������myeclipse��û��Ϊ��������DAO�ӿڣ�����������һ�����ݿ�ʵ���࣬Ϊ��ʹspring ��ǿ�����Ǳ��붨��һ��DAO�ӿڣ�ֻ��Ҫ�����proxyTargetClass���Զ���Ϊtrue�����ǳ���Ҫ�����������п��ܺ�����������ô����йء�

������дһ�����Գ��򣬺�����Ĳ��Գ��������ͬ��Ψһ��ͬ�ǽ������

UserDAO userdao=(UserDAO)context.getBean("userDAO");

����

UserDAO userdao=(UserDAO)context.getBean("userDAOProxy");

ִ�У�һ��ok��������ȷ�Ĳ��뵽���ݿ��С�