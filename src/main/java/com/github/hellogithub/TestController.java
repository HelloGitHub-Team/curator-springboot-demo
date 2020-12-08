package com.github.hellogithub;

import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author: junjiexun
 * @date: 2020/12/8 4:31 下午
 * @description:
 */
@RestController
public class TestController {

    @Resource
    private LockRegistry lockRegistry;

    @GetMapping("debug")
    public String dubug() {
        System.out.println(lockRegistry);
        return "SSSS";
    }

    @GetMapping("/lock10")
    public String lock10() {
        System.out.println("lock10 start " + System.currentTimeMillis());
        final Lock lock = lockRegistry.obtain("lock");
        try {
            lock.lock();
            System.out.println("lock10 get lock success " + System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
        return "OK";
    }

    @GetMapping("/immediate")
    public String immediate() {
        System.out.println("immediate start " + System.currentTimeMillis());
        final Lock lock = lockRegistry.obtain("lock");
        try {
            lock.lock();
            System.out.println("immediate get lock success " + System.currentTimeMillis());
        } finally {
            lock.unlock();
        }
        return "immediate return";
    }
}
