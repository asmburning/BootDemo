package org.lxy.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "props")
public class TestYml {

    private String name;
    private Integer age;
    private Map<String, String> maps;
    private List<String> lists;

}
