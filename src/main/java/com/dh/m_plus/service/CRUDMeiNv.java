package com.dh.m_plus.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dh.m_plus.bean.Meinv;
import com.dh.m_plus.mapper.MeinvMapper;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther:D-hao
 * @Date:2020/11/17-11-17-16:03
 * @Description:com.dh.m_plus.service
 */
@Service
public class CRUDMeiNv {
    @Autowired
    private MeinvMapper meinvMapper;

    public void insertest01() {
        Meinv meinv = new Meinv();
        meinv.setEname("周芷若");
        meinv.setShengao(198);
        int result = meinvMapper.insert(meinv);
        System.out.println(result);
    }
    public void updateTest() {
        Meinv meinv = new Meinv();
//        meinv.setId(20);
        meinv.setEname("周芷若");
        meinv.setShengao(1);
        UpdateWrapper<Meinv> meinvUpdateWrapper = new UpdateWrapper<>();
        meinvUpdateWrapper.eq("id",80);
        int result = meinvMapper.update(meinv,meinvUpdateWrapper);
        System.out.println(result);
    }

    public void deletedTest() {
        meinvMapper.deleteById(20);
    }

    public void testOptimisticLocker2(){
        // 线程 1
        Meinv meinv = new Meinv();
        meinv.setId(20);
        meinv.setEname("hhhhhh");;
        // 模拟另外一个线程执行了插队操作
        Meinv meinv2 = new Meinv();
        meinv2.setId(20);
        meinv2.setEname("dddd");
        meinvMapper.updateById(meinv2);
        // 自旋锁来多次尝试提交！
        meinvMapper.updateById(meinv); // 如果没有乐观锁就会覆盖插队线程的值！
    }

    public void pageSelect() {
        // 参数一：当前页
        // 参数二：页面大小
        // 使用了分页插件之后，所有的分页操作也变得简单的！
        Page<Meinv> page = new Page<>(2, 5);
        Page<Meinv> meinvPage = meinvMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println("完成测试");
        System.out.println("over");
    }

}
