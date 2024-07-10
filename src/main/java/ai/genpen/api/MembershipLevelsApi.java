package ai.genpen.api;

import ai.genpen.dao.MembershipLevelsDAO;
import ai.genpen.models.MembershipLevels;
import io.swagger.annotations.*;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/membershipLevels")
@Api(description = "the membershipLevels API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class MembershipLevelsApi {
		/* Insert Scribe [[MembershipLevels]][[]] [[c95a1e02-6f63-4a46-a43f-2afd6ab5d9b3]]*/

    @POST
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Create MembershipLevels", notes = "This can only be done by the logged in user.", response = MembershipLevels.class, tags={ "membershipLevels" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = MembershipLevels.class)
    })
    public Response createMembershipLevels(@Valid MembershipLevels membershipLevels) {
		/* Insert Scribe [[MembershipLevels]][[createMembershipLevels(@Valid MembershipLevels membershipLevels)]] [[9e5db8ee-ba9b-4087-a47f-e5335db6d3a1]]*/
		/* Insert Scribe [[MembershipLevels]][[createMembershipLevels(@Valid MembershipLevels membershipLevels)]] [[9e5db8ee-ba9b-4087-a47f-e5335db6d3a1]] create code below */
		MembershipLevelsDAO dao = new MembershipLevelsDAO();
		MembershipLevels a = dao.find(membershipLevels.getId());
		if( a == null ){
		    int n = dao.insert(membershipLevels);
		    if (n > 0){
		        return Response.ok().entity(membershipLevels).build();
		    }
		}
		return Response.status(400).build();

    }

    @POST
    @Path("/createWithList")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Creates list of MembershipLevels with given input array", notes = "Creates list of membershipLevels with given input array", response = MembershipLevels.class, tags={ "membershipLevels" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = MembershipLevels.class),
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response createMembershipLevelssWithListInput(@Valid List<MembershipLevels> membershipLevels) {
		/* Insert Scribe [[MembershipLevels]][[createMembershipLevelssWithListInput(@Valid List<MembershipLevels> membershipLevels)]] [[06f28a7b-2ef8-4f54-aec2-03c186cbcc27]]*/
		/* Insert Scribe [[MembershipLevels]][[createMembershipLevelssWithListInput(@Valid List<MembershipLevels> membershipLevels)]] [[06f28a7b-2ef8-4f54-aec2-03c186cbcc27]] create code below */
		MembershipLevelsDAO dao = new MembershipLevelsDAO();
		for(int i =0; i < membershipLevels.size(); i++ ) {
            MembershipLevels a = dao.find(membershipLevels.get(i).getId());
            if (a == null) {
                int n = dao.insert(membershipLevels.get(i));
                if (n > 0) {
                    return Response.ok().entity(membershipLevels.get(i)).build();
                }
            }
        }
		return Response.status(400).build();

    }

    @DELETE
    @Path("/{name}")
    @ApiOperation(value = "Delete membershipLevels", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "membershipLevels" })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid MembershipLevels variable supplied", response = Void.class),
        @ApiResponse(code = 404, message = "MembershipLevels not found", response = Void.class)
    })
    public Response deleteMembershipLevels(@PathParam("name") @ApiParam("The membershipLevels that needs to be deleted by name") String name) {
		/* Insert Scribe [[MembershipLevels]][[deleteMembershipLevels(@PathParam("name")]] [[55020e7b-0d6c-44c5-826d-2897ece4e727]]*/
		/* Insert Scribe [[MembershipLevels]][[deleteMembershipLevels(@PathParam("name")]] [[55020e7b-0d6c-44c5-826d-2897ece4e727]] delete by id code below */
		MembershipLevelsDAO dao = new MembershipLevelsDAO();
		int n = dao.delete(name);
		return n == 1 ? Response.ok().build() : Response.status(400).build();

    }

    @GET
    @Path("/{name}")
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Get membershipLevels by name", notes = "", response = MembershipLevels.class, tags={ "membershipLevels" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = MembershipLevels.class),
        @ApiResponse(code = 400, message = "Invalid MembershipLevels variable supplied", response = Void.class),
        @ApiResponse(code = 404, message = "MembershipLevels not found", response = Void.class)
    })
    public Response getMembershipLevelsByName(@PathParam("name") @ApiParam("The name that needs to be fetched. Use membershipLevels1 for testing. ") String name) {
		/* Insert Scribe [[MembershipLevels]][[getMembershipLevelsByName(@PathParam("name")]] [[fd8723cc-08d1-4500-b4c6-2fdce74f38fd]]*/
		/* Insert Scribe [[MembershipLevels]][[getMembershipLevelsByName(@PathParam("name")]] [[fd8723cc-08d1-4500-b4c6-2fdce74f38fd]] getModelById code below */
		MembershipLevelsDAO dao = new MembershipLevelsDAO();
		MembershipLevels a = dao.find(name);
		if( a != null ) {
		    return Response.ok().entity(a).build();
		} else {
		    return Response.status(404).build();
		}

    }

    @PUT
    @Path("/{name}")
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @ApiOperation(value = "Update membershipLevels", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "membershipLevels" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response updateMembershipLevels(@PathParam("name") @ApiParam("name of membershipLevels that needs to be deleted") String name,@Valid MembershipLevels membershipLevels) {
		/* Insert Scribe [[MembershipLevels]][[updateMembershipLevels(@PathParam("name")]] [[6a604538-5ba2-4785-b3fc-e361611e75ab]]*/
		/* Insert Scribe [[MembershipLevels]][[updateMembershipLevels(@PathParam("name")]] [[6a604538-5ba2-4785-b3fc-e361611e75ab]] updateModel by Id code below */
		MembershipLevelsDAO dao = new MembershipLevelsDAO();
		MembershipLevels a = dao.find(name);
		return Response.ok().entity(a).build();

    }
}
