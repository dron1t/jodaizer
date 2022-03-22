package pl.dron1t.models;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Sentence {

    private UUID id;
    private String value;
}
