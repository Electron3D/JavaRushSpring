package com.electron3d.JavaRushSpring.service.impl;

import com.electron3d.JavaRushSpring.dao.TaskDao;
import com.electron3d.JavaRushSpring.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao;
}
