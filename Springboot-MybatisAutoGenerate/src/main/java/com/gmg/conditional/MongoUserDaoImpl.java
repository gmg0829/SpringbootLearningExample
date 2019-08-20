package com.gmg.conditional;

/**
 * @author gmg
 * @title: MongoUserDaoImpl
 * @projectName demo
 * @description: TODO
 * @date 2019/8/20 12:24
 */

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author sdcuike
 * @date 2018/1/28
 * @since 2018/1/28
 */
@Repository
@Conditional(MongoDbTypeCondition.class)
public class MongoUserDaoImpl implements UserDao {
    @Override
    public List<String> getAllUserNames() {
        return Arrays.asList(" Mongo db ", "test");
    }
}