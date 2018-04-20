package com.example.demo.dao;

import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by gmg on on 2018-01-12 15:08.
 */
@Repository
public class BaseDao
{
    @Autowired
    private MongoTemplate mongoTemplate;

   public List<Map> findAll(String collectionName){
       return mongoTemplate.findAll(Map.class,collectionName);
   }

    public void save(String collectionName,Map<String,Object> data){
        mongoTemplate.save(data,collectionName);
    }

    public void delete(String id, String collectionName) {
        mongoTemplate.remove(Query.query(Criteria.where("_id").is(id)), collectionName);
    }

    public WriteResult update(String id, String collectionName, Map<String, Object> keyValues) {
        Update update = null;
        for (Map.Entry<String, Object> entry : keyValues.entrySet()) {
            if (update == null) {
                update = Update.update(entry.getKey(), entry.getValue());
            } else {
                update.set(entry.getKey(), entry.getValue());
            }
        }
        return mongoTemplate.updateFirst(Query.query(Criteria.where("_id").is(id)), update, collectionName);
    }
    public Object findOne(String id, String collectionName) {
    return mongoTemplate.findOne(Query.query(Criteria.where("_id").is(id)), Map.class, collectionName);
}






}
