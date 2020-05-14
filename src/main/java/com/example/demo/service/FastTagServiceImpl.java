package com.example.demo.service;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.model.FastTagPayment;
import com.example.demo.model.FastTagStatus;
import com.example.demo.repository.FtRepo;

import nl.flotsam.xeger.Xeger;


@Repository
public class FastTagServiceImpl implements FastTagService {
	
	@Autowired
	FtRepo ftRepo;

	@Override
	public FastTagStatus FtStatus() {

		return FastTagStatus.ACTIVE;
	}

	/**
	 * Generates Primary key (Fast Tag id) using regex
	 * @return
	 */
	String generateFTid() {
		String regex = "FT[0-9]{4}[a-v]{5}";
		Xeger generator = new Xeger(regex);
		String result = generator.generate();
		assert result.matches(regex);
		return result;
	}

	/**
	 *Creates a new, Sets Fast tag id and expiry date
	 */
	@Transactional
	@Override
	public void createNewFT(FastTagPayment ftp) {

		if (StringUtils.isBlank(ftp.getFastTagId())) {
			ftp.setFastTagId(generateFTid());
		}
		
		ftp.setDateExpiry(LocalDate.now().plusDays(365));
		
		ftRepo.save(ftp);

	}
	

}
