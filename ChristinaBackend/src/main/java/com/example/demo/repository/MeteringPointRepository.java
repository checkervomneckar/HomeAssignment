package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.MeteringPoint;
import java.util.List;

/**
 * Hi, I am also a JPA repository interface, this time for MeteringPoint
 */
public interface MeteringPointRepository extends JpaRepository<MeteringPoint, Long> {
	List<MeteringPoint> findByCustomerCustomerId(Long custID);
}

