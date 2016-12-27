import classes.Bar;
import classes.Foo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"classes"})
public class AppConfig {
    @Bean(initMethod = "init", destroyMethod = "cleanup")
    public Foo foo() {
        return new Foo(bar());
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Foo foo = context.getBean(Foo.class);
        System.out.println(foo.toString());
        context.close();
    }

}
