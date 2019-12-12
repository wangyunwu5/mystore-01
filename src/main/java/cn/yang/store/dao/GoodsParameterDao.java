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
	
	@Query("select gp.id from GoodsParameter as gp where gp.paraName=?1")
	Integer findGoodsParameterByName(String paramName);

	@Query("select gp from GoodsParameter as gp, ParamGoods as pg where gp.id=pg.paramId and pg.goodsId=?1")
	List<GoodsParameter> findParamByGoodsId(Integer goodsId);

	@Query("select gp from GoodsParameter as gp, ParamCate as pc where gp.id=pc.paramId and pc.cateId=?1")
	List<GoodsParameter> findParameterBycateId(Integer cateId);

	@Query("select gp from GoodsParameter as gp where gp.id=?1")
	GoodsParameter findParamById(Integer id);
}
