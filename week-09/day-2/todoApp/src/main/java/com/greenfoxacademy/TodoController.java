package com.greenfoxacademy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rita on 2016-12-20.
 */
@Controller
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value = {"/", "/list"})
    public String list(Model model, @RequestParam(name = "active", required = false) String active) {
        List<Todo> list = todoService.getTodos();
        List<Todo> result = new ArrayList<>();
        if (active != null && active.equals("active")) {
            for (Todo todo : list) {
                if (!todo.isDone()) {
                    result.add(todo);
                }
            }
        } else {
            result = list;
        }
        model.addAttribute("todos", result);
        return "todo";
    }
}
