package com.Lockedme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class LockedMeProject 
{
	static final String folderpath="D:\\my java\\Myphase1project\\LockedMeFiles";
//	private static final FileManager LockedMeMain = null;
	private static final int case1 = 0;

	public static void main(String[] args) {
		int proceed=1;
		do
		{
		
		//Variable decleration
		Scanner obj=new Scanner(System.in);
		int ch;
		//Menu
		
		displayMenu();
		System.out.println("Enter your choice:");
		ch=Integer.parseInt(obj.nextLine());
		switch(ch)
		{
		  case 1:getAllFiles();
		   break;
		  case 2:addFiles();
		   break;
		  case 3:deleteFiles();
		   break;
		  case 4:searchFiles();
		   break;
		  case 5:System.exit(0);
		   break;
		  default: System.out.println("Invalid Option");
		   break;
		}
		}while(proceed>0); 
	}
	
	   

		public static void displayMenu(){
	    	System.out.println("**********************************************************");
			System.out.println("\t\tlockedme.com");
			System.out.println("**********************************************************");
			System.out.println("1.Display all files");
			System.out.println("2.Add new files");
			System.out.println("3.Delete a file");
			System.out.println("4.Search a files");
			System.out.println("5.Exit");
			System.out.println("**********************************************************");
			
			
	    	
	    }
		public static void getAllFiles() {
	// code to get filenames.
    List<String> fileNames = FileManager.getAllFiles(folderpath);
    if(fileNames.size()==0)
    	System.out.println("No files in the directory");
    else
    {
    	System.out.println("file List is below:/n");
        for(String f:fileNames)
    	System.out.println(f);
		}
	}	
		public static void addFiles() {
    //code for adding a files.
    Scanner obj = new Scanner(System.in);
    String filename;
    int linesCount;
    List<String> content = new ArrayList<String>();
    
    //Read file name from user
    System.out.println("Enter file Name:");
	filename =obj.nextLine();
    
    //Read number of lines from user
	System.out.println("Enter how many lines in the file:");
	linesCount=Integer.parseInt(obj.nextLine());
    
    //Read Lines from user
	for (int i = 1;i<=linesCount;i++)
    {
    	System.out.println("Enter line"+i+":");
    	content.add(obj.nextLine());
    }	
     
    //save the content into the file
	boolean isSaved = FileManager.createFiles(folderpath, filename, content);
    if(isSaved)
    	System.out.println("file and data saved successfully");
    else
    	System.out.println("some error occured.Please contact admin@sai.com");
    
  //Close scanner object
    
		}
    
    public static void deleteFiles() {
    	 //code for deleting a file
	    String fileName;
	    Scanner obj=new Scanner(System.in);
	    System.out.println("Enter file name to be deleted:");
	    fileName=obj.nextLine();
	    
	    boolean isDeleted=FileManager.deleteFile(folderpath,fileName);
	    
	    if(isDeleted)
	    	System.out.println("File deleted successfully");
	    else
	    	System.out.println("Either file not there or some access issue");
	    
    	}
    public static void searchFiles() {
    	//code for searching a file
	    String fileName;
	    Scanner obj=new Scanner(System.in);
	    System.out.println("Enter file name to be searched:");
	    fileName=obj.nextLine();
	    
	    boolean isFound=FileManager.searchFile(folderpath,fileName);
	    
	    if(isFound)
	    	System.out.println("File is present in the folder");
	    else
	    	System.out.println("File is not present in the folder");
    }
}  

