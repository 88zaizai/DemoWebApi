package org.zaizai.DemoWebApi.Authentication;

import java.io.Serializable;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.codehaus.jettison.json.JSONObject;

@Path("/authentication")
public class AuthenticationEndpoint
{
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt()
	{
		return "authenticate";
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticateUser(Credentials credentials) throws Exception
	{
		try
		{
			authenticate(credentials.username, credentials.password);

			String token = issueToken("hello");

			return Response.ok(token).build();
		}
		catch (Exception e)
		{
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}	
	
//	@POST
//	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED, MediaType.APPLICATION_JSON })
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response authenticateUser(String incomingData) throws Exception
//	{
//		try
//		{
//			JSONObject jsonObj = new JSONObject(incomingData);
//
//			authenticate(jsonObj.optString("username"), jsonObj.optString("password"));
//
//			String token = issueToken("hello");
//
//			return Response.ok(token).build();
//		}
//		catch (Exception e)
//		{
//			return Response.status(Response.Status.UNAUTHORIZED).build();
//		}
//	}

	// @POST
	// @Consumes({MediaType.APPLICATION_FORM_URLENCODED,
	// MediaType.APPLICATION_JSON})
	// @Produces(MediaType.APPLICATION_JSON)
	// public Response authenticateUser(@FormParam("username") String username,
	// @FormParam("password") String password)
	// throws Exception
	// {
	// try
	// {
	// authenticate(username, password);
	//
	// String token = issueToken("hello");
	//
	// return Response.ok(token).build();
	// }
	// catch (Exception e)
	// {
	// return Response.status(Response.Status.UNAUTHORIZED).build();
	// }
	// }

	private void authenticate(String username, String password) throws Exception
	{
		// Authenticate against a database, LDAP, file or whatever
		// Throw an Exception if the credentials are invalid
		throw new Exception();
	}

	private String issueToken(String username)
	{
		// Issue a token (can be a random String persisted to a database or a
		// JWT token)
		// The issued token must be associated to a user
		// Return the issued token
		return "tocken123randomstring";
	}
}

class Credentials implements Serializable {
	private static final long serialVersionUID = 4505402434900594717L;
    public String username;
    public String password;
}
