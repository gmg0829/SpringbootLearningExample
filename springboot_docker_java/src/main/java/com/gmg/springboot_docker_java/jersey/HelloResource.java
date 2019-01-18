package com.gmg.springboot_docker_java.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author gmg
 * @Title:
 * @Package
 * @Description:
 * @date 2019/1/18  11:06
 */
@Path("/hello")
public class HelloResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello()
    {
        return "Hello World!" ;
    }

    @GET
    @Path("/{param}")
    @Produces("text/plain;charset=UTF-8")
    public String sayHelloToUTF8(@PathParam("param") String username)
    {
        return "Hello " + username;
    }

}
