package regAid;

/**
 *
 * @author Noel Hansen
 */
import java.util.*;
import java.io.*;

public class Search
{
    /** searches through the array of MajorArrayLists for something that contains the given string.
     * @param majors        the array of Majors to search through
     * @param size          the number of majors to search through
     * @param toFind        the string to find
     * @return a MajorArrayList containing all the items found **/
    MajorArrayList Search(MajorArrayList[] majors, int size, String toFind)
    {
       // Creates a MajorArrayList to store all the found classes.
       MajorArrayList foundItems = new MajorArrayList("", "");
       // Searches through the majors.
       for (int i = 0; i < size; i++)
       {
           // Searches through the classes in the majors.
           for (int j = 0; j < majors[i].getSize(); j++)
	   {
               Class curr = majors[i].get(j);
               // If something even remotely matching what was passed is found, add that to the MajorArrayList of all found classes.
               if (NameEquals(toFind, curr.getName()) || NameEquals(toFind, curr.getTeacher()) || curr.getClassType().equalsIgnoreCase(toFind) 
                       || curr.getTime().equalsIgnoreCase(toFind) || keywordFound(curr.getDescription(), toFind))
               {
                   foundItems.add(curr);
               }
           }
       }
       return foundItems;
    }
    
    /** searches through the given description for the given keyword.
     * @param description       the description of the class to look through for the keyword
     * @param keyword           the keyword to search for
     * @return a boolean indicating whether or not the keyword was found **/
    boolean keywordFound(String description, String keyword)
    {
        String temp = description.toLowerCase();
        if (temp.contains(keyword.toLowerCase()))
        {
            return true;
        }
        return false;
    }
    
    /** compares one name to another
     * @param name          the name to check
     * @param toCompare     the name to check the other against
     * @return a boolean indicating this name matches, at least somewhat, the name to compare it to **/
    boolean NameEquals(String name, String toCompare)
    {
        String copy = toCompare.toLowerCase();
        String[] names = name.split(" ");
        for (int i = 0; i < names.length; i++)
        {
            if (copy.contains(names[i].toLowerCase()))
            {
                return true;
            }
        }
        return false;
    }
}