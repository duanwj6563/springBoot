/**
 * @describe 
 * @author duanwj
 * @since 2017年9月30日 上午10:23:33
 */
package com.sunland.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunland.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserName(String userName);

	User findByPhone(Integer phone);

}
