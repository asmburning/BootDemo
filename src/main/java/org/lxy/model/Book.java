package org.lxy.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Insert;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.TimeZone;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
