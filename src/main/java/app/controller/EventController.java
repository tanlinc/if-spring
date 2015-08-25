package app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.service.EventService;


@RestController
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	@RequestMapping("/events")
	Map<String,app.domain.Event> getAllEvents(){
		return eventService.getAllFutureEvents();
	}
	
	//ein einzelnes Event über seinen Namen abfragen
	@RequestMapping("/event")
	app.domain.Event getEvent(@RequestParam(value="name") String name){
		return eventService.getEventbyName(name);
	}
	
	//ein Event speichern (method POST)
	@RequestMapping(value = "/newevent", method = RequestMethod.POST)
	void saveEvent(@RequestBody app.domain.Event event){
		eventService.saveEvent(event);
	}
	
	//eine Ressource löschen
	@RequestMapping(value = "/delevent", method = RequestMethod.DELETE)
	 void deleteEvent(@RequestParam(value="name") String name){
		eventService.deleteEvent(name);
	}
}
