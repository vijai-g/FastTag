package com.example.demo.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.swing.Spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.model.FtContact;
import com.example.demo.repository.FtcRepository;
import com.example.demo.service.FtcService;
import com.example.demo.service.FtcServiceImpl;
@ExtendWith(SpringExtension.class)
@DataJdbcTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=validate"
})
class FtcServiceImplTest {
@Autowired
	FtcService ftsi;
@Autowired
FtcRepository ftcRepo;

	@Test
	void testFindAllStatus() {
		List<FtContact> ftc = ftcRepo.findAll();
		assertThat(ftc.get(1).getStatus()).isEqualTo("ACTIVE");
	}

	@Test
	void testCheckAndSetStatus() {
		fail("Not yet implemented");
	}

}
