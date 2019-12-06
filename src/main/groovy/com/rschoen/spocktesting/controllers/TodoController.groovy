package com.rschoen.spocktesting.controllers

import com.rschoen.spocktesting.models.Todo
import com.rschoen.spocktesting.services.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("todo")
class TodoController {

    @Autowired
    TodoService todoService

    @GetMapping('')
    List<Todo> getAll() {
        return todoService.getAll()
    }
}
