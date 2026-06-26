package cite.project.demo.repository;

import cite.project.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //TODO: Написать findAll() через пагинацию Используя @Query с возможностью сортировать по любому полю. без дублей пагинации на стороне БД, не в памяти
    //TODO: Сделать миграцию чтобы таблица заполнялась данными штук 10 а если запрос уже выполнен то не выполнять егор
}