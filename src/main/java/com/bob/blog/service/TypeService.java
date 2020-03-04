package com.bob.blog.service;

import com.bob.blog.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author BobJiang
 * @version 1.0
 * @date 2020/2/1 20:44
 */
public interface TypeService {
    Type saveType(Type type);

    Type getType(Long id);

    Type getTypeByName(String name);

    List<Type> listType();

    List<Type> listTypeTop(Integer size);

    Page<Type> listType(Pageable pageable);

    Type updateType(Long id,Type type);

    void deleteType(Long id);
}
