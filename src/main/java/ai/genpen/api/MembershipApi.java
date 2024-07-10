package ai.genpen.api;

import ai.genpen.dao.MembershipDAO;
import ai.genpen.models.Membership;
import io.swagger.annotations.*;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/membership")
@Api(description = "the membership API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class MembershipApi {
		/* Insert Scribe [[Membership]][[]] [[a909c893-3415-46b3-a822-172c9c74b062]]*/

    @POST
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Create Membership", notes = "This can only be done by the logged in user.", response = Membership.class, tags={ "membership" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Membership.class)
    })
    public Response createMembership(@Valid Membership membership) {
		/* Insert Scribe [[Membership]][[createMembership(@Valid Membership membership)]] [[868e0f42-cbfb-40e5-92fc-5111218911f7]]*/
		/* Insert Scribe [[Membership]][[createMembership(@Valid Membership membership)]] [[868e0f42-cbfb-40e5-92fc-5111218911f7]] create code below */
		MembershipDAO dao = new MembershipDAO();
		Membership a = dao.find(membership.getId());
		if( a == null ){
		    int n = dao.insert(membership);
		    if (n > 0){
		        return Response.ok().entity(a).build();
		    }
		}
		return Response.status(400).build();

    }

    @POST
    @Path("/createWithList")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Creates list of Membership with given input array", notes = "Creates list of membership with given input array", response = Membership.class, tags={ "membership" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Membership.class),
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response createMembershipsWithListInput(@Valid List<Membership> membership) {
		/* Insert Scribe [[Membership]][[createMembershipsWithListInput(@Valid List<Membership> membership)]] [[201ad1cd-4e97-4afe-ac12-4276fa4d4ee1]]*/
		/* Insert Scribe [[Membership]][[createMembershipsWithListInput(@Valid List<Membership> membership)]] [[201ad1cd-4e97-4afe-ac12-4276fa4d4ee1]] create code below */
		MembershipDAO dao = new MembershipDAO();
		for(int i = 0; i < membership.size(); i++) {
            Membership a = dao.find(membership.get(i).getId());
            if (a == null) {
                int n = dao.insert(membership.get(i));
                if (n > 0) {
                    return Response.ok().entity(membership.get(i)).build();
                }
            }
        }
		return Response.status(400).build();
    }

    @DELETE
    @Path("/{name}")
    @ApiOperation(value = "Delete membership", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "membership" })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid Membership variable supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Membership not found", response = Void.class)
    })
    public Response deleteMembership(@PathParam("name") @ApiParam("The membership that needs to be deleted by name") String name) {
		/* Insert Scribe [[Membership]][[deleteMembership(@PathParam("name")]] [[cd8992fe-1042-48b6-90da-79c8a0edeb39]]*/
		/* Insert Scribe [[Membership]][[deleteMembership(@PathParam("name")]] [[cd8992fe-1042-48b6-90da-79c8a0edeb39]] delete by id code below */
		MembershipDAO dao = new MembershipDAO();
		int n = dao.delete(name);
		return n == 1 ? Response.ok().build() : Response.status(400).build();

    }

    @GET
    @Path("/{name}")
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Get membership by name", notes = "", response = Membership.class, tags={ "membership" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Membership.class),
        @ApiResponse(code = 400, message = "Invalid Membership variable supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Membership not found", response = Void.class)
    })
    public Response getMembershipByName(@PathParam("name") @ApiParam("The name that needs to be fetched. Use membership1 for testing. ") String name) {
		/* Insert Scribe [[Membership]][[getMembershipByName(@PathParam("name")]] [[19eb17b7-90c4-44c4-823e-2104787f8af0]]*/
		/* Insert Scribe [[Membership]][[getMembershipByName(@PathParam("name")]] [[19eb17b7-90c4-44c4-823e-2104787f8af0]] getModelById code below */
		MembershipDAO dao = new MembershipDAO();
		Membership a = dao.find(name);
		if( a != null ) {
		    return Response.ok().entity(a).build();
		} else {
		    return Response.status(404).build();
		}

    }

    @PUT
    @Path("/{name}")
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @ApiOperation(value = "Update membership", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "membership" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response updateMembership(@PathParam("name") @ApiParam("name of membership that needs to be deleted") String name,@Valid Membership membership) {
		/* Insert Scribe [[Membership]][[updateMembership(@PathParam("name")]] [[2a7f68d8-8a15-41de-8eda-1bb909b6241f]]*/
		/* Insert Scribe [[Membership]][[updateMembership(@PathParam("name")]] [[2a7f68d8-8a15-41de-8eda-1bb909b6241f]] updateModel by Id code below */
		MembershipDAO dao = new MembershipDAO();
		Membership a = dao.find(name);
		return Response.ok().entity(a).build();
    }
}
