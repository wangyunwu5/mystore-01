package cn.yang.store.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yang.store.dao.GoodsDao;
import cn.yang.store.dao.GoodsImageDao;
import cn.yang.store.dao.GoodsParameterDao;
import cn.yang.store.dao.GoodsTypeDao;
import cn.yang.store.entity.Goods;
import cn.yang.store.entity.GoodsImage;
import cn.yang.store.entity.GoodsParameter;
import cn.yang.store.entity.GoodsType;

@Service
@Transactional //update或者delete操作需要事务，需要再service层定义事务，  表示spring的事务注解
public class GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private GoodsTypeDao goodsTypeDao;
	
	@Autowired
	private GoodsParameterDao goodsParameterDao;
	
	@Autowired
	private GoodsImageDao goodsImageDao;
	
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
		goodsDao.deleteGoodsById(goodsId);
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
		goodsTypeDao.deleteGoodsTypeById(typeId);
	}

	public void saveGoodsParameter(GoodsParameter goodsParameter) {
		goodsParameterDao.save(goodsParameter);
	}

	public GoodsParameter findOneGoodsParameterById(Integer goodsParameterId) {
		return goodsParameterDao.findOneParameter(goodsParameterId);
	}
	
	public List<GoodsParameter> findGoodsParameterList(){
		return goodsParameterDao.findParameterList();
	}

	public void deleteGoodsParameterById(Integer goodsParameterId) {
		goodsParameterDao.deleteGoodsParameterById(goodsParameterId);
	}

	public GoodsImage findOneGoodsImageById(Integer goodsImageId) {
		return goodsImageDao.findOneGoodsImageById(goodsImageId);
	}

	public List<GoodsImage> findGoodsImageList() {
		return goodsImageDao.findGoodsImageList();
	}
	
}
