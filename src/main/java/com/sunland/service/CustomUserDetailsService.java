/**
 * @describe 
 * @author duanwj
 * @since 2017年9月29日 下午7:15:08
 */
package com.sunland.service;

import com.sunland.domain.User;
import com.sunland.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired // 数据库服务类
	private UserRepository userRepository;
    private final Logger logger= LoggerFactory.getLogger(CustomUserDetailsService.class);
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		logger.info("user {}",user );
		if (user == null) {
			throw new UsernameNotFoundException("UserName " + userName + " not found");
		}
		/*Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		user.setGrantedAuthorities();*/
        return user;

	}

}
