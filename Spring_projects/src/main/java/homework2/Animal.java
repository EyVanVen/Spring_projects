package homework2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Animal {
    String name;
    int age;
    boolean tail;

    public Animal (){}


    public Animal(String name, int age, boolean tail) {
        this.name = name;
        this.age = age;
        this.tail = tail;
    }

    @Bean
    @Autowired
    public void init (String name, int age, boolean tail){
        this.name = name;
        this.age = age;
        this.tail = tail;
    }
    @Bean
    public String getName() {
        return name;
    }

    @Bean
    public void setName(String name) {
        this.name = name;
    }

    @Bean
    public int getAge() {
        return age;
    }

    @Bean
    public void setAge(int age) {
        this.age = age;
    }

    @Bean
    public boolean getTail() {
        return tail;
    }

    @Bean
    public void setTail(boolean tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tail=" + tail +
                '}';
    }
}
