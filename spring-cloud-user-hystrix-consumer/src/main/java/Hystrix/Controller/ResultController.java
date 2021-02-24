package Hystrix.Controller;

import Hystrix.Interface.IResultInterface;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class ResultController {

    @Autowired
    IResultInterface iResultInterface;

    @RequestMapping("/getResult/{id}")
    @HystrixCommand(fallbackMethod = "fallbackGetResult")
    public String getResult(@PathVariable("id") Integer id) {
        return iResultInterface.getResult(id);
    }

    //触发熔断器的返回值
    public String fallbackGetResult(Integer id){
        return "这里进入熔断器的默认值";
    }
}
