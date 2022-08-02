# Запуск тестов
Для запуска необходимо ПО 
* IntelliJ IDEA
* Docker Desktop
* Node.js
1. Запустить Docker Desktop
2. Запустить IntelliJ IDEA и открыть проект
## Тесты с MySQL
1. Для запуска контейнеров выполниить `docker-compose up`
2. Перейти в каталог `cd gate-simulator` и выполнить `npm start` для запуска банковских сервисов
3. Для запуска приложения выполнить `java -jar artifacts/aqa-shop.jar -Dspring.datasource.url=jdbc:mysql://localhost:3306/app`
4. Запустить тесты командой `./gradlew test -Durl=jdbc:mysql://localhost:3306/app` и дождаться их прохождения
5. После тестов для генерации и просмотра отчета выполнить `./gradlew allureserve`
6. Нажать `Ctrl+C` и `y` для выхода
7. Выполнить `docker-compose down` для остановки контейнеров
8. Выполнить `taskkill /f /im java.exe` для завершения работы приложения
# Тесты с PostgreSQL
1. Для запуска контейнеров выполниить `docker-compose up`
2. Перейти в каталог `cd gate-simulator` и выполнить `npm start` для запуска банковских сервисов
3. Для запуска приложения выполнить `java -jar artifacts/aqa-shop.jar -Dspring.datasource.url=jdbc:postgresql://localhost:5432/postgres`
4. Запустить тесты командой `./gradlew test -Durl=jdbc:postgresql://localhost:5432/postgres` и дождаться их прохождения
5. После тестов для генерации и просмотра отчета выполнить `./gradlew allureserve`
6. Нажать `Ctrl+C` и `y` для выхода
7. Выполнить `docker-compose down` для остановки контейнеров
8. Выполнить `taskkill /f /im java.exe` для завершения работы приложения
