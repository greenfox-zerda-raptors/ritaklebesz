package com.greenfoxacademy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        if (active != null && active.equals("active")) {
            model.addAttribute("todos", todoService.getActiveTodos());
        } else {
            model.addAttribute("todos", todoService.getTodos());
        }
        return "todo";
    }

    @RequestMapping("/details/{itemID}")
    public String listItemDetails(Model model, @PathVariable int itemID) {
        model.addAttribute("item", todoService.getTodoBasedOnId(itemID));
        return "itemDetails";
    }

    @GetMapping(value = "/add")
    public String addNewItem(Model model) {
        model.addAttribute("item", new Todo());
        return "form";
    }

    @PostMapping(value = "/add")
    public String submitNewItem(@ModelAttribute Todo item) {
        todoService.addTodo(item);
        return "redirect:list";
    }
}
