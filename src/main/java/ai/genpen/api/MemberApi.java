package ai.genpen.api;

import ai.genpen.dao.MemberDAO;
import ai.genpen.models.Member;
import io.swagger.annotations.*;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/member")
@Api(description = "the member API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class MemberApi {
		/* Insert Scribe [[Member]][[]] [[47ce4423-040b-409d-bf99-aac0af10b7a4]]*/

    @POST
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Create Member", notes = "This can only be done by the logged in user.", response = Member.class, tags={ "member" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Member.class)
    })
    public Response createMember(@Valid Member member) {
		/* Insert Scribe [[Member]][[createMember(@Valid Member member)]] [[83511442-e415-4678-9135-3352a2a59208]]*/
		/* Insert Scribe [[Member]][[createMember(@Valid Member member)]] [[83511442-e415-4678-9135-3352a2a59208]] create code below */
		MemberDAO dao = new MemberDAO();
		Member a = dao.find(member.getId());
		if( a == null ){
		    int n = dao.insert(member);
		    if (n > 0){
		        return Response.ok().entity(member).build();
		    }
		}
		return Response.status(400).build();

    }

    @POST
    @Path("/createWithList")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Creates list of Member with given input array", notes = "Creates list of member with given input array", response = Member.class, tags={ "member" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Member.class),
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response createMembersWithListInput(@Valid List<Member> member) {
		/* Insert Scribe [[Member]][[createMembersWithListInput(@Valid List<Member> member)]] [[b8750ce9-76eb-4c12-bda4-a2b818f4acc8]]*/
		/* Insert Scribe [[Member]][[createMembersWithListInput(@Valid List<Member> member)]] [[b8750ce9-76eb-4c12-bda4-a2b818f4acc8]] create code below */
		MemberDAO dao = new MemberDAO();
		for(int i = 0; i < member.size(); i++) {
            Member a = dao.find(member.get(i).getId());
            if (a == null) {
                int n = dao.insert(member.get(i));
                if (n <= 0) {
                    return Response.status(400).build();
                }
            }
        }
        return Response.ok().entity(member).build();


    }

    @DELETE
    @Path("/{name}")
    @ApiOperation(value = "Delete member", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "member" })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid Member variable supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Member not found", response = Void.class)
    })
    public Response deleteMember(@PathParam("name") @ApiParam("The member that needs to be deleted by name") String name) {
		/* Insert Scribe [[Member]][[deleteMember(@PathParam("name")]] [[0e630e8a-7862-4d7a-8f7f-76cf84335ae8]]*/
		/* Insert Scribe [[Member]][[deleteMember(@PathParam("name")]] [[0e630e8a-7862-4d7a-8f7f-76cf84335ae8]] delete by id code below */
		MemberDAO dao = new MemberDAO();
		int n = dao.delete(name);
		return n == 1 ? Response.ok().build(): Response.status(400).build();
    }

    @GET
    @Path("/{name}")
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Get member by name", notes = "", response = Member.class, tags={ "member" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Member.class),
        @ApiResponse(code = 400, message = "Invalid Member variable supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Member not found", response = Void.class)
    })
    public Response getMemberByName(@PathParam("name") @ApiParam("The name that needs to be fetched. Use member1 for testing. ") String name) {
		/* Insert Scribe [[Member]][[getMemberByName(@PathParam("name")]] [[f7aad39f-f682-4cc3-a987-78abdb949f62]]*/
		/* Insert Scribe [[Member]][[getMemberByName(@PathParam("name")]] [[f7aad39f-f682-4cc3-a987-78abdb949f62]] getModelById code below */
		MemberDAO dao = new MemberDAO();
		Member a = dao.find(name);
		if( a != null ) {
		    return Response.ok().entity(a).build();
		} else {
		    return Response.status(404).build();
		}

    }

    @PUT
    @Path("/{name}")
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @ApiOperation(value = "Update member", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "member" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response updateMember(@PathParam("name") @ApiParam("name of member that needs to be deleted") String name,@Valid Member member) {
		/* Insert Scribe [[Member]][[updateMember(@PathParam("name")]] [[ed5fbd94-0983-49a3-9361-208c2401efe7]]*/
		/* Insert Scribe [[Member]][[updateMember(@PathParam("name")]] [[ed5fbd94-0983-49a3-9361-208c2401efe7]] updateModel by Id code below */
		MemberDAO dao = new MemberDAO();
		Member a = dao.find(name);
		dao.update(a);
		return Response.ok().entity(a).build();

    }
}
