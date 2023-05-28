package com.mislbd.ababil.integration.test.inmemorydb.repository;

import com.mislbd.ababil.integration.test.inmemorydb.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {}
