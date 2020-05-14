package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.example.demo.model.AccountUser;


public interface AccountUserRepository extends JpaRepository<AccountUser, Long> {

	void deleteByCif(int cif);

	List<AccountUser> findByLocation(String location);

	
//	  @Modifying(flushAutomatically = true) // flush before our query is executed
	@Query("SELECT u FROM AccountUser u WHERE u.accHolderName =:userName  AND u.location =:location")
	AccountUser findUserByNameAndLocation(@Param("userName") String userName, @Param("location") String location);
	
	
	
	
	
	
	/*
	 * @Modifying(flushAutomatically = true) // flush before our query is executed
	 * 
	 * @Query(
	 * value="SELECT u FROM ACCOUNT_USER u WHERE u.ACC_HOLDER_NAME = ?1 AND u.LOCATION =?2"
	 * ,nativeQuery=true) AccountUser findUserByNameAndLocation(String userName,
	 * String location);
	 */
}
