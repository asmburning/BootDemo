package org.lxy.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.apache.ibatis.annotations.Insert;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.TimeZone;

@Getter
@Builder
@TableName("T_BOOK")
public class Book extends BaseModel{

    private String bookName;
    private String remark;
    private String rating;
    private String quote;

    public Book() {
    }

    public Book(String bookName, String remark, String rating, String quote) {
        this.bookName = bookName;
        this.remark = remark;
        this.rating = rating;
        this.quote = quote;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
