import java.util.*;
public class Main {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        Main a=new Main();
        a.login();
    }

    public static void clrscr(){
        try{
            System.out.println("\033[H\033[2J");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    protected void login(){
        while (true){
            clrscr();
            System.out.println("\t\t<-----WELCOME----->");
            System.out.println("\t\t 1.Admin");
            System.out.println("\t\t 2.User");
            System.out.println("\t\t 3.Exit");
            System.out.println("\t\tEnter your choice: ");
            int a=sc.nextInt();
            switch (a){
                case 1:
                    Admin b=new Admin();
                    b.adminlogin();
                    break;
                case 2:
                    User c=new User();
                    c.Userlogin();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter the Valid choice...");
            }
        }

    }
}

