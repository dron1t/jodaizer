package pl.dron1t.producers;

import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import pl.dron1t.models.Sentence;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class SentenceProducer {

    Emitter<Record<UUID, String>> emitter;

    public SentenceProducer(@Channel("words-out") Emitter<Record<UUID, String>> emitter) {
        this.emitter = emitter;
    }

    public void sendSentence(Sentence words) {
        emitter.send(Record.of(words.getId(), words.getValue()));
    }
}
