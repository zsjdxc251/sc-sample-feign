package org.example.sc.feign;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.RetryLoadBalancerInterceptor;
import org.springframework.cloud.loadbalancer.blocking.retry.BlockingLoadBalancedRetryPolicy;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.openfeign.loadbalancer.FeignBlockingLoadBalancerClient;
import org.springframework.cloud.openfeign.loadbalancer.RetryableFeignBlockingLoadBalancerClient;

/**
 *
 *
 *    spring cloud commons 抽象 https://docs.spring.io/spring-cloud-commons/docs/3.1.3/reference/html/#spring-cloud-commons-common-abstractions
 *
 *   loadbalnacer 重试配置可参考配置
 *                  https://www.cnblogs.com/xfeiyun/p/16219937.html
 *                  https://blog.csdn.net/weixin_42189048/article/details/117781378
 *                  https://blog.csdn.net/qq_39363204/article/details/124357014
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
 *   6. 关于spring cloud 切换到 loadbalancer 看查看博客 https://blog.csdn.net/Amy126/article/details/108636810
 *
 *   7. loadbalancer 从 {@link  ServiceInstanceListSupplier} 获取到实例 或者可以使用本地无注册中心可以使用该类实现
 *
 *   8. 全局配置超时时间 是否可以   通过feign 配置 全局超时时间 不能像之前一样使用ribbon
 *
 *   9. 通用feign fallback
 *
 *   10. 关于接入熔断器问题 与 trace 不兼容问题
 *   11. ribbon 原始实现
 *   12. gateway 替换 loadbalancer
 *
 *   {@link  BlockingLoadBalancedRetryPolicy}
 *   {@link  RetryableFeignBlockingLoadBalancerClient} 和它相差无几 {@link  RetryLoadBalancerInterceptor}
 * @author zhengshijun
 * @date 2022/8/27.
 */
@SpringBootApplication
public class ScFeignBootstrap {
    public static void main(String[] args) {

        SpringApplication.run(ScFeignBootstrap.class,args);
    }
}
