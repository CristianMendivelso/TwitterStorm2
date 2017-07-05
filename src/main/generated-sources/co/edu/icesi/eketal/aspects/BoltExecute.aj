package co.edu.icesi.eketal.aspects;
		
import backtype.storm.tuple.Tuple;
import co.edu.icesi.eketal.automaton.*;
import co.edu.icesi.eketal.groupsimpl.*;
import co.edu.icesi.eketal.handlercontrol.*;
import co.edu.icesi.eketal.reaction.*;
import co.edu.icesi.ketal.core.Automaton;
import co.edu.icesi.ketal.core.Event;
import co.edu.icesi.ketal.core.NamedEvent;
import com.autentia.tutoriales.*;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public aspect BoltExecute{
	
	final static Log logger = LogFactory.getLog(BoltExecute.class);
	//seqEventDetector
	//--------Evento: execute-------------
	pointcut execute():
		(pointComautentiatutorialesboltTweetSplitterBoltexecute() && if(GroupsControl.host("localGroup")));
		
	//after() returning (Object o): execute() {
	//	System.out.println("[Aspectj] Returned normally with " + o);
	//}
	//after() throwing (Exception e): execute() {
	//	System.out.println("[Aspectj] Threw an exception: " + e);
	//}
	after(): execute(){
		Automaton automata = SeqEventDetector.getInstance();
		Reaction.verifyAfter(automata);
		//System.out.println("[Aspectj] After: Returned or threw an Exception");
		logger.debug("[Aspectj] After: Returned or threw an Exception");
	}
	before(): execute(){
		EventHandler distribuidor = EventHandler.getInstance();
		Automaton automata = SeqEventDetector.getInstance();
		Map map = new HashMap<String, Object>();
		//map.put("Automata", automata);
		Event event = new NamedEvent("execute");
		event.setLocalization(distribuidor.getAsyncAddress());
		distribuidor.multicast(event, map);
		if(!automata.evaluate(event)){
			//System.out.println("[Aspectj] Before: Event not recognized by the automaton");
			logger.debug("[Aspectj] Before: Event not recognized by the automaton");
			//Debería parar
		}else{
			Reaction.verifyBefore(automata);
			//System.out.println("[Aspectj] Before: Returned or threw an Exception");
			logger.debug("[Aspectj] Before: Returned or threw an Exception");
		}
		//while(!automata.evaluate(event)){
		//	wait(100);
		//	
		//}
	}
	
	pointcut pointComautentiatutorialesboltTweetSplitterBoltexecute(): execution(* com.autentia.tutoriales.bolt.TweetSplitterBolt.execute(Tuple));
}
