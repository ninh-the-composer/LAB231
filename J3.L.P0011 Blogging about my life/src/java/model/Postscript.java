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
public class Postscript {
    private String content;
    private String author;

    public Postscript() {
    }

    public Postscript(String content, String author) {
        this.content = content;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
    
    
}
