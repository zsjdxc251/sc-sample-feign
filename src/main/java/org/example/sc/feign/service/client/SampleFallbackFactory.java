package org.example.sc.feign.service.client;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author zhengshijun
 * @date 2022/8/28.
 */
@Slf4j
@Component
public class SampleFallbackFactory implements feign.hystrix.FallbackFactory <Object> {
    @Override
    public Object create(Throwable throwable) {
        log.error(throwable.getMessage(),throwable);
        Object result = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{DemoClient.class,},
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                    return ResponseEntity.status(500).build();
                }
            });

        return result;

    }
}
