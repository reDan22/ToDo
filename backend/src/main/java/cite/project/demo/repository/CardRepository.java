package cite.project.demo.repository;

import cite.project.demo.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    //TODO: Реализовать функционал поиска полный
    List<Card> findByTitleContainingIgnoreCase(String keyword);
}
