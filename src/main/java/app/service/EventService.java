package app.service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import app.domain.Event;


@Service
public class EventService {
	
	private Map<String,app.domain.Event> eventMap = new HashMap<String,app.domain.Event>();
	
	public void fillEventMap(){

		Event event1= new Event();
		event1.name = "eins";
		event1.id = 1;
		event1.startDate = new Date();
		event1.endDate = new Date();
		eventMap.put("eins",event1);
		
		Event event2= new Event();
		event2.name = "zwei";
		event2.id = 2;
		event2.startDate = new Date();
		event2.endDate = new Date();
		eventMap.put("zwei",event2);
	}
	
	public Map<String,app.domain.Event> getAllFutureEvents(){
		fillEventMap();
		return eventMap;
	}

	public Event getEventbyName(String name) {
		fillEventMap();
		Event ev = eventMap.get(name);
		return ev;
	}

	public void saveEvent(Event event) {
		eventMap.put(event.name, event);
	}

	public void deleteEvent(String name) {
		fillEventMap();
		eventMap.remove(name);
	}
	
}
