package ku.message.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class MessageDto {

    @NotBlank
    private String user;

    @NotEmpty
    private String text;
}
