package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {

        byte[] s = {67, 111, 117, 108, 100, 32, 110, 111, 116, 32, 101, 120, 116, 114, 97, 99, 116, 32, 99, 111, 108, 117, 109, 110, 32, 91, 51, 93, 32, 102, 114, 111, 109, 32, 74, 68, 66, 67, 32, 82, 101, 115, 117, 108, 116, 83, 101, 116};
        String s1 = new String(s);
        System.out.println(s1);

    }

}
