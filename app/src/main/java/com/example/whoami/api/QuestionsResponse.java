
package com.example.whoami.api;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuestionsResponse {

    @SerializedName("1")
    @Expose
    private List<com.example.whoami.api.One> One = null;
    @SerializedName("2")
    @Expose
    private List<com.example.whoami.api.Two> Two = null;
    @SerializedName("3")
    @Expose
    private List<com.example.whoami.api.Three> Three = null;
    @SerializedName("4")
    @Expose
    private List<com.example.whoami.api.Four> Four = null;
    @SerializedName("5")
    @Expose
    private List<com.example.whoami.api.Five> Five = null;
    @SerializedName("6")
    @Expose
    private List<com.example.whoami.api.Six> Six = null;
    @SerializedName("7")
    @Expose
    private List<com.example.whoami.api.Seven> Seven = null;

    public List<com.example.whoami.api.One> get1() {
        return One;
    }

    public void set1(List<com.example.whoami.api.One> one) {
        this.One = one;
    }

    public List<com.example.whoami.api.Two> get2() {
        return Two;
    }

    public void set2(List<com.example.whoami.api.Two> two) {
        this.Two = two;
    }

    public List<com.example.whoami.api.Three> get3() {
        return Three;
    }

    public void set3(List<com.example.whoami.api.Three> three) {
        this.Three = three;
    }

    public List<com.example.whoami.api.Four> get4() {
        return Four;
    }

    public void set4(List<com.example.whoami.api.Four> four) {
        this.Four = four;
    }

    public List<com.example.whoami.api.Five> get5() {
        return Five;
    }

    public void set5(List<com.example.whoami.api.Five> five) {
        this.Five = five;
    }

    public List<com.example.whoami.api.Six> get6() {
        return Six;
    }

    public void set6(List<com.example.whoami.api.Six> six) {
        this.Six = six;
    }

    public List<com.example.whoami.api.Seven> get7() {
        return Seven;
    }

    public void set7(List<com.example.whoami.api.Seven> seven) {
        this.Seven = seven;
    }

}
