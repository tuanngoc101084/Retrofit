package com.example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DEMO3 {

@SerializedName("language")
@Expose
private Language language;

/**
* No args constructor for use in serialization
*
*/
public DEMO3() {
}

/**
*
* @param language
*/
public DEMO3(Language language) {
super();
this.language = language;
}

public Language getLanguage() {
return language;
}

public void setLanguage(Language language) {
this.language = language;
}

}
