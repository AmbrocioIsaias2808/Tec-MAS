package com.example.tecmas.InfoCards;

public class InfoObjects {
    public int articleID;
    public String title;
    //public String description;
    public int imageId;

    public InfoObjects(int articleID,String title, String description, int imageId) {
        this.articleID=articleID;
        this.title = title;
      //  this.description = description;
        this.imageId = imageId;
    }
}
