/*
Game class - guess the word

In this game, the user has to input a series of words into a word list and try to guess the words in said word list. The user can also start a new game that will take a word from the wordlist and make the layer guess what it is. The user can also quit the game at any point. 

Classes:
- Game

Method: 
- play()
- addWord()
- ldr()

Author - Zaira Ganga, Kelsey Wang, and Keira Wong

Change history:
5/13: Created
5/26: testing
5/31: demoed and after school, adding in more of the requirements
*/


import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;


public class Game {
  private ArrayList<String> wrdBnk;
  private ArrayList<String> lttrs;
  private ArrayList<String> dfltWrds;
  private String crrntWrd;
  private String shw;
  Scanner scan = new Scanner(System.in);
  private String gss;
  private int mx; 
  HashMap<String, Integer> ldrbrd = new HashMap<String, Integer>();
  
  //private HashMap<String, String> facts;


  // Constructor, to initialize the instance variable
  public Game(){
  
    wrdBnk = new ArrayList<>();
    lttrs = new ArrayList<>();
    mx = 100;
    dfltWrds = new ArrayList<>();
    dfltWrds.add("onomatopoeia");
    dfltWrds.add("sangfroid");
    dfltWrds.add("alliteration");
    dfltWrds.add("technology"); 
  }

  // Method that allows user to enter words and code checks if letter 
  public void play(){
    if (wrdBnk.size() == 0){
      System.out.println("there are no words inside the WORD BANK. Please add words to play.");
      return;
      }
    
    /* This line of code is returned if the player does not input a word to the now defunct original value of wrdBnk. Now replaced with arrayList wrdBnk */
    
    lttrs.clear();
    crrntWrd = wrdBnk.get(Utils.randInt(0, wrdBnk.size() - 1));
    shw = "";
    for (int j = 0; j < crrntWrd.length(); j++){
      shw += "-";
    }
    for (int i = 0; i < mx; i++){
      gss = Utils.inputStr(shw + "\n guess a letter ");
      while(lttrs.indexOf(gss) != -1){
        gss = Utils.inputStr("that letter has been guessed already. please guess another letter ");
      }
      lttrs.add(gss);
      for (int j = 0; j < crrntWrd.length(); j++){
        if (crrntWrd.substring(j, j+1).equals(gss)){
          shw = shw.substring(0, j) + gss + shw.substring(j + 1, crrntWrd.length());
        }
      }
      if (crrntWrd.equals(shw)){
        System.out.println("\nCongratulations! You have guessed the word " + shw.toUpperCase() + " in " + i + " guesses!\n");

        System.out.println("Type in a nickname to be added to the LEADERBOARD: ");
        String nck = scan.nextLine();
        ldrbrd.put(nck, i);
        
     return;
}
   
    //switch-case: have string message printed out after a certain amount of guesses. at 5, 10, and 20.
    switch(i){
    case 5:
      System.out.println("5 tries already :o");
      break;
    case 10:
      System.out.println("10 TRIES?? come on! you can do it!!");
      break;
    case 20:
      System.out.println("20... YOU CAN DO IT! WE BELIEVE :D");
  }
    }
    return;
  }  
  
  public void addWord(String s){
    wrdBnk.add(s);
  }
  
  public void ldr(){
    System.out.println(ldrbrd);
    
}

}