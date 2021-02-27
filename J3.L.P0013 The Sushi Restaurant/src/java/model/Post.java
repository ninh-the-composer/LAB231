/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sogor
 */
public class Post {
    private int id;
    private String title;
    private String imagePath;
    private String content;

    public Post() {
    }

    public Post(int id, String title, String imagePath, String content) {
        this.id = id;
        this.title = title;
        this.imagePath = imagePath;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getContent() {
        return content;
    }
    
}
