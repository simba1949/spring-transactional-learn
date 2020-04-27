package top.simba1949.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.simba1949.service.UserService;

/**
 * 需要从日志中查看 “Creating new transaction with name” ，如果打印查看到说明事务处创建成功
 * ”Initiating transaction commit“ 说明事务提交
 * @Author Theodore
 * @Date 2020/4/26 18:55
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("0-0")
    public String propagationRequired00(){
        userService.propagationRequired00();
        return "SUCCESS";
    }

    @GetMapping("0-1")
    public String propagationRequired01(){
        userService.propagationRequired01();
        return "SUCCESS";
    }
    /****************************************************************************************/

    @GetMapping("1-0")
    public String propagationSupports00(){
        userService.propagationSupports00();
        return "SUCCESS";
    }

    @GetMapping("1-1")
    public String propagationSupports01(){
        userService.propagationSupports01();
        return "SUCCESS";
    }
    /****************************************************************************************/

    @GetMapping("2-0")
    public String propagationMandatory00(){
        userService.propagationMandatory00();
        return "SUCCESS";
    }
    @GetMapping("2-1")
    public String propagationMandatory01(){
        userService.propagationMandatory01();
        return "SUCCESS";
    }
    /****************************************************************************************/

    @GetMapping("3-0")
    public String propagationRequiresNew00(){
        userService.propagationRequiresNew00();
        return "SUCCESS";
    }
    @GetMapping("3-1")
    public String propagationRequiresNew01(){
        userService.propagationRequiresNew01();
        return "SUCCESS";
    }
    /****************************************************************************************/

    @GetMapping("4-0")
    public String propagationNotSupported00(){
        userService.propagationNotSupported00();
        return "SUCCESS";
    }
    @GetMapping("4-1")
    public String propagationNotSupported01(){
        userService.propagationNotSupported01();
        return "SUCCESS";
    }
    /****************************************************************************************/

    @GetMapping("5-0")
    public String propagationNever00(){
        userService.propagationNever00();
        return "SUCCESS";
    }
    @GetMapping("5-1")
    public String propagationNever01(){
        userService.propagationNever01();
        return "SUCCESS";
    }
    /****************************************************************************************/

    @GetMapping("6-0")
    public String propagationNested00(){
        userService.propagationNested00();
        return "SUCCESS";
    }
    @GetMapping("6-1")
    public String propagationNested01(){
        userService.propagationNested01();
        return "SUCCESS";
    }
}