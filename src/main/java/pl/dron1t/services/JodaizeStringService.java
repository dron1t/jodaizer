package pl.dron1t.services;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class JodaizeStringService {

    public String jodaize(String message) {
        var parts = message.split(",");
        var result = new ArrayList<String>();
        for (String part : parts) {
            var list = part.split(" ");
            result.addAll(List.of(list));
        }

        Collections.shuffle(result);

        return String.join(" ", result).replaceAll("\\s\\s", " ");
    }
}
