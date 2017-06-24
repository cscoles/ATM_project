/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author cdsyc8
 */
public class ATM 
{
//    Account acct1 = new Account();
//    Account acct2 = new Account();
//    Account acct3 = new Account();
//    Account[] acctArray = {acct1, acct2, acct3};
    Account[] acctArray = new Account[3];
    public static Scanner sc = new Scanner(System.in);
    static boolean acctsLoaded = false;
    static boolean acctsPop = false;
    
    public static void main(String[] args) throws Exception
    {
        ATM myATM = new ATM();
        int input = -99;
        do
        {
            System.out.println("1) Load Accounts");
            System.out.println("2) Populate Accounts");
            System.out.println("3) Select Accounts");
            System.out.println("4) Save Accounts");
            System.out.println("5) Exit");

            input = sc.nextInt();
            switch (input)
            { 
                case 1:
                myATM.loadAccounts();
                break;
                case 2:
                myATM.populateAccounts();
                break;
                case 3:
                myATM.selectAccounts();
                break;
                case 4:
                myATM.saveAccount();
                System.exit(0);
                case 5:
                System.exit(0);
                
           }
            
        }while(input !=5);
               
    }
    
    public void loadAccounts()
    {
       try
       {
        FileInputStream inStream = new FileInputStream ("C:\\Users\\Dennis\\Desktop\\ATM_ASSIGNMENT\\src\\account_list.txt");  //"C:\\Users\\cscoles\\Desktop\\ATM_ASSIGNMENT\\src\\file.out
        ObjectInputStream is=new ObjectInputStream(inStream);
        acctArray =(Account[]) is.readObject();
        is.close();
       }
       catch (Exception ioe)
       {
           System.out.println(ioe.getMessage());
       }
       acctsLoaded = true;

    }
            
    public void populateAccounts()
    {
        if(acctsPop)
        {
            System.out.println("Accounts have already been created.");
        }
        else
        {
            for(int i=0; i<acctArray.length;i++)
            {
                acctArray[i] = new Account();

                acctsPop = true;
            }
        }
    }
            
    public void selectAccounts()
    {
        boolean goAgain = true;
        int input = 0;
        while (goAgain)
            
        {
            System.out.println("0 -Account0");
            System.out.println("1 - Account1");
            System.out.println("2 - Account2");
            System.out.println("-99 - Exit");
            input = sc.nextInt();
            Account account;
            ATM_Transaction transaction;
            switch (input)
            { 
                case 0:
                account = acctArray[0];
                transaction = new ATM_Transaction(account);
                break;
                case 1:
                account = acctArray[1];
                transaction = new ATM_Transaction(account);
                break;
                case 2:
                account = acctArray[2];
                transaction = new ATM_Transaction(account);
                break;
                case -99:
                goAgain = false;
                
           }
            
        }
        
    }
    
    public void saveAccount()
    {
        try
        {
            FileOutputStream outStream = new FileOutputStream("C:\\Users\\Dennis\\Desktop\\ATM_ASSIGNMENT\\src\\account_list.txt");
            ObjectOutputStream os=new ObjectOutputStream(outStream);
            os.writeObject(acctArray);
            os.flush();
            os.close();
        }
        catch(IOException ioe)
        {
            System.err.println(ioe);
        }    
    }
            
    public void startMenu() throws IOException
    {
        int input;
        Scanner sc = new Scanner(System.in);
        
    }
}