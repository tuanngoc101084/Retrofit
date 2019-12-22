package com.example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Language {

@SerializedName("en")
@Expose
private En en;
@SerializedName("vn")
@Expose
private Vn vn;

/**
* No args constructor for use in serialization
*
*/
public Language() {
}

/**
*
* @param vn
* @param en
*/
public Language(En en, Vn vn) {
super();
this.en = en;
this.vn = vn;
}

public En getEn() {
return en;
}

public void setEn(En en) {
this.en = en;
}

public Vn getVn() {
return vn;
}

public void setVn(Vn vn) {
this.vn = vn;
}

}
