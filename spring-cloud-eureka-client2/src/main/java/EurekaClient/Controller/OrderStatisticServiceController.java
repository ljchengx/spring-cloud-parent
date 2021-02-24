package EurekaClient.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderStatisticServiceController {
    @Value("${server.port}")
    private Integer port;

    /**
     * 根据用户id获取今日完单数
     *
     * @param id 用户ID
     * @return 完单数
     */
    @GetMapping("/getTodayFinishOrderNum/{id}")
    public Integer getTodayFinishOrderNum(@PathVariable("id") Integer id) {
        return port;
    }

    @GetMapping("/getResult/{id}")
    public String getResult(@PathVariable("id") Integer id) {
        return "getResult = " + port + "--" + +id;
    }
}
