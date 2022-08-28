package org.example.sc.feign.configure;

import feign.RetryableException;
import feign.Retryer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhengshijun
 * @date 2022/8/27.
 */
@Configuration
@EnableFeignClients(basePackages = "org.example.sc.feign.service.client")
public class OpenFeignConfigure {


}
