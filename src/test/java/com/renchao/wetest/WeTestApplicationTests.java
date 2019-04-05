package com.renchao.wetest;

import com.renchao.wetest.services.MobileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeTestApplicationTests {
    @Autowired
    MobileService service;

    @Test
    public void contextLoads() {
        ArrayList<String> list = (ArrayList<String>) service.getDistinctKinds("system");
        for(String s : list)
        System.out.println(s);
    }
}
