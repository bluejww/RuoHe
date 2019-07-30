package com.jzt.ruohe.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 配置用户认证逻辑，因为我们是有自己的一套用户体系的
 * 
 * @author jianww
 *
 */
public class JztUserDetailsService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("user name is : " + username);
		
		String passward = passwordEncoder.encode("123456");
		
		// 根据用户名查找对应的密码权限. 参数分别是：用户名，密码，用户权限
		User user = new User(username, passward, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
		return user;
	}

}
