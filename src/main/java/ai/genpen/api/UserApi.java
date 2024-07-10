package ai.genpen.api;

import io.swagger.annotations.*;
import org.primefaces.rain.dao.UserDAO;
import org.primefaces.rain.domain.User;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

@Path("/user")
@Api(description = "the user API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class UserApi {
		/* Insert Scribe [[User]][[]] [[43f95d4f-cd07-4aa5-adb7-d5d19f592592]]*/

    @POST
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Create user", notes = "This can only be done by the logged in user.", response = User.class, tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = User.class)
    })
    public Response createUser(@Valid User user) throws SQLException {
		/* Insert Scribe [[User]][[createUser(@Valid User user)]] [[fd406d59-876a-47dc-b1a4-93001d863527]]*/
		/* Insert Scribe [[User]][[createUser(@Valid User user)]] [[fd406d59-876a-47dc-b1a4-93001d863527]] create code below */
		UserDAO dao = new UserDAO();
		User a = dao.find(user.getId());
		if( a == null ){
		    dao.insert(user);
		    return Response.ok().entity(user).build();
		}
		return Response.status(400).build();
    }

    @POST
    @Path("/createWithList")
    @Consumes({ "application/json" })
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Creates list of users with given input array", notes = "Creates list of users with given input array", response = User.class, tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = User.class),
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response createUsersWithListInput(@Valid List<User> user) throws SQLException {
		/* Insert Scribe [[User]][[createUsersWithListInput(@Valid List<User> user)]] [[13b1417b-8012-4c26-acad-45cbf97c8a10]]*/
		/* Insert Scribe [[User]][[createUsersWithListInput(@Valid List<User> user)]] [[13b1417b-8012-4c26-acad-45cbf97c8a10]] create code below */
		UserDAO dao = new UserDAO();
		for(int i = 0; i < user.size(); i++ ) {
            User a = dao.find(user.get(i).getId());
            if (a == null) {
                dao.insert(user.get(i));
                return Response.ok().entity(user.get(i)).build();
            }
        }
		return Response.status(400).build();
    }

    @DELETE
    @Path("/{username}")
    @ApiOperation(value = "Delete user", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid username supplied", response = Void.class),
        @ApiResponse(code = 404, message = "User not found", response = Void.class)
    })
    public Response deleteUser(@PathParam("username") @ApiParam("The name that needs to be deleted") String username) {
		/* Insert Scribe [[User]][[deleteUser(@PathParam("username")]] [[b58c6dbe-351f-4abf-bc57-1215679b448d]]*/
		/* Insert Scribe [[User]][[deleteUser(@PathParam("username")]] [[b58c6dbe-351f-4abf-bc57-1215679b448d]] delete by id code below */
		//UserDAO dao = new UserDAO();
		//int n = dao.delete(username);
		//return n == 1 ? Response.ok().build() : Response.status(400).build();
        //return Response.ok().entity("magic!").build();
        return Response.status(403).build();
    }

    @GET
    @Path("/{username}")
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Get user by user name", notes = "", response = User.class, tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = User.class),
        @ApiResponse(code = 400, message = "Invalid username supplied", response = Void.class),
        @ApiResponse(code = 404, message = "User not found", response = Void.class)
    })
    public Response getUserByName(@PathParam("username") @ApiParam("The name that needs to be fetched. Use user1 for testing. ") String username) throws SQLException {
		/* Insert Scribe [[User]][[getUserByName(@PathParam("username")]] [[2eb627a0-4a08-46da-9c3c-462e67b8df93]]*/
		/* Insert Scribe [[User]][[getUserByName(@PathParam("username")]] [[2eb627a0-4a08-46da-9c3c-462e67b8df93]] getModelById code below */
		UserDAO dao = new UserDAO();
		User a = dao.find(username);
		if( a != null ) {
		    return Response.ok().entity(a).build();
		} else {
		    return Response.status(404).build();
		}

    }

    @GET
    @Path("/login")
    @Produces({ "application/xml", "application/json" })
    @ApiOperation(value = "Logs user into the system", notes = "", response = String.class, tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = String.class),
        @ApiResponse(code = 400, message = "Invalid username/password supplied", response = Void.class)
    })
    public Response loginUser(@QueryParam("username")  @ApiParam("The user name for login")  String username,@QueryParam("password")  @ApiParam("The password for login in clear text")  String password) {
		/* Insert Scribe [[User]][[loginUser(@QueryParam("username")]] [[3c55afd8-ebf9-49d6-b54f-ea2559e8af64]]*/
        return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/logout")
    @ApiOperation(value = "Logs out current logged in user session", notes = "", response = Void.class, tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response logoutUser() {
		/* Insert Scribe [[User]][[logoutUser()]] [[f7cd24ad-9e61-49c3-b81b-7f43ee8a8e48]]*/
        return Response.ok().entity("magic!").build();
    }

    @PUT
    @Path("/{username}")
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @ApiOperation(value = "Update user", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "user" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response updateUser(@PathParam("username") @ApiParam("name that need to be deleted") String username,@Valid User user) throws SQLException {
		/* Insert Scribe [[User]][[updateUser(@PathParam("username")]] [[d327d36b-f9e8-4202-86fc-ee6190fdc0d2]]*/
		/* Insert Scribe [[User]][[updateUser(@PathParam("username")]] [[d327d36b-f9e8-4202-86fc-ee6190fdc0d2]] updateModel by Id code below */
		UserDAO dao = new UserDAO();
		User a = dao.find(username);
		return Response.ok().entity(a).build();
    }
}
