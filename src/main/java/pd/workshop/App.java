package pd.workshop;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import pd.workshop.config.AppConfig;
import pd.workshop.service.EmailService;

public class App 
{
    public static void main( String[] args )
    {
        // Without IOC
        //EmailService emailService = new EmailService();

        // With IOC
        // 1. Bean Factory - XmlBeanFactory
        BeanFactory beanFactory1 = new XmlBeanFactory(new ClassPathResource("spring.xml"));
        EmailService emailService1 = beanFactory1.getBean("emailService", EmailService.class);
        emailService1.sendEmail("Tina@gmail.com", "Hi I am Alexa");

        // 2. Bean Factory - ClassPathXmlApplicationContext
        BeanFactory beanFactory2 = new ClassPathXmlApplicationContext("spring.xml");
        EmailService emailService2 = beanFactory2.getBean("emailService", EmailService.class);
        emailService2.sendEmail("Tina@gmail.com", "Hi I am Alexa");

        // 3.  ApplicationContext  --sub-interface ---> BeanFactory ==> Recommended to use
        ApplicationContext context1 = new ClassPathXmlApplicationContext("spring.xml");
        EmailService emailService3 = context1.getBean("emailService", EmailService.class);
        emailService3.sendEmail("Tina@gmail.com", "Hi I am Alexa");

        // 4. AnnotationConfig ==> Recommended to use
        ApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
        EmailService emailService4 = context2.getBean("emailService", EmailService.class);
        emailService4.sendEmail("test@gmail.com","Hello from Me....");
    }
}
