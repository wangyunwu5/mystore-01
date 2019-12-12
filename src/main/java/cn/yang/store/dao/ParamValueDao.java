package cn.yang.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.yang.store.entity.ParamValue;

public interface ParamValueDao extends JpaRepository<ParamValue, Integer>{

	@Query("select pv from ParamValue as pv where pv.paramId=?1")
	List<ParamValue> findParamValueByParamId(Integer id);

	@Query("select pv from ParamValue as pv where pv.id=?1")
	ParamValue findParamValueById(Integer id);

	@Modifying
	@Query("update ParamValue as pv set pv.status =1 where pv.id=?1")
	void deleteParamValue(Integer id);

	
}
