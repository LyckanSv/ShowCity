
package com.app.lyckan.showcity.web.service;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SOSubscribedResponse {

    @SerializedName("subscribed")
    @Expose
    private List<Subscribed> subscribed = null;

    public List<Subscribed> getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(List<Subscribed> subscribed) {
        this.subscribed = subscribed;
    }

}
