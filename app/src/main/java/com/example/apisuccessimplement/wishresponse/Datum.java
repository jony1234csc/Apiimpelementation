
package com.example.apisuccessimplement.wishresponse;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Datum implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("description")
    @Expose
    private String captionEn;
    @SerializedName("description_bn")
    @Expose
    private String captionBn;
    @SerializedName("link")
    @Expose
    private String link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaptionEn() {
        return captionEn;
    }

    public void setCaptionEn(String captionEn) {
        this.captionEn = captionEn;
    }

    public String getCaptionBn() {
        return captionBn;
    }

    public void setCaptionBn(String captionBn) {
        this.captionBn = captionBn;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


}
