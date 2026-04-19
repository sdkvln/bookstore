# Книжный магазин

Backend для онлайн-книжного магазина.

Реализована работа с авторами, произведениями, книгами и бронированием книг.

## Структура проекта

```text
src/main/java/com/evelina/bookstore
├── controller   # REST-контроллеры
├── dto          # DTO для запросов и ответов
├── entity       # JPA-сущности
├── exception    # пользовательские исключения
├── mapper       # преобразование Entity в DTO
├── repository   # Spring Data JPA репозитории
└── service      # бизнес-логика

## Запуск проекта

### 1. Запустить PostgreSQL

В корне проекта выполнить:

```bash
docker compose up -d
```

PostgreSQL запускается в Docker и доступен на порту `5433`.


### 2. Запустить приложение

В корне проекта выполнить:

```bash
./mvnw spring-boot:run
```

После запуска приложение будет доступно по адресу:

```text
http://localhost:8080
```

Таблицы создаются автоматически при запуске

## Примеры запросов

### Создать автора

```http
POST /api/authors
Content-Type: application/json
```

```json
{
    "firstName":"Федор",
    "lastName": "Достоевский"
}
```

### Получить автора по ID

```http
GET /api/authors/1
```
вернется ответ:
```json
{
    "id": 1,
    "firstName": "Федор",
    "lastName": "Достоевский"
}
```
### Создать произведение

```http
POST /api/works
Content-Type: application/json
```

```json
{
    "title":"Преступление и наказание",
    "authorId": 1
}
```

### Создать книгу

```http
POST /api/books
Content-Type: application/json
```

```json
{
  "isbn": "34",
  "publisher": "аст",
  "year": 2000,
  "price": 700,
  "workId": 1
}
```

### Получить все книги автора

```http
GET /api/authors/1/books
```

пример полученного ответа:
```json
[
    {
        "id": 2,
        "isbn": "334",
        "title": "Преступление и наказание",
        "publisher": "аст",
        "year": 1900,
        "price": 900.0,
        "status": "AVAILABLE",
        "workId": 1
    },
    {
        "id": 3,
        "isbn": "34",
        "title": "Преступление и наказание",
        "publisher": "аст",
        "year": 2000,
        "price": 700.0,
        "status": "AVAILABLE",
        "workId": 1
    },
    {
        "id": 1,
        "isbn": "33456",
        "title": "Преступление и наказание",
        "publisher": "аст",
        "year": 1869,
        "price": 1000.0,
        "status": "RESERVED",
        "workId": 1
    }
]
```
### Забронировать книгу

```http
POST /api/books/1/reserve
```

Если книга доступна, ее статус изменится с `AVAILABLE` на `RESERVED`.

Если книга уже забронирована или продана, API вернет ошибку `409 Conflict`.

## Обработка ошибок

- `400 Bad Request` - ошибка валидации входных данных
- `404 Not Found` - автор, произведение или книга не найдены
- `409 Conflict` - книга недоступна для бронирования
- `500 Internal Server Error` - внутренняя ошибка сервера
