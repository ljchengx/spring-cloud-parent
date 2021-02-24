package Consumer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user/data")
public class UserCenterController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getTodayStatistic/{id}")
    public Integer getTodayStatistic(@PathVariable("id") Integer id){

        // 使用discoveryClient 类能够与eureka server 交互， getInstances 获取注册到eureka server
        // 的"spring-cloud-order-service-provider" 实例列表

        List<ServiceInstance> instances = discoveryClient.getInstances("spring-cloud-order-service-provider");

        // 获取第一个服务信息
        ServiceInstance instanceInfo = instances.get(0);
        //获取ip
        String ip = instanceInfo.getHost();
        //获取port
        int port = instanceInfo.getPort();
        String url  ="http://"+ip+":"+port+"/order/data/getTodayFinishOrderNum/"+id;
        return restTemplate.getForObject(url, Integer.class);
    }
}
