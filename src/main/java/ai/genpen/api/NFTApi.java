package ai.genpen.api;

import ai.genpen.dao.NFTDAO;
import ai.genpen.models.NFT;
import io.swagger.annotations.*;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/nFT")
@Api(description = "the nFT API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class NFTApi {
		/* Insert Scribe [[NFT]][[]] [[f333c685-3f08-4068-bd94-e7d454b515af]]*/


    @POST
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Create NFT", notes = "This can only be done by the logged in user.", response = NFT.class, tags={ "nFT" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = NFT.class)
    })
    public Response createNft(@Valid NFT nft) {
        /* Insert Scribe [[NFT]][[createNft(@Valid NFT nft)]] [[0644d0ab-93cf-43ee-8d8a-94c478befc80]] create code below */
		NFTDAO dao = new NFTDAO();
		System.out.println(nft);
		NFT a = dao.find(nft.getId());
		if( a == null ){
		    int n = dao.insert(nft);
		    if (n > 0){
		        return Response.ok().entity(nft).build();
		    }
		}
		return Response.status(400).build();

    }

    @POST
    @Path("/createWithList")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Creates list of NFT with given input array", notes = "Creates list of nFT with given input array", response = NFT.class, tags={ "nFT" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = NFT.class),
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response createNftsWithListInput(@Valid List<NFT> nft) {
		/* Insert Scribe [[NFT]][[createNftsWithListInput(@Valid List<NFT> nft)]] [[7b6dea0d-cbd7-44da-898d-cf5fc5b9b174]]*/
		/* Insert Scribe [[NFT]][[createNftsWithListInput(@Valid List<NFT> nft)]] [[7b6dea0d-cbd7-44da-898d-cf5fc5b9b174]] create code below */
		NFTDAO dao = new NFTDAO();
		for(int i =0; i < nft.size(); i++ ) {
            NFT a = dao.find(nft.get(i).getId());
            if (a == null) {
                int n = dao.insert(nft.get(i));
                if (n > 0) {
                    return Response.ok().entity(a).build();
                }
            }
        }
		return Response.status(400).build();
    }

    @DELETE
    @Path("/{name}")
    @ApiOperation(value = "Delete nFT", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "nFT" })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid NFT variable supplied", response = Void.class),
        @ApiResponse(code = 404, message = "NFT not found", response = Void.class)
    })
    public Response deleteNft(@PathParam("name") @ApiParam("The nFT that needs to be deleted by name") String name) {
		/* Insert Scribe [[NFT]][[deleteNft(@PathParam("name")]] [[f3d1b37b-fbed-44c4-8254-b20de72cbc52]]*/
        return Response.ok().entity("magic!").build();
    }

    @GET
    @Path("/{name}")
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Get nFT by name", notes = "", response = NFT.class, tags={ "nFT" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = NFT.class),
        @ApiResponse(code = 400, message = "Invalid NFT variable supplied", response = Void.class),
        @ApiResponse(code = 404, message = "NFT not found", response = Void.class)
    })
    public Response getNftByName(@PathParam("name") @ApiParam("The name that needs to be fetched. Use nFT1 for testing. ") String name) {
		/* Insert Scribe [[NFT]][[getNftByName(@PathParam("name")]] [[cba9413f-2002-4d2b-9d15-2600a0c44f36]]*/
        return Response.ok().entity("magic!").build();
    }

    @PUT
    @Path("/{name}")
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @ApiOperation(value = "Update nFT", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "nFT" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response updateNft(@PathParam("name") @ApiParam("name of nFT that needs to be deleted") String name,@Valid NFT nft) {
		/* Insert Scribe [[NFT]][[updateNft(@PathParam("name")]] [[404bebff-95ef-43b1-bd12-af66ebe37b53]]*/
        return Response.ok().entity("magic!").build();
    }
}
