package com.example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vn {

@SerializedName("name")
@Expose
private String name;
@SerializedName("address")
@Expose
private String address;
@SerializedName("course1")
@Expose
private String course1;
@SerializedName("course2")
@Expose
private String course2;
@SerializedName("course3")
@Expose
private String course3;

/**
* No args constructor for use in serialization
*
*/
public Vn() {
}

/**
*
* @param course3
* @param address
* @param name
* @param course2
* @param course1
*/
public Vn(String name, String address, String course1, String course2, String course3) {
super();
this.name = name;
this.address = address;
this.course1 = course1;
this.course2 = course2;
this.course3 = course3;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getCourse1() {
return course1;
}

public void setCourse1(String course1) {
this.course1 = course1;
}

public String getCourse2() {
return course2;
}

public void setCourse2(String course2) {
this.course2 = course2;
}

public String getCourse3() {
return course3;
}

public void setCourse3(String course3) {
this.course3 = course3;
}

}