package program.java.lockdeme;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe {
	//declaring the variables
		static Scanner sc = new Scanner(System.in);
		static Scanner sc1= new Scanner(System.in);
		static int userinput2,userinput;
		static String path = "C:/Users/senthilmano/folder/";
		 static String str[];
		 public static void main(String[] args) {
	System.out.println("\n	::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"
					+ "\n	***                                                                                      ***"
					+ "\n	***                                 LOCKED ME.COM                                        ***"
					+ "\n	***                                                                                      ***"
					+ "\n	::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"
					+ "\n	*** DEVELOPED BY :: SENTHIL KUMAR ***        	"
					+ "\n\n   Directory ::"+path);
	// welcome page 
			//MAIN MENU 
			do{
			 System.out.println("               \n\n              ******MAIN MENU******\n\n"
			                    +"            	Choose the option below\n\n"
			                    +"            1.To get the Files in the Directory\n\n"
			                    +"            2.To manage the Files in the Directory\n\n"
			                    +"            3.To Exit the Application\n");
			 if(sc.hasNextInt()){//to check whether user entered numeric value or not
				 userinput = sc.nextInt();
				 }
				 else {
					 sc.next();// if  user enter string value throw a message to enter numeric value
					 System.out.println("please provide the correct number");
					 userinput=0;
				 }
				 if(userinput>4||userinput<=0){//if user enter the number other then option throw a message to change value 
					 System.out.println("please provide the correct number"); 
				 }
				 switch(userinput){//switch statements for main menu 
					case 1:
						list();//method to list files in the directory 
						break;
					case 2:
						
					do{	
						//sub menu to manage the files
						System.out.println("\n\n        >>>Choose below the option to manage the files<<< "
						+"\n\n 1.To Add a file in the directory"
						+"\n\n 2.To Delete a file in the directory"
						+"\n\n 3.To search a file in the directory"
						+"\n\n 4.To go Back Main menu ");
						if(sc.hasNextInt()){
						 userinput2 = sc.nextInt();
						}
						else{
							sc.next();
							System.out.println("please provide the correct number");
							userinput2=0;
						}
					   if(userinput2>4||userinput2<=0){
							System.out.println("please provide the correct number");	
						}
						switch(userinput2){//switch statements for sub menu 
						case 1: 
							create();
							break;
						case 2:
							delete();
							break;
						case 3:
							search();
							break;
						case 4:
							System.out.println("\n Going back main menu....");
						}
					}while(userinput2!=4||userinput2>4);//repeat the switch operation until user choose "4" for sub menu 
					break;
						case 3:
							exit();
							}
						}while(userinput!=3||userinput>3);//repeat the switch operation until user choose "3" for main menu				
		}
		 
		 
		 
		 static void exit(){
				
				System.out.println("\n Are you sure to exit?"
				                   +"\n\n (Y)->YES    To close the Application?"
				                   +"\n\n (N)-> NO    To return Menu ");
				String exit = sc1.next();
				if(exit.equals("yes")||exit.equals("y")||exit.equals("YES")||exit.equals("Y")){//if yes exit the program
					System.out.println("\n              ******THANK YOU******");	
				}
				else if(exit.equals("no")||exit.equals("n")||exit.equals("No")||exit.equals("N")){//if no return to main menu 
					userinput=2;
					}
				else{
					System.out.println("To confirm, press Y or N ");// repeat the operation until user choose y or no 
					exit();
				}
			}
		 static void list(){
			 str = files();//store the file names  in str array 
				if(str.length==0){//to check whether directory folder is empty or not
				System.out.println("There is no file in the directory:" +path);
				}
					else{//list the files from the directory 
						System.out.println("These are the files in the directory  :"+path);
						for(int i=0;i < str.length;i++){
							System.out.println(i+1+":   "+str[i]+"\n");
							}
						}
		 }
		 
		 static String[]files(){//to takes files in the directory and to sort files in ascending oder
				File file = new File (path);
				String str[] = file.list();
				 Arrays.sort(str);//array sort
			return str;	
			}
		 
		  static void search(){
			System.out.println("**To Search file in the directory**\n");
			System.out.println("Enter a file name :");
		    String filename2 =sc.next();
			File s = new File(path+filename2);//takes user input to search files
			if(s.exists()){
				 str = files();
				 for(int i=0;i<str.length;i++){//search files using linear search method
					if( filename2.equalsIgnoreCase(str[i])){//case sensitive added
						String search = str[i];
						System.out.println("\n File found : "+search+"  in the directory:: "+s.getAbsolutePath());
					}
				 }
			}
			else {// return the message if file  not found
				System.out.println("     The File not found   ");
			}
			 
		 }
		 static void delete(){
			 System.out.println("   **To Delete file in the directory**\n");		
				System.out.println("Enter a File name :");
			    String filename1 =sc.next();
				File d = new File(path+filename1);
				if(d.exists()){// to search the user entered file
					 str = files();
					 String search = null ;
					 for(int i=0;i<str.length;i++){
						if( filename1.equalsIgnoreCase(str[i])){
							 search = str[i];
						}
						}
					d.delete();// deleting the file if exists
					System.out.println(search+"  file deleted sucessfully!!");
				}
				else {
					System.out.println("     The file not found ");
				}
		 }
		 
		 static void create(){
				try{
					System.out.println("\n **To Add a file in the directory**");
					System.out.println("\n Enter a File name :");
					String filename =sc.next();
					File c = new File(path+filename);
					if(c.createNewFile()){//create a file 
						System.out.println("  The file is created in the directory :  "+path+filename);
					}
						else{
							if(c.exists()){//check whether the file exits 
								System.out.println("        The file already exits!!!  "+c.getAbsolutePath());
							}
						}
					}										
					catch(IOException a){//throws Io exception 
						System.out.println("error in the program "+a);
					}
		 }
}
