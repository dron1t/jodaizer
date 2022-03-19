package pl.dron1t.controllers;

import pl.dron1t.models.RequestBody;
import pl.dron1t.models.ResponseBody;
import pl.dron1t.services.JodaizeStringService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/jodaizes")
public class JodaizeController {

    private final JodaizeStringService jodaizeStringService;

    public JodaizeController(JodaizeStringService jodaizeStringService) {
        this.jodaizeStringService = jodaizeStringService;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseBody run(@Valid RequestBody requestBody) {

        return new ResponseBody(jodaizeStringService.jodaize(requestBody.getMessage()));
    }
}
