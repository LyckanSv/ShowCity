
package com.app.lyckan.showcity.web.service;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subscribed {

    @SerializedName("id_user")
    @Expose
    private String idUser;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("work")
    @Expose
    private String work;
    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}
