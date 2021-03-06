/**
 *  SimpleIOMath prints a conversation the computer has with a user
 *  while asking the user to input numerical data.
 * @version 09/27/2021
 * @author 22yancy
 */
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class SimpleIOMath {
    private static String name;
    private static int age;
    private static int favNumber;

    private int smallestPrime(int num)  {
        for(int i = 2; i <= (int)(Math.sqrt(num))+1; i++)   {
            if(num % i == 0)
                return i;
        }
        return num;
    }

    /**
     * Asks the user questions and stores the answer
     */
    public void promptUser()    {
        Scanner input = new Scanner(System.in);
        System.out.println("Question 1: What is your name?");
        name = input.nextLine();
        System.out.println("Question 2: How old are you?");
        age = input.nextInt();
        System.out.println("Question 3: What is your favorite number?");
        favNumber = input.nextInt();
    }
    /**
    * Asks the user who their favorite person is
    */
    public void myExtra()   {
        Scanner input = new Scanner(System.in);
        System.out.println("Before we continue, lets ask an important question.");
        System.out.println("But first, let me make a little suggestion.");
        System.out.println("Choose your answer carefully");
        System.out.println("Choose you answer wisely");
        System.out.println("The consequences to your actions could be quite jostling");
        System.out.println("Who is your favorite person, after James Gosling?");
        String ans = input.nextLine();
        ans = ans.substring(0,1).toUpperCase() + ans.substring(1);
        String rans = "Michael";
        if(Objects.equals(ans, rans)) {
            System.out.println("That is correct!");
        }   else    {
            System.out.println(ans + " is not your favorite person; Michael is, silly!");
        }
    }

    /**
     * Prints the necessary info
     */
    public void printInfo() {
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.println("At your next birthday, you will turn " + (age + 1));
        System.out.println("The first prime factor of " + age + " is: " + smallestPrime(age));
        System.out.println("Your favorite number squared is: " + (favNumber * favNumber));
    }

    /**
     * Main entry point for class SimpleIOMath
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("* Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me");
        SimpleIOMath obj = new SimpleIOMath();
        obj.promptUser();
        obj.myExtra();
        System.out.println("I'm gonna teach you how to sing it out");
        System.out.println("Come on, come on, come on");
        System.out.println("Let me tell you what it's all about");
        System.out.println("Reading, writing, arithmetic");
        System.out.println("Are the branches of the learning tree");
        obj.printInfo();
        System.out.println("* end of program *");
    }
}
