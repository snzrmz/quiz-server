package services; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType; 
import javax.ws.rs.core.Response; 

@Path("/") 
@Produces(MediaType.TEXT_HTML) 
public class HelloWorldRest {               

    @GET  
    public Response sayHello() {     
        return Response.ok("<h1>Hello World</h1>").build();
    } 
}