package com.github.hellogithub;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: junjiexun
 * @date: 2020/12/8 4:09 下午
 * @description:
 */
@SpringBootApplication(scanBasePackages = {"com.github"})
public class Boot {

    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }
}
