import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *  BMICalculator will handle input of feet'inches", convert that height into inches,
 *  then calculates the user's BMI by converting weight to kg and using the equation weight/height
 *  and prints it out.
 * @version 11/09/2021
 * @author 22yancy
 */
public class BMICalculator {
    /** Convert English to metric units, perform the BMI calculation.
     * NOTE: the method must properly handle bad data */
    public static double computeBMI(int inches, int pounds) {
        //1 inch == 0.0254 meters
        //1 pound == 0.454 kg
        if(inches <= 0 || pounds < 0)
            return 0;
        return pounds*.454 / Math.pow(inches*.0254, 2);
    }

    /**
     * Converts feet'inches" to inches and returns the value.
     * @param value
     * @return
     */
    public int extractInches(String value) {
        int qtPos = value.indexOf("'");
        int dblQtPos = value.indexOf("\"");
        if (qtPos == -1 || dblQtPos == -1) {
            return -1;
        }
        int feet = Integer.parseInt(value.substring(0, qtPos));
        int inches = Integer.parseInt(value.substring(qtPos + 1, dblQtPos));
        if (inches < 0 || inches > 11 || feet < 0)
            return -1;
        return feet * 12 + inches;
    }

    /**
     * Main entry point for BMICalculator: Uses a Scanner to prompt the user for info,
     * process the feet/inches conversion, calls the computeBMI method and prints the correct information.
     * @param args
     */
    public static void main(String[] args)  {
        BMICalculator obj = new BMICalculator();
        Scanner in = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        int weight;
        while(true) {
            String age = null;
            try {
                System.out.print("How old are you?");
                age = in.nextLine();
                System.out.print("Enter your height in the format ft'in\" (Example: 6'1\"): ");
                String height = in.nextLine();
                int inches = obj.extractInches(height);
                System.out.print("Enter your weight in pounds: ");
                weight = in.nextInt();
                // print BMI here
                System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " + df.format(computeBMI(inches, weight)) + " kg/m^2");

            } catch (Exception e) {
                System.err.println("You made an error. So did your mom " + age + " years ago.");
            }
            //I cannot figure out why this is not working.
            System.out.print("Continue (Y/N): ");
            String cont = in.nextLine();
            if(!cont.toLowerCase().equals("y"))
                break;
        }
        System.out.println("End of program");
    }
}

