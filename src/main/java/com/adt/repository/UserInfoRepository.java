package com.adt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adt.model.UserInfo;
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
	
	@Query(value = "select email from USER_INFO", nativeQuery=true)
	public List<String> getAllEmail();
	
	@Query(value = "FROM USER_INFO u WHERE u.email LIKE %:query%")
	public List<UserInfo> searchUserByEmail(@Param("query") String query);
}
