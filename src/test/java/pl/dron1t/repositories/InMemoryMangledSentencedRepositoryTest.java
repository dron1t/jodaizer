package pl.dron1t.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class InMemoryMangledSentencedRepositoryTest {

    @Test
    void addSentence_shouldAddSentence() {
        var sut = new InMemoryMangledSentencedRepository();
        var id = UUID.randomUUID();
        sut.addSentence(id, "nicetest");

        Assertions.assertEquals("nicetest", sut.getById(id));
    }

    @Test
    void getAllDb_shouldReturnDb() {
        var sut = new InMemoryMangledSentencedRepository();
        var id = UUID.randomUUID();
        sut.addSentence(id, "nicetest");

        var db = sut.getAllDb();
        Assertions.assertEquals(1, db.size());
    }

    @Test
    void getById_shouldReturnById() {
        var sut = new InMemoryMangledSentencedRepository();
        var id = UUID.randomUUID();
        sut.addSentence(id, "nicetest");

        Assertions.assertEquals("nicetest", sut.getById(id));
    }
}