package xyz.incraft.SimpleAnnotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.incraft.SimpleAnnotation.testclass.VerySimpleClass;

/**
 * Created by Михаил on 19.01.2016.
 *
 */
public class MainApp {

    private final Logger logger = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        new MainApp().test();
    }

    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        VerySimpleClass verySimpleClass = context.getBean("verySimpleClass",VerySimpleClass.class);
        int i = verySimpleClass.ReturnValue();
        logger.info("Должно быть 5, пришло {}",i);
        int j = verySimpleClass.Add(3,4);
    }
}
