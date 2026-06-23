# Task Tracker REST API

REST API для системы управления задачами с возможностью связывания карточек. Написано на Java и Spring Boot.

## Стек и технологии
* **Backend:** Java, Spring Boot (Web, Data JPA, Validation)
* **База данных:** PostgreSQL
* **Миграции:** Liquibase
* **Инструменты:** Maven, Lombok, Swagger / OpenAPI

## Архитектурные особенности
* **Связанные задачи:** Реализована структура связного списка (Linked List) на уровне БД. Карточки ссылаются друг на друга через `next_card_id` (Foreign Keys).
* **Оптимизация:** Использование `existsById()` вместо выгрузки целых сущностей в память при проверках. Разделение слоев через DTO.
* **Безопасность:** Исключение `application.properties` из контроля версий.
