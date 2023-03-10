package com.example.mylibrary;

public class Book {
    private int id;
    private  String name;
    private String author;
    private int pages;
    private String imgUrl;
    private String shortDesc;
    private String logDesc;

    private Boolean isExpanded;

    public Book(int id, String name, String author, int pages, String imgUrl, String shortDesc, String logDesc) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.imgUrl = imgUrl;
        this.shortDesc = shortDesc;
        this.logDesc = logDesc;
        isExpanded = false;
    }

    public Boolean getExpanded() {
        return isExpanded;
    }

    public void setExpanded(Boolean expanded) {
        isExpanded = expanded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", imgUrl='" + imgUrl + '\'' +
                ", shortDesc='" + shortDesc + '\'' +
                ", logDesc='" + logDesc + '\'' +
                '}';
    }
}
