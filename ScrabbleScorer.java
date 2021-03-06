import java.io.File;
import java.util.*;

/**
 * ScrabbleScorer opens a dictionary and returns a summed value of points awarded for each letter in a word.
 * @version Monday 01/24/2021
 * @author 22yancy
 */

public class ScrabbleScorer {
    private ArrayList<String> dictionary;
    private int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    private String alpha;

    /**
     * constructor for ScrabbleScorer.java
     */
    public ScrabbleScorer()   {
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        buildDictonary();
    }

    /**
     * Builds the dictionary i.e. opens the data file and imports scrabble
     * words and puts it in the dictionary array list
     */
    public void buildDictonary()    {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while(sc.hasNextLine()) {
                dictionary.add(sc.next());
            }
            sc.close();
            Collections.sort(dictionary);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        //use try/catch
        //use a Scanner
        //read data file
        //when file is read into dictionary, close stream
    }

    /**
     * Validates whether the input word is in the dictionary list
     * @param word user's input
     * @return returns true or false for whether the word is in the dictionary
     */
    public boolean isValidWord(String word) {
        return Collections.binarySearch(dictionary, word) >= 0;
    }

    /**
     * parse word one letter at a time -- for loop ""+charAt or substring
     * find the index of each letter
     * add the corresponding score/point value from the
     * @param word user's input
     * @return returns the sum of the point value of the input word
     */
    public int getWordScore(String word)    {
        int sum = 0;
        for(int i = 0; i <= word.length()-1; i++)   {
            int num = points[alpha.indexOf("" + word.charAt(i))];
            sum += num;
        }
        return sum; //sum of the point value of that word
    }

    /**
     * Main method calls supporting methods to respond to input
     * and responds with the necessary output
     * @param args
     */
    public static void main(String[] args) {
        ScrabbleScorer app = new ScrabbleScorer();
        System.out.println("* Welcome to the Scrabble Word Scorer app *");
        String userWord;
        Scanner userIn = new Scanner(System.in);
        try {
            while(true) {
                System.out.print("Enter a word to score or 0 to quit: ");
                userWord = userIn.nextLine();
                if(userWord.equals("0"))
                    break;
                else    {
                    if(app.isValidWord(userWord.toUpperCase()))   {
                        System.out.println(userWord);
                        System.out.println(app.getWordScore(userWord.toUpperCase()));
                    }
                    else{
                        System.out.println(userWord + " is not a valid word in the dictionary");
                    }
                }
            }
        }
        catch(Exception e)  {
            e.printStackTrace();
        }
        System.out.println("Exiting the program thanks for playing");
    }
}

