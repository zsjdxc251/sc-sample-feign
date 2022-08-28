package org.example.sc.feign.controller;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhengshijun
 * @date 2022/8/27.
 */
@Slf4j
@Controller
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    private ServerProperties serverProperties;

    @PostMapping("/e1")
    public ResponseEntity<String> e1(){
        log.info("sample-e1"+serverProperties.getPort());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("sample-e1-休眠结束"+serverProperties.getPort());
        return ResponseEntity.ok("demo-1"+serverProperties.getPort());
    }

    @GetMapping("/e2")
    public ResponseEntity<String> e2(){
        log.info("sample-e2"+serverProperties.getPort());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("sample-e2-休眠结束"+serverProperties.getPort());
        return ResponseEntity.ok("demo-2"+serverProperties.getPort());
    }
}
