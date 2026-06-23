package cite.project.demo.CardDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
@AllArgsConstructor
public class CreateCardDTO {


    @NotBlank(message = "Название не может быть пустым")
    private String title;

    private String description;

    private String imageUrl;

    private Long nextCardId;
}
