package com.bob.blog.service;

import com.bob.blog.entity.Tag;
import com.bob.blog.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author BobJiang
 * @version 1.0
 * @date 2020/2/1 20:44
 */
public interface TagService {
    Tag saveTag(Tag type);

    Tag getTag(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    List<Tag> listTagTop(Integer size);

    Tag updateTag(Long id, Tag tag);

    void deleteTag(Long id);
}
