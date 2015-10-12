package org.gochev;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by gochev on 10/6/15.
 */

@Controller
@Path("hello")
public class HelloController {

    @Inject
    private Models models;

    @GET
    public String hello(){
        models.put("msg","Hello World");
        return "/hello.jsp";
    }
}
