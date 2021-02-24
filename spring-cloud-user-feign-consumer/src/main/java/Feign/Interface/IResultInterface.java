package Feign.Interface;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "spring-cloud-order-service-provider")
public interface IResultInterface {
    @RequestMapping(value = "/order/getResult/{id}")
    String getResult(@PathVariable("id") Integer id);
}
