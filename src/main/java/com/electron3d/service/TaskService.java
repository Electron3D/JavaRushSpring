package com.electron3d.service;

import com.electron3d.domain.Status;
import com.electron3d.domain.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAll(int offset, int limit);
    int getAllCount();
    void edit(int id, String description, Status status);
    Task create(String description, Status status);
    void delete(int id);
}
