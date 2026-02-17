package car.example.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationSetterInjection.xml");
        Car myCar = (Car) context.getBean("myCar");
        myCar.displayDetails();
    }
}
