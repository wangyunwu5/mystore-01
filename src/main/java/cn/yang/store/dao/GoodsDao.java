package cn.yang.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.yang.store.entity.Goods;

public interface GoodsDao extends JpaRepository<Goods, Integer> {

	@Query("select g from Goods as g")
	List<Goods> findGoodsList();
	@Query("select g from Goods as g where g.id=?1")
	Goods findOneGoods(Integer goodsId);
}
