package com.example.farm_game.repositories;

import com.example.farm_game.models.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CropRepository extends JpaRepository<Crop,Long> {

    @Modifying
    @Query(value = "UPDATE CROPS SET STOCK = STOCK - 1 WHERE CROPS.ID = :CROP_ID", nativeQuery = true)
    @Transactional
    public void reduceStockByOne(@Param("CROP_ID") Long cropID);
}
