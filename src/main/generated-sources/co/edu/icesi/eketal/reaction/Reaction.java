package co.edu.icesi.eketal.reaction;

import co.edu.icesi.ketal.core.Automaton;
import co.edu.icesi.ketal.core.State;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class Reaction {
  public static void reactionseqEventDetectorfirtsState() {
    try {
      String ruta = "/home/administrador/storm/output/eketal.txt";
      File file = new File(ruta);
      boolean _exists = file.exists();
      if (_exists) {
        File _absoluteFile = file.getAbsoluteFile();
        FileWriter fw = new FileWriter(_absoluteFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Reaction detected :o High Frequency");
        bw.write("\n");
        bw.close();
      } else {
        file.createNewFile();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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
