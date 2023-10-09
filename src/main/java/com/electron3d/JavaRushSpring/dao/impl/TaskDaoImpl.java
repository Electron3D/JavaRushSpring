package com.electron3d.JavaRushSpring.dao.impl;

import com.electron3d.JavaRushSpring.dao.TaskDao;
import com.electron3d.JavaRushSpring.domain.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public TaskDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Task getById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Task.class, id);
    }

    @Override
    public List<Task> getAll() {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("FROM Task", Task.class).getResultList();
    }

    @Override
    public void save(Task task) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(task);
    }

    @Override
    public void update(Task task) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.merge(task);
    }

    @Override
    public void delete(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Task taskToDelete = currentSession.get(Task.class, id);
        if (taskToDelete != null) {
            currentSession.remove(taskToDelete);
        }
    }

    @Override
    public List<Task> getTasksByPage(int pageNumber, int pageSize) {
        Session currentSession = sessionFactory.getCurrentSession();
        int start = (pageNumber - 1) * pageSize;
        return currentSession.createQuery("FROM Task", Task.class)
                .setFirstResult(start)
                .setMaxResults(pageSize)
                .getResultList();
    }
}
