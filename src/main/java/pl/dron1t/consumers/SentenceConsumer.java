package pl.dron1t.consumers;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;
import io.smallrye.reactive.messaging.kafka.Record;
import pl.dron1t.repositories.InMemoryMangledSentencedRepository;
import pl.dron1t.services.JodaizeStringService;

@ApplicationScoped
public class SentenceConsumer {

    private final Logger logger = Logger.getLogger(SentenceConsumer.class);
    private final InMemoryMangledSentencedRepository repository;
    private final JodaizeStringService jodaizeStringService;

    public SentenceConsumer(InMemoryMangledSentencedRepository repository, JodaizeStringService jodaizeStringService) {
        this.repository = repository;
        this.jodaizeStringService = jodaizeStringService;
    }

    @Incoming("words-in")
    public void receive(Record<UUID, String> record) {
        logger.infof("Got a record: %s, %s", record.key(), record.value());

        repository.addSentence(record.key(), jodaizeStringService.jodaize(record.value()));
    }
}
