package org.lxy.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * 2020/6/24
 */
@Configuration
@MapperScan(basePackages = {"org.lxy.dao"})
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }

    @Bean("mybatisPlusAutoFill")
    public MetaObjectHandler mybatisMetaObjectHandler(){
        MetaObjectHandler metaObjectHandler = new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                this.strictInsertFill(metaObject, "id", Long.class, IdWorker.getId());
                this.strictInsertFill(metaObject, "create_time", LocalDateTime.class, LocalDateTime.now());
                this.strictInsertFill(metaObject, "update_time", LocalDateTime.class, LocalDateTime.now());
            }

            @Override
            public void updateFill(MetaObject metaObject) {
                this.strictUpdateFill(metaObject, "update_time", LocalDateTime.class, LocalDateTime.now());
            }
        };

        return metaObjectHandler;
    }
}
