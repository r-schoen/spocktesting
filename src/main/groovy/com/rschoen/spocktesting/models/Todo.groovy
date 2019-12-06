package com.rschoen.spocktesting.models



class Todo {
    Long id
    String text
    Date dueDate

    Todo(id,text,dueDate) {
        this.id=id
        this.text=text
        this.dueDate=dueDate
    }
}
