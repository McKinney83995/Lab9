package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class App {
  public static void main(String[] args) throws IOException {
    // int trials = 100000, data = 11;
    // String[] notes = {"a","a","a","a", "The bird is red!","a","a","a","abc","The
    // bird is red","The bird is red!"};
   String note;
   String[] articles;

     note = Files.readString(
     Path.of( "plays", "romeo_and_juliet.txt")
     );
     
    articles = new String[] {
     Files.readString(Path.of( "plays", "othello.txt"))
     };

    System.out.println("Can you make Romeo and Juliet out of Othello?");
    System.out.println("canCreateNote: " + canCreateNote(note, articles));

    //note = "a! z";
    //articles = new String[] { "a", "b!", "z " };
    
     //for(int i = 0; i < trials; ++i){ //MIA LESS THAN OR EQUAL RO

     // a [“a”] true
     note = "a";
     articles = new String[] { "a" };

      System.out.println("\nNote: a  Articles: [“a”]     SHOULD BE TRUE");
     System.out.println("canCreateNote: " + canCreateNote(note, articles));

     // a [“ab”] true
     note = "a";
     articles = new String[] { "ab" };

     System.out.println("\nNote: a  Articles: [“ab”]     SHOULD BE TRUE");
     System.out.println("canCreateNote: " + canCreateNote(note, articles));
     
     // a [“a”, “b”] true
     note = "a";
     articles = new String[] { "a", "b" };

     System.out.println("\nNote: a  Articles: [“a”, “b”]     SHOULD BE TRUE");
     System.out.println("canCreateNote: " + canCreateNote(note, articles));
     
     // abc [“a”, “b”, “c”] true
     note = "a";
     articles = new String[] { "a", "b", "c" };
        System.out.println("\nNote: a  Articles: [“a”, “b”, “c”]     SHOULD BE TRUE");
     System.out.println("canCreateNote: " + canCreateNote(note, articles));
     
     // The bird is red! [“I write a lot.”, “To and fro.”, “Here be deadly dragons!“]
     // true
      note = "The bird is red!";
     articles = new String[] { "I write a lot.", "To and fro.",
      "Here be deadly dragons!" };
           System.out.println("\nNote: The bird is red!  Articles: [“I write a lot.”, “To and fro.”, “Here be deadly dragons!“]     SHOULD BE TRUE");
     System.out.println("canCreateNote: " + canCreateNote(note, articles));
      
      // a [“b”] false
      note = "a";
      articles = new String[] { "b" };
           System.out.println("\nNote: a  Articles: [“b”]     SHOULD BE FALSE");
     System.out.println("canCreateNote: " + canCreateNote(note, articles));
      
      // a [“bc”] false
      note = "a";
      articles = new String[] { "bc" };
           System.out.println("\nNote: a  Articles: [“bc”]     SHOULD BE FALSE");
     System.out.println("canCreateNote: " + canCreateNote(note, articles));
      
      // a [“b”, “c”] false
      note = "a";
      articles = new String[] { "b", "c" };
           System.out.println("\nNote: a  Articles: [“b”, “c”]     SHOULD BE FALSE");
     System.out.println("canCreateNote: " + canCreateNote(note, articles));
      
      // abc [“a”, “b”, “d”] false
      note = "abc";
      articles = new String[] { "a", "b", "d" };
           System.out.println("\nNote: abc  Articles: [“a”, “b”, “d”]     SHOULD BE FALSE");
     System.out.println("canCreateNote: " + canCreateNote(note, articles));
      
      // The bird is red [“I write a lot.”, “To and fro.”] false
      note = "The bird is red";
      articles = new String[] { "I write a lot.", "To and fro." };
           System.out.println("\nNote: The bird is red  Articles: [“I write a lot.”, “To and fro.”]     SHOULD BE FALSE");
     System.out.println("canCreateNote: " + canCreateNote(note, articles));
      
      // The bird is red! [“I write a lot.”, “To and fro.”, “Here be deadly dragons”]
     // false
     note = "The bird is red!";
     articles = new String[] { "I write a lot.", "To and fro.",
     "Here be deadly dragons" };
          System.out.println("\nNote: The bird is red!  Articles: [“I write a lot.”, “To and fro.”, “Here be deadly dragons”]     SHOULD BE FALSE");
     System.out.println("canCreateNote: " + canCreateNote(note, articles));
     
  }

  public static boolean canCreateNote(String note, String[] articles) {
    HashTable<Integer> noteTable = new HashTable<>();
    String article = " ";
    // if(articles.length > 1)

    // System.out.println(articles.length);
    for (int i = 0; i < articles.length; i++)
      article += articles[i];

    for (int i = 0; i < note.length(); i++) { // iterate through note
      if (note.charAt(i) > 32 && note.charAt(i) < 123)
        noteTable.put(note.charAt(i), i); //
    }

    /*
     * for (int i = 0; i < articles.length; i++) { //iterate through array
     * for (int j = 0; j < articles[i].length(); j++) { //iterate through string
     * 
     * if (articles[i].charAt(j) > 32 && articles[i].charAt(j) < 123 ) //if not
     * white space
     * noteTable.remove(articles[i].charAt(j)); //remove from hash table
     * 
     * }
     * 
     * if (noteTable.isEmpty()) //stop and check -- if note table is empty, dont
     * have to keep going
     * return true;
     * }
     */

    for (int i = 1; i < article.length(); ++i) { //can skip first index bc its gonna be a space
      if (article.charAt(i) > 32 && article.charAt(i) < 123) {
        noteTable.remove(article.charAt(i));
        if (noteTable.isEmpty()) // stop and check -- if note table is empty, dont have to keep going
          return true;
      }

    }

    return false; //if we made it here w out tripping the other check, its false
  }
}