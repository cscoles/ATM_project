/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cdsyc8
 */

public class ATM_Transaction
{
    public ATM_Transaction (Account account)
    { 
        boolean go=true;
        Scanner s = new Scanner(System.in);
        while(go)
        {
            System.out.println("Automated Teller Machine");
            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 2 for Deposit");
            System.out.println("Choose 3 for Check Balance");
            System.out.println("Choose 4 for Interest");
            System.out.println("Choose 5 for EXIT");
            System.out.print("Choose the operation you want to perform: ");
            int n = s.nextInt();
            switch(n)
            {
                case 1:
                try {
                    account.withdraw();
                } catch (IOException ex) {
                    Logger.getLogger(ATM_Transaction.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
 
                case 2:
                try {
                    account.deposit();
                } catch (IOException ex) {
                    Logger.getLogger(ATM_Transaction.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
 
                case 3:
                try {
                    account.checkBalance();
                } catch (IOException ex) {
                    Logger.getLogger(ATM_Transaction.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                case 4:
            
                try {
                    account.getInterest();
                } catch (IOException ex) {
                    Logger.getLogger(ATM_Transaction.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                
                    
                case 5:
//                System.exit(0);
                go=false;
                
            }
           
        }
    }
}
    

