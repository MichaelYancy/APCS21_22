import javax.swing.*;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

/**
 * ScrabbleRackManager establishes a dictionary array list filled with eligible words for scrabble
 * and establishes a rack of seven random letters and then tests to see which words can be made from those letters.
 * @version 03/25/2022
 * @author 22yancy 
 */
public class ScrabbleRackManager {
    ArrayList<ArrayList<String>> dictionary;
    ArrayList<String> tileRack;
    private String  alpha;

    /** class constructor */
    public ScrabbleRackManager()    {
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        dictionary = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < 26; i++)
            dictionary.add(new ArrayList<String>());
        buildDictionary();
        buildTileRack();
    }

    private void buildDictionary()  {
        try {
            Scanner filein = new Scanner(new File("SCRABBLE.txt"));
            while(filein.hasNext()) {
                String temp = filein.nextLine();
                dictionary.get(alpha.indexOf(temp.charAt(0))).add(temp);
            }
            filein.close();
        }
        catch(Exception e)  {
            System.out.println("Error opening file see here: " + e);
        }
    }

    private void buildTileRack()    {
        tileRack = new ArrayList<String>();
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] frequencies = {9, 2, 2, 4, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2, 2, 1, 2, 1};
        ArrayList<String> allTiles = new ArrayList<>();
        int index = 0;
        for(int count : frequencies)    {
            for (int i = 0; i < count; i++) {
                allTiles.add(alpha.substring(index, index + 1));
            }
            index++;
        }
        // randomly shuffle the tiles
        Collections.shuffle(allTiles);
        // now pick seven out from the virtual pile of tiles
        for(int i = 0; i < 7; i++)
            tileRack.add(allTiles.remove((int)(Math.random()*allTiles.size())));
    }

    /** displays the contents of the player's tile rack */
    public void printRack() {
        System.out.println("Letters in the rack: " + tileRack);
    }

    /** builds and returns an ArrayList of String objects that are values pulled
     from
     * the dictionary/database based on the available letters in the user's tile
     * rack */
    public ArrayList<String> getPlaylist()  {
        ArrayList<String> plays = new ArrayList<>();
        for(ArrayList<String> bucket : dictionary)  {
            for(String word : bucket)   {
                if(isPlayable(word))
                    plays.add(word);
            }
        }
        return plays;
    }

    private boolean isPlayable(String word) {
        ArrayList<String> rackCopy = new ArrayList<>(tileRack);
        for(int i = 0; i < word.length(); i++)  {
            if(!(rackCopy.remove("" + word.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    /** print all of the playable words based on the letters in the tile rack */
    public void printMatches()  {
        ArrayList<String> plays = getPlaylist();
        boolean bingo = false;
        System.out.println("You can play the following words from the letters in your rack: ");
        if(plays.isEmpty())
            System.out.println("Sorry, NO words can be played from these tiles.");
        for(int i = 0; i < plays.size(); i++)   {
            String word = plays.get(i);
            if(word.length() == 7)  {
                word += "*";
                bingo = true;
            }
            System.out.printf("%-10s", word);
            if((i+1) % 10 == 0)
                System.out.println();
        }
        if(bingo)
            System.out.println("\n* Denotes BINGO");
    }

    /** main method for the class; use only 3 command lines in main
     * @param args commandd line arguments if needed
     */
    public static void main(String[] args){
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();
    }
}
