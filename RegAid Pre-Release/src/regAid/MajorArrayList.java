package regAid;

/**
 *
 * @author Noel Hansen
 */
import java.util.*;
import java.io.*;

public class MajorArrayList 
{
    // the list of classes.
    private Class[] classList;
    // the number of classes
    private int size;
    // The default size of the dynamically allocated array
    private static final int DEFAULT_SIZE = 20;
    // the names of the files to look in for informations about the classes and their syllabi
    private String classFileName = "";
    private String infoFileName = "";
    
    
    /** the constructor for the object
     * @param classFileName          the place to look for the classes
     * @param infoFileName           the place to look for the syllabi**/
    public MajorArrayList (String classFileName, String infoFileName)
    {
        this.classFileName = classFileName;
        this.infoFileName = infoFileName;
        classList = new Class[DEFAULT_SIZE];
        size = 0;
    }
    
    /** fills the list with the data from the files
     * @throws FileNotFoundException**/
    public void fillList () throws FileNotFoundException
    {
        // assign input streams to the right files
        InputStream is1 = getClass().getResourceAsStream(classFileName);
        InputStream is2 = getClass().getResourceAsStream(infoFileName);
        // create scanners out of those input streams, so the program can access the data stored in them
        Scanner classFile = new Scanner(is1, "UTF8");
        Scanner infoFile = new Scanner(is2, "UTF8");
        // While there is still data in the class file, assign the relevant data to a class, then add it to the array
        while(classFile.hasNextLine())
        {
            Class temp = new Class(classFile.next(), getSyllabus(infoFile), classFile.next(), classFile.next(), classFile.next());
            this.add(temp);
        }
    }
 
    /** scans the file and returns the syllabus.
     * @param info          the scanner to hold the place in the list of syllabi
     * @return a string with the syllabus stored in it **/
    private String getSyllabus(Scanner info)
    {
        String curr = info.nextLine();
        String total = "";
        while(!curr.equals("***"))
        {
            total+=(curr+"\n");
            curr=info.nextLine();
        }
        return total;
    }
    
    /** adds the class to the array
     * @param newClass           the class to add. **/
    public void add (Class newClass)
    {
	this.ensureCapacity(size+1);
	classList[size] = newClass;
	size++;
    }
    
    /** makes sure that there is enough space for the capacity given. 
     * If there is not enough room for it, it resizes the array accordingly
     * @param capacity          the capacity to ensure the array has **/
    private void ensureCapacity(int capacity)
    {
	if(capacity > classList.length)
	{
		int newCap = classList.length*2+1;
		if (capacity > newCap)
		{
			newCap = capacity;
		}
		classList = Arrays.copyOf(classList, newCap);
         }
    }
    
    /** checks if the array is empty
     * @return a boolean indicating if the array is empty or not **/
    public boolean isEmpty ()
    {
        return size == 0;
    }
    
    /** returns the item at the given index
     * @param index          the index to retrieve the desired item from
     * @return the item at the given index**/
    public Class get(int index)
    {
        checkIndex(index);
        return classList[index];
    }
    
    /** compares one name to another
     * @return a boolean indicating this name matches, at least somewhat, the name to compare it to **/
    public Class[] getArray()
    {
       return classList;
    }
    
    /** returns an array the names of all the classes in the major
     * @return an array with the names of all the classes **/
    public String[] getNameArray()
    {
        String[] str = new String[size];
        int count = 0;
        while(count < size)
        {
            str[count]=classList[count].getName();
            count++;
        }
        return str;
    }
    
    /** returns an array of the descriptions of all the classes in the major
     * @return an array containing all of the descriptions **/
    public String[] getDescriptionArray()
    {
        String[] str = new String[size];
        int count = 0;
        while (count < size)
        {
            str[count]=classList[count].getDescription();
            count++;
        }
        return str;
    }
    
    /** checks to make sure the given index is good
     * @param index                         the index to be checked
     * @throws IndexOutOfBoundsException**/
    private void checkIndex(int index)
    {
	if (index < 0 || index >= size)
	{
		throw new IndexOutOfBoundsException("Index: "+ index); 
	}
    }
    
    /** returns the number of elements in the array
     * @return an int for the number of items in the array **/
    public int getSize()
    {
        return size;
    }
}
