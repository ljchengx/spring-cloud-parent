package Ribbon.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getResult/{id}")
    public String getResult(@PathVariable("id") Integer id) {

        String url = "http://" + "spring-cloud-order-service-provider" + "/order/getResult/" + id;
        return restTemplate.getForObject(url, String.class);
    }
}
