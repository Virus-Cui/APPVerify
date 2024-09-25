package cn.mrcsh.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

class BackendApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(new Date().after(new Date(System.currentTimeMillis()-10000)));
    }

}
