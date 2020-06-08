package spring.todo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.todo.dao.TodosRepository;
import spring.todo.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Created 26 / 05 / 2020 - 11:16 AM
 * @project SpringToDo
 * @Author Hamdamboy
 */
@Service
@Transactional
public class TodoService {

    private final TodosRepository todosRepository;

    public TodoService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    public List<Todo> findAll(){
        List<Todo> todos = new ArrayList<>();
        for(Todo todo : todosRepository.findAll()) {
            todos.add(todo);
        }
        return todos;
    }

    public void save(Todo todo){

        todosRepository.save(todo);
    }

    public void delete(int id) {
        Optional<Todo> todo = todosRepository.findById(id);
        todosRepository.delete(todo.get());
    }

    public Optional<Todo> findTodo(int id){
        return todosRepository.findById(id);
    }
}
