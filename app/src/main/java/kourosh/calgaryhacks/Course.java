package kourosh.calgaryhacks;

/**
 * Created by Nasir on 2017-02-21.
 */

public class Course {
    private String ProfName;
    private String CourseName;

    public Course(String instructorName, String CourseName) {
        this.ProfName = instructorName;
        this.CourseName = CourseName;
    }

    public Course()
    {

    }

    public void setProfName(String ProfName)
    {
        this.ProfName = ProfName;
    }

    public void setCourseName(String CourseName)
    {
        this.CourseName = CourseName;
    }

    public String getProfName()
    {
        return ProfName;
    }

    public String getCourseName()
    {
        return CourseName;
    }
}
