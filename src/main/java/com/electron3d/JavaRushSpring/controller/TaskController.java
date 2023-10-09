package com.electron3d.JavaRushSpring.controller;

import com.electron3d.JavaRushSpring.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
}
