package com.app.lyckan.showcity.pojos;


import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class SubscribedNews implements Parcelable{
    private String id;
    private String titule;
    private String description;
    private String image;
    private String autor;
    private String markdown;
    private float stars;

    public SubscribedNews(String id, String titule, String description, String image, String autor, float stars, String markdown) {
        this.id = id;
        this.titule = titule;
        this.description = description;
        this.image = image;
        this.autor = autor;
        this.stars = stars;
        this.markdown = markdown;
    }

    public SubscribedNews(Parcel in) {

        readToParcel(in);
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(titule);
        parcel.writeString(description);
        parcel.writeString(image);
        parcel.writeString(autor);
        parcel.writeString(markdown);
        parcel.writeFloat(stars);
    }

    private void readToParcel(Parcel in){
        id = in.readString();
        titule = in.readString();
        description = in.readString();
        image = in.readString();
        autor = in.readString();
        markdown = in.readString();
        stars = in.readFloat();
    }

    public static final Parcelable.Creator<SubscribedNews> CREATOR
            = new Parcelable.Creator<SubscribedNews>() {
        public SubscribedNews createFromParcel(Parcel in) {
            return new SubscribedNews(in);
        }

        public SubscribedNews[] newArray(int size) {
            return new SubscribedNews[size];
        }
    };


}
