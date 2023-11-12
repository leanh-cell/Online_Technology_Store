# Online_Technology_Store


## Config JAVA_HOME
Add JAVA_HOME in system environment. Run echo %JAVA_HOME% to check value (Project use JDK 11)

Port default config in file [application.properties]

    server.port: 8080

* [http://localhost:8080/home](http://localhost:8080/home)

## Database config
Start Xampp in file application.properties change the path to the database :

    spring.datasource.url=jdbc:mysql://<my_port>/nanogear_store?createDatabaseIfNotExist=true
    spring.datasource.username=<my_username>
    spring.datasource.password=<my_password>

    Ex:
       spring.datasource.url=jdbc:mysql://127.0.0.1/nanogear_store?createDatabaseIfNotExist=true
       spring.datasource.username=root
       spring.datasource.password=123456

## Password encrypt
Password in table encrypted by `new BCryptPasswordEncoder().encode(password)` note: The account cookie memory period is 10 days

    Ex: new BCryptPasswordEncoder().encode("admin")
    Output: $2a$12$3hrlZBOJDCrIynDknlATE.5M3WaKdafOrMSDsImFJjDJOvuy9BKpy

## Source code structure
#### Source code java
    /java
      /com.doapp.nanogear
        /been
        /config
        /controller
           /admin (admin controller)
           (user & home controller) 
        /dto
        /entity
        /interceptor
        /repository
        /sesrvice
           /serviceImpl
           (class interface service) 

#### Resource file:
    /resources
      /db.migration(contains sql script files for migrate database: V<version>__init_<description>.sql)
#### webapp
    /css
    /image
    /WEB-INF
      /common
      /layouts
      /views
        /admin
        /user
      tiles.xml

### DB Diagram

* https://dbdiagram.io/d/6416a0b6296d97641d8904ef

### Flyway database migration

    spring.flyway.baseline-on-migrate=true

`spring.flyway.baseline-on-migrate=true` auto execute sql script in file resources/db/migration/Vx__<description>.sql
SQL Script version information is managed in the `flyway_schema_history` table

