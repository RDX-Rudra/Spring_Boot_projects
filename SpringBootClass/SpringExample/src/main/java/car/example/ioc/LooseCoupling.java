package car.example.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LooseCoupling {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationIoClooseCoupling.xml");

        UserManager userManagerWithND = (UserManager) applicationContext.getBean("userManagerWithNewDataProvider");
        System.out.println(userManagerWithND.getUserInfo());
        UserManager userManagerWithWS = (UserManager) applicationContext.getBean("userManagerWithWebProvider");
        System.out.println(userManagerWithWS.getUserInfo());
    }
}
