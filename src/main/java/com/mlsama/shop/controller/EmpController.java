package com.mlsama.shop.controller;

import com.mlsama.shop.pojo.Emp;
import com.mlsama.shop.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * DESC:
 * AUTHOR:mlsama
 * 2019/12/25 17:44
 */
@Controller
@Slf4j
public class EmpController {
    @Resource
    private EmpService empService;

    /**
     * springboot的事务不需要@EnableTransactionManagement开启事务管理,已经自动配置
     * 虽然 @Transactional 注解可以作用于接口、接口方法、类以及类方法上，但是 Spring 建议不要在接口或者接口方法上使用该注解，
     * 因为这只有在使用基于接口的代理时它才会生效。另外， @Transactional 注解应该只被应用到 public 方法上,
     * 这是由 Spring AOP 的本质决定的。如果你在 protected、private 或者默认可见性的方法上使用 @Transactional 注解，这将被忽略，也不会抛出任何异常。
     * @Transactional 一般作用在最外层(如controller层)的方法上,因为这些方法会调用多个service的多个方法,在这个方法上设置事务即可保证这些方法执行的一致性
     *      try...catch处理异常,不会回滚
     *      try...catch,再在catch中抛出异常,回滚
     *      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); 手动回滚
     *      只有发生RuntimeException时才会回滚,手动回滚任何异常都有效.
     * 总结:
     *      @Transactional 所在的方法不能对抛出来的异常进行捕抓处理,否则无法回滚,但是可以在下层进行捕抓处理
     *      默认只对发生RuntimeException回滚,可以手动指定回滚的异常(rollbackFor)
     *      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); 在catch块手动回滚,与异常类型无关
     *
     *
     * @return
     */
    @GetMapping("/add")
    @ResponseBody
    @Transactional
    public String insert() {
        try {
            empService.insert(new Emp(8, "mlsama", new BigDecimal(888888888)));
            empService.update(2,6);
            return "插入数据成功";
        }catch (Exception e){
            //手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "插入数据失败"+e.getMessage();
        }

    }

}
