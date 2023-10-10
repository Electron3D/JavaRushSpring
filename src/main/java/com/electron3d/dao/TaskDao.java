package com.electron3d.dao;

import com.electron3d.domain.Task;

import java.util.List;

public interface TaskDao {
    Task getById(int id);
    List<Task> getAll(int offset, int limit);
    int getAllCount();
    void saveOrUpdate(Task task);
    void delete(Task task);
}
