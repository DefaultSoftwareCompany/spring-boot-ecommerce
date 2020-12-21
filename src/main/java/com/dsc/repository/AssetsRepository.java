package com.dsc.repository;

import com.dsc.model.Assets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Native;

@Repository
public interface AssetsRepository extends JpaRepository<Assets, Long> {
    public Assets getAssetsByAssetsId(Long assetsId);
}
