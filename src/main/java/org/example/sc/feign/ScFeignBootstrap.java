package org.example.sc.feign;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.loadbalancer.blocking.retry.BlockingLoadBalancedRetryPolicy;
import org.springframework.cloud.openfeign.loadbalancer.FeignBlockingLoadBalancerClient;
import org.springframework.cloud.openfeign.loadbalancer.RetryableFeignBlockingLoadBalancerClient;

/**
 *
 *   问题
 *   1. 通过该应用ribbon 尝试 POST socket closed 是否会重试
 *   2. loadbalancer 查看并知道 socket closed 原理不会重试原因
 *   3. loadbalancer 查找不到应用 不会报错问题 (retry 不会报错，没有重试则会报错) 添加重试
 *       {@link  FeignBlockingLoadBalancerClient#execute(feign.Request, feign.Request.Options)}这个地方会检验实例是否存在返回响应
 *       开启了重试机制则不会去校验是否存在该实例
 *   4. 融合到k8s loadbalancer
 *   5. loadbalancer 和 feign 重试方式策略是否冲突 是否是并行存在的
 *      feign 重试 {@link  SynchronousMethodHandler#invoke(java.lang.Object[])}
 *      结论：冲突 ， feign 是顶层重试，不会有下一个实例重试，而 loadbalancer则更准确可以通过 实例和下一个实例重试
 *
 *   {@link  BlockingLoadBalancedRetryPolicy}
 *   {@link  RetryableFeignBlockingLoadBalancerClient}
 * @author zhengshijun
 * @date 2022/8/27.
 */
@SpringBootApplication
public class ScFeignBootstrap {
    public static void main(String[] args) {

        SpringApplication.run(ScFeignBootstrap.class,args);
    }
}
