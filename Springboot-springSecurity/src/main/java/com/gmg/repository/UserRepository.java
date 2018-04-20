package com.gmg.repository;
import com.gmg.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by beikongguocai on 2017/4/26.
 */
public interface UserRepository extends JpaRepository<User,Integer>{

}
