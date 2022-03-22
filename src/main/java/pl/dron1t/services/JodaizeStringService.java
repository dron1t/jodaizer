package pl.dron1t.services;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class JodaizeStringService {

    public String jodaize(String message) {
        var parts = new ArrayList<>(List.of(message.split("[\\W]")));
        Collections.shuffle(parts);

        return String.join(" ", parts).replaceAll("\\s\\s", " ");
    }
}
