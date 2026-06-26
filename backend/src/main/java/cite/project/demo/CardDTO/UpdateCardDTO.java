package cite.project.demo.CardDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCardDTO {

    private String title;

    private String description;

    private String imageUrl;

    private Long nextCardId;
}
