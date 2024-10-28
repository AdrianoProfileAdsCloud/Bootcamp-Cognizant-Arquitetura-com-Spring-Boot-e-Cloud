package edu.prj.designpatterns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.prj.designpatterns.model.User;
import edu.prj.designpatterns.model.dto.UserRequestDTO;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT e FROM User e JOIN FETCH e.roles WHERE e.username= (:username)")
    User findByUsername(@Param("username") String username);
}