
## Developers

Initially, to generate the Docker container with the MySQL database, run (in the project directory):

```docker compose up -d```

To start the application for development, run (in the project directory):

```mvn spring-boot:run```

The application will create a new table in the database and populate it with 4 tasks.
If you do not want this to happen, remove the `initDatabase` method from `TarefasApplication.java`.
