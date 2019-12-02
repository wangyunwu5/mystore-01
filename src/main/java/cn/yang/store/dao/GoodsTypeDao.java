package cn.yang.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.yang.store.entity.GoodsType;

public interface GoodsTypeDao extends JpaRepository<GoodsType, Integer> {

	@Query("select gt from GoodsType as gt")
	List<GoodsType> findGoodsTypeListAll();
	@Query("select gt from GoodsType as gt where gt.id=?1")
	GoodsType findOneGoodsType(Integer goodsTypeId);
	
	@Modifying 
	@Query("update GoodsType as gt set gt.isDelete = 1 where gt.id=?1")
	void deleteGoodsTypeById(Integer typeId);
}
