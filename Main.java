/*
Main - this is a runner class that runs the Game class

Author - Marc Shepard
*/
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    System.out.println("Starting Hangman");
    Scanner scan = new Scanner(System.in);
    Game g = new Game();
    String act = "";

    do{
      System.out.println("Choose an action to begin: press a to add word to word list, press n to start new game, press l for the leaderboard, and press q to quit");
      act = scan.nextLine();
      switch (act.toLowerCase()){
        case "q":
          System.out.println("Thanks for playing!");
          break;
        case "a":
          g.addWord(Utils.inputStr("Type a word to add to word bank: "));
          break;
        case "n":
          g.play();
          break;
        case "l":
          g.ldr();
          break;
        default:
          break;
      }  
    }while (!act.equals("q"));
      
   }


  // Unit tests for Utils.java. Call this from main if you want to
  // see examples of the Utils methods
  public static void testUtils () {
    return;
    
    
  }
}