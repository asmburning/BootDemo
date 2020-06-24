package org.lxy.model;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Insert;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("T_BOOK")
public class Book {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    private String bookName;
    private String remark;
    private String rating;
    private String quote;
    @TableField(update = "now()", updateStrategy = FieldStrategy.IGNORED)
    private LocalDateTime createTime;
    @TableField(update = "now()")
    private LocalDateTime updateTime;
}
