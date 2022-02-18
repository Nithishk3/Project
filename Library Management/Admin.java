
import java.util.*;
public class Admin {
    String name;
    String EmailId;
    String pass;
    Admin(String a,String b,String c){
        this.name=a;
        this.EmailId=b;
        this.pass=c;
    }
    static List<Admin>adm=new ArrayList<>();
    static Scanner sc=new Scanner(System.in);
    static{
        adm.add(new Admin("admin","adm","123"));
    }
    public Admin(){}
    void clrscr(){
        try{
            System.out.print("\033[H\033[2J");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    void adminlogin(){
        int attempt=0;
        while(attempt++<3){
            clrscr();
            System.out.println("Welcome Admin");
            System.out.print("Enter your EmailID : ");
            String a=sc.nextLine();
            System.out.print("Enter your Password : ");
            String b=sc.nextLine();
            int ind = isadmin(a);
            if(ind!=-1){
                if(adm.get(ind).pass.equals(b)){
                    adminmenu();
                    break;
                }
            }
            System.out.println("Entered Credentials are Wrong");
            enter_wait();
        }
        System.out.println("Maximum Attempts Exceeded! Please Try after sometime");
    }
    void enter_wait() {
        System.out.print("Press ENTER to Continue!!..");
        sc.nextLine();
    }
    int isadmin(String a){
        for(int i=0;i<adm.size();i++){
            if(a.equals(adm.get(i).EmailId)){
                return i;
            }
        }
        return -1;
    }
    void adminmenu(){
        int cho=0;
        while(true){
            clrscr();
            System.out.println(" Welcome to Admin menu");
            System.out.println("""
            1 - Add Admin
            2 - Add Borrowers
            3 - Edit menu
            4 - book search
            5 - Managing Fine limit
            6 - report
            7 - Issue Counter
            8 - Return Counter
            0 - back""");
            if(cho == -1){
                System.out.println("Please Enter a valid Choise.");
            }
            System.out.print("Choice : ");
            cho=sc.nextInt();sc.nextLine();
            User xx=new User();
            Book x=new Book();
            switch(cho){
                case 1:
                    addadmin();
                    break;
                case 2:
                    xx.addbook();
                    break;
                case 3:
                    x.bookmenu();
                    break;
                case 4:
                    x.booksearch();
                    break;
                case 5:
                    System.out.print("Current Fine Per Day = ");
                    System.out.println(Book.FineperDay);
                    System.out.print("Enter new Fine Limit : ");
                    Book.FineperDay=sc.nextInt();sc.nextLine();
                    break;
                case 6:
                    reportmenu();
                    break;
                case 7:
                    IssuCounter();
                    break;
                case 8:
                    Return_Counter();
                    break;
                case 0:
                    Main l=new Main();
                    l.login();
                    break;
                default :
                    cho=-1;
            }
        }
    }
    protected void reportmenu() {
        int cho=0;
        Book z=new Book();
        User x=new User();
        while(true){
            clrscr();
            System.out.println("""
            1 - Books Less than 5 in quantity
            2 - Sorted by Book Borrowed count
            3 - A book Borrower List
            0 - Back""");
            if(cho==-1)System.out.println("Invalid Input");
            System.out.print("Choice : ");
            cho=sc.nextInt();sc.nextLine();
            switch(cho){
                case 1:
                    boolean fla=true;
                    clrscr();
                    System.out.print("Book Name ");
                    System.out.print("   Author Name ");
                    System.out.print("   Book ISBN ");
                    System.out.print("   Book Quantity");
                    System.out.print("   Book Price");
                    System.out.println();
                    for (int i=0;i<Book.books.size();i++){
                        if (Book.books.get(i).quantity <=5){
                            fla=false;
                            System.out.print(Book.books.get(i).book_name+" ");
                            System.out.printf("%15s",Book.books.get(i).author+" ");
                            System.out.printf("%15s",Book.books.get(i).ISBN+" ");
                            System.out.printf("%15s",Book.books.get(i).quantity +" ");
                            System.out.printf("%15s",Book.books.get(i).book_price+" ");
                            System.out.println();
                        }
                    }
                    if(fla){
                        clrscr();
                        System.out.println("There is no Book quantity avalable less then 5");
                        enter_wait();
                        reportmenu();
                    }
                    enter_wait();
                    break;
                case 2:
                    z.borrowcount();
                    break;
                case 3:
                    x.bookborrowlist();
                    break;
                case 0:
                    adminmenu();
                default:
                    cho=-1;
            }
        }
    }
    private void Return_Counter() {
        int cho=0;
        Book x=new Book();
        User z=new User();
        l:while(true){
            clrscr();
            System.out.println("""
            1 - Return Book
            2 - Lost Book
            3 - Membership card Lost
            0 - Back""");
            if(cho==-1){
                System.out.println("Enter valid choice");
            }
            System.out.print("Choice : ");
            cho=sc.nextInt();sc.nextLine();
            switch(cho){
                case 1:
                    x.bookRet();
                    break;
                case 2:
                    x.lostbook();
                    break;
                case 3:
                    z.lostmember();
                    break ;
                case 0:
                    break l;
                default:
                    cho=-1;
            }
        }
    }
    private void IssuCounter() {
        clrscr();
        System.out.print("Enter Borrower EmailID : ");
        String a=sc.nextLine();
        System.out.print("Enter Borrower Password : ");
        String b=sc.nextLine();
        User z=new User();
        Book y=new Book();
        int ind=z.isborrower(a);
        if(ind!=-1&&b.equals(User.bor.get(ind).pass)){
            if(z.Boorfineaun(ind)>=500){
                System.out.print("Enter Book ISBN :");
                int book_num=sc.nextInt();sc.nextLine();
                int bookind=y.isbook(book_num);
                if(bookind!=-1){
                    if(Book.books.get(bookind).quantity >=1){
                        if(User.bor.get(ind).borrowb.size()<3){
                            if(z.isbookin_borrower(book_num,ind)==-1){
                                Book.books.get(bookind).quantity--;
                                Book.books.get(bookind).borrowcount++;
                               User.bor.get(ind).borrowb.add(Book.books.get(bookind));
                                Book.books.get(bookind).borrowbook.add(User.bor.get(ind));
                                System.out.println(Book.books.get(bookind).book_name+" is Issued to "+User.bor.get(ind).name+" Successfully");
                                User.bor.get(ind).list_of_bor+=Book.books.get(bookind).book_name+"book is Issued to "+User.bor.get(ind).name+"\n";
                                enter_wait();
                            }else{
                                System.out.println("Book can't take Twice");
                                enter_wait();
                            }
                        }else{
                            System.out.println("Maximun number books has been borrowed \nReturn the books and borrow books from library!!.");
                            enter_wait();
                        }
                    }else{
                        System.out.println(Book.books.get(bookind).book_name+"book is not Avalable in Libirary");
                        enter_wait();
                    }
                }else{
                    System.out.println("Book is not Founded!!.");
                    enter_wait();
                }
            }else{
                System.out.println("Wallet amount is less than 500 \n please Add Wallet Amount");
                enter_wait();
            }
        }else{
            System.out.println("Enter Correct EmailId or Password");
            enter_wait();
        }
    }
    private void addadmin() {
        System.out.print("Enter admin name : ");
        String a=sc.nextLine();
        String b;
        int count=0;
        do{
            if(++count>1)System.out.println("User id already exist");
            System.out.print("Enter admin EmailID : ");
            b = sc.nextLine();
        }
        while(isadmin(b)!=-1);
        System.out.print("Enter admin Password : ");
        String c=sc.nextLine();
        adm.add(new Admin(a, b, c));
        enter_wait();
    }
}
