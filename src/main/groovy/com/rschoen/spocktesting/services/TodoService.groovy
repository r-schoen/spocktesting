package com.rschoen.spocktesting.services

import com.rschoen.spocktesting.models.Todo
import org.springframework.stereotype.Service

@Service
class TodoService {
    // TODO: Connect DAO Here

    def getAll() {
        def f = new ArrayList<Todo>();
        f.add(new Todo(1,"string", new Date()))
        return f
    }
}
