package cn.yang.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.yang.store.entity.GoodsImage;

public interface GoodsImageDao extends JpaRepository<GoodsImage, Integer> {

	
	@Query("select gi from GoodsImage as gi where gi.id=?1")
	GoodsImage findOneGoodsImageById(Integer goodsImageId);

	@Query("select gi from GoodsImage as gi")
	List<GoodsImage> findGoodsImageList();

}
