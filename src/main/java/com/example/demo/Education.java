
package com.example.demo;
        import javax.persistence.Entity;
        import javax.persistence.Id;
        import javax.validation.constraints.Min;
        import javax.validation.constraints.NotNull;
        import javax.validation.constraints.Size;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String universityname;
    private String educationlevel;
    private String graduationyear;
private String major;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUniversityname() {
        return universityname;
    }

    public void setUniversityname(String universityname) {
        this.universityname = universityname;
    }

    public String getEducationlevel() {
        return educationlevel;
    }

    public void setEducationlevel(String educationlevel) {
        this.educationlevel = educationlevel;
    }

    public String getGraduationyear() {
        return graduationyear;
    }

    public void setGraduationyear(String graduationyear) {
        this.graduationyear = graduationyear;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}