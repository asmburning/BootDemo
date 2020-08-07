package org.lxy.props;

import lombok.Data;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:hello.yml")
@Data
public class HelloYml {
    private String name;
    private Integer age;
}
