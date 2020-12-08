package com.github.hellogithub;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.zookeeper.config.CuratorFrameworkFactoryBean;
import org.springframework.integration.zookeeper.lock.ZookeeperLockRegistry;

/**
 * @author: junjiexun
 * @date: 2020/12/8 4:34 下午
 * @description:
 */
@Configuration
public class ZookeeperLockConfiguration {
    @Value("${zookeeper.host:127.0.0.1:2181}")
    private String zkUrl;

    @Bean
    public CuratorFrameworkFactoryBean curatorFrameworkFactoryBean() {
        return new CuratorFrameworkFactoryBean(zkUrl);
    }

    @Bean
    public ZookeeperLockRegistry zookeeperLockRegistry(CuratorFramework curatorFramework) {

        return new ZookeeperLockRegistry(curatorFramework, "/HG-lock");
    }
}
