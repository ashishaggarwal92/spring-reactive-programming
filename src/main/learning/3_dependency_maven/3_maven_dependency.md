For suing mono and flux we need

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>io.projectreactor</groupId>
            <artifactId>reactor-test</artifactId>
            <scope>test</scope>
        </dependency>

2) In order to connect ith DB

        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-r2dbc</artifactId>
        </dependency>
        <dependency>
            <groupId>io.r2dbc</groupId>
            <artifactId>r2dbc-h2</artifactId>
        </dependency>

3) connection factory

# for mysql
server.port=8081
#jdbc:mysql://localhost:3307/database
spring.r2dbc.url=r2dbc:mysql://localhost:3307/boot_work
spring.r2dbc.username=root
spring.r2dbc.password=root

# for h2
    @Configuration
    @EnableR2dbcRepositories
    class R2DBCConfiguration extends AbstractR2dbcConfiguration {
    @Bean
    public H2ConnectionFactory connectionFactory() {
    return new H2ConnectionFactory(
    H2ConnectionConfiguration.builder()
    .url("mem:testdb;DB_CLOSE_DELAY=-1;")
    .username("sa")
    .build()
    );
    }
    }


4) Repository

        interface PlayerRepository extends ReactiveCrudRepository<Player, Integer> {}

5) Model

           @Data
           @NoArgsConstructor
           @AllArgsConstructor
           class Player {
           @Id
           Integer id;
           String name;
           Integer age;
           }

6) Custom Queries

           @Query("select id, name, age from player where name = $1")
           Flux<Player> findAllByName(String name);
        
           @Query("select * from player where age = $1")
           Flux<Player> findByAge(int age);


7) Batch: Another feature of R2DBC is to create batches. A batch is useful when executing multiple SQL statements as they’ll perform better than individual operations.

To create a Batch we need a Connection object:

    Batch batch = connection.createBatch();

