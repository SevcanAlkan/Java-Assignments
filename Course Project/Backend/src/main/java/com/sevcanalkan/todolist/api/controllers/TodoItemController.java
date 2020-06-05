package com.sevcanalkan.todolist.api.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/todo")
public class TodoItemController {

    public TodoItemController() {

    }

    // /todo
    @GetMapping
    public List<Todo> Get() { //date filter, isCompleted, isDeleted

    }

    // /todo/id
    @GetMapping
    public Todo Get(@RequestParam int id) {

    }

    @PostMapping
    public Todo Get(@RequestBody Todo item) {

    }

    @PutMapping
    public Todo Get(@RequestParam int id, @RequestBody Todo item) {

    }

    @DeleteMapping
    public void Get(@RequestParam int id) {

    }
}
