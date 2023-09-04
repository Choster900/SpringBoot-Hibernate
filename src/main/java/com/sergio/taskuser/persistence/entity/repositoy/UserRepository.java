package com.sergio.taskuser.persistence.entity.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import com.sergio.taskuser.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("SELECT u FROM User u")
	List<User> findAllUsersWithoutTasks();



	@Query(value = "SELECT * FROM user u WHERE u.id_user IN (SELECT DISTINCT id_user FROM task)", nativeQuery = true)
	java.util.Collection<User> usuariosConTareas();
}
