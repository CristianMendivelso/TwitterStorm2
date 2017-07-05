package co.edu.icesi.eketal.reaction;

import co.edu.icesi.ketal.core.Automaton;
import co.edu.icesi.ketal.core.State;

@SuppressWarnings("all")
public class Reaction {
  public static void reactionseqEventDetectorfirtsState() {
    String msg = "Reaction detected :o High Frequency";
    System.out.println("++++++++++++++++++++++++++++++++++++++");
    System.out.println(msg);
    System.out.println("++++++++++++++++++++++++++++++++++++++");
  }
  
  public static void verifyBefore(final Automaton automaton) {
    State actual = automaton.getCurrentState();
    if(actual.equals(co.edu.icesi.eketal.automaton.SeqEventDetector.estados.get("firtsState"))){
    	reactionseqEventDetectorfirtsState();
    }
  }
  
  public static void verifyAfter(final Automaton automaton) {
    
  }
}
