package com.sevcanalkan.todolist.api.repositories;

import com.sevcanalkan.todolist.api.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}