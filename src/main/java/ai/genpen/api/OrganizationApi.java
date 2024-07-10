package ai.genpen.api;

import ai.genpen.dao.OrganizationDAO;
import ai.genpen.models.Organization;
import io.swagger.annotations.*;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/organization")
@Api(description = "the organization API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class OrganizationApi {
		/* Insert Scribe [[Organization]][[]] [[a18c5e23-f311-4901-98e9-8433d666af18]]*/

    @POST
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Create Organization", notes = "This can only be done by the logged in user.", response = Organization.class, tags={ "organization" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Organization.class)
    })
    public Response createOrganization(@Valid Organization organization) {
		/* Insert Scribe [[Organization]][[createOrganization(@Valid Organization organization)]] [[a2ae8596-476c-4c15-844c-103eeb8541a2]]*/
		/* Insert Scribe [[Organization]][[createOrganization(@Valid Organization organization)]] [[a2ae8596-476c-4c15-844c-103eeb8541a2]] create code below */
		OrganizationDAO dao = new OrganizationDAO();
		Organization a = dao.find(organization.getId());
		if( a == null ){
		    int n = dao.insert(organization);
		    if (n > 0){
		        return Response.ok().entity(organization).build();
		    }
		}
		return Response.status(400).build();

    }

    @POST
    @Path("/createWithList")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Creates list of Organization with given input array", notes = "Creates list of organization with given input array", response = Organization.class, tags={ "organization" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Organization.class),
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response createOrganizationsWithListInput(@Valid List<Organization> organization) {
		/* Insert Scribe [[Organization]][[createOrganizationsWithListInput(@Valid List<Organization> organization)]] [[f40b49bc-1598-4613-825e-16a9b99744f1]]*/
		/* Insert Scribe [[Organization]][[createOrganizationsWithListInput(@Valid List<Organization> organization)]] [[f40b49bc-1598-4613-825e-16a9b99744f1]] create code below */
		OrganizationDAO dao = new OrganizationDAO();
		for(int i = 0; i < organization.size(); i++ ) {
            Organization a = dao.find(organization.get(i).getId());

            if (a == null) {
                int n = dao.insert(organization.get(i));
                if (n > 0) {
                    return Response.ok().entity(organization.get(i)).build();
                }
            }
        }
		return Response.status(400).build();
    }

    @DELETE
    @Path("/{name}")
    @ApiOperation(value = "Delete organization", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "organization" })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid Organization variable supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Organization not found", response = Void.class)
    })
    public Response deleteOrganization(@PathParam("name") @ApiParam("The organization that needs to be deleted by name") String name) {
		/* Insert Scribe [[Organization]][[deleteOrganization(@PathParam("name")]] [[8079ed27-d17b-45a9-9e8a-7cb307a42310]]*/
		/* Insert Scribe [[Organization]][[deleteOrganization(@PathParam("name")]] [[8079ed27-d17b-45a9-9e8a-7cb307a42310]] delete by id code below */
		OrganizationDAO dao = new OrganizationDAO();
		int n = dao.delete(name);
		return n == 1 ? Response.ok().build() : Response.status(400).build();
    }

    @GET
    @Path("/{name}")
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Get organization by name", notes = "", response = Organization.class, tags={ "organization" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Organization.class),
        @ApiResponse(code = 400, message = "Invalid Organization variable supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Organization not found", response = Void.class)
    })
    public Response getOrganizationByName(@PathParam("name") @ApiParam("The name that needs to be fetched. Use organization1 for testing. ") String name) {
		/* Insert Scribe [[Organization]][[getOrganizationByName(@PathParam("name")]] [[56def44b-718e-47fe-9978-637161c61f89]]*/
		/* Insert Scribe [[Organization]][[getOrganizationByName(@PathParam("name")]] [[56def44b-718e-47fe-9978-637161c61f89]] getModelById code below */
		OrganizationDAO dao = new OrganizationDAO();
		Organization a = dao.find(name);
		if( a != null ) {
		    return Response.ok().entity(a).build();
		} else {
		    return Response.status(404).build();
		}

    }

    @PUT
    @Path("/{name}")
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @ApiOperation(value = "Update organization", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "organization" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response updateOrganization(@PathParam("name") @ApiParam("name of organization that needs to be deleted") String name,@Valid Organization organization) {
		/* Insert Scribe [[Organization]][[updateOrganization(@PathParam("name")]] [[329856ac-0031-4b3e-b1d6-4eb546e9b142]]*/
		/* Insert Scribe [[Organization]][[updateOrganization(@PathParam("name")]] [[329856ac-0031-4b3e-b1d6-4eb546e9b142]] updateModel by Id code below */
		OrganizationDAO dao = new OrganizationDAO();
		Organization a = dao.find(name);
		return Response.ok().entity(a).build();
    }
}
