package org.lxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 2020/6/24
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class RedisControllerTest {

    @Resource
    private TestRestTemplate testRestTemplate;

    @Test
    public void testSetNxEx() {
        ResponseEntity<Boolean> response = testRestTemplate.getForEntity("/redis/testSetNxEx", Boolean.class);
        Assert.assertSame(response.getStatusCode(), HttpStatus.OK);
        Assert.assertTrue(response.getBody());

        ResponseEntity<Boolean> secondTime = testRestTemplate.getForEntity("/redis/testSetNxEx", Boolean.class);
        Assert.assertSame(secondTime.getStatusCode(), HttpStatus.OK);
        Assert.assertFalse(secondTime.getBody());
        log.info("-----------testSetNxEx------------");
    }

    @Test
    public void testAsync() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/redis/testAsync", String.class);
        Assert.assertSame(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals("OK", response.getBody());
        log.info("-----------testAsync------------");
    }

    @Test
    public void testAsync2() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/redis/testAsync2", String.class);
        Assert.assertSame(response.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(response.getBody());
        log.info("-----------testAsync2------------");
    }

    @Test
    public void testTemplate() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/redis/testTemplate", String.class);
        Assert.assertSame(response.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(response.getBody(), "template");

        log.info("-----------testTemplate------------");
    }
}
