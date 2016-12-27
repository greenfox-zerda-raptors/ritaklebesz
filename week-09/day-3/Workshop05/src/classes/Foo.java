package classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Foo {

    Bar bar;

    @Autowired
    public Foo(Bar bar) {
        this.bar = bar;

    }

    public String toString() {
        return "In Foo:" + bar.toString();
    }

    public void init() {
        System.out.println("The Foo Man is awakening!");
    }

    public void cleanup() {
        System.out.println("The Foo Man is no more, and his mess is gone too!");
    }
}
