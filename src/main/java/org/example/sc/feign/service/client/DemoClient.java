package org.example.sc.feign.service.client;

import feign.Request.Options;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhengshijun
 * @date 2022/8/27.
 */
@FeignClient(name = "sc-sample-feign",path = "/sample" )
public interface DemoClient {

    @PostMapping("/e1")
    ResponseEntity<String> e1(Options options);

    @GetMapping("/e2")
    ResponseEntity<String> e2(Options options);

    @PostMapping("/invoker02")
    ResponseEntity<String> invoker02(@RequestParam("age")Integer age, Options options);
}
