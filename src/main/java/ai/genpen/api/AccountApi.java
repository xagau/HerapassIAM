package ai.genpen.api;

import ai.genpen.dao.AccountDAO;
import ai.genpen.models.Account;
import io.swagger.annotations.*;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/account")
@Api(description = "the account API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class AccountApi {
		/* Insert Scribe [[Account]][[]] [[28fc1922-b85d-491e-a615-af8f8ba6c75a]]*/

    @POST
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Create Account", notes = "This can only be done by the logged in user.", response = Account.class, tags={ "account" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Account.class)
    })
    public Response createAccount(@Valid Account account) {
		/* Insert Scribe [[Account]][[createAccount(@Valid Account account)]] [[13c366bc-6a91-44a3-b243-a7a1f69bb104]]*/
		/* Insert Scribe [[Account]][[createAccount(@Valid Account account)]] [[13c366bc-6a91-44a3-b243-a7a1f69bb104]] create code below */
		AccountDAO dao = new AccountDAO();
		Account a = dao.find(account.getId());
		if( a == null ){
		    int n = dao.insert(account);
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
    @ApiOperation(value = "Creates list of Account with given input array", notes = "Creates list of account with given input array", response = Account.class, tags={ "account" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Account.class),
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response createAccountsWithListInput(@Valid List<Account> account) {
		/* Insert Scribe [[Account]][[createAccountsWithListInput(@Valid List<Account> account)]] [[dff967df-850b-46ae-857d-e1495e33036e]]*/
		/* Insert Scribe [[Account]][[createAccountsWithListInput(@Valid List<Account> account)]] [[dff967df-850b-46ae-857d-e1495e33036e]] create code below */
		AccountDAO dao = new AccountDAO();
		for(int i =0; i < account.size(); i++ ) {
            Account a = dao.find(account.get(i).getId());
            if (a == null) {
                int n = dao.insert(account.get(i));
                if (n > 0) {
                    return Response.ok().entity(a).build();
                }
            }
        }
		return Response.status(400).build();

    }

    @DELETE
    @Path("/{name}")
    @ApiOperation(value = "Delete account", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "account" })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid Account variable supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Account not found", response = Void.class)
    })
    public Response deleteAccount(@PathParam("name") @ApiParam("The account that needs to be deleted by name") String name) {
		/* Insert Scribe [[Account]][[deleteAccount(@PathParam("name")]] [[c6827cbb-e59e-4256-9a84-a6167d539664]]*/
		/* Insert Scribe [[Account]][[deleteAccount(@PathParam("name")]] [[c6827cbb-e59e-4256-9a84-a6167d539664]] delete by id code below */
		AccountDAO dao = new AccountDAO();
		int n = dao.delete(name);
		return n == 1 ? Response.ok().build() : Response.status(400).build();

    }

    @GET
    @Path("/{name}")
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Get account by name", notes = "", response = Account.class, tags={ "account" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Account.class),
        @ApiResponse(code = 400, message = "Invalid Account variable supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Account not found", response = Void.class)
    })
    public Response getAccountByName(@PathParam("name") @ApiParam("The name that needs to be fetched. Use account1 for testing. ") String name) {
		/* Insert Scribe [[Account]][[getAccountByName(@PathParam("name")]] [[6c461779-992f-4896-9cea-700319c599e3]]*/
		/* Insert Scribe [[Account]][[getAccountByName(@PathParam("name")]] [[6c461779-992f-4896-9cea-700319c599e3]] getModelById code below */
		AccountDAO dao = new AccountDAO();
		Account a = dao.find(name);
		if( a != null ) {
		    return Response.ok().entity(a).build();
		} else {
		    return Response.status(404).build();
		}
    }

    @PUT
    @Path("/{name}")
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @ApiOperation(value = "Update account", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "account" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response updateAccount(@PathParam("name") @ApiParam("name of account that needs to be deleted") String name,@Valid Account account) {
		/* Insert Scribe [[Account]][[updateAccount(@PathParam("name")]] [[2af163e5-e121-41e2-ab63-fc1eb6fbad93]]*/
		/* Insert Scribe [[Account]][[updateAccount(@PathParam("name")]] [[2af163e5-e121-41e2-ab63-fc1eb6fbad93]] updateModel by Id code below */
		AccountDAO dao = new AccountDAO();
		Account a = dao.find(name);
		return Response.ok().entity(a).build();
    }
}
