package cite.project.demo.service;

import cite.project.demo.DTO.CreateCardDTO;
import cite.project.demo.DTO.PatchCardDTO;
import cite.project.demo.DTO.UpdateCardDTO;
import cite.project.demo.model.Card;
import cite.project.demo.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    //Создание новой карточки
    public Card createCard(CreateCardDTO cardDTO){
        Card card = new Card();
        card.setTitle(cardDTO.getTitle());
        card.setDescription(cardDTO.getDescription());
        card.setImageUrl(cardDTO.getImageUrl());
        card.setNextCardId(cardDTO.getNextCardId());
        //TODO: заменить на реальный id пользователя
        card.setUserId(1L);


        return cardRepository.save(card);
    }

    //Получение карточки по id

    public Card getCard(Long id){
        return cardRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Карточка с ID:" + id + "не найдена!"));
    }

    //Получение всех карточек
    public List<Card> getAllCards(){
        return cardRepository.findAll();
    }

    @Transactional
    public void deleteCard(Long id) {
        if (cardRepository.existsById(id)){
            cardRepository.deleteById(id);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Карточки с ID: " + id + " не существует");
        }


    }

    @Transactional
    public Card modifyCard(Long id, PatchCardDTO patchCardDTO){
        Card modifiedCard =  cardRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        if (patchCardDTO.getTitle().isPresent()) {
            modifiedCard.setTitle(patchCardDTO.getTitle().get());
        }
        if (patchCardDTO.getDescription().isPresent()) {
            modifiedCard.setDescription(patchCardDTO.getDescription().get());
        }
        if (patchCardDTO.getImageUrl().isPresent()) {
            modifiedCard.setImageUrl(patchCardDTO.getImageUrl().get());
        }
        if (patchCardDTO.getNextCardId().isPresent()) {
            modifiedCard.setNextCardId(patchCardDTO.getNextCardId().get());
        }

        return cardRepository.save(modifiedCard);

    }

    @Transactional
    public Card replaceCard(Long id, UpdateCardDTO updateCardDTO){

        Card modifiedCard = cardRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        modifiedCard.setTitle(updateCardDTO.getTitle());
        modifiedCard.setDescription(updateCardDTO.getDescription());
        modifiedCard.setImageUrl(updateCardDTO.getImageUrl());
        modifiedCard.setNextCardId(updateCardDTO.getNextCardId());


        return cardRepository.save(modifiedCard);
    }


}
