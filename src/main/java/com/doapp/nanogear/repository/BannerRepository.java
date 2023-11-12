package com.doapp.nanogear.repository;

import com.doapp.nanogear.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer> {
    //    @Query("select b from Banner b where b.id =: idImg")
//    Banner findById();
//    @Query("select b from Banner b where b.id =: id")
    Banner findById(@Param("id") int id);
}
