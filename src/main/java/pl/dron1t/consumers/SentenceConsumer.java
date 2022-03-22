package pl.dron1t.consumers;

import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;
import pl.dron1t.repositories.MangledSentencesRepository;
import pl.dron1t.services.JodaizeStringService;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class SentenceConsumer {

    private final Logger logger = Logger.getLogger(SentenceConsumer.class);
    private final MangledSentencesRepository repository;
    private final JodaizeStringService jodaizeStringService;

    public SentenceConsumer(MangledSentencesRepository repository, JodaizeStringService jodaizeStringService) {
        this.repository = repository;
        this.jodaizeStringService = jodaizeStringService;
    }

    @Incoming("words-in")
    public void receive(Record<UUID, String> record) {
        logger.infof("Got a record: %s, %s", record.key(), record.value());

        repository.addSentence(record.key(), jodaizeStringService.jodaize(record.value()));
    }
}
