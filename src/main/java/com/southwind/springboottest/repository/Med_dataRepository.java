package com.southwind.springboottest.repository;

import com.southwind.springboottest.entity.Med_data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Med_dataRepository extends JpaRepository<Med_data,Integer> {
}
