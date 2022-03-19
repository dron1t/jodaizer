package pl.dron1t.models;

import lombok.Data;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Setter
public class RequestBody {

    @NotBlank(message = "{request.body.message.not.blank}")
    @Size(min = 1, max = 256, message = "{request.body.message.size}")
    private String message;
}
