package cn.wsyjlly.config;

import cn.wsyjlly.entity.User;
import cn.wsyjlly.entity.UserRole;
import cn.wsyjlly.mapper.UserMapper;
import cn.wsyjlly.mapper.UserRoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author wsyjlly
 * @create 2019.06.14 - 19:39
 * 配置启动系统参数
 * 测试Mybatis-plus QueryWrapper 查询语句筛选
 * Mybatis-plus只适用于单表查询
 **/
@Component
@Order(1)
public class MybatisPlusQueryWrapper implements ApplicationRunner {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        QueryWrapper<UserRole> queryWrapper2 = new QueryWrapper<>();
        List<User> users;
        List<UserRole> userRoles;

        /*
         * SELECT * FROM user
         * */
        queryWrapper.select("*");
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * SELECT id,username,password FROM user
         * */
        queryWrapper.select("id","username","password");
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * SELECT id,username FROM user
         * */
        queryWrapper.select("id,username");
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * SELECT password,enable,locked FROM user
         * */
        queryWrapper.excludeColumns(User.class,"id","username");
        System.out.println("-------------------------------------------------");
        String sqlSelect = queryWrapper.getSqlSelect();
        System.out.println(sqlSelect);
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * SELECT * FROM user WHERE id=1 and enable=true
         * */
        queryWrapper.setEntity(new User().setId((long)1).setEnable(true));
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * WHERE id = 3
         * */
        queryWrapper.eq(true,"id",3);
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * WHERE id <> 3
         * */
        queryWrapper.ne(true,"id",3);
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * WHERE id > 3
         * */
        queryWrapper.gt(true,"id",3);
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * WHERE id >= 3
         * */
        queryWrapper.ge(true,"id",3);
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * WHERE id < 3
         * */
        queryWrapper.lt(true,"id",3);
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * WHERE id <= 3
         * */
        queryWrapper.le(true,"id",3);
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * WHERE id BETWEEN 3 AND 5
         * */
        queryWrapper.between(true,"id",3,5);
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * NOT BETWEEN 3 AND 5
         * */
        queryWrapper.notBetween(true,"id",3,5);
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();


        /*
         * LIKE "%y%"
         * */
        queryWrapper.like("username","y");
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * NOT LIKE "%y%"
         * */
        queryWrapper.notLike("username","y");
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * LIKE "%y"
         * */
        queryWrapper.likeLeft("username","y");
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * LIKE "y%"
         * */
        queryWrapper.likeRight("username","y");
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * IS NULL
         * */
        queryWrapper.isNull("username");
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * IN(对象数组)
         * */
//        String[] inArray = {"ysw","晏沈威"};
        queryWrapper.in("username", Arrays.asList("ysw","晏沈威"));
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * NOT IN(对象数组)
         * */
//        String[] notInArray = {"ysw","晏沈威"};
        queryWrapper.notIn("username",Arrays.asList("ysw","晏沈威") );
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * IN(sql语句)
         * */
        queryWrapper.inSql("username","select username from user where username='ysw'" );

        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();


        /*
         * EXISTS(sql语句)
         * */
        queryWrapper.exists("select username from user where username='ysw'" );
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * NOT IN(sql语句)
         * */
        queryWrapper.notInSql("username","select username from user where username='ysw'" );
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * NOT EXISTS(sql语句)
         * */
        queryWrapper.notExists("select username from user where username='ysw'" );
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * GROUP BY  column HAVING
         * */
        queryWrapper2.select("sum(uid) as sumId");
        queryWrapper2.groupBy("uid" );
        queryWrapper2.having("sum(uid)>{0}",6);
        userRoles = userRoleMapper.selectList(queryWrapper2);
        System.out.println(userRoles);
        queryWrapper2 = new QueryWrapper<>();



        /*
         * 条件关键词：ORDER BY ASC
         * */
        queryWrapper.orderBy(true,true,"id");
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * 条件关键词：ORDER BY DESC
         * */
        queryWrapper.orderBy(true,false,"id");
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * 条件关键词：ORDER BY ASC
         * */
        queryWrapper.orderByAsc("id");
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * 条件关键词：ORDER BY DESC
         * */
        queryWrapper.orderByDesc("id");
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * 条件关键词：OR
         * */
        queryWrapper.eq(true,"id",3).or().eq("id",5);
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * 条件关键词：OR
         * */
        queryWrapper.or((i)->
                i.eq("id",3).eq("id",5)
        );
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * 条件关键词：AND
         * */
        queryWrapper.and((i)->
                i.eq("username","wysjlly").eq("id",9)
        );
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * SQL语句追加
         * */
        queryWrapper.last("limit 3");
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * SQL语句追加
         * */
        queryWrapper.nested(i->i.eq("username","wsyjlly").or().ne("id",8));
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();

        /*
         * SQL语句追加
         * */
        queryWrapper.eq("username","wsyjlly").ne("id",8);
        users = userMapper.selectList(queryWrapper);
        System.out.println(users);
        queryWrapper = new QueryWrapper<>();
    }
}
