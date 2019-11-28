package cn.yang.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.yang.store.entity.GoodsImage;

public interface GoodsImageDao extends JpaRepository<GoodsImage, Integer> {

}
