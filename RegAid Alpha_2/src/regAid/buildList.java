package regAid;

/**
 *
 * @author Noel Hansen
 */

import java.util.*;
import java.io.*;

public class buildList {
    public buildList(MajorArrayList toBuild)
    {
        try
        {
            toBuild.fillList();
        }
        catch (FileNotFoundException e)
        {
            
        }
                
    }
}