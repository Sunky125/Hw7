package urfu.lesson8.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urfu.lesson8.Data.ToDoList;
import urfu.lesson8.Repository.ToDoListRepository;

import javax.validation.Valid;

@RestController
public class RestDatabaseController {

    @Autowired
    private ToDoListRepository listRepository;

    @GetMapping("todo/save")
    public void SaveToDoList(@Valid @RequestBody ToDoList toDoList) {
        listRepository.insertToDoList(toDoList.getId(), toDoList.getName(), toDoList.getEvents());
    }

    @PostMapping("todo/get")
    public ToDoList GetToDoList(@RequestBody String name) {
        return listRepository.findByName(name);
    }
}
