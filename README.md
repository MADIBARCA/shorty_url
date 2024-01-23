# ShortyUrl API
Backend app for url shortening service in Java

## Getting started

### Working on the project

* Откройте проект с помощью удобвного для вас Java IDE
* В терминале, запуск проекта осуществляется с помощью: 'docker-compose up' или './gradlew bootRun'
    * Запускает сервер по адресу http://localhost:80

## Databases
По умолчанию база данных подключена к PostgreSQL с помощью сервиса FL0. Конфигурация для подключения к базе находится в файле application.yml.

## Endpoints
В этом проекте 2 эндпоинта:
      * POST /api/url/create - Создает url (в body прописывается параметр "url")
      * GET /api/url/{key} - Выдает оригинальный url
