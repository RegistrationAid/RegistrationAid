package regAid;


/**
 *
 * @author Noel Hansen
 */
public class Class 
{
    private String description;
    private String name;
    private String teacherName;
    private String classType;
    private String time;
    public Class (String name, String description, String teacherName, String classType, String time)
    {
        this.name = name;
        this.description = description;
        this.teacherName = teacherName;
        this.classType = classType;
        this.time = time;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getTeacher()
    {
        return teacherName;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getClassType()
    {
        return classType;
    }
    public String getTime()
    {
        return time;
    }
}