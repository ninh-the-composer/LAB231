/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author sogor
 */
public class Article {
    private int id;
    private String title;
    private String imagePath;
    private String content;
    private Date date;
    private String author;

    public Article() {
    }

    public Article(int id, String title, String imagePath, String content, Date date, String author) {
        this.id = id;
        this.title = title;
        this.imagePath = imagePath;
        this.content = content;
        this.date = date;
        this.author = author;
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

    public Date getDate() {
        return date;
    }

    public String getAuthor() {
        return author;
    }
    
    public String getSummary(){
        return content.substring(0, 100) + "...";
    }
}    
