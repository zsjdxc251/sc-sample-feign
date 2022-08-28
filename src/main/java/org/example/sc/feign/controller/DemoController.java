package org.example.sc.feign.controller;

import feign.Request.Options;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.example.sc.feign.service.client.DemoClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhengshijun
 * @date 2022/8/27.
 */
@Slf4j
@Controller
@RequestMapping("/demo")
public class DemoController {

    private final DemoClient demoClient;

    public DemoController(DemoClient demoClient) {this.demoClient = demoClient;}

    @GetMapping("/e1")
    public ResponseEntity<String> e1(){
        Options options = new Options(500, TimeUnit.MILLISECONDS,3,TimeUnit.SECONDS,true);

        log.info("demo-e1");
        return demoClient.e1(null);
    }

    @GetMapping("/e2")
    public ResponseEntity<String> e2(){
        Options options = new Options(500, TimeUnit.MILLISECONDS,3,TimeUnit.SECONDS,true);

        log.info("demo-e2");
        return demoClient.e2(null);
    }
}
