package com.rivers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rivers.entity.AccountDetails;

public interface AccountRepository extends JpaRepository<AccountDetails, String> {

}
