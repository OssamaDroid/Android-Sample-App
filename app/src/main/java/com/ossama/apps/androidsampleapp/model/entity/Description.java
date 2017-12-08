package com.ossama.apps.androidsampleapp.model.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ossama on 12/6/17.
 */

public class Description implements Serializable {

    @SerializedName("en-CA")
    private String englishDescription;
    @SerializedName("fr-CA")
    private String frenchDescription;
}
