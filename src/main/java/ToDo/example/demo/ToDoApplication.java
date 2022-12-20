package ToDo.example.demo;

import ToDo.example.demo.entity.Todo;
import ToDo.example.demo.entity.User;
import ToDo.example.demo.repository.TodoRepository;
import ToDo.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user=new User();
		user.setId(1L);
		user.setPassword("should be hashed");
		user.setUsername("Jhon");

		Todo todo=new Todo();
		todo.setId(1L);
		todo.setContent("Upload video to YT");

		user.getTodoList().add(todo);
		todoRepository.save(todo);
		userRepository.save(user);

	}
}
