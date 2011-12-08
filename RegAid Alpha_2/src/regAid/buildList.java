package regAid;

/**
 *
 * @author Noel Hansen
 */

import java.io.*;

public class buildList {
    /** Builds the MajorArrayList, since the GUI doesn't like FileNotFound exceptions
     * @param toBuild       The MajorArrayList to build.  **/
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