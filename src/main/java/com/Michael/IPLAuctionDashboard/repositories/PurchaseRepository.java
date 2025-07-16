package com.Michael.IPLAuctionDashboard.repositories;

import com.Michael.IPLAuctionDashboard.domains.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Integer> {
}
