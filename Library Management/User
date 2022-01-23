import java.util.*;
public class User {
    String name;
    String EmailId;
    String pass;
    int wallet;
    String list_of_bor;
    String Fine;
    List<Book>borrowb=new ArrayList<>();
    public User(String a,String b,String c){
        this.name=a;
        this.EmailId=b;
        this.pass=c;
        this.list_of_bor="";
        this.Fine="";
        this.wallet=1000;
    }
    public User(){}
    static Scanner sc=new Scanner(System.in);
    static List<User>bor= new ArrayList<>();
    static {
        bor.add(new User("Nithish", "nithish", "1234"));

    }
    void clr(){
        try{
            System.out.print("\033[H\033[2J");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void addbook() {
        System.out.print("Enter Borrower name : ");
        String a=sc.nextLine();
        String b;
        int count=0;
        do{
            if(++count>1)System.out.println("User id already exist");
            System.out.print("Enter admin EmailID : ");
            b = sc.nextLine();
        }
        while(isborrower(b)!=-1);
        System.out.print("Enter password : ");
        String c=sc.nextLine();
        bor.add(new User(a, b, c));
        enter_wait();
    }
    public void Userlogin() {
        int attempt=0;
        while(attempt++<3){
            clr();
            System.out.println("WELCOME Borrower");
            System.out.print("Enter your EmailID : ");
            String a=sc.nextLine();
            System.out.print("Enter your Password : ");
            String b=sc.nextLine();
            int ind = isborrower(a);
            if(ind!=-1){
                if(bor.get(ind).pass.equals(b)){
                    borrowermenu(ind);
                    break;
                }
            }
            System.out.println("Entered Credentials are Wrong");
            enter_wait();
        }
        System.out.println("Maximum Attempts Exceeded! Please Try after sometime");
        enter_wait();
    }
    private void borrowermenu(int ind) {
        while(true){
            clr();
            int cho=0;
            System.out.println("Welcome");
            System.out.println("""
            1 - List of Borrows
            2 - Current Borrows
            3 - Fine History
            4 - Wallet
            0 - Back""");
            if(cho==1){
                System.out.println("Enter valid Choice!!..");
            }
            System.out.print("Choice : ");
            cho=sc.nextInt();sc.nextLine();
            switch(cho){
                case 1:
                    clr();
                    if(0==bor.get(ind).list_of_bor.length())System.out.println("No History of Borrowes avalable");
                    System.out.println(bor.get(ind).list_of_bor);
                    enter_wait();
                    break;
                case 2:
                    clr();
                    if(bor.get(ind).borrowb.size()==0){
                        System.out.println("There is no Current borrows Avalable!!..");
                        enter_wait();
                        break;
                    }
                    System.out.print("Book Name ");
                    System.out.print("    Author Name ");
                    System.out.print("       Book ISBN ");
                    System.out.print("   Book Price");
                    System.out.println();
                    for(int i=0;i<bor.get(ind).borrowb.size();i++){
                        System.out.print(bor.get(ind).borrowb.get(i).book_name+" ");
                        System.out.printf("%15s",bor.get(ind).borrowb.get(i).author+" ");
                        System.out.printf("%15s",bor.get(ind).borrowb.get(i).ISBN+" ");
                        System.out.printf("%15s",bor.get(ind).borrowb.get(i).book_price+" ");
                        System.out.println();
                        enter_wait();
                    }
                    break;
                case 3:
                    clr();
                    if(0==bor.get(ind).Fine.length())System.out.println("No Fine History avalable");
                    System.out.println(bor.get(ind).Fine);
                    enter_wait();
                    break;
                case 4:
                    Wallet(ind);
                    break;
                case 0:
                    Main z=new Main();
                    z.login();
                    break;
                default:
                    cho=-1;
            }
        }
    }
    private void Wallet(int i) {
        int cho=0;
        t:while(true){
            clr();
            System.out.println("Your Wallet amount is = "+bor.get(i).wallet);
            System.out.println("""
            1 - Add money
            0 - Back""");
            if(cho==-1){
                System.out.println("Enter valid Choice!!..");
            }
            cho=sc.nextInt();
            switch(cho){
                case 1:
                    System.out.print("Enter money to add in wallet : ");
                    bor.get(i).wallet+=sc.nextInt();sc.nextLine();
                    System.out.println("Amount Added Succesfully!.");
                    enter_wait();
                    break t;
                case 0:
                    break;
            }
        }
    }
    protected int isborrower(String a) {
        for(int i=0;i<bor.size();i++){
            if(a.equals(bor.get(i).EmailId)){
                return i;
            }
        }
        return -1;
    }
    void enter_wait() {
        System.out.print("Press ENTER to Continue!!..");
        sc.nextLine();
    }
    public int Boorfineaun(int ind) {
        return bor.get(ind).wallet;
    }
    public int isbookin_borrower(int book_num,int ind) {
        for(int i=0;i<bor.get(ind).borrowb.size();i++){
            if(book_num==bor.get(ind).borrowb.get(i).ISBN)return i;
        }
        return -1;
    }
    public int isbookofborrower(int bookind, String a) {
        for(int i=0;i<Book.books.get(bookind).borrowbook.size();i++){
            if(Book.books.get(bookind).borrowbook.get(i).EmailId.equals(a))return i;
        }
        return -1;
    }
    public void lostmember() {
        Admin z=new Admin();
        int attempt=0;
        while(attempt++<3){
            clr();
            System.out.print("Enter your EmailID : ");
            String a=sc.nextLine();
            System.out.print("Enter your Password : ");
            String b=sc.nextLine();
            int ind = isborrower(a);
            if(ind!=-1){
                if(bor.get(ind).pass.equals(b)){
                    bor.get(ind).wallet-=10;
                    bor.get(ind).Fine+="rs.10 fine for losting membership card of library\n";
                    System.out.println("Member ship card is re-issued and fine for losting membershipcard is rs.10");
                    System.out.println("rs.10 is debited from your wallet!..");
                    enter_wait();
                    z.adminmenu();
                }
            }
            System.out.println("Entered detais are Wrong or He is not a member in this Library");
            enter_wait();
        }
        System.out.println("Maximum Attempts Exceeded! Please Try after sometime");
        enter_wait();
    }
    public void bookborrowlist() {
        Book z=new Book();
        Admin x=new Admin();
        int attempt=0;
        a:while(attempt++<3){
            clr();
            System.out.print("Enter book ISBN : ");
            int isbn=sc.nextInt();sc.nextLine();
            int ind=z.isbook(isbn);
            if(ind!=-1){
                if(Book.books.get(ind).ISBN==isbn){
                    if(Book.books.get(ind).borrowbook.size()==0){
                        System.out.println("This book is not Borred By any one");
                        enter_wait();
                        break a;
                    }
                    System.out.println("Borrower name        Barrower EmailID");
                    for(int i=0;i<Book.books.get(ind).borrowbook.size();i++){
                        System.out.print(bor.get(i).name);
                        System.out.printf("%15s",bor.get(i).EmailId+"\n");
                    }
                    enter_wait();
                    x.reportmenu();
                }
            }
            System.out.println("Entered Book Details are Wrong!!");
            enter_wait();
        }
    }
}
