package pl.dron1t.repositories;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class InMemoryMangledSentencedRepository implements MangledSentencesRepository {

    private final Map<UUID, String> db = new HashMap<>();


    @Override
    public void addSentence(UUID uuid, String sentence) {
        this.db.put(uuid, sentence);
    }

    @Override
    public Collection<String> getAllDb() {
        return db.values();
    }

    @Override
    public String getById(UUID id) {
        return db.get(id);
    }
}
