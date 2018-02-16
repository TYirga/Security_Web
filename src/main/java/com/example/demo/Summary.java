package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Summary {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

   @NotNull
    private String summaryofresume;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSummaryofresume() {
        return summaryofresume;
    }

    public void setSummaryofresume(String summaryofresume) {
        this.summaryofresume = summaryofresume;
    }
}

