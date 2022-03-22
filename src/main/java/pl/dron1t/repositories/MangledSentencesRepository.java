package pl.dron1t.repositories;

import java.util.Collection;
import java.util.UUID;

public interface MangledSentencesRepository {

    public void addSentence(UUID uuid, String sentence);

    Collection<String> getAllDb();

    String getById(UUID id);
}
