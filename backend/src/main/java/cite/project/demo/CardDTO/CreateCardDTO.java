package cite.project.demo.CardDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@Getter
@Setter
public class CreateCardDTO {


    @NotBlank(message = "Название не может быть пустым")
    private String title;

    private String description;

    private String imageUrl;


}
