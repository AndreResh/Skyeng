package com.app.repository;

import com.app.model.PostalDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostalDeliveryRepository extends JpaRepository<PostalDelivery, Long> {
}
