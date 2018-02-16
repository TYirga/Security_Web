package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  long id;
    private String skillrate;

    public String getSkill() {
        return skillrate;
    }

    public void setSkill(String skillrate) {
        this.skillrate = skillrate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkillrate() {
        return skillrate;
    }

    public void setSkillrate(String skillrate) {
        this.skillrate = skillrate;
    }
}
