import java.util.*;
public class ATM{
    static int num,user1,amount,admin_co,contin,amount_succ,saving,press,deposit,conti;
    static int current,sav_amo,total_amt,total_amt200,total_amt500,total_amt2000,total_amt100;
    static int arr[]={0,0,0,0};
    static String name,admin_id,admin_pass,pass;
    static Scanner sc=new Scanner(System.in);
    public static void clear(){ 
        System.out.println("\033[H\033[2J");
    }
    public static void user(){ //This method is used for the user condition. 
        clear();
        System.out.print("ENTER USER ID : "); 
        name=sc.next();
        System.out.print("ENTER 4 DIGIT PIN: ");
        pass=sc.next();
        if(name.equals("user")&&(pass.equals("1234"))){ //Checking whether the  user id and password is  correct.
        clear();
        System.out.println("\t\t******* WELCOME USER ********");
        System.out.println("1.WITHDRAWL AMOUNT");
        System.out.println("2.AVAILABLE AMOUNT");
        System.out.println("3.CHANGE PIN");
        System.out.println("4.DIRECT DEPOSIT");
        System.out.println("5.EXIT");
        System.out.print("ENTER YOUR CHOICE: ");
        user1=sc.nextInt();
        switch(user1){
            case 1:
            withdrawl(); //Withdrawl function is called for the case 1.
            break;
            case 2:
            available_amount(); // Available amount function is called for the case 2.
            break;
            case 3:
            clear();
            //chan_pin(); 
            break;
            case 4:
            clear();
            deposit(); //Deposit function is called Here.
            break;
            case 5:
            clear();
            main2(); //When is needed to exit from the menu it will be called.
            break;
        }
        }else{ //When the user is enter the wrong id or pin atm will show an below on.
            System.out.println("------------PLEASE ENTER THE CORRECT USER ID AND PIN----------");
            clear();
            user();
        }
    }
    public static void withdrawl(){  //This method is used to Withdrawl the money for the ATM.
        clear();
        int amount_avail=10000;
        System.out.print("ENTER THE AMOUNT : ");
        amount=sc.nextInt();
        if(amount<amount_avail && amount<total_amt){ //Checking  whether there is Money in the Account and ATM.
            System.out.print("\t\t\t********** PLEASE COLLECT YOU CASH ***********");  
            main2(); //After collecting the cash the main methos is called.
        }
        else{
            System.out.println("\t\t************ INSUFFICENT BALANCE *********");
            main2();
        }  
    }
    public static void available_amount(){ //This method is used to check the available Amount.
        clear();
        int amount_avail=10000;
        int afterwith=amount_avail-amount;
        if(afterwith==13700){
            System.out.println("AVAILABLE AMOUNT: "+afterwith);
        }else{
            System.out.println("AVAILABLE AMOUNT: "+afterwith);
        }
        main2(); //After checking the Available Amount main method is called.
    }
    public static void deposit(){ //Used for deposting the money
        int amount_avail=10000;
        System.out.print("ENTER THE DEPOSIT AMOUNT: ");
        deposit=sc.nextInt();
        amount_avail+=deposit;
        System.out.println("AMOUNT IS DEPOSITED SUCCESSFULLY\n");
        System.out.println("AVAIABLE AMOUNT: "+amount_avail);
        System.out.println("PRESS 1 TO CONTINUE: ");
        contin=sc.nextInt();
        if(contin==1){
            user();
        }else{
            main2();
        }
    }
    public static void admin(){  //Admin Method
        clear(); //This function is used to clear page.
        System.out.println("\t\t\t********** WELCOME YOU ADMIN ! ! ! **********");
        System.out.print("ENTER ADMIN ID: ");
        admin_id=sc.next();
        System.out.print("ENTER ADMIN PASSWORD: ");
        admin_pass=sc.next();
        if(admin_id.equals("admin") && admin_pass.equals("1234")){ //Checking whether Admin id and password is correct or Not.
            clear();
            System.out.println("\t\t\t********** WELCOME YOU ADMIN ! ! ! **********");
            System.out.println("1.ADD CASH");
            System.out.println("2.AVAILABLE AMOUNT");
            System.out.println("3.EXIT");
            System.out.print("ENTER YOUR CHOICE: ");
            admin_co=sc.nextInt();
            switch(admin_co){
                case 1:
                add_cash(); //add_cash function is called to add the  cash to the ATM.
                break;
                case 2:
                atm_cap(); //This function is used to check the ATM capacity.
                break;
                case 3:
                clear();
                main2(); //Going to the previous menu.
                break;
            }
        }else{ //This conditon will run when the admin enter the Invalid one.
            System.out.println("--------- INVALID INPUT ! ! ! ------");
            main2();
        }
    }
    public static void add_cash(){ //Filling cash to the ATM
        clear();
        System.out.println("ADD NUMBER OF NOTES.");
        System.out.print("2000 =>");
        arr[0]=sc.nextInt();
        System.out.print("500  =>");
        arr[1]=sc.nextInt();
        System.out.print("200  =>");
        arr[2]=sc.nextInt();
        System.out.print("100  =>");
        arr[3]=sc.nextInt();
        System.out.println("AMOUNT ARE ADD SUCCESSFULLY.\n");
        System.out.println("PRESS 1 TO CONTINUE");
        amount_succ=sc.nextInt();
        if(amount_succ==1){
            clear();
            admin();
        }else{
            clear();
            add_cash();
        }
    }
    public static void atm_cap(){     // This method is used to check the ATM capacity.
        clear();
        System.out.println("AVAILABLE AMOUNT ARE: ");
        System.out.println("2000 =>"+arr[0]);
        System.out.println("500  =>"+arr[1]);
        System.out.println("200  =>"+arr[2]);
        System.out.println("100  =>"+arr[3]);
        total_amt2000=(arr[0]*2000);
        System.out.println("AMOUNT AVAILABLE IN 2000: "+total_amt2000);
        total_amt500=(arr[1]*500);
        System.out.println("AMOUNT AVAILABLE IN 500: "+total_amt500);
        total_amt200=(arr[2]*200);
        System.out.println("AMOUNT AVAILABLE IN 200: "+total_amt200);
        total_amt100=(arr[3]*100);
        System.out.println("AMOUNT AVAILABLE IN 100: "+total_amt100);
        total_amt=((arr[0]*2000)+(arr[1]*500)+(arr[2]*200)+(arr[3]*100)-amount);
        System.out.println("TOTAL AMOUNT: "+total_amt);
        System.out.println("PRESS 1 TO CONTINUE");
        press=sc.nextInt();
        if(press==1){
            clear();
            main2();
        }else{
            clear();
            atm_cap();
        }
    }
    public static void main2(){
        System.out.println("\t\t*********** WELCOME YOU *************\n");
        System.out.println("\t\t     PLEASE INSERT THE CARD  ! ! ! \n");
        System.out.println("PRESS 1 TO CONTINUE");
        contin=sc.nextInt();
        if(contin==1){
        System.out.println("\033[2J\033[H");
        System.out.println("1.USER LOGIN");
        System.out.println("2.ADMIN LOGIN");
        System.out.println("3.Exit");
        System.out.print("ENTER YOUR CHOICE : ");
        num=sc.nextInt();
        switch(num){
            case 1:
            user();
            break;
            case 2:
            admin();
            break;
            case 3:
            clear();
            main2();
            break;
        }
        }
        else{
            clear();
            main2();
        }
    }
    public static void main(String[] args){     //Main Method
    System.out.println("\t\t*********** WELCOME YOU *************\n");
    System.out.println("\t\t     PLEASE INSERT THE CARD  ! ! !\n");
    System.out.println("PRESS 1 TO CONTINUE");
    contin=sc.nextInt();
    if(contin==1){
    System.out.println("\033[2J\033[H");
    System.out.println("1.USER LOGIN");
    System.out.println("2.ADMIN LOGIN");
    System.out.println("3.Exit");
    System.out.print("ENTER YOUR CHOICE : ");
    num=sc.nextInt();
    switch(num){
        case 1:
        user(); //User method is called for  user login.
        break;
        case 2:
        admin(); //Admin method is called for admin login.
        break;
        case 3:
        clear();
        main2();
        break;
    }
    }
    else{
        clear();
        main2();
    }
    }
}