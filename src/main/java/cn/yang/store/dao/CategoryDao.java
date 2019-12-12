package cn.yang.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.yang.store.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

	@Query("select c from Category as c where c.id=?1")
	Category findCategoryById(Integer id);

	@Query("select c from Category as c")
	List<Category> findCategoryList();

	@Query("update Category as c set c.status = 1 where c.id=?1")
	void deleteCategoryById(Integer id);

}
