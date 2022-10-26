import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Thread;
import java.lang.Exception;
import java.util.Random;

class Student implements Serializable {
    int id;
    String name,contact_no,email;
    double fee;

    public Student(int id,String name,String contact_no,String email,double fee){
        this.id=id;
        this.name= name;
        this.contact_no=contact_no;
        this.email=email;
        this.fee=fee;
    }
    public static final String RESET = "\u001B[0m";
    public static final String PURPLE = "\u001B[35m";

    //autocall
    public String toString(){
        return ( PURPLE +"\n Student Details:  "+"\n ID: "+id+"\n Student Name: "+name+
                "\n Contact No: "+contact_no+"\n Semester fee:  "+fee+"\n Email Address: "+email +" "+RESET);
    }


}
class Loading extends Thread{
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public void run(){
        try {
            System.out.println(YELLOW +"                                L"+RESET );
            Thread.sleep(1000);
            System.out.println(YELLOW +"                                O"+RESET );
            Thread.sleep(1000);
            System.out.println(YELLOW +"                                A"+RESET );
            Thread.sleep(1000);
            System.out.println(YELLOW +"                                D"+RESET );
            Thread.sleep(1000);
            System.out.println(YELLOW +"                                I"+RESET );
            Thread.sleep(1000);
            System.out.println(YELLOW +"                                N"+RESET );
            Thread.sleep(1000);
            System.out.println(YELLOW +"                                G"+RESET );
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
class Student_Management1{
    // Declaring ANSI_RESET so that we can reset the color
    public static final String RESET = "\u001B[0m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BLUE  = "\u001B[34m";

 void display(ArrayList<Student>Stud){
        System.out.println(PURPLE  +"\n         **STUDENTS LIST**\n" + RESET);
        for(Student e:Stud){
        System.out.println(BLUE +"\n Student Details:  "+"\n ID: "+e.id+"\n Student Name: "+e.name+
        "\n Contact No: "+e.contact_no+"\n Semester fee:  "+e.fee+"\n Email Address: "+e.email + RESET);
        }
}
}
public class Student_Management {
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String  RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BLUE  = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {

        Loading l1= new Loading();
        l1.run();

        Student_Management1 m = new Student_Management1();

       int id;
        String name,contact_no,email;
        double fee;

        Random rand = new Random();

        Scanner sc=new Scanner(System.in);

        ArrayList<Student>Stud=new ArrayList<>();


        File f=null;
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;


        try {
            f=new File("new.txt");
            if(f.exists()){
                fis=new FileInputStream(f);
                ois=new ObjectInputStream(fis);

                //deseralization
                Stud=(ArrayList<Student>)ois.readObject();

            }


        }catch (Exception e){
            System.out.println(e);
        }

        do {

            System.out.println( CYAN+"\n                  *** STUDENTS MANAGEMENT SYSTEM ***                  \n"+RESET);

            System.out.println( PURPLE+"                  -------------------------------------------                  "+RESET);
            System.out.println(
                    CYAN+"                  1) Add Student data                  \n"+RESET
                    + PURPLE+ "                  -------------------------------------------                  \n"+RESET+
                    CYAN+"                  2) Search for Student data by given ID                  \n"+RESET+
                    PURPLE+ "                  -------------------------------------------                  \n"+RESET+
                    CYAN+"                  3)  Edit Student Details                    \n"+RESET+
                   PURPLE+ "                  -------------------------------------------                  \n"+RESET+
                   CYAN+"                  4)  Delete Student Details                    \n"+RESET+
                    PURPLE+ "                  -------------------------------------------                  \n"+RESET+
                    CYAN+"                  5) Display All Students data                   \n"+RESET+
                     PURPLE+ "                  -------------------------------------------                  \n"+RESET
                            + CYAN+"                  6)   Save                  \n"
                            + RESET+ PURPLE+"                  ---------------------                  \n"+RESET
                    +CYAN+ "                  7)   EXIT                  \n"
                            + RESET+ PURPLE+"                  ---------------------                  \n"+RESET);


            System.out.println(BLUE+"\nEnter the choice : "+ RESET);

            int ch= sc.nextInt();


            switch (ch){
                case 1:
                    //add
                    System.out.println(YELLOW+"Enter the following details:  \n"+ RESET);
                    System.out.println(YELLOW+"Enter ID:  "+ RESET);
                    id=sc.nextInt();

//                    System.out.println(YELLOW+" ID will be generate automatically:  "+ RESET);
//                    id=rand.nextInt(1000-01) + 01;

                    System.out.println(YELLOW+"Enter Name:  "+ RESET);
                    name=sc.next();
                    System.out.println(YELLOW+"Enter the Contact No:  "+ RESET);
                    contact_no=sc.next();
                    System.out.println(YELLOW+"Enter email:  "+RESET);
                    email=sc.next();
                    int w=0;
                    try{
                        for (int i=0; i<email.length();i++){
                            if (email.contains("@")){
                            w++    ;
                            }
                        }
                     if (w==1)  {
                         System.out.println(email);

                     }
                        if (w==0){
                            System.out.println( RED+"\n----Not Correct, Please Enter the valid Email----"+RESET)  ;                     }
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    System.out.println(YELLOW+"Enter the Semester fee:  "+ RESET);
                    fee=sc.nextDouble();
                    Stud.add(new Student(id,name,contact_no,email,fee));
                    m.display(Stud);
                    try {
                        fos=new FileOutputStream(f);
                        oos=new ObjectOutputStream(fos);
                        oos.writeObject(Stud);
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                    break;


                case 2: {
                    //search
                    System.out.println(YELLOW+"Enter Student id to search: "+ RESET);
                    id = sc.nextInt();
                    int i = 0;
                    for (Student e : Stud) {
                        if (id == e.id) {
                            System.out.println(e + "\n");
                            i++;
                        }
                    }
                    if (i == 0) {
                        System.out.println(RED+"----Student ID is incorrect :( \n ** Please Enter valid ID!!----"+RESET);

                    }
                    break;
                }

                case 3:
                    //Edit
                    System.out.println(YELLOW+"Enter Student Id to edit the details:  \n"+ RESET);
                    id=sc.nextInt();
                    int j=0;
                    for (Student e:Stud) {
                        if (id==e.id) {
                            j++;}

                        while (j==1){
                            System.out.println("\n*Edit Student Details*\n");
                            System.out.println("1) Student ID");
                            System.out.println("2) Name");
                            System.out.println("3)contact No  \n" + "4)Email\n" + "5)Semester fee\n");
                            System.out.println("6)GO BACK!");
                            System.out.print("Enter your choice to edit: ");
                            int choice = sc.nextInt();
                            switch (choice){
                                case 1:
                                {System.out.println("Enter new Id:");
                                    e.id=sc.nextInt();
                                    System.out.println(e+"\n");
                                    break;}
                                case 2:
                                {System.out.println("Enter new name:");
                                    e.name=sc.next();
                                    System.out.println(e+"\n");
                                    break;}
                                case 3:
                                {System.out.println("Enter new Contact No:");
                                    e.contact_no=sc.next();
                                    System.out.println(e+"\n");
                                    break;}
                                case 4:
                                { System.out.println("Enter new Email:");
                                    e.email=sc.next();
                                    int q=0;
                                    try{
                                        for (int i=0; i<e.email.length();i++){
                                            if (e.email.contains("@")){
                                                q++ ;
                                            }
                                        }
                                        if (q==1)  {
                                            System.out.println(e.email);

                                        }
                                        if (q==0){
                                            System.out.println( RED+"\n----Not Correct, Please Enter the valid Email----"+RESET)  ;
                                        }
                                    }
                                    catch(Exception ep){
                                        System.out.println(ep);
                                    }
                                    break;}
                                case 5:
                                {  System.out.println("Enter new Semester fee:");
                                    e.fee=sc.nextDouble();
                                    System.out.println(e+"\n");
                                    break;}

                                case 6:
                                {j++;
                                    break;}
                                default:
                                { System.out.println(RED+"----Enter the correct choice!!----"+RESET);
                                    break;}
                            }

                        }}
                    if (j==0){

                        System.out.println(RED+"----Student Details is not Found please enter the valid ID!!----\n"+RESET);
                    }
                    break;

                case 4:
                    //DELETE
                    System.out.println(RED+"Enter the Student ID to delete the Data"+RESET);
                    id= sc.nextInt();
                    int k=0;
                    try {
                        for (Student e:Stud){
                            if (id==e.id){
                                Stud.remove(e);
                                k++;
                            }

                        }if (k==0){
                            System.out.println(RED+"----Student details is not available.\n Please enter the valid ID----\n"+RESET);
                        }
                    }catch (Exception ex){
                        System.out.println(RED+"\n---- Deleting the file ----"+RESET);
                    }


                case 5:
                    m.display(Stud);
                    break;
                case 6:

                    //save
                    try {
                        fos=new FileOutputStream(f);
                        oos=new ObjectOutputStream(fos);
                        oos.writeObject(Stud);
                    }catch (IOException e){
                        System.out.println(e);
                    }

                    finally {
                        try {
                            fis.close();
                            fos.close();
                            ois.close();
                            oos.close();

                        }catch (IOException ex){
                            System.out.println(ex);
                        }
                        System.out.println(RED+"\n Saving the file "+RESET);
                        break;

                    } // Finally block end


                case 7:
                {
                    sc.close();
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println(RED+"\n----Enter the correct choice from given options----"+RESET);
            }
        }while (true);
    }
}