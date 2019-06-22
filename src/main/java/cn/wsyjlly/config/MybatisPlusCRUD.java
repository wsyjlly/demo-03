package cn.wsyjlly.config;

import cn.wsyjlly.entity.User;
import cn.wsyjlly.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wsyjlly
 * @create 2019.06.14 - 19:39
 * 配置启动系统参数
 * 测试Mybatis-plus CRUD 及 分页
 **/
@Component
@Order(2)
public class MybatisPlusCRUD implements ApplicationRunner {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Logger logger = LoggerFactory.getLogger(getClass());
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        List<User> users;
        logger.info("------------------------------------------------------------------------");

        /*
        * 查找操作
        * */
        User user = userMapper.selectById((long)1);
        System.out.println(user);
        /*
        * 根据ID数组查找
        * */
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(userList);
        /*
        * 根据多个字段及其值组成的Map查找
        * */
        HashMap<String, Object> map = new HashMap<>();
        map.put("id",2);
        map.put("username","yan");
        userList = userMapper.selectByMap(map);
        System.out.println(userList);
        /*
        * 根据QueryWrapper筛选对象查看选中记录条数
        * */
        Integer selectCount = userMapper.selectCount(queryWrapper.eq("username", "ysw"));
        System.out.println(selectCount);
        /*
        * 根据QueryWrapper筛选对象选中一条数据
        * */
        queryWrapper = new QueryWrapper<>();
        user =userMapper.selectOne(queryWrapper.eq("id",1));
        System.out.println(user);
        /*
        * 根据QueryWrapper筛选对象查看返回任意对象
        * */
        queryWrapper = new QueryWrapper<>();
        List<Object> objectList = userMapper.selectObjs(queryWrapper.select("*").eq("username", "ysw"));
        System.out.println(objectList);
        /*
        * 根据Page对象和QueryWrapper筛选对象进行分页，赶回IPage<T>对象,通过getRecords方法获取当前页对象，该分页需要配置分页过滤器
        * */
        queryWrapper = new QueryWrapper<>();
        System.out.println("--------------------分页----------------------");
        IPage<User> userIPage = userMapper.selectPage(new Page<>(2,3), queryWrapper.select("*"));
        List<User> records = userIPage.getRecords();
        System.out.println(records);




        /*
         * 添加操作
         * */
//        int result = userMapper.insert(new User().setUsername("ysw").setPassword("222333"));
//        logger.debug(String.valueOf(result));

        /*
        * 删除操作
        * */
//        userMapper.delete(queryWrapper.eq("id",10));
//        userMapper.deleteById((long) 8);
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(11);
//        list.add(12);
//        userMapper.deleteBatchIds(list);
//        userMapper.deleteBatchIds(Arrays.asList(1,2,3,4));

        /*
         * 更新操作
         * */
//        userMapper.updateById(new User().setId((long) 8).setUsername("ysw").setPassword("222333"));
//        userMapper.update(new User().setId((long) 8).setUsername("ysw").setPassword("222333"),queryWrapper.eq("id",9));
    }
}
