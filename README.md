#Fitness Tracker REST API

Backendový REST API systém pre správu a sledovanie tréningov, postavený na **Spring Boot 3/Java 21**, s prezistenciou v databáze **PostgresSQL**, interaktívnou dokumnetáciou cez **Swagger/OpenAPI** a plnou kontajnerizáciou cez **Docker**.

---

## Použitý Tech Stack

- **Jazyk & Framework:** Java 21, Spring Boot
- **Bezpečnosť":** Spring Security, JWT (JSON Web Tokens)
- **Dáta & Databáza:** Spring Data JPA, Hibernate, PostgreSQL
- **Validácia:** Jakarta Bean Validation ('@Valid', custom validačné anotácie)
- **Dokumentácia:** OpenAPI 3/Swagger UI (springdoc-openapi)
- **Testovanie:** JUnit 5, Mockito
- **DevOps & Kontajnerizácia:** Docker, Docker Compose, Multi-stage builds, Docker Hub

---

## Kľúčové funkcionality

- **Autentifikácia & Autorizácia:** Bezpečné prihlasovanie používateľov pomocou JWT tokenov a bezstavovej (stateless) relácie
- **Manažment tréningov (CRUD):** Zaznamenávanie cvikov, sérií, váhy a opakovaní s priradením ku konktrétnemu používateľovi
- **Unit testovanie:** Izolované testovanie servisnej logiky ('WorkoutService') s mockovaním závislosti cez Mockito
- **Docker Compose Orchestration:** Jedno-príkazové spustenie celej infraštruktúry (aplikácia + databáza) bez nutnosti lokálnej inštalácie Javy či PostgreSQL

---

## Spustenie projektu cez Docker

Projekt je plne pripravený na spustenie cez Docker Compose.

### Požiadavky:
- [Docker Desktop] (https://www.docker.com/products/docker-desktop/) (nainštalovaný a spustený)
- git clone https://github.com/TomasFejczo/Fitness-app.git

##Docker Hub Image
-Docker image aplikácie je publikovaný a dostupný na Docker Hub.
- fejci/fitapp:latest