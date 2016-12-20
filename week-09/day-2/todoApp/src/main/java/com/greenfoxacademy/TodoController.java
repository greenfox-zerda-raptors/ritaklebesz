package com.greenfoxacademy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rita on 2016-12-20.
 */
@Controller
@RequestMapping("/todo")
public class TodoController {
    TodoService todos;

    public TodoController() {
        todos = new TodoService();
    }

    @RequestMapping(value = {"/", "/list"})
    public String list(Model model) {
        model.addAttribute("todos", todos.getTodos());
        return "todo";
    }
}
