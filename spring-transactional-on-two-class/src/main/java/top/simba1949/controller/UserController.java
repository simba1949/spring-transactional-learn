package top.simba1949.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    public String propagationRequired0(){
        userService.propagationRequired();
        return "SUCCESS";
    }

    @GetMapping("0-1")
    @Transactional(rollbackFor = Exception.class)
    public String propagationRequired1(){
        userService.propagationRequired();
        return "SUCCESS";
    }
    /****************************************************************************************/

    @GetMapping("1-0")
    public String propagationSupports0(){
        userService.propagationSupports();
        return "SUCCESS";
    }

    @GetMapping("1-1")
    @Transactional(rollbackFor = Exception.class)
    public String propagationSupports1(){
        userService.propagationSupports();
        return "SUCCESS";
    }
    /****************************************************************************************/

    @GetMapping("2-0")
    public String propagationMandatory0(){
        userService.propagationMandatory();
        return "SUCCESS";
    }

    @GetMapping("2-1")
    @Transactional(rollbackFor = Exception.class)
    public String propagationMandatory1(){
        userService.propagationMandatory();
        return "SUCCESS";
    }
    /****************************************************************************************/

    @GetMapping("3-0")
    public String propagationRequiresNew0(){
        userService.propagationRequiresNew();
        return "SUCCESS";
    }

    @GetMapping("3-1")
    @Transactional(rollbackFor = Exception.class)
    public String propagationRequiresNew1(){
        userService.propagationRequiresNew();
        return "SUCCESS";
    }
    /****************************************************************************************/

    @GetMapping("4-0")
    public String propagationNotSupported0(){
        userService.propagationNotSupported();
        return "SUCCESS";
    }

    @GetMapping("4-1")
    @Transactional(rollbackFor = Exception.class)
    public String propagationNotSupported1(){
        userService.propagationNotSupported();
        return "SUCCESS";
    }
    /****************************************************************************************/

    @GetMapping("5-0")
    public String propagationNever0(){
        userService.propagationNever();
        return "SUCCESS";
    }

    @GetMapping("5-1")
    @Transactional(rollbackFor = Exception.class)
    public String propagationNever1(){
        userService.propagationNever();
        return "SUCCESS";
    }
    /****************************************************************************************/

    @GetMapping("6-0")
    public String propagationNested0(){
        userService.propagationNested();
        return "SUCCESS";
    }

    @GetMapping("6-1")
    @Transactional(rollbackFor = Exception.class)
    public String propagationNested1(){
        userService.propagationNested();
        return "SUCCESS";
    }
}
