package com.example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Demo4 {

@SerializedName("khoahoc")
@Expose
private String khoahoc;
@SerializedName("hocphi")
@Expose
private String hocphi;

public String getKhoahoc() {
return khoahoc;
}

public void setKhoahoc(String khoahoc) {
this.khoahoc = khoahoc;
}

public String getHocphi() {
return hocphi;
}

public void setHocphi(String hocphi) {
this.hocphi = hocphi;
}

}