package com.bob.blog.ov;

import lombok.Data;

/**
 * @author BobJiang
 * @version 1.0
 * @date 2020/2/2 19:30
 */
@Data
public class BlogQuery {
    private String title;
    private  Long typeId;
    private boolean recommend;

    public BlogQuery() {
    }

    public BlogQuery(String title, Long typeId, Boolean recommend) {
        this.title = title;
        this.typeId = typeId;
        this.recommend = recommend;
    }
}
