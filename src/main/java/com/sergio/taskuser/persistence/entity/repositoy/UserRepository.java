package com.sergio.taskuser.persistence.entity.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import com.sergio.taskuser.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.tasksList")
	List<User> findAllUsersWithTasks();
}
