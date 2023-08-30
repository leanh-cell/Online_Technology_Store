package com.doapp.nanogear.model.respository;

import com.doapp.nanogear.model.data.ContactUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUserRepository extends JpaRepository<ContactUser, Integer> {
    ContactUser findContactUserById(int userid);
    @Query("SELECT c.imageUrl from ContactUser c where c.user.id = :userid")
    String findAvatar(int userid);
}
