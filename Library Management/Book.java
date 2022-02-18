import java.util.*;
public class Book {
    String book_name;
    String author;
    int ISBN;
    int quantity;
    int book_price;
    int borrowcount;
    List<User>borrowbook=new ArrayList<>();
    Book(String a,String b,int c,int d,int e){
        this.book_name=a;
        this.author=b;
        this.ISBN=c;
        this.quantity =d;
        this.book_price=e;
    }
    Book(){}
    static Scanner sc=new Scanner(System.in);
    static List<Book>books=new ArrayList<>();
    static int FineperDay=2;
    static{
        books.add(new Book("The New Born", "Robert",110,6,150));
        books.add(new Book("The Animal Farm", "George orwell",125,15,168));
        books.add(new Book("High Fidelity", "Nick Hornby",155,10,176));
        books.add(new Book("Harry potter", "JK Rowling",195,17,126));
        books.add(new Book("Julius caesar", "William Shakespeare",168,20,275));
    }
    static protected void clr(){
        try{
            System.out.print("\033[H\033[2J");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    private void nextbutton() {
        System.out.println("Press ENTER to Continue..");
        sc.nextLine();
    }
    public void bookmenu() {
        clr();
        int cho=0;
        l:while(true){
            System.out.println(""" 
                        Welcome Edit menu
            1 - Add Book
            2 - Remove Book
            3 - Modify book details(Quantity and price)
            4 - Sort list by name
            5 - Sort list by Quantity
            0 - Back""");
            if(cho == -1){
                System.out.println("Please Enter a valid Choise.");
            }
            System.out.print("Choise : ");
            cho=sc.nextInt();sc.nextLine();
            switch(cho){
                case 1:
                    addbook();
                    break;
                case 2:
                    removebook();
                    break;
                case 3:
                    modify();
                    break;
                case 4:
                    for (int i=0;i<books.size();i++){
                        int min=i;
                        for (int j=i+1;j<books.size();j++){
                            if (books.get(j).book_name.compareTo(books.get(min).book_name)>0){
                                min=j;
                            }
                        }
                        Book temp=books.get(i);
                        books.set(i,books.get(min));
                        books.set(min,temp);
                    }
                    clr();
                    System.out.println("Books Sorted in Alphabetic Order");
                    printbooklist();
                    nextbutton();
                    bookmenu();
                    break;
                case 5:
                    for (int i=0;i<books.size();i++){
                        int min=i;
                        for (int j=i+1;j<books.size();j++){
                            if (books.get(j).quantity <(books.get(min).quantity)){
                                min=j;
                            }
                        }
                        Book temp=books.get(i);
                        books.set(i,books.get(min));
                        books.set(min,temp);
                    }
                    clr();
                    System.out.println("Books Sorted in by Quantity");
                    printbooklist();
                    nextbutton();
                    bookmenu();
                    break;
                case 0:
                    clr();
                    break l;
                default :
                    cho=-1;
            }
        }
    }
    private void printbooklist() {
        System.out.print("Book Name ");
        System.out.print("    Author Name ");
        System.out.print("       Book ISBN ");
        System.out.print("   Book Quantity");
        System.out.print("   Book Price");
        System.out.println();
        for(int i=0;i<books.size();i++){
            System.out.print(books.get(i).book_name+" ");
            System.out.printf("%15s",books.get(i).author+" ");
            System.out.printf("%15s",books.get(i).ISBN+" ");
            System.out.printf("%15s",books.get(i).quantity +" ");
            System.out.printf("%15s",books.get(i).book_price+" ");
            System.out.println();
        }
    }
    private void modify() {
        int attempt=0;
        while(attempt++<3){
            clr();
            System.out.print("Enter book name : ");
            String bookname=sc.nextLine();
            System.out.print("Enter book ISBN : ");
            int isbn=sc.nextInt();sc.nextLine();
            int ind=isbook(bookname);
            if(ind!=-1){
                if(books.get(ind).ISBN==isbn){
                    System.out.println("Enter Quantity of the book : ");
                    books.get(ind).quantity =sc.nextInt();
                    System.out.println("Enter Price of the book : ");
                    books.get(ind).book_price=sc.nextInt();
                    System.out.println("Book Updated Succesfully!!..");
                    nextbutton();
                    break;
                }
            }
            System.out.println("Entered Details are Wrong!!");
            nextbutton();
        }
        System.out.println("Maximum Attempts Exceeded! Please Try after sometime");
        nextbutton();
    }
    private void removebook() {
        int attempt=0;
        while(attempt++<3){
            clr();
            System.out.print("Enter book name : ");
            String bookname=sc.nextLine();
            System.out.print("Enter book ISBN : ");
            int isbn=sc.nextInt();sc.nextLine();
            int ind=isbook(bookname);
            if(ind!=-1){
                if(books.get(ind).ISBN==isbn){
                    books.remove(ind);
                    System.out.println("Book Removed Succesfully!!..");
                    nextbutton();
                    break;
                }
            }
            System.out.println("Entered Details are Wrong!!");
            nextbutton();
        }
        System.out.println("Maximum Attempts Exceeded! Please Try after sometime");
    }
    protected int isbook(String a) {
        for(int i=0;i<books.size();i++){
            if(a.equals(books.get(i).book_name)){
                return i;
            }
        }
        return -1;
    }
    protected int isbook(int a) {
        for(int i=0;i<books.size();i++){
            if(a==(books.get(i).ISBN)){
                return i;
            }
        }
        return -1;
    }
    private void addbook() {
        System.out.print("Enter Book name : ");
        String a=sc.nextLine();
        System.out.print("Enter Book Author name : ");
        String b=sc.nextLine();
        System.out.print("Enter ISBN : ");
        int c=sc.nextInt();
        System.out.print("Enter book Quantity : ");
        int d=sc.nextInt();
        System.out.print("Enter Book Price : ");
        int e=sc.nextInt();sc.nextLine();
        books.add(new Book(a, b, c, d, e));
        System.out.println("Book Added Successfully!!..");
        nextbutton();
        bookmenu();
    }
    public void booksearch() {
        while(true){
            clr();
            System.out.print("Enter book name : ");
            String bookname=sc.nextLine();
            System.out.print("Enter book ISBN : ");
            int isbn=sc.nextInt();sc.nextLine();
            int ind=isbook(bookname);
            if(ind!=-1){
                if(books.get(ind).ISBN==isbn){
                    displaybook(ind);
                }
            }
            System.out.println("Entered Book Details are Wrong!!");
            nextbutton();
        }
    }
    private void displaybook(int i) {
        System.out.print("Book Name ");
        System.out.print("    Author Name ");
        System.out.print("       Book ISBN ");
        System.out.print("  Book Quantity");
        System.out.print("  Book Price");
        System.out.println();
        System.out.print(books.get(i).book_name+" ");
        System.out.printf("%15s",books.get(i).author+" ");
        System.out.printf("%15s",books.get(i).ISBN+" ");
        System.out.printf("%15s",books.get(i).quantity +" ");
        System.out.printf("%15s",books.get(i).book_price+" ");
        System.out.println();
        nextbutton();
    }
    public void bookRet() {
        User z=new User();
        t:while(true){
            clr();
            System.out.print("Enter Borrowe's EmailID : ");
            String a=sc.nextLine();
            System.out.print("Enter Borrowe's Password : ");
            String pass=sc.nextLine();
            int ind=z.isborrower(a);
            if(ind!=-1&&pass.equals(User.bor.get(ind).pass)){
                System.out.print("Enter Book ISBN : ");
                int b=sc.nextInt();sc.nextLine();
                int bookind=isbook(b);
                if(bookind!=-1){
                    int borrowind=z.isbookin_borrower(b,ind);
                    if(borrowind!=-1){
                        int bookborrowerind=z.isbookofborrower(bookind,a);
                        if(borrowind!=-1&&bookborrowerind!=-1&&ind!=-1&&bookind!=-1){
                            System.out.print("Enter the no.of.Returning day : ");
                            int returnday=sc.nextInt();sc.nextLine();
                            if(returnday<=15){
                                books.get(bookind).quantity++;
                                User.bor.get(ind).borrowb.remove(borrowind);
                                System.out.println(Book.books.get(bookind).book_name+" is Returned by "+User.bor.get(ind).name+" Successfully");
                                books.get(bookind).borrowbook.remove(bookborrowerind);
                                // System.out.println("Book is removed Successfully");
                                nextbutton();
                                break t;
                            }else{
                                returnday-=15;
                                int res=returnday*FineperDay;
                                if(res>(int)books.get(bookind).book_price*0.8){
                                    System.out.println("Your Fine Amount is : "+(int)books.get(bookind).book_price*0.8);
                                    System.out.println("This Amount is debited in your wallet!!..");
                                    User.bor.get(ind).wallet-=(int)books.get(bookind).book_price*0.8;
                                    User.bor.get(ind).Fine+="Rs."+books.get(bookind).book_price*0.8+" is Fine for "+books.get(bookind).book_name+"\n";
                                    books.get(bookind).quantity++;
                                    User.bor.get(ind).borrowb.remove(borrowind);
                                    System.out.println(Book.books.get(bookind).book_name+" is Returned by "+User.bor.get(ind).name+" Successfully");
                                    books.get(bookind).borrowbook.remove(bookborrowerind);
                                    nextbutton();
                                    break t;
                                }else{
                                    System.out.println("Your Fine Amount is : "+res);
                                    System.out.println("This Amount is debited in your wallet!!..");
                                    User.bor.get(ind).wallet-=res;
                                    User.bor.get(ind).Fine+="Rs."+res+" is Fine for "+books.get(bookind).book_name+"\n";
                                    books.get(bookind).quantity++;
                                    User.bor.get(ind).borrowb.remove(borrowind);
                                    System.out.println(Book.books.get(bookind).book_name+" is Returned by "+User.bor.get(ind).name+" Successfully");
                                    books.get(bookind).borrowbook.remove(bookborrowerind);
                                    nextbutton();
                                    break t;
                                }
                            }
                        }else{
                            System.out.println("Enter Details are Wrong!!.");
                            nextbutton();
                        }
                    }else{
                        System.out.println("Book is not Borrowed By that Borrower!!..");
                        nextbutton();
                    }
                }else{
                    System.out.println("ISBN no : "+(b)+" is not avalable in Library ");
                    nextbutton();
                }
            }else{
                System.out.println("Enter Correct EmailId or Password!!.");
                nextbutton();
            }
        }
    }
    public void lostbook() {
        User z=new User();
        t:while(true){
            clr();
            System.out.print("Enter Borrower's EmailID : ");
            String a=sc.nextLine();
            System.out.print("Enter Borrower's Password : ");
            String pass=sc.nextLine();
            int ind=z.isborrower(a);
            if(ind!=-1&&pass.equals(User.bor.get(ind).pass)){
                System.out.print("Enter Book ISBN : ");
                int b=sc.nextInt();sc.nextLine();
                int bookind=isbook(b);
                if(bookind!=-1){
                    int borrowind=z.isbookin_borrower(b,ind);
                    if(borrowind!=-1){
                        int bookborrowerind=z.isbookofborrower(bookind,a);
                        if(borrowind!=-1&&bookborrowerind!=-1&&ind!=-1&&bookind!=-1){
                            System.out.println("Your Fine Amount is : "+(int)books.get(bookind).book_price*0.5+"for lost"+books.get(bookind).book_name+" book");
                            System.out.println("This Amount is debited in your wallet!!..");
                            User.bor.get(ind).wallet-=(int)books.get(bookind).book_price*0.5;
                            User.bor.get(ind).Fine+="Rs."+books.get(bookind).book_price*0.5+" is Fine for lost "+books.get(bookind).book_name+" book\n";
                            User.bor.get(ind).borrowb.remove(borrowind);
                            books.get(bookind).borrowbook.remove(bookborrowerind);
                            nextbutton();
                            break t;
                        }else{
                            System.out.println("Enter Details are Wrong!!.");
                            nextbutton();
                        }
                    }else{
                        System.out.println("Book is not Borrowed By that Borrower!!..");
                        nextbutton();
                    }
                }else{
                    System.out.println("ISBN no : "+(b)+" is not avalable in Library ");
                    nextbutton();
                }
            }else{
                System.out.println("Enter Correct EmailId or Password!!.");
                nextbutton();
            }
        }
    }
    public void borrowcount() {
        for (int i=0;i<books.size();i++){
            int min=i;
            for (int j=i+1;j<books.size();j++){
                if (books.get(j).borrowcount>(books.get(min).borrowcount)){
                    min=j;
                }
            }
            Book temp=books.get(i);
            books.set(i,books.get(min));
            books.set(min,temp);
        }
        clr();
        System.out.println("Books Sorted in borrow count in high's borrowed count to least borrowed count");
        printbooklist();
        nextbutton();
        Admin z=new Admin();
        z.reportmenu();
    }
}
