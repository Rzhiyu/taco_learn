package com.example.demo.deprecated;

import com.example.demo.beans.Ingredient;
import com.example.demo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Iterable<Ingredient> findAll() {
        String sql = "select * from ingredient";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        List<Ingredient> list = new ArrayList<>();
        for (Map<String, Object> t:maps) {
            list.add(new Ingredient((String) t.get("id"), (String) t.get("name"), Ingredient.Type.valueOf((String) t.get("type"))));
        }
        return list;
    }

    @Override
    public Ingredient findById(String id) {
        String sql = "select * from ingredient where id = ?";
        Ingredient o = (Ingredient) jdbcTemplate.queryForObject(sql, (rs,colnum)->{
            return new Ingredient(rs.getString("id"),rs.getString("name"),Ingredient.Type.valueOf(rs.getString("type")));
        }, id);
        return o;
    }

    @Override
    public int save(Ingredient ingredient) {
        return jdbcTemplate.update("insert into ingredient values (?,?,?)", ingredient.getId(), ingredient.getName(), ingredient.getType().toString());
    }
}
