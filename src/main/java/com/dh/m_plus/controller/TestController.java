package com.dh.m_plus.controller;

import com.dh.m_plus.service.CRUDMeiNv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:D-hao
 * @Date:2020/11/17-11-17-16:14
 * @Description:com.dh.m_plus.controller
 */
@RestController
public class TestController {
    @Autowired
    CRUDMeiNv crudMeiNv;

    @RequestMapping("/insert")
    public String intserCRUD() {
        crudMeiNv.insertest01();
        return "";
    }
    @RequestMapping("/update")
    public String updateCRUD() {
        crudMeiNv.updateTest();
        return "";
    }

    /**
     * 逻辑删除
     * @return
     */
    @RequestMapping("/deleted")
    public String deletedCRUD() {
        crudMeiNv.deletedTest();
        return "";
    }

    /**
     * 乐观锁
     * @return
     */
    @RequestMapping("/opt")
    public String optCRUD() {
        crudMeiNv.testOptimisticLocker2();
        return "";
    }

    /**
     * 分页查询
     * @return
     */
    @RequestMapping("/pageSelect")
    public String pageCRUD() {
        crudMeiNv.pageSelect();
        return "";
    }

}
