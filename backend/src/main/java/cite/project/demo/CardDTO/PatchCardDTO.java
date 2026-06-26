package cite.project.demo.CardDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openapitools.jackson.nullable.JsonNullable;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchCardDTO {

    private JsonNullable<String> title = JsonNullable.undefined();

    private JsonNullable<String> description = JsonNullable.undefined();

    private JsonNullable<String> imageUrl = JsonNullable.undefined();

    private JsonNullable<Long> nextCardId = JsonNullable.undefined();

}
