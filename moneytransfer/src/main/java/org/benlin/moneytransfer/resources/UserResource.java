package org.benlin.moneytransfer.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.benlin.moneytransfer.model.User;
import org.benlin.moneytransfer.service.UserService;


@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
	
	UserService userService = new UserService();
	
	@GET
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GET
	@Path("/{username}")
	public User getUser(@PathParam("username") String username) {
		return userService.getUser(username);
	}
	
	@POST
	public User addUser(User user) {
		return userService.addUser(user);
	}
	
	@PUT
	@Path("/{username}")
	public User updateUser(@PathParam("username") String username, User user) {
		user.setUsername(username);
		return userService.updateUser(user);
	}
	
	@DELETE
	@Path("/{username}")
	public void deleteAccount(@PathParam("username") String username) {
		userService.removeUser(username);
	}
	

}

