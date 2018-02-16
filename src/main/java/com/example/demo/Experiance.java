package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
    public class Experiance {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private long id;
        private String profession;
        private String companyname;
        private String startingdate;
        private String endingdate;
        private String duty;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getCompanyname() {
            return companyname;
        }

        public void setCompanyname(String companyname) {
            this.companyname = companyname;
        }

        public String getStartingdate() {
            return startingdate;
        }

        public void setStartingdate(String startingdate) {
            this.startingdate = startingdate;
        }

        public String getEndingdate() {
            return endingdate;
        }

        public void setEndingdate(String endingdate) {
            this.endingdate = endingdate;
        }

        public String getDuty() {
            return duty;
        }

        public void setDuty(String duty) {
            this.duty = duty;
        }
    }
