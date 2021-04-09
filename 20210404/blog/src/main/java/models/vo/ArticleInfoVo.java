package models.vo;

import models.ArticleInfo;

/**
 * @program: blog
 * @description:
 * @author: FENG CHEN
 * @create: 2021-04-08 20:03
 */
public class ArticleInfoVo extends ArticleInfo {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
