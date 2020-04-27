package top.simba1949;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author Theodore
 * @Date 2020/4/26 18:46
 */
@SpringBootApplication
@MapperScan(basePackages = "top.top.simba1949.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
