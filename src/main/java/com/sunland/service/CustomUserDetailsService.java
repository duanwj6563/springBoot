/**
 * @describe 
 * @author duanwj
 * @since 2017年9月29日 下午7:15:08
 */
package com.sunland.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sunland.domain.User;
import com.sunland.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
	@Autowired // 数据库服务类
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("UserName " + userName + " not found");

		}
//        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return user;

	}

}
