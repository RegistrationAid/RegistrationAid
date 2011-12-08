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
    /** Constructor for the class
     * @param name          the name of the class
     * @param descritpion   the description of the class
     * @param teacherName   the name of the teacher of that class
     * @param classType     the type of the class
     * @param time          the time of the class**/
    public Class (String name, String description, String teacherName, String classType, String time)
    {
        this.name = name;
        this.description = description;
        this.teacherName = teacherName;
        this.classType = classType;
        this.time = time;
    }
    
    /** returns the name of the class
     * @return the name of the class **/
    public String getName()
    {
        return name;
    }
    
    /** returns the name of the teacher of the class
     * @return the name of the teacher of the class **/
    public String getTeacher()
    {
        return teacherName;
    }
    
    /** returns the description of the class
     * @return the description of the class **/
    public String getDescription()
    {
        return description;
    }
    
    /** returns the type of the class
     * @return the type of the class **/
    public String getClassType()
    {
        return classType;
    }
    
    /** returns the time the class takes place
     * @return the time the class takes place **/
    public String getTime()
    {
        return time;
    }
}