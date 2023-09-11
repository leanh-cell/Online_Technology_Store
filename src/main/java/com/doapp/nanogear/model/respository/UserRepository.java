package com.doapp.nanogear.model.respository;

import com.doapp.nanogear.model.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u where u.id = :userid")
    User getUserById(@Param("userid") int userid);
    @Query("SELECT u FROM User u WHERE u.username = :usernameOrEmail OR u.email = :usernameOrEmail")
    User findByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);
}
