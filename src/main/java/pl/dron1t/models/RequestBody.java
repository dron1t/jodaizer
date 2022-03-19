package pl.dron1t.models;

import lombok.Data;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Data
@Setter
public class RequestBody {

    @NotBlank(message = "{request.body.should.be.not.empty}")
    private String message;
}
