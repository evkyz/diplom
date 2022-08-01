# Запуск тестов
Для запуска необходимо ПО 
* IntelliJ IDEA
* Docker Desktop
* Node.js
1. Запустить Docker Desktop
2. Запустить IntelliJ IDEA и открыть проект
## Тесты с MySQL
1. При необходимости изменить в application.properties `spring.datasource.url=jdbc:postgresql://localhost:5432/postgres` на `spring.datasource.url=jdbc:mysql://localhost:3306/app` и
2. В build.gradle `systemProperty 'url', System.getProperty('url', "jdbc:postgresql://localhost:5432/postgres")` на `systemProperty 'url', System.getProperty('url', "jdbc:mysql://localhost:3306/app")`
3. Для запуска контейнеров выполниить `docker-compose up`
4. Перейти в каталог `cd gate-simulator` и выполнить `npm start` для запуска банковских сервисов
5. Для запуска приложения выполнить `java -jar artifacts/aqa-shop.jar`
6. Запустить тесты командой `./gradlew test` и дождаться их прохождения
7. После тестов для генерации и просмотра отчета выполнить `./gradlew allureserve`
8. Нажать `Ctrl+C` и `y` для выхода
9. Выполнить `docker-compose down` для остановки контейнеров
10. Выполнить `taskkill /f /im java.exe` для завершения работы приложения
# Тесты с PostgreSQL
1. Изменить в application.properties `spring.datasource.url=jdbc:mysql://localhost:3306/app` на `spring.datasource.url=jdbc:postgresql://localhost:5432/postgres`
2. Изменить в build.gradle `systemProperty 'url', System.getProperty('url', "jdbc:mysql://localhost:3306/app")` на `systemProperty 'url', System.getProperty('url', "jdbc:postgresql://localhost:5432/postgres")`
3. Для запуска контейнеров выполниить `docker-compose up`
4. Перейти в каталог `cd gate-simulator` и выполнить `npm start` для запуска банковских сервисов
5. Для запуска приложения выполнить `java -jar artifacts/aqa-shop.jar`
6. Запустить тесты командой `./gradlew test` и дождаться их прохождения
7. После тестов для генерации и просмотра отчета выполнить `./gradlew allureserve`
8. Нажать `Ctrl+C` и `y` для выхода
9. Выполнить `docker-compose down` для остановки контейнеров
10. Выполнить `taskkill /f /im java.exe` для завершения работы приложения
