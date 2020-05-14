package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.FastTagPayment;

/**
 * @author Vijai
 *
 */
public interface FtRepo extends JpaRepository<FastTagPayment, String>
{
	
	
	@Query("SELECT a.accHolderName,f.fastTagId,f.dateExpiry FROM FastTagPayment f  JOIN f.accountUser a")
	List<Object[]> getJoinInfo();
	
	@Query("SELECT a.accHolderName,f.fastTagId,f.dateExpiry FROM FastTagPayment f  RIGHT JOIN f.accountUser a")
	List<Object[]> getRightJoinInfo();
	
	/*
	 * @Query("Select * from FastTagPayment a  left join AccountUser b on a.cif=b.cif"
	 * ) public List<> FindAllWithFastTag();
	 * 
	 * @Query("select u.accHolderName from AccountUser u inner join FastTag ar where ar.idArea = :idArea"
	 * )
	 */
	}
