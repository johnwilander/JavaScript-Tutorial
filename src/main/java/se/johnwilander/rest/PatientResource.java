package se.johnwilander.rest;

import org.springframework.stereotype.Component;
import se.johnwilander.personnummer.BadPersonnummerException;
import se.johnwilander.patient.Patient;
import se.johnwilander.patient.PatientDb;
import se.johnwilander.personnummer.Personnummer;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @johnwilander
 */
@Path("/patient")
@Component
public class PatientResource {
    @Resource
    private PatientDb patientDataBase;

    @GET
    @Path("/{patientPersonnummer}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getUser(@PathParam("patientPersonnummer") String patientPersonnummerStr) { // throws NoSuchPatientException {
        Patient patient = null;
        Response response;
        try {
            patient = patientDataBase.getPatient(new Personnummer(patientPersonnummerStr));
            System.err.println("Tried to get patient with personnummer " + patientPersonnummerStr + ", result: " + patient);
            if (patient != null) {
                return Response.ok(patient).build();
            } else {
                return Response.ok(new BooleanStatus(false)).build();
            }
        } catch (BadPersonnummerException e) {
            response = Response.status(Response.Status.BAD_REQUEST).build();
        }
        return response;
    }

}
