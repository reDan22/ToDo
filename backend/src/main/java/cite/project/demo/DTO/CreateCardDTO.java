package cite.project.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardDTO {


    @NotBlank(message = "Название не может быть пустым")
    private String title;

    private String description;

    private String imageUrl;

    private Long nextCardId;
}
