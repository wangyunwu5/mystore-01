package cn.yang.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.yang.store.entity.Goods;

public interface GoodsDao extends JpaRepository<Goods, Integer> {

	@Query("select g from Goods as g")
	List<Goods> findGoodsList();
	@Query("select g from Goods as g where g.id=?1")
	Goods findOneGoods(Integer goodsId);
	/*当需要删除或者更新操作时需要添加@Modifying,告知Spring data这是一个Update或delete操作
	 * jpql不支持insert操作。
	 */
	@Modifying 
	@Query("update Goods as g set g.isDelete = 1 where g.id=?1")
	void deleteGoodsById(Integer goodsId);
}
