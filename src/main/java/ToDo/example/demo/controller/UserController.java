package ToDo.example.demo.controller;

import ToDo.example.demo.entity.Todo;
import ToDo.example.demo.entity.User;
import ToDo.example.demo.repository.TodoRepository;
import ToDo.example.demo.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping
public class UserController {

    UserRepository userRepository;
    TodoRepository todoRepository;

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userid){
        return userRepository.findById(userid).orElseThrow(() -> new NoSuchElementException());
    }
 @PostMapping
    public User AddUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @PostMapping("/{userId}/todos")
    public void AddToDo(@PathVariable Long userId, @RequestBody Todo todo){
        User user=userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        user.getTodoList().add(todo);
    }
}
