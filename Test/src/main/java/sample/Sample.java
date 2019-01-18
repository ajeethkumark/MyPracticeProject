package sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/a")

public class Sample {
	
	
	
	@GET
	@Path("ok")
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt()
	{
		System.out.println("Calling");
		return "getIt";
	}

}
