package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cover {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String introduceyourself;
    private String fit;
    private String other;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIntroduceyourself() {
        return introduceyourself;
    }

    public void setIntroduceyourself(String introduceyourself) {
        this.introduceyourself = introduceyourself;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
