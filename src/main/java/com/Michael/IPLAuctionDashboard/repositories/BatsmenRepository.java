package com.Michael.IPLAuctionDashboard.repositories;

import com.Michael.IPLAuctionDashboard.domains.entities.Batsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatsmenRepository extends JpaRepository<Batsman,Integer> {
}
