package cn.yang.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.yang.store.entity.GoodsParameter;

public interface GoodsParameterDao extends JpaRepository<GoodsParameter, Integer> {

	@Query("select gp from GoodsParameter as gp where gp.id=?1")
	GoodsParameter findOneParameter(Integer goodsParameterId);

	@Query("select gp from GoodsParameter as gp")
	List<GoodsParameter> findParameterList();

	@Modifying 
	@Query("update GoodsParameter as gp set gp.isDelete = 1 where gp.id=?1")
	void deleteGoodsParameterById(Integer goodsParameterId);
}
