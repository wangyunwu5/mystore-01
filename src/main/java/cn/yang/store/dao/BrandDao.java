package cn.yang.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.yang.store.entity.Brand;

public interface BrandDao extends JpaRepository<Brand, Integer> {

	@Query("select b from Brand as b where b.id=?1")
	Brand findBrandById(Integer id);
	@Query("select b from Brand as b")
	List<Brand> findBrandList();
	
	/**
	 * 当时测试时出现bug,用这个方法更新时，createTime字段也跟着更新，手动更新数据库数据create_time字段也更新。
	 * 后来找到原因，是因为create_time把根据当前时间戳更新✔上了，去掉✔即可解决问题
	 * @param brandId
	 */
	@Modifying
	@Query("update Brand as b set b.isDelete=1 where b.id=?1")
	void deleteBrandById(Integer brandId);

}
