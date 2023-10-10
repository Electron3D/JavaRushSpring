package com.electron3d.controller;

import com.electron3d.domain.Task;
import com.electron3d.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/")
    public String tasks(Model model,
                            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        List<Task> tasks = taskService.getAll((page - 1) * limit, limit);
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping("/{id}")
    public String edit(Model model,
                     @PathVariable Integer id,
                     @RequestBody TaskInfo taskInfo) {
        if (Objects.isNull(id) || id <= 0) {
            throw new RuntimeException("Invalid id");
        }
        taskService.edit(id, taskInfo.getDescription(), taskInfo.getStatus());
        return tasks(model, 1, 10);
    }

    @PostMapping("/")
    public String addTask(Model model,
                     @RequestBody TaskInfo taskInfo) {
        taskService.create(taskInfo.getDescription(), taskInfo.getStatus());
        return tasks(model, 1, 10);
    }

    @DeleteMapping("/{id}")
    public String delete(Model model,
                         @PathVariable Integer id) {
        if (Objects.isNull(id) || id <= 0) {
            throw new RuntimeException("Invalid id");
        }
        taskService.delete(id);
        return "tasks";
    }
}
