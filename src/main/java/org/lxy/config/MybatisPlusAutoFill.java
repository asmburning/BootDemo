package org.lxy.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 2020/7/3
 */
@Component
@Slf4j
public class MybatisPlusAutoFill implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // to gain more information
        TableInfo tableInfo = this.findTableInfo(metaObject);

        // if you are sure about the existence and type of create_time
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());

        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // direct update metaObject
        metaObject.setValue("updateTime", LocalDateTime.now());

        // this didn't work if you want update what is not null
        // com.baomidou.mybatisplus.core.handlers.MetaObjectHandler.strictFillStrategy line 290
        // this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
    }
}
