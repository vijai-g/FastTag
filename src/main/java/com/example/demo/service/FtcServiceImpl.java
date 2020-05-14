package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FastTagStatus;
import com.example.demo.model.FtContact;
import com.example.demo.repository.FtcRepository;

@Repository
public class FtcServiceImpl implements FtcService {

	@Autowired
	FtcRepository ftcRepo;

	/**
	 *@return List of Status
	 */
	@Override
	public List<FtContact> findAllStatus() {
		CheckAndSetStatus();
		return ftcRepo.findAll();
	}

	/**
	 * Checks the expiry date and updates Fast Tag Status
	 */
	@Transactional
	public
	void CheckAndSetStatus() {
		List<FtContact> ftc = ftcRepo.findAll();

		ftc.stream()
		.filter((x) -> x.getStatus().equals("NA")) //Default Value for STATUS is set as "NA".
		.forEach((y)-> {
			if (y.getFastTagPayment().getDateExpiry().isAfter(LocalDate.now()))
			{
				y.setStatus(FastTagStatus.ACTIVE);
				ftcRepo.saveAndFlush(y);
			} else {

				y.setStatus(FastTagStatus.RECHARGE);
				ftcRepo.saveAndFlush(y);
			}

		});
	}
	
	
}
