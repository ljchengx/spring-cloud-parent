package Feign.Controller;


import Feign.Interface.IResultInterface;
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
    public String getResult(@PathVariable("id") Integer id) {
        return iResultInterface.getResult(id);
    }
}

