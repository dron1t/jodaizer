package pl.dron1t.controllers;

import pl.dron1t.models.RequestBody;
import pl.dron1t.models.Sentence;
import pl.dron1t.producers.SentenceProducer;
import pl.dron1t.repositories.MangledSentencesRepository;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

import static javax.ws.rs.core.Response.*;

@Path("/kafko-jodas")
public class KafkoJodaizerController {

    private final SentenceProducer sentenceProducer;
    private final MangledSentencesRepository mangledSentencesRepository;

    public KafkoJodaizerController(SentenceProducer sentenceProducer, MangledSentencesRepository mangledSentencesRepository) {
        this.sentenceProducer = sentenceProducer;
        this.mangledSentencesRepository = mangledSentencesRepository;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response run(@Valid RequestBody requestBody) {

        sentenceProducer.sendSentence(Sentence.builder().id(UUID.randomUUID()).value(requestBody.getMessage()).build());
        return accepted().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {

        return ok(mangledSentencesRepository.getAllDb()).build();
    }
}
