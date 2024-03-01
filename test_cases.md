#Тест-кейс 1 Создание сущности.

## Предусловие:
###headers
1. Content-Type: application/json
2. accept: text/plain 
###body
```json
{
  "addition": {
    "additional_info": "Дополнительные сведения",
    "additional_number": 123
  },
  "important_numbers": [
    42,
    87,
    15
  ],
  "title": "Заголовок сущности",
  "verified": true
}
```

## Шаги:
1. Выполнить POST http://localhost:8080/api/create
2. Проверить код ответа
3. Проверить тело ответа
4. Выполнить GET http://localhost:8080/get/{id} (ID, полученный на шаге 1)
5. Проверить код ответа
6. Проверить тело ответа
7. Выполнить DELETE http://localhost:8080/api/delete/{id} (ID, полученный на шаге 1)
## Ожидаемый результат:
1. Запрос успешно отправлен на сервер
2. 200 ОК
3. Получен уникальный сгенерированный ID
4. Запрос успешно отправлен на сервер
5. 200 ОК 
6. Найдена сущность с ID, полученный на шаге 3. Данные соответствуют ранее введенным данным на шаге 1
7. Запрос успешно отправлен на сервер

#Тест-кейс 2 Удаление сущности.

## Предусловие:
###headers
1. Content-Type: application/json
###body
```json
{
  "addition": {
    "additional_info": "Дополнительные сведения",
    "additional_number": 123
  },
  "important_numbers": [
    42,
    87,
    15
  ],
  "title": "Заголовок сущности",
  "verified": true
}
```

## Шаги:
1. Выполнить POST http://localhost:8080/api/create
2. Проверить код ответа
3. Проверить тело ответа
4. Выполнить DELETE http://localhost:8080/api/delete/{id} (ID, полученный на шаге 1)
5. Проверить код ответа
6. Выполнить GET http://localhost:8080/get/{id} (ID, полученный на шаге 1)
7. Проверить код ответа
8. Проверить тело ответа
## Ожидаемый результат:
1. Запрос успешно отправлен на сервер
2. 200 ОК
3. Получен уникальный сгенерированный ID
4. Запрос успешно отправлен на сервер
5. 204 No Content
6. Запрос успешно отправлен на сервер
7. 500 Error: Internal Server Error
8. Ответ соответствует сообщению:
```json
{
  "error": "no rows in result set"
}
```

#Тест-кейс 3 Получение сущности.

## Предусловие:
###headers
1. Content-Type: application/json
###body
```json
{
  "addition": {
    "additional_info": "Дополнительные сведения",
    "additional_number": 123
  },
  "important_numbers": [
    42,
    87,
    15
  ],
  "title": "Заголовок сущности",
  "verified": true
}
```

## Шаги:
1. Выполнить POST http://localhost:8080/api/create
2. Проверить код ответа
3. Проверить тело ответа
4. Выполнить GET http://localhost:8080/get/{id} (ID, полученный на шаге 1)
5. Проверить код ответа
6. Проверить заголовки ответа
7. Проверить тело ответа
8. Выполнить DELETE http://localhost:8080/api/delete/{id} (ID, полученный на шаге 1)
## Ожидаемый результат:
1. Запрос успешно отправлен на сервер
2. 200 ОК
3. Получен уникальный сгенерированный ID
4. Запрос успешно отправлен на сервер
5. 200 ОК 
6. Content-Type: application/json
7. Найдена сущность с ID, полученный на шаге 3. body соответствует:
 ```json
{
  "addition": {
    "additional_info": "Дополнительные сведения",
    "additional_number": 123
  },
  "important_numbers": [
    42,
    87,
    15
  ],
  "title": "Заголовок сущности",
  "verified": true,
  "id": {id}
}
```
8. Запрос успешно отправлен на сервер


#Тест-кейс 4 Получение списка сущностей.

## Предусловие:
###headers
1. Content-Type: application/json
###body
```json
{
  "addition": {
    "additional_info": "Дополнительные сведения",
    "additional_number": 123
  },
  "important_numbers": [
    42,
    87,
    15
  ],
  "title": "Заголовок сущности",
  "verified": true
}
```

## Шаги:
1. Выполнить POST http://localhost:8080/api/create
2. Проверить код ответа
3. Проверить тело ответа
4. Повторить 1-3 шаги
5. Выполнить GET http://localhost:8080/get/getAll
6. Проверить код ответа
7. Проверить заголовки ответа
8. Проверить тело ответа
9. Выполнить DELETE http://localhost:8080/api/delete/{id} (ID, полученный на шаге 1)
10. Повторить шаг 9 (id взять из шага 4)
## Ожидаемый результат:
1. Запрос успешно отправлен на сервер
2. 200 ОК
3. Получен уникальный сгенерированный ID
4. Получен второй уникальный сгенерированный ID
5. Запрос успешно отправлен на сервер 
6. 200 ОК
7. Content-Type: application/json
8. Найдены сущности с ID, полученные на шаге 3 и 4. body соответствует:
 ```json
{
  "entity": [
    {
      "addition": {
        "additional_info": "Дополнительные сведения",
        "additional_number": 123
      },
      "important_numbers": [
        42,
        87,
        15
      ],
      "title": "Заголовок сущности",
      "verified": true,
      "id": {
        id_1
      }
    },
    {
      "addition": {
        "additional_info": "Дополнительные сведения",
        "additional_number": 123
      },
      "important_numbers": [
        42,
        87,
        15
      ],
      "title": "Заголовок сущности",
      "verified": true,
      "id": {
        id_2
      }
    }
  ]
}
```
9. Запрос успешно отправлен на сервер
10. Запрос успешно отправлен на сервер

#Тест-кейс 5 Получение списка сущностей по title и verified.

## Предусловие:
###headers
1. Content-Type: application/json
###body
```json
{
  "addition": {
    "additional_info": "Дополнительные сведения",
    "additional_number": 123
  },
  "important_numbers": [
    42,
    87,
    15
  ],
  "title": "another title",
  "verified": false
}
```
###params:
1. title="another title"
2. verified=false

## Шаги:
1. Выполнить POST http://localhost:8080/api/create
2. Проверить код ответа
3. Проверить тело ответа
4. Выполнить GET http://localhost:8080/get/getAll?title=another%20title&verified=false
5. Проверить код ответа
6. Проверить заголовки ответа
7. Проверить тело ответа
8. Выполнить DELETE http://localhost:8080/api/delete/{id} (ID, полученный на шаге 1)

## Ожидаемый результат:
1. Запрос успешно отправлен на сервер
2. 200 ОК
3. Получен уникальный сгенерированный ID
4. Запрос успешно отправлен на сервер
5. 200 ОК
6. Content-Type: application/json
7. Найдена сущность с ID, полученный на шаге 3. body соответствует:
 ```json
{
  "entity": [
    {
      "addition": {
        "additional_info": "Дополнительные сведения",
        "additional_number": 123
      },
      "important_numbers": [
        42,
        87,
        15
      ],
      "title": "another title",
      "verified": false
    }
  ]
}
```
8. Запрос успешно отправлен на сервер

#Тест-кейс 6 Обновление сущности.

## Предусловие:
###headers
1. Content-Type: application/json
###body
```json
{
  "addition": {
    "additional_info": "Дополнительные сведения",
    "additional_number": 123
  },
  "important_numbers": [
    42,
    87,
    15
  ],
  "title": "updated title",
  "verified": false
}
```
###path-param:
1. id={id}

## Шаги:
1. Выполнить POST http://localhost:8080/api/create
2. Проверить код ответа
3. Проверить тело ответа
4. Выполнить PATCH http://localhost:8080/api/patch/{id} (ID, полученный на шаге 3)
5. Проверить код ответа
6. Выполнить GET http://localhost:8080/get/{id} (ID, полученный на шаге 3)
7. Проверить код ответа
8. Проверить тело ответа
9. Выполнить DELETE http://localhost:8080/api/delete/{id} (ID, полученный на шаге 1)

## Ожидаемый результат:
1. Запрос успешно отправлен на сервер
2. 200 ОК
3. Получен уникальный сгенерированный ID
4. Запрос успешно отправлен на сервер
5. 204 No Content
6. Запрос успешно отправлен на сервер
7. 200 OK
8. Найдена сущность с ID, полученный на шаге 3. body соответствует:
 ```json
{
  "entity": [
    {
      "addition": {
        "additional_info": "Дополнительные сведения",
        "additional_number": 123
      },
      "important_numbers": [
        42,
        87,
        15
      ],
      "title": "updated title",
      "verified": false
    }
  ]
}
```
9. Запрос успешно отправлен на сервер
