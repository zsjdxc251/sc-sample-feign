//package org.example.sc.feign.configure;
//
//import java.util.Arrays;
//import java.util.List;
//import org.springframework.cloud.client.DefaultServiceInstance;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import reactor.core.publisher.Flux;
//
///**
// * @author zhengshijun
// * @date 2022/8/27.
// */
//@Configuration
//public class ContextConfigure {
//
//    @Bean
//    public ServiceInstanceListSupplier sampleServiceInstanceListSupplier(){
//        return new ServiceInstanceListSupplier(){
//
//            @Override
//            public Flux<List<ServiceInstance>> get() {
//                return Flux.just(Arrays
//                    .asList(new DefaultServiceInstance(getServiceId() + "1", getServiceId(), "localhost", 8080,
//                        false),new DefaultServiceInstance(getServiceId() + "2", getServiceId(), "localhost", 8082,
//                        false),new DefaultServiceInstance(getServiceId() + "3", getServiceId(), "localhost", 8081,
//                        false)));
//            }
//
//            @Override
//            public String getServiceId() {
//                return "sc-sample-feign";
//            }
//        };
//    }
//}
