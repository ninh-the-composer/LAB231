/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ninh
 */
public class Post {
    private String id;
    private String title;
    private String type;
    private String imagePath;
    private String content;
    private String createdAt;

    public Post() {
    }

    public Post(String id, String title, String type, String imagePath, String content, String createdAt) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.imagePath = imagePath;
        this.content = content;
        this.createdAt = createdAt;
    }

    

    public String getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    
}
