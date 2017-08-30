
package com.app.lyckan.showcity.web.service;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {

    @SerializedName("id_articles")
    @Expose
    private String idArticles;
    @SerializedName("titule")
    @Expose
    private String titule;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("md_doc")
    @Expose
    private String mdDoc;
    @SerializedName("stars")
    @Expose
    private Double stars;

    public String getIdArticles() {
        return idArticles;
    }

    public void setIdArticles(String idArticles) {
        this.idArticles = idArticles;
    }

    public String getTitule() {
        return titule;
    }

    public void setTitule(String titule) {
        this.titule = titule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMdDoc() {
        return mdDoc;
    }

    public void setMdDoc(String mdDoc) {
        this.mdDoc = mdDoc;
    }

    public Double getStars() {
        return stars;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

}
