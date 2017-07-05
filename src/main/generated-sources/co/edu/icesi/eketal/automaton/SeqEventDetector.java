package co.edu.icesi.eketal.automaton;

import co.edu.icesi.ketal.core.Automaton;
import co.edu.icesi.ketal.core.DefaultEqualsExpression;
import co.edu.icesi.ketal.core.Event;
import co.edu.icesi.ketal.core.Expression;
import co.edu.icesi.ketal.core.NamedEvent;
import co.edu.icesi.ketal.core.State;
import co.edu.icesi.ketal.core.Transition;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings("all")
public class SeqEventDetector {
  private static Automaton instance;
  
  public static Map<String, State> estados = new HashMap<String, State>();
  
  public static Automaton getInstance() {
    if(instance==null)
    	new SeqEventDetector();
    return instance;
  }
  
  private SeqEventDetector() {
    initialize();
  }
  
  private void initialize() {
    //Relación evento caracter
    Map<String, Character> mapping = new TreeMap<String, Character>();
    //Estado inicial
    State inicial = null;
    //lista de estados finales
    Set<State> estadosFinales = new HashSet();
    
    //conjunto de transiciones
    HashSet<Transition> transitionSet = new HashSet();
    //map de expresiones con caracteres
    Hashtable<Expression, Character> expressions = new Hashtable();
    
    int consecutivo = 65;
    Character caracter = (char)consecutivo;
    String nombreEvento = "";
    String estadoLlegada = "";
    
    //Definición del estado: initialState
    String estadoInitialState = "initialState";
    estados.put(estadoInitialState, new State());
    //start start 1
    //Estado inicial: initialState
    inicial = estados.get(estadoInitialState);
    //Definición del estado: firtsState
    String estadoFirtsState = "firtsState";
    estados.put(estadoFirtsState, new State());
    //Definición del estado: finalState
    String estadoFinalState = "finalState";
    estados.put(estadoFinalState, new State());
    //Transicion de printer -> firtsState
    estadoLlegada = "firtsState";
    if(!estados.containsKey(estadoLlegada)){
    	estados.put(estadoInitialState, new State());
    }
    caracter = (char)consecutivo;
    consecutivo++;
    nombreEvento = "printer";
    if(!mapping.containsKey(nombreEvento)){
    	mapping.put(nombreEvento, caracter);
    	expressions.put(new DefaultEqualsExpression(new NamedEvent(nombreEvento)), mapping.get(nombreEvento));
    }
    Transition initialStatePrinter = new Transition(estados.get(estadoInitialState), estados.get(estadoLlegada), mapping.get(nombreEvento));
    transitionSet.add(initialStatePrinter);
    
    //Transicion de printer -> initialState
    estadoLlegada = "initialState";
    if(!estados.containsKey(estadoLlegada)){
    	estados.put(estadoFirtsState, new State());
    }
    caracter = (char)consecutivo;
    consecutivo++;
    nombreEvento = "printer";
    if(!mapping.containsKey(nombreEvento)){
    	mapping.put(nombreEvento, caracter);
    	expressions.put(new DefaultEqualsExpression(new NamedEvent(nombreEvento)), mapping.get(nombreEvento));
    }
    Transition firtsStatePrinter = new Transition(estados.get(estadoFirtsState), estados.get(estadoLlegada), mapping.get(nombreEvento));
    transitionSet.add(firtsStatePrinter);
    
    //Estado final FinalState
    estados.get(estadoFinalState).setAccept(true);
    estadosFinales.add(estados.get(estadoFinalState));
    
    Automaton automata = new Automaton(transitionSet, inicial, estadosFinales, expressions){
    	@Override
    	    	public boolean evaluate(Event event){
    	    		if(event instanceof NamedEvent){
    	    			return super.evaluate(event);
    	    		}
    	    		return false;
    	    	}
    };
    automata.initializeAutomaton();
    instance = automata;
  }
}
