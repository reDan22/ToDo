package cite.project.demo.controller;

import cite.project.demo.CardDTO.CreateCardDTO;
import cite.project.demo.model.Card;
import cite.project.demo.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/cards")
public class CardController {

    private final CardService cardService;


    @GetMapping
    public List<Card> getAllCards(){
        return cardService.getAllCards();
    }

    @GetMapping(value = "/{id}")
    public Card getCardById(@PathVariable Long id){
        return cardService.getCard(id);
    }

    @PostMapping
    public Card createCard(@RequestBody @Valid CreateCardDTO createCardDTO){
        return cardService.createCard(createCardDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCard(@PathVariable Long id){
        cardService.deleteCard(id);
    }


}
