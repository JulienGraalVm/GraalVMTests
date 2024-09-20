package org.rcs.graalvm.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(DemoRestController.RESOURCE_PATH)
public class DemoRestController {

    public static final String RESOURCE_PREFIX = "/";
    public static final String RESOURCE_PATH   = RESOURCE_PREFIX + "demo";
    public static final String RESOURCE_GET    = RESOURCE_PREFIX + "{number}";

    @GetMapping(RESOURCE_GET)
    public DemoPojo get(@PathVariable int number) {
        return new DemoPojo(number);
    }
}
