package com.electron3d.dao.impl;

import com.electron3d.dao.TaskDao;
import com.electron3d.domain.Task;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskDaoImpl implements TaskDao {
    private final SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Task getById(int id) {
        return getSession().get(Task.class, id);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int getAllCount() {
        return Math.toIntExact(getSession()
                .createQuery("SELECT COUNT(t) FROM Task t", Long.class)
                .uniqueResult()
        );
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(Task task) {
        getSession().persist(task);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Task task) {
        getSession().remove(task);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Task> getAll(int offset, int limit) {
        return getSession().createQuery("FROM Task", Task.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
