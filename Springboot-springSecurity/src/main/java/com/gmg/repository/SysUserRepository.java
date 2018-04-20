package com.gmg.repository;

import com.gmg.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by beikongguocai on 2017/4/27.
 */
public interface SysUserRepository extends JpaRepository<SysUser,Long> {
    SysUser findByUsername(String username);
}
