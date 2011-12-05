package regAid;

/**
 *
 * @author Noel Hansen
 */
import java.util.*;
import java.io.*;

public class Search
{
    MajorArrayList Search(MajorArrayList[] majors, int size, String toFind)
    {
       // Creates a MajorArrayList to store all the found classes.
       MajorArrayList foundItems = new MajorArrayList("", "");
       for (int i = 0; i < size; i++)
       {
           for (int j = 0; j < majors[i].size(); j++)
	   {
               Class curr = majors[i].get(j);
               if (NameEquals(toFind, curr.getName()) || NameEquals(toFind, curr.getTeacher()) || curr.getClassType().equalsIgnoreCase(toFind) 
                       || curr.getTime().equalsIgnoreCase(toFind) || keywordFound(curr.getDescription(), toFind))
               {
                   foundItems.add(curr);
               }
           }
       }
       return foundItems;
    }
    
    boolean keywordFound(String description, String keyword)
    {
        if (description.contains(keyword))
        {
            return true;
        }
        return false;
    }
    
    boolean NameEquals(String name, String toCompare)
    {
        String copy = toCompare;
        String[] names = name.split(" ");
        for (int i = 0; i < names.length; i++)
        {
            if (toCompare.contains(names[i]))
            {
                return true;
            }
        }
        return false;
    }
}