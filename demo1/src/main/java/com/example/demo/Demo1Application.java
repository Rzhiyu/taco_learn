package com.example.demo;

import com.example.demo.beans.Ingredient;
import com.example.demo.repository.IngredientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
//    @Bean
//    public CommandLineRunner dataLoader(JdbcTemplate jdbcTemplate) {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//
//
//
//                 jdbcTemplate.query("select * from ingredient",(rs, rowNum) -> {
//                     throws SQLException{
//                         return new Ingredient(rs.getString("id"),rs.getString("name"),Ingredient.Type.valueOf(rs.getString("type")))
//                     }
//                 })
//            }
//        };
//    }
}
