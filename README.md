# Tarefas API

## Desenvolvedores

Inicialmente, para gerar o container Docker com o banco de dados MySQL, execute (no diretório do projeto):

```docker compose up -d```

Para iniciar a aplicação em modo de desenvolvimento, execute (no diretório do projeto):

```mvn spring-boot:run```

A aplicação irá criar uma nova tabela no banco de dados e populá-la com 4 tarefas.
Se você não quiser que isso aconteça, remova o método `initDatabase` de `TarefasApplication.java`.

### Swagger

esta aplicação possui os endpoint documentado no swagger, para acessa-lo inicia a aplicação e acesse
```http://localhost:8080/swagger-ui/index.html```
