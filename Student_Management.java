import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Thread;
import java.lang.Exception;
import java.io.Serializable;

class Student implements Serializable{
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
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public String toString(){
        return ( ANSI_PURPLE +"\n Student Details:  "+"\n ID: "+id+"\n Student Name: "+name+
                "\n Contact No: "+contact_no+"\n Semester fee:  "+fee+"\n Email Address: "+email +" "+ANSI_RESET);
    }


}
class Loading extends Thread{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public void run(){
        try {
            System.out.println(ANSI_YELLOW +"                                L"+ANSI_RESET );
            Thread.sleep(1000);
            System.out.println(ANSI_YELLOW +"                                O"+ANSI_RESET );
            Thread.sleep(1000);
            System.out.println(ANSI_YELLOW +"                                A"+ANSI_RESET );
            Thread.sleep(1000);
            System.out.println(ANSI_YELLOW +"                                D"+ANSI_RESET );
            Thread.sleep(1000);
            System.out.println(ANSI_YELLOW +"                                I"+ANSI_RESET );
            Thread.sleep(1000);
            System.out.println(ANSI_YELLOW +"                                N"+ANSI_RESET );
            Thread.sleep(1000);
            System.out.println(ANSI_YELLOW +"                                G"+ANSI_RESET );
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
class Student_Management1{
    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE  = "\u001B[34m";

static void display(ArrayList<Student>emp){

        System.out.println(ANSI_PURPLE  +"\n          *STUDENTS LIST**\n" + ANSI_RESET);
        for(Student e:emp){
        System.out.println(ANSI_BLUE +"\n Student Details:  "+"\n ID: "+e.id+"\n Student Name: "+e.name+
        "\n Contact No: "+e.contact_no+"\n Semester fee:  "+e.fee+"\n Email Address: "+e.email + ANSI_RESET);
        }
}
}
public class Student_Management {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String  ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_BLUE  = "\u001B[34m";

    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {

        Loading l1= new Loading();
        l1.run();

        Student_Management1 m = new Student_Management1();

        int id;
        String name,contact_no,email;
        double fee;


        Scanner sc=new Scanner(System.in);
        ArrayList<Student>emp=new ArrayList<>();


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
                emp=(ArrayList<Student>)ois.readObject();

            }

        }catch (Exception e){
            System.out.println(e);
        }

        do {

            System.out.println( ANSI_CYAN+"\n                  *** STUDENTS MANAGEMENT SYSTEM ***                  \n"+ANSI_RESET);

            System.out.println(  ANSI_PURPLE+"                  -------------------------------------------                  "+ANSI_RESET);
            System.out.println(
                    ANSI_CYAN+"                  1) Add Student data                  \n"+ANSI_RESET
                    + ANSI_PURPLE+ "                  -------------------------------------------                  \n"+ANSI_RESET+
                    ANSI_CYAN+"                  2) Search for Student data by given ID                  \n"+ANSI_RESET+
                     ANSI_PURPLE+ "                  -------------------------------------------                  \n"+ANSI_RESET+
                    ANSI_CYAN+"                  3)  Edit Student Details                    \n"+ANSI_RESET+
                    ANSI_PURPLE+ "                  -------------------------------------------                  \n"+ANSI_RESET+
                    ANSI_CYAN+"                  4)  Delete Student Details                    \n"+ANSI_RESET+
                    ANSI_PURPLE+ "                  -------------------------------------------                  \n"+ANSI_RESET+
                    ANSI_CYAN+"                  5) Display All Students data                   \n"+ANSI_RESET+
                     ANSI_PURPLE+ "                  -------------------------------------------                  \n"+ANSI_RESET
                            + ANSI_CYAN+"                  6)   Save                  \n"
                            + ANSI_RESET+ ANSI_PURPLE+"                  ---------------------                  \n"+ANSI_RESET
                    +ANSI_CYAN+ "                  7)   EXIT                  \n"
                            + ANSI_RESET+ ANSI_PURPLE+"                  ---------------------                  \n"+ANSI_RESET);


            System.out.println(ANSI_BLUE+"\nEnter the choice : "+ ANSI_RESET);

            int ch= sc.nextInt();


            switch (ch){
                case 1:
                    System.out.println(ANSI_YELLOW+"Enter the following details:  \n"+ ANSI_RESET);
                    System.out.println(ANSI_YELLOW+"Enter ID:  "+ ANSI_RESET);
                    id=sc.nextInt();
                    System.out.println(ANSI_YELLOW+"Enter Name:  "+ ANSI_RESET);
                    name=sc.next();
                    System.out.println(ANSI_YELLOW+"Enter the Contact No:  "+ ANSI_RESET);
                    contact_no=sc.next();
                    System.out.println(ANSI_YELLOW+"Enter email:  "+ ANSI_RESET);
                    email=sc.next();
                    System.out.println(ANSI_YELLOW+"Enter the Semester fee:  "+ ANSI_RESET);
                    fee=sc.nextDouble();
                    emp.add(new Student(id,name,contact_no,email,fee));
                    m.display(emp);
                    break;


                case 2: {
                    System.out.println(ANSI_YELLOW+"Enter Student id to search: "+ ANSI_RESET);
                    id = sc.nextInt();
                    int i = 0;
                    for (Student e : emp) {
                        if (id == e.id) {
                            System.out.println(e + "\n");
                            i++;
                        }
                    }
                    if (i == 0) {
                        System.out.println(ANSI_RED+"Student ID is incorrect :( \n ** Please Enter valid ID!! "+ANSI_RESET);

                    }
                    break;
                }

                case 3:
                    System.out.println(ANSI_YELLOW+"Enter Student Id to edit the details:  \n"+ ANSI_RESET);
                    id=sc.nextInt();
                    int j=0;
                    for (Student e:emp) {
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
                                    System.out.println(e+"\n");
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
                                { System.out.println(ANSI_RED+"Enter the correct choice!!"+ ANSI_RESET);
                                    break;}
                            }

                        }}
                    if (j==0){

                        System.out.println(ANSI_RED+"Student Details is not Found please enter the valid ID!!\n"+ANSI_RESET);
                    }
                    break;

                case 4:
                    System.out.println(ANSI_RED+"Enter the Student ID to delete the Data"+ANSI_RESET);
                    id= sc.nextInt();
                    int k=0;
                    try {
                        for (Student e:emp){
                            if (id==e.id){
                                emp.remove(e);
                                k++;
                            }

                        }if (k==0){
                            System.out.println(ANSI_RED+"Student details is not available.\n Please enter the valid ID\n"+ANSI_RESET);
                        }
                    }catch (Exception ex){
                        System.out.println(ex);
                    }


                case 5:
                    try {
                        emp=(ArrayList<Student>) ois.readObject();
                    }catch (IOException ex){

                    }catch (Exception e){

                    }

                    m.display(emp);
                    break;
                case 6:
                    try {
                        fos=new FileOutputStream(f);
                        oos=new ObjectOutputStream(fos);
                        oos.writeObject(emp);
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
                        System.out.println(ANSI_RED+"\n Saving the file "+ANSI_RESET);


                        break;

                    } // Finally block end


                case 7:
                {
                    sc.close();
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println(ANSI_RED+"\n Enter the correct choice from given options"+ANSI_RESET);
            }

        }while (true);


    }

}