package org.lxy.controller;

import org.lxy.props.HelloYml;
import org.lxy.props.TestYml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private TestYml testYml;
    @Autowired
    private HelloYml helloYml;

    @RequestMapping("/testYml")
    public Object testYml(){
        return testYml;
    }

    @RequestMapping("/helloYml")
    public Object helloYml(){
        return helloYml;
    }
}
