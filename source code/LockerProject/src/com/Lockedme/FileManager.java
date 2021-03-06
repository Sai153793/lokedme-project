package com.Lockedme;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager 
{
	/**
	 * This method will return the files names from the folder.
	 * @param folderpath
	 * @return List<String>
	 */
	public static List<String> getAllFiles(String folderpath)
	{
		File fl = new File(folderpath);
		//getting all the files into FileArray
		File[] listofFiles = fl.listFiles();
		//declare a list to store file names
		List<String> fileNames = new ArrayList<String>();
		
		for (File f:listofFiles) //Using ForEach to get the file names 
			fileNames.add(f.getName());
		return fileNames;
	}
	/**
	 * This method will create or append content into the file specified.
	 * @param folderpath
	 * @param filename
	 * @param content
	 * @return boolean
	 */
	public static boolean createFiles(String folderpath,String filename,List<String> content)
	{
		try
		{
			File f1=new File(folderpath,filename);
			FileWriter fw=new FileWriter(f1);
			
			for(String s:content)
			{
				fw.write(s+"/n");
			}
			fw.close();
			return true;
		}
		catch(Exception EX)
		{
			return false;
		}
	}
    /**
     * This method will delete the filename if it exist.
     * @param folderpath
     * @param fileName
     * @return
     */
	public static boolean deleteFile(String folderpath, String fileName)
	{
		File file = new File(folderpath+"//"+fileName);
		try
		{
		 if(file.delete())
			 return true;
		 else
			 return false;
		}
		catch(Exception Ex)
		{
		 return false;
		}
	}
	/**
	 * This method will search the file from the folder.
	 * @param folderpath
	 * @param fileName
	 * @return
	 */
	public static boolean searchFile(String folderpath, String fileName)
	{
		//adding folderpath with filename and creating file object
		File file=new File(folderpath+"//"+fileName);
		if(file.exists())
			return true;
		else
			return false;
	}
}
	
	
		
	


