package com.sergio.taskuser.persistence.entity.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sergio.taskuser.persistence.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
