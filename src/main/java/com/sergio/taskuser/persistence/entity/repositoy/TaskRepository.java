package com.sergio.taskuser.persistence.entity.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sergio.taskuser.persistence.entity.Task;
import com.sergio.taskuser.persistence.entity.User;

import antlr.collections.List;

public interface TaskRepository extends JpaRepository<Task, Long>{
    java.util.List<Task> findByUser(User user);
}
