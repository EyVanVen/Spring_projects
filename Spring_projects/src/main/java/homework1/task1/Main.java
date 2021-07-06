package homework1.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("Duplicates")
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        Animal dog = context.getBean("dog", Animal.class);
        Animal cat = context.getBean("cat", Animal.class);
        Animal eagle = context.getBean("eagle", Animal.class);

        dog.setName("Sobaka");
        dog.setAge(4);
        dog.setTail(true);

        eagle.init("orel", 42, false);

        System.out.println(dog);
        System.out.println(cat);
        System.out.println(eagle);
    }
}
