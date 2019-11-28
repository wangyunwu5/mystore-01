package cn.yang.store.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yang.store.dao.GoodsDao;
import cn.yang.store.dao.GoodsTypeDao;
import cn.yang.store.entity.Goods;
import cn.yang.store.entity.GoodsType;

@Service
@Transactional
public class GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private GoodsTypeDao goodsTypeDao;
	
	public void saveGoods(Goods goods) {
		goodsDao.save(goods);
	}

	public List<Goods> findGoodsList(){
		return  goodsDao.findGoodsList();
	}

	public Goods findOneGoods(Integer goodsId) {
		return goodsDao.findOneGoods(goodsId);
	}
	
	public void deleteGoodsById(Integer goodsId) {
		//Goods goods = this.findOneGoods(goodsId);
		goodsDao.delete(findOneGoods(goodsId));
	}
	
	public List<GoodsType> findGoodsTypeList() {
		return goodsTypeDao.findGoodsTypeListAll();
	}

	public void saveGoodsType(GoodsType goodsType) {
		goodsTypeDao.save(goodsType);
	}

	public GoodsType findOneGoodsType(Integer goodsTypeId) {
		return goodsTypeDao.findOneGoodsType(goodsTypeId);
	}
	
	public void deleteGoodsTypeById(Integer typeId) {
		goodsTypeDao.delete(findOneGoodsType(typeId));
	}

	
}
