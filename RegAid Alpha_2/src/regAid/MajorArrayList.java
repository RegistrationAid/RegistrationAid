package regAid;

/**
 *
 * @author Noel Hansen
 */
import java.util.*;
import java.io.*;

public class MajorArrayList 
{
    private Class[] classList;
    private int size;
    private String name;
    private static final int DEFAULT_SIZE = 20;
    private String classFileName = "";
    private String infoFileName = "";
    
    public MajorArrayList (String classFileName, String infoFileName)
    {
        this.classFileName = classFileName;
        this.infoFileName = infoFileName;
    }
    
    public void fillList () throws FileNotFoundException
    {
        classList = new Class[DEFAULT_SIZE];
        size = 0;
        Scanner classFile = new Scanner(new File (classFileName));
        Scanner infoFile = new Scanner(new File (infoFileName));
        this.name = classFile.next();
        while(classFile.hasNextLine())
        {
            Class temp = new Class(classFile.next(), getSyllabus(infoFile), classFile.next(), classFile.next(), classFile.next());
            this.add(temp);
        }
    }
    
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
    
    public void add (Class newClass)
    {
	this.ensureCapacity(size+1);
	classList[size] = newClass;
	size++;
    }
    
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
    
    public boolean isEmpty ()
    {
		return size == 0;
    }
    
    public String getMajorName()
    {
        return name;
    }
    
    public Class get(int index)
    {
		checkIndex(index);
		return classList[index];
    }
	 
	 public int size()
	 {
	 	return size;
	 }
    
    public String getIndex(int index)
    {
        checkIndex(index);
        return classList[index].getName()+":\n"+classList[index].getDescription();
    }
    
    public Class[] getArray()
    {
       return classList;
    }
    
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
    
    private void checkIndex(int index)
    {
	if (index < 0 || index >= size)
	{
		throw new IndexOutOfBoundsException("Index: "+ index); 
	}
    }
}
