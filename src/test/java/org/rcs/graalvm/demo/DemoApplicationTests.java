package org.rcs.graalvm.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

    @Autowired
    private DemoRestController demoRestController;
    @Autowired
    private TestRestTemplate   restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
        assertThat(demoRestController).isNotNull();
    }

    @Test
    void verifyGetNumberEndpoint() throws Exception {
        var responseEntity = this.restTemplate.getForEntity("http://localhost:" + port + "/demo/12", DemoPojo.class);
        var body = responseEntity.getBody();
        assertThat(body).isNotNull();
        assertThat(body.getNumber()).isEqualTo(12);
    }

}
