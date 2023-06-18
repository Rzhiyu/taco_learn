package com.example.demo.repository;

import com.example.demo.beans.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco,String> {
    //public Taco save(Taco taco);
}
