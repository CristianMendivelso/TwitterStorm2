package co.edu.icesi.eketal.reaction;

import co.edu.icesi.ketal.core.Automaton;
import co.edu.icesi.ketal.core.State;

@SuppressWarnings("all")
public class Reaction {
  public static void reactionseqEventDetectorfirtsState() {
    System.out.println("------------------Reaction detected with Eketal--------------------------");
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
