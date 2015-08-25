package app.controller;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.hamcrest.Matchers.*;


import static com.jayway.restassured.RestAssured.*;
import app.EventApp;
import app.domain.Event;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EventApp.class)
@WebIntegrationTest
public class EventControllerTest {
	
	//@Autowired
   // private ObjectMapper om;

    @Test
    public void test_getAllEvents(){
    	get("/events")
    	.then()
    	.log().all()
    	.statusCode(200)
    	.contentType("application/json;charset=UTF­8")
    	.body(containsString("name")).body(containsString("eins"))
    	.body("zwei.name", equalTo("zwei"))
    	.body("eins.id", equalTo(1))
    	.body("zwei.id", equalTo(2))
    	.body(containsString("zwei"));
    }
    
    
    @Test
    public void test_getEvent(){
    	get("/event?name=eins")
    	.then()
    		.log().all()
    	    .statusCode(200)
    	    .contentType("application/json;charset=UTF­8")
    	    .body("name", equalTo("eins"))
    	    .body("id", equalTo(1));
    }
    
    
    @Test
    public void test_saveEvent() throws Exception{
    	Event event1= new Event();
		event1.name = "neu";
		event1.id = 3;
		event1.startDate = new Date();
		event1.endDate = new Date();
		
    	given()
    	.when()
    	    .contentType("application/json")
    	    //.body(om.writeValueAsString(event1))
    	    .post("/newevent")
    	.then()
    		.log().all()
    	    .statusCode(200)
    	    .contentType("application/json;charset=UTF­8")
    	    .body(isEmptyString());
    	;
    }
  
    
    @Test
    public void test_deleteEvent(){
    	delete("/delevent?name=eins")
    	.then()
    		.log().all()
    	    .statusCode(200)
    	    .contentType("application/json;charset=UTF­8")
    	    .body(isEmptyString());
    	;
    }
}
