package cite.project.demo.DTO;

import cite.project.demo.enums.StatusEnum;

import lombok.*;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDTO {

    private String fullName;

    @Size(max = 1, message = "Пол необходимо указывать 1 буквой")
    private String gender;

    private StatusEnum status;


}
