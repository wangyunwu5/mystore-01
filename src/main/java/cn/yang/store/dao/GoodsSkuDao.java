package cn.yang.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.yang.store.entity.GoodsSku;

public interface GoodsSkuDao extends JpaRepository<GoodsSku, Integer> {

}
