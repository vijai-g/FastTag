package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AccountUser;
import com.example.demo.model.FtContact;

public interface FtcRepository extends JpaRepository<FtContact, Integer>{

}
