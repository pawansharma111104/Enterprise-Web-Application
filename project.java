import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
class UserManagement{
	Scanner sc=new Scanner(System.in);
	int option;
	String name,pass,pass1,name1;
	void printPattern(){
		    System.out.println("                        ***             *********                  ******           ");
        System.out.println("                      **   **           *********                 ***               ");
        System.out.println("                     ***   ***          ***                       ***               ");
        System.out.println("                    ***     ***         *********                  ***              ");
        System.out.println("                    ***     ***         *********                    ***            ");
        System.out.println("                     ***   ***          ***                            ***          ");
        System.out.println("                      **   **           *********                      ***          ");
        System.out.println("                        ***   nline     ********* xamination       ******  ystem    ");
	}
	void clear(){
    	try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void saveUserData(String name, String password) {
        try {
            FileWriter writer = new FileWriter("user_data.txt", true);
            writer.write(name + " " + password + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	void perform(){
		clear();
         printPattern();
		System.out.println("     For Teacher-\n     1.)Sign Up \n     2.)Login");
		System.out.println("                                                       'Press key according'");
		option=sc.nextInt();
		switch(option){
			case 1:
			int i=0;
			System.out.print("\n     Enter your first name:");
			name=sc.next();
			while(i==0){
			System.out.print("\n     Enter your password:");
			pass=sc.next();
			System.out.print("\n     Re-Enter your password:");
			pass1=sc.next();
			if(pass.equals(pass1)){
                saveUserData(name, pass);
				break;
			}
			else
			System.out.print("\n     Please Enter the same password");
		}
			break;
			case 2:
			int count=3;
			clear();
         printPattern();
			for(i=1;i<=3;i++){
				System.out.println("                                              Number of attempts:"+count);
			System.out.print("\n     Enter your first name:");


			name1=sc.next();
			System.out.print("\n     Enter your password:");
			pass=sc.next();
			count--;
			if(pass.equals(pass1) && name.equals(name1)){
				System.out.println("                                                 Welcome to the Online Examination System!");
				System.out.println("                        Please set Exam");
				break;
			}
			else{
				System.out.println("     Wrong name or password!");
			}
		}
			break;
		}
 	}
}
class ExamSetting extends UserManagement {
    int ques,count=0,mark;
    String stuName,rollno;
    void student(){
    	System.out.print("     For Student-\n     Enter your name:");
    	stuName=sc.nextLine();
    	System.out.print("\n     Enter the Roll Number:");
    	rollno=sc.nextLine();
    }
    void printStudent(){
    	System.out.println("              Student Name -- "+stuName+"              Roll Number -- "+rollno);
    }
    void ques() {
    	clear();
         printPattern();
        System.out.print("\n     How many MCQs based questions do you want to set?:");
        ques = sc.nextInt();
        System.out.print("\n     Marks for each correct question:");
        mark=sc.nextInt();
    	int arr[] = new int[ques];
    	int ans[]=new int [ques];
    	sc.nextLine();
    	String[][] S = new String[ques][5];
            for (int x = 0; x < ques; x++) {
            		clear();
            		printPattern();
            System.out.print("\n     Enter Question No. " + (x + 1)+"- ");
            S[x][0] = sc.nextLine();
            for (int s = 1; s <= 4; s++) {
                System.out.print("\n     Option "+s+"- " );
               S[x][s] = sc.nextLine();
            }
            System.out.print("\n     Which one of them is the correct answer (option number):");
            arr[x] = sc.nextInt();
            sc.nextLine(); 
        }
        clear();
            printPattern();
            student();
        for (int x = 0; x < ques; x++) {
     		clear();
     		printPattern();
     		printStudent();
        	System.out.println("\n     Question No. " + (x + 1)+"- "+S[x][0]+"  ");
            for (int s = 1; s <= 4; s++) {
                System.out.print("\n     Option "+s+ "- "+S[x][s]+"\n");
               }
               System.out.print("\n     Answer(option number):");
               ans[x]=sc.nextInt();
               if(ans[x]==arr[x]){
               	count++;
               }}
               clear();
            printPattern();
            if(count==ques){
            	printStudent();
            	System.out.println("               Excellent Performance!      Marks="+(mark*ques)+"/"+(mark*ques));
            }
            else{
            	printStudent();
            	System.out.println("               Work Harder!      Marks="+(mark*count)+"/"+(mark*ques));
            	for (int x = 0; x < ques; x++){
            		System.out.println("\n     Question No " + (x + 1)+"- "+S[x][0]+"  ");
            		for (int s = 1; s <= 4; s++){
            			System.out.print("\n     Option "+s+ "- "+S[x][s]+"\n");
            		}
            		System.out.print("\n     Answer(option number):"+arr[x]+"         Option Marked:"+ans[x]);
            	}
            }

           }}
public class Finalproject{
	public static void main(String[] args) {
		 UserManagement obj=new UserManagement();
		ExamSetting obj1=new ExamSetting();
		 obj.perform();  
		 obj.perform();
		 obj1.ques();
	}
}
