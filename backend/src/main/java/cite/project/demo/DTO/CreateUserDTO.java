package cite.project.demo.DTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CreateUserDTO {

    @NotBlank(message = "ФИО не должно быть пустым")
    private String fullName;

    @Size(max = 1, message = "Пол необходимо указывать 1 буквой")
    private String gender;

}
