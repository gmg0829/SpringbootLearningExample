package com.gmg.conditional;

/**
 * @author gmg
 * @title: JdbcUserDaoImpl
 * @projectName demo
 * @description: TODO
 * @date 2019/8/20 12:23
 */

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


@Repository
@Conditional(MySqlDbTypeCondition.class)
public class JdbcUserDaoImpl implements UserDao {
    @Override
    public List<String> getAllUserNames() {
        return Arrays.asList("jdbc", "test");
    }
}