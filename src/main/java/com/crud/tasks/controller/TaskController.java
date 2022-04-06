package com.crud.tasks.controller;
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final DbService service;
    private final TaskMapper taskMapper;
    @GetMapping
    public List<TaskDto> getTasks() {
        List<Task> tasksList = service.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasksList);
    }

    @GetMapping(value = "/{taskId}")
    public TaskDto getTask(@PathVariable("taskId") Long taskId) {
        Task task = service.getTask(taskId);
        return taskMapper.mapToTaskDto(task);
    }

    @DeleteMapping
    public void deleteTask(Long taskId) {
    }
    @PutMapping
    public TaskDto updateTask(TaskDto taskDto) {
        return new TaskDto(1L, "Edited test title", "Test content");
    }
    @PostMapping
    public void createTask(TaskDto taskDto) {
    }
}