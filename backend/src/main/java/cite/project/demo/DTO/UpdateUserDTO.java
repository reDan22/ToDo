package cite.project.demo.DTO;

import cite.project.demo.enums.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class UpdateUserDTO {

    private String fullName;

    @Size(max = 1, message = "Пол необходимо указывать 1 буквой")
    private String gender;

    private StatusEnum status;


}
