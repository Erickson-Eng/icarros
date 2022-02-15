# ICarros - Desafio backend 

Esse desafio propõem que o desenvolvedor faça o consumo de uma api externa e realize a disponibilização desses dados via endpoint próprios.

## Como utilizar o projeto

Para estar utilizando o projeto é necessario ter:

- [Maven](https://maven.apache.org/download.cgi) *Faça download dos arquivos binarios*
- [Java 11](https://openjdk.java.net/install/)


### O que é o Maven?

O Maven é um gerenciador de dependencia que realiza o download de todos os arquivos necessarios para compilação do projeto.

### Como executar o projeto

Caso você já tenha essas dependencias instaladas, ou, faz uso por exemplo de uma IDE como intellij ou Eclipse que já contem elas embarcadas você pode estar utilizando os plugins.

Se você deseja estar executando o projeto pelo terminal é necessário é necessario que o maven esteja no seu path.
- Como adicionar o maven no path variable [Guia](https://stackoverflow.com/questions/45119595/how-to-add-maven-to-the-path-variable).

Quando você estiver dentro do diretorio backend/ basta executar no terminal o seguinte comando para executar localmente:
``` 
$ mvn clean install -DskipTests
$ mvn spring-boot:run
```

## Estrutura de diretorios

Foi utilizado a padronização da estrutura Hexagonal, entretanto, como há diretorios que não houve necessidade de implementação dentro do dominio do negocio e dos resources a implementação ficou da seguinte forma:

- Application
    - [Config](https://github.com/Erickson-Eng/icarros/tree/main/backend/src/main/java/com/icarros/backend/application/config)
    - [Controller](https://github.com/Erickson-Eng/icarros/tree/main/backend/src/main/java/com/icarros/backend/application/controller)
    - [DTO](https://github.com/Erickson-Eng/icarros/tree/main/backend/src/main/java/com/icarros/backend/application/dto/api)
    - [Exception](https://github.com/Erickson-Eng/icarros/tree/main/backend/src/main/java/com/icarros/backend/application/exception)

- Domain
    - [Service](https://github.com/Erickson-Eng/icarros/tree/main/backend/src/main/java/com/icarros/backend/domain/service) *Interfaces*
    - [Impl](https://github.com/Erickson-Eng/icarros/tree/main/backend/src/main/java/com/icarros/backend/domain/service/impl) *Classes concretas*
## Endpoints

Todos os endpoints da aplicação se encotram disponiveis localmente e na cloud [Heroku](https://icarros-backend.herokuapp.com/).

- [Serviço no qual os dados foram retirados](https://ergast.com/api/f1/2017/last/results.json)

*O heroku tem uma particularidade na versão aberta que quando ocioso ele não executa a cloud, então, quando executar o primeiro endpoint é possivel que ele demore para responder, ou, não responda de primeira. Espere um minuto e execute novamente*

| endpoint | Método HTTP | Retornos |
| -------- | ----------- | -------- |
| [/api/v1/formula1](https://icarros-backend.herokuapp.com/api/v1/formula1) | GET | Retorna todos os dados da api
| [/api/v1/formula1/races](https://icarros-backend.herokuapp.com/api/v1/formula1/races) | GET | Retorna uma tabela com todas as corridas
| [/api/v1/formula1/races/{season}](https://icarros-backend.herokuapp.com) | GET | Retorna uma tabela com as corridas da season (Ano).
| [/api/v1/formula1/driver](https://icarros-backend.herokuapp.com/api/v1/formula1/races/2017) | GET | Retorna todos os pilotos participantes da corrida.
| [/api/v1/formula1/driver/{driverId}](https://icarros-backend.herokuapp.com/api/v1/formula1/driver/vettel) | GET | Busca um piloto pelo seu identificador.
| [/api/v1/formula1/circuit](https://icarros-backend.herokuapp.com/api/v1/formula1/circuit) | GET | Retorna o circuito dos dados disponibilizados.
| [/swagger-ui.html](https://icarros-backend.herokuapp.com/swagger-ui.html) | | Documentação da API
