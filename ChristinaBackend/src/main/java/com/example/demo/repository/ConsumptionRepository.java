package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Consumption;
import java.util.List;

/**
 * Hi, I am also a JPA repository interface, this time for Consumption (of current)
 */
public interface ConsumptionRepository extends JpaRepository<Consumption, Long> {
	List<Consumption> findByMeteringPointMeteringPointId(Long mpId);
}                   //findByMeteringPointMeteringPointId
                    //findByMeteringPointMeteringPointCustomerId

