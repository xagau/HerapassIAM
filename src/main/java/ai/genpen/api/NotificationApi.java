package ai.genpen.api;

import ai.genpen.dao.NotificationDAO;
import ai.genpen.models.Notification;
import io.swagger.annotations.*;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/notification")
@Api(description = "the notification API")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-05-30T01:12:52.555-04:00[America/Toronto]")
public class NotificationApi {
		/* Insert Scribe [[Notification]][[]] [[ea9a40be-b501-4272-b929-dc661c14261a]]*/

    @POST
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Create Notification", notes = "This can only be done by the logged in user.", response = Notification.class, tags={ "notification" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Notification.class)
    })
    public Response createNotification(@Valid Notification notification) {
		/* Insert Scribe [[Notification]][[createNotification(@Valid Notification notification)]] [[e30307a1-6ff8-494c-862f-0318115688c6]]*/
		/* Insert Scribe [[Notification]][[createNotification(@Valid Notification notification)]] [[e30307a1-6ff8-494c-862f-0318115688c6]] create code below */
		NotificationDAO dao = new NotificationDAO();
		Notification a = dao.find(notification.getId());
		if( a == null ){
		    int n = dao.insert(notification);
		    if (n > 0){
		        return Response.ok().entity(notification).build();
		    }
		}
		return Response.status(400).build();

    }

    @POST
    @Path("/createWithList")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Creates list of Notification with given input array", notes = "Creates list of notification with given input array", response = Notification.class, tags={ "notification" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation", response = Notification.class),
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response createNotificationsWithListInput(@Valid List<Notification> notification) {
		/* Insert Scribe [[Notification]][[createNotificationsWithListInput(@Valid List<Notification> notification)]] [[6d6c3567-9afc-4a01-a8b2-06fb632df04a]]*/
		/* Insert Scribe [[Notification]][[createNotificationsWithListInput(@Valid List<Notification> notification)]] [[6d6c3567-9afc-4a01-a8b2-06fb632df04a]] create code below */
		NotificationDAO dao = new NotificationDAO();
		for(int i = 0; i < notification.size(); i++ ) {
            Notification a = dao.find(notification.get(i).getId());
            if (a == null) {
                int n = dao.insert(notification.get(i));
                if (n > 0) {
                    return Response.ok().entity(notification.get(i)).build();
                }
            }
        }
		return Response.status(400).build();

    }

    @DELETE
    @Path("/{name}")
    @ApiOperation(value = "Delete notification", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "notification" })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid Notification variable supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Notification not found", response = Void.class)
    })
    public Response deleteNotification(@PathParam("name") @ApiParam("The notification that needs to be deleted by name") String name) {
		/* Insert Scribe [[Notification]][[deleteNotification(@PathParam("name")]] [[b2dc1002-94bd-41db-a173-08933c08d358]]*/
		/* Insert Scribe [[Notification]][[deleteNotification(@PathParam("name")]] [[b2dc1002-94bd-41db-a173-08933c08d358]] delete by id code below */
		NotificationDAO dao = new NotificationDAO();
		int n = dao.delete(name);
		return n == 1 ? Response.ok().build() : Response.status(400).build();

    }

    @GET
    @Path("/{name}")
    @Produces({ "application/json", "application/xml" })
    @ApiOperation(value = "Get notification by name", notes = "", response = Notification.class, tags={ "notification" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Notification.class),
        @ApiResponse(code = 400, message = "Invalid Notification variable supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Notification not found", response = Void.class)
    })
    public Response getNotificationByName(@PathParam("name") @ApiParam("The name that needs to be fetched. Use notification1 for testing. ") String name) {
		/* Insert Scribe [[Notification]][[getNotificationByName(@PathParam("name")]] [[7a033e2f-0f3f-4e1c-b5d2-ada2f64bccd2]]*/
		/* Insert Scribe [[Notification]][[getNotificationByName(@PathParam("name")]] [[7a033e2f-0f3f-4e1c-b5d2-ada2f64bccd2]] getModelById code below */
		NotificationDAO dao = new NotificationDAO();
		Notification a = dao.find(name);
		if( a != null ) {
		    return Response.ok().entity(a).build();
		} else {
		    return Response.status(404).build();
		}

    }

    @PUT
    @Path("/{name}")
    @Consumes({ "application/json", "application/xml", "application/x-www-form-urlencoded" })
    @ApiOperation(value = "Update notification", notes = "This can only be done by the logged in user.", response = Void.class, tags={ "notification" })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Void.class)
    })
    public Response updateNotification(@PathParam("name") @ApiParam("name of notification that needs to be deleted") String name,@Valid Notification notification) {
		/* Insert Scribe [[Notification]][[updateNotification(@PathParam("name")]] [[2ee35ae1-6615-4f91-9ab8-1abf0d3f930f]]*/
		/* Insert Scribe [[Notification]][[updateNotification(@PathParam("name")]] [[2ee35ae1-6615-4f91-9ab8-1abf0d3f930f]] updateModel by Id code below */
		NotificationDAO dao = new NotificationDAO();
		Notification a = dao.find(name);
		return Response.ok().entity(a).build();

    }
}
