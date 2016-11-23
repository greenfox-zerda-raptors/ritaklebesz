import javax.swing.*;
import java.awt.*;

/**
 * Created by Rita on 2016-11-23.
 */
public class HelloWorld extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HelloWorld();
            }
        });
    }

    String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
            "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
            "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
            "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};

    public HelloWorld() {
        JPanel panel = new JPanel();
        this.setSize(400, 400);
        this.setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width/2)-(this.getWidth()/2);
        int yPos = (dim.height/2)-(this.getHeight()/2);
        this.setLocation(xPos, yPos);
        this.setTitle("Hello World");
        this.setTitle("Hello Rita");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("HelloWorld text");
        label.setVisible(true);
        this.add(panel);
        panel.add(label);
        for (int i = 0; i< hellos.length; i++) {
            panel.add(new Label(hellos[i]));
        }
    }
}
