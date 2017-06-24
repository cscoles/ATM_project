/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author cdsyc8
 */
public class Account implements Serializable
{
    public Account()
    {
        balance = 100;
        interest = 0.05;
        Date initDate = new Date();
    }
    
    protected double balance;
    protected double interest;
    protected Date initDate;
    protected int firstdate;
    protected int seconddate;
    protected Calendar cal1 = new GregorianCalendar();
    protected Calendar cal2 = new GregorianCalendar();
    protected boolean dateflag = false;
//if (mychar == "d" || my char == "D")
//{
//    deposit();
//}
//else if (mychar == "w" || mychar == "W")
//{
//    withdraw();
//}
//else if (my char == "c" || mychar == "C")
//{
//    checkBalance();
//}

    void deposit() throws IOException
    {
        if(dateflag == true)
        {
            getDate2();
            getInterest();
        }
        else
        {
            getDate1();
        }

        BufferedReader br;
        String entered_amount;

        System.out.print("How much would you like to deposit?");
        br = new BufferedReader (new InputStreamReader(System.in));
        entered_amount = br.readLine();
        double deposit = Double.parseDouble(entered_amount);
               
        
            balance = balance + deposit;
            System.out.println("New balance: " + formatMoney(balance));
            System.out.println("Your Money has been successfully depsited");
    }

    public void withdraw() throws IOException
    {
       if(dateflag == true)
        {
            getDate2();
            getInterest();
        }
        else
        {
            getDate1();
        }

        BufferedReader br;
        String entered_amount;

        System.out.println("How much would you like to withdraw?");
        System.out.println("");
        br = new BufferedReader (new InputStreamReader(System.in));
        entered_amount = br.readLine();
        double withdraw = Double.parseDouble(entered_amount);
        if(balance >= withdraw)       
        {
            balance = balance - withdraw;
            System.out.println("New balance: " + formatMoney(balance));
            System.out.println("Please collect your money");
        }
        else
        {
            System.out.println("Insufficient Balance");
        }                
    }

    void checkBalance() throws IOException
    {
        if(dateflag == true)
        {
            getDate2();
            getInterest();
        }
        else
        {
            getDate1();
        }

        String currbal = formatMoney(balance);
        System.out.println("Your balance is:" + currbal);

    }

    private void getDate1() throws IOException
    {
        System.out.print("Enter todays date(mm/dd/yyyy): ");
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        String inputText = br.readLine();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse(inputText, pos);
        cal1.setTime(date);

        firstdate = cal1.get(Calendar.DAY_OF_YEAR);
        dateflag = true;
    }

    private void getDate2() throws IOException

    {
        System.out.print("Enter todays date(mm/dd/yyyy): ");
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        String inputText = br.readLine();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        ParsePosition pos = new ParsePosition(0);
        Date date= new Date();
        date = formatter.parse(inputText, pos);

        cal2.setTime(date);
        int seconddate = cal2.get(Calendar.DAY_OF_YEAR);


            if (firstdate > seconddate) 
            {
                System.out.println("You must enter a future date.");
                getDate2();
            }
    }

    void getInterest() throws IOException
    {
        int seconddate = cal2.get(Calendar.DAY_OF_YEAR);
        int datediff = seconddate - firstdate;
        double rate = .10/365;
        double ratetime = Math.pow(1+rate,datediff);
        double newInterest = balance * ratetime;
        System.out.println("Current interest: " + formatMoney(newInterest));
    }

    public String formatMoney(double amount) throws IOException
    {
        NumberFormat currencyFormatter;
        String currencyOut;

        currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        currencyOut = currencyFormatter.format(amount);

        return currencyOut;
    }


}