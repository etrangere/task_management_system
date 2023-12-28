package com.em.test_em.controllers;


import org.springframework.web.bind.annotation.*;



import io.swagger.v3.oas.annotations.tags.Tag;


@CrossOrigin()
//@RestController
@RequestMapping("/api/v1/task")
@Tag(name = "Task", description = "Task management APIs")
public class TaskController {

   // @Autowired
  //  private TaskService taskService;

/*
    // get all tasks
    @GetMapping(value = "/getAllTasks")
    @ResponseStatus(code = HttpStatus.OK)
    public List<TaskDTO> findAll() {
        return this.taskService.getAllTasks();
    }

    // get task by id
    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
        TaskDTO task = this.taskService.getTaskById(id);
        return task.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // create task
    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDTO) {
        TaskDTO createdTask = this.taskService.createTask(taskDTO);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    // update task
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public ResponseEntity<TaskDTO> update(@RequestBody TaskDTO taskDTO, @PathVariable("id") Long id) {
        if (!id.equals(taskDTO.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        TaskDTO updatedTask = this.taskService.updateTask(taskDTO);
        return new ResponseEntity<>(updatedTask, HttpStatus.ACCEPTED);
    }
    

    // delete task
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        this.taskService.deleteTask(id);
    }
    */
}
