package com.electron3d.service.impl;

import com.electron3d.dao.TaskDao;
import com.electron3d.domain.Status;
import com.electron3d.domain.Task;
import com.electron3d.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao;

    @Override
    public List<Task> getAll(int offset, int limit) {
        return taskDao.getAll(offset, limit);
    }

    @Override
    public int getAllCount() {
        return taskDao.getAllCount();
    }

    @Override
    @Transactional
    public void edit(int id, String description, Status status) {
        Task task = taskDao.getById(id);
        if (Objects.isNull(task)) {
            throw  new RuntimeException("Not found");
        }
        task.setDescription(description);
        task.setStatus(status);
        taskDao.saveOrUpdate(task);
    }

    @Override
    public Task create(String description, Status status) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(status);
        taskDao.saveOrUpdate(task);
        return task;
    }

    @Override
    public void delete(int id) {
        Task task = taskDao.getById(id);
        if (Objects.isNull(task)) {
            throw  new RuntimeException("Not found");
        }
        taskDao.delete(task);
    }
}
