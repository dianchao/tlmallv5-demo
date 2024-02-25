package com.tuling.tulingmallauthcenter.service;

import com.tuling.tulingmall.common.api.CommonResult;
import com.tuling.tulingmallauthcenter.domain.MemberDetails;
import com.tuling.tulingmallauthcenter.feign.UmsMemberFeignService;
import com.tuling.tulingmallauthcenter.model.UmsMember;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author Fox
 */
@Slf4j
@Component
public class TulingUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 加载用户信息
        if(StringUtils.isEmpty(username)) {
            log.warn("用户登陆用户名为空:{}",username);
            throw new UsernameNotFoundException("用户名不能为空");
        }

        UmsMember umsMember = getByUsername(username);

        if(null == umsMember) {
            log.warn("根据用户名没有查询到对应的用户信息:{}",username);
        }

        log.info("根据用户名:{}获取用户登陆信息:{}",username,umsMember);

        // 会员信息的封装 implements UserDetails
        MemberDetails memberDetails = new MemberDetails(umsMember);

        return memberDetails;
    }

    @Autowired
    private UmsMemberFeignService umsMemberFeignService;

    public UmsMember getByUsername(String username) {
        // fegin获取会员信息
        CommonResult<UmsMember> umsMemberCommonResult = umsMemberFeignService.loadUserByUsername(username);

        return umsMemberCommonResult.getData();
    }
}
