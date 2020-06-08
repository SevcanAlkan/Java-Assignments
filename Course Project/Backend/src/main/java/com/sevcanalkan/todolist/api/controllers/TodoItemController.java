package com.sevcanalkan.todolist.api.controllers;

import com.sevcanalkan.todolist.api.models.Todo;
import com.sevcanalkan.todolist.api.repositories.TodoRepository;
import org.apache.coyote.Response;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/todo")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoItemController {

    private TodoRepository repository;

    public TodoItemController(TodoRepository repository) {
        this.repository = repository;
    }

    // /todo
    @GetMapping
    public ResponseEntity<List<Todo>> Get() { //date filter, isCompleted, isDeleted
        return new ResponseEntity(this.repository.findAll(), HttpStatus.OK);
    }

    // /todo/id
    @GetMapping(path = "/{id}")
    public ResponseEntity<Todo> GetById(@PathVariable int id) {
        if(this.repository.existsById(id)) {
           return new ResponseEntity(this.repository.getOne(id), HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Todo> Post(@RequestBody Todo item) {
        return new ResponseEntity(this.repository.save(item), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Todo> Put(@PathVariable int id, @RequestBody Todo item) {
        item.setId(id);

        if(!this.repository.existsById(id)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(this.repository.save(item), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity Delete(@PathVariable int id) {
        if(!this.repository.existsById(id)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        Todo item = this.repository.getOne(id);
        item.setIsDeleted(true);
        this.repository.save(item);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
