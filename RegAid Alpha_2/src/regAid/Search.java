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
               if ((curr.getName().equals(toFind) || curr.getTeacher().equals(toFind) || curr.getClassType().equals(toFind)) || curr.getTime().equals(toFind))
               {
                   foundItems.add(curr);
               }
           }
       }
       return foundItems;
    }
}