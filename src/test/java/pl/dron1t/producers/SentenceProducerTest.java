package pl.dron1t.producers;

import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.dron1t.models.Sentence;
import io.smallrye.reactive.messaging.kafka.Record;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SuppressWarnings("unchecked")
@QuarkusTest
public class SentenceProducerTest {


    @Test
    public void emitterIsCalled() {
        Emitter<Record<UUID,String>> mockedEmitter = Mockito.mock(Emitter.class);

        var sut = new SentenceProducer(mockedEmitter);
        sut.sendSentence(Sentence.builder().id(UUID.randomUUID()).value("value").build());
        verify(mockedEmitter).send(any(Record.class));
    }

}
