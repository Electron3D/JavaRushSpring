package com.electron3d.JavaRushSpring.dao;

import com.electron3d.JavaRushSpring.domain.Task;

import java.util.List;

public interface TaskDao {
    Task getById(int id);
    List<Task> getAll();
    void save(Task task);
    void update(Task task);
    void delete(int id);
    List<Task> getTasksByPage(int pageNumber, int pageSize);
}
