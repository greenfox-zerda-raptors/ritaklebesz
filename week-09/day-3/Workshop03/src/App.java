import com.greenfox.configuration.AppConfig;
import com.greenfox.services.TextEditor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        TextEditor textEditor = context.getBean(TextEditor.class);
//        textEditor.spellCheck("Woof");
        TextEditor textEditor2 = context.getBean(TextEditor.class);
        textEditor2.spellCheck("hello");
        System.out.println(textEditor2.toString());
        context.close();
    }
}
