package com.bob.blog.dao;

import com.bob.blog.entity.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author BobJiang
 * @version 1.0
 * @date 2020/2/1 20:50
 */
public interface TypeRepository extends JpaRepository<Type,Long> {
    Type findByName(String name);

    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
