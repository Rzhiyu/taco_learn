package com.example.demo;

import com.example.demo.beans.Ingredient;
import com.example.demo.beans.Ingredient.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

@SpringBootTest
class JdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;
//    @Test
//    public void findAll() {
//        String sql = "select * from twitter_crawler";
//        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
//        for (Map<String, Object> t:maps) {
//            Iterator<Map.Entry<String, Object>> iterator = t.entrySet().iterator();
//            while(iterator.hasNext()){
//                Map.Entry<String, Object> entry = iterator.next();
//                System.out.print(entry.getKey());
//                System.out.print(',');
//                System.out.println(entry.getValue());
//            }
//        }
//    }

    public Iterable<Ingredient> findAll() {
        String sql = "select * from ingredient";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        List<Ingredient> list = new ArrayList<>();
        for (Map<String, Object> t:maps) {
            list.add(new Ingredient((String) t.get("id"), (String) t.get("name"), Type.valueOf((String) t.get("type"))));
        }
        return list;
    }
    public Ingredient findById(String id) {
        String sql = "select * from ingredient where id = ?";
        Ingredient o = (Ingredient) jdbcTemplate.queryForObject(sql, (rs,colnum)->{
            return new Ingredient(rs.getString("id"),rs.getString("name"), Type.valueOf(rs.getString("type")));
        }, id);
        return o;
    }
    public int save(Ingredient ingredient) {
        return jdbcTemplate.update("insert into ingredient values (?,?,?)", ingredient.getId(), ingredient.getName(), ingredient.getType().toString());
    }
    @Test
    public void jdbctest(){
        Iterable<Ingredient> all = findAll();
        Iterator<Ingredient> iterator = all.iterator();
        while(iterator.hasNext()){
            Ingredient next = iterator.next();
            System.out.println(next);
        }
    }
    @Test
    public void jdbctestone(){
        Ingredient e = findById("1");
        System.out.println(e);

    }
    @Test
    public void jdbctestsave(){
//        Ingredient i = new Ingredient("2", "second", Ingredient.Type.CHEESE);
//        save(i);
        List<Ingredient> ingredients = Arrays.asList(
        new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
        new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
        new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
        new Ingredient("CARN", "Carnitas", Type.PROTEIN),
        new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
        new Ingredient("LETC", "Lettuce", Type.VEGGIES),
        new Ingredient("CHED", "Cheddar", Type.CHEESE),
        new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
        new Ingredient("SLSA", "Salsa", Type.SAUCE),
        new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );
        for(Ingredient e:ingredients){
            save(e);
        }

    }
}