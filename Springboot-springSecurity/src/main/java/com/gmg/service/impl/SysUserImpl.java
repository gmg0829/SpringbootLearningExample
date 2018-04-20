package com.gmg.service.impl;

import com.gmg.domain.SysUser;
import com.gmg.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by beikongguocai on 2017/4/27.
 */
public class SysUserImpl implements UserDetailsService {
    @Autowired
    SysUserRepository sysUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser flag=sysUserRepository.findByUsername(username);
        if(flag==null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return flag;
    }
}
