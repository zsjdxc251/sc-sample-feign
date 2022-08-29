# sc-sample-feign
spring cloud feign 示例 ,  用于ribbon 切换到spring cloud loadbalancer 重试机制，因为 ribbon 在 okhttp timeout 而导致 socket closed 之后会对POST请求进行重试，ribbon内部机制决定
