/*
     * Copyright(C) 2021,  FPT University.
     * J3.L.P0004 Digital News
     * Record of change:
     * DATE              Version             AUTHOR                 DESCRIPTION
     * 2021-02-25        1.0              NinhTBMHE141325           Initial commit
 */
package entity;

import java.sql.Date;

/**
 * This Class represent for Business object Article. The method has properties:
 * <ul>
 * <li>id <code>int</code> </li>
 * <li>title <code>java.lang.String</code></li>
 * <li>imagePath <code>java.lang.String</code></li>
 * <li>content <code>java.lang.String</code></li>
 * <li>date <code>java.util.Date</code></li>
 * <li>author <code>java.lang.String</code></li>
 * </ul>
 *
 * @author NinhTBMHE141325
 */
public class Article {

    private int id;
    private String title;
    private String imagePath;
    private String content;
    private Date date;
    private String author;

    /**
     * Default Article constructor.
     */
    public Article() {
    }

    /**
     * Full properties Article constructor.
     *
     * @param id primatives integer
     * @param title java.lang.String
     * @param imagePath java.lang.String
     * @param content java.lang.String
     * @param date java.util.Date
     * @param author java.lang.String
     */
    public Article(int id, String title, String imagePath, String content, Date date, String author) {
        this.id = id;
        this.title = title;
        this.imagePath = imagePath;
        this.content = content;
        this.date = date;
        this.author = author;
    }

    /**
     * This method return information of <i>private</i> property <b>id</b> of
     * Article object.
     *
     * @return primatives type <code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * This method return information of <i>private</i> property <b>title</b> of
     * Article object.
     *
     * @return primatives type <code>java.lang.String</code>
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method return information of <i>private</i> property
     * <b>imagePath</b> of Article object.
     *
     * @return primatives type <code>java.lang.String</code>
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * This method return information of <i>private</i> property <b>content</b>
     * of Article object.
     *
     * @return primatives type <code>java.lang.String</code>
     */
    public String getContent() {
        return content;
    }

    /**
     * This method return information of <i>private</i> property <b>date</b>
     * of Article object.
     *
     * @return primatives type <code>java.until.Date</code>
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method return information of <i>private</i> property <b>author</b>
     * of Article object.
     *
     * @return primatives type <code>java.lang.String</code>
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method return summary of first 100 characters of <b>content</b>.<br>
     * The method is using substring method.
     * @return primatives type <code>java.lang.String</code>
     */
    public String getSummary() {
        return content.substring(0, 100) + "...";
    }
}
