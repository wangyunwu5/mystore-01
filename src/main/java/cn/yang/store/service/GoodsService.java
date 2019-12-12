package cn.yang.store.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yang.store.dao.BrandDao;
import cn.yang.store.dao.CategoryDao;
import cn.yang.store.dao.GoodsDao;
import cn.yang.store.dao.GoodsImageDao;
import cn.yang.store.dao.GoodsParameterDao;
import cn.yang.store.dao.ParamCateDao;
import cn.yang.store.dao.ParamGoodsDao;
import cn.yang.store.dao.ParamValueDao;
import cn.yang.store.entity.Goods;
import cn.yang.store.entity.GoodsImage;
import cn.yang.store.entity.GoodsParameter;
import cn.yang.store.entity.ParamCate;
import cn.yang.store.entity.ParamGoods;
import cn.yang.store.entity.ParamValue;
import cn.yang.store.entity.Brand;
import cn.yang.store.entity.Category;

@Service
@Transactional //update或者delete操作需要事务，需要再service层定义事务，  表示spring的事务注解
public class GoodsService {
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private GoodsParameterDao goodsParameterDao;
	
	@Autowired
	private GoodsImageDao goodsImageDao;
	
	@Autowired
	private BrandDao brandDao;
	
	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ParamCateDao paramCateDao;
	
	@Autowired
	private ParamGoodsDao paramGoodsDao;
	
	@Autowired
	private ParamValueDao paramValueDao;
	public void saveBrand(Brand brand) {
		brandDao.save(brand);
	}
	
	public void updateBrand(Brand newBrand,Integer id) {
		Brand oldBrand = this.findBrandById(id);
		if(newBrand.getBrandName() !=null || newBrand.getBrandName() != "") {
			oldBrand.setBrandName(newBrand.getBrandName());
		}
		if(newBrand.getLogoUrl() !=null || newBrand.getLogoUrl()  != "") {
			oldBrand.setLogoUrl(newBrand.getLogoUrl() );
		}
		if(newBrand.getBrandDescribe() !=null || newBrand.getBrandDescribe()  != "") {
			oldBrand.setBrandDescribe(newBrand.getBrandDescribe());
		}
		if(newBrand.getIsDelete() !=null) {
			oldBrand.setIsDelete(newBrand.getIsDelete());
		}
		brandDao.save(oldBrand);
	}
	public Brand findBrandById(Integer id) {
		return brandDao.findBrandById(id);
	}

	public List<Brand> findBrandList() {
		return brandDao.findBrandList();
	}
	
	public void deleteBrandById(Integer brandId) {
		brandDao.deleteBrandById(brandId);
	}
	public void saveCategory(Category category) {
		categoryDao.save(category);
	}

	public void updateCategoryAll(Category newCategory, Integer id) {
		Category oldCategory = this.findCategoryById(id);
		if(newCategory.getCateName() !=null || newCategory.getCateName() != "") {
			oldCategory.setCateName(oldCategory.getCateName());
		}
		if(newCategory.getSort() !=null) {
			oldCategory.setSort(newCategory.getSort());
		}
		categoryDao.save(oldCategory);
	}
	public Category findCategoryById(Integer id) {
		return categoryDao.findCategoryById(id);
	}
	public List<Category> findCategoryList() {
		return categoryDao.findCategoryList();
	}

	public void deleteCategoryById(Integer id) {
		categoryDao.deleteCategoryById(id);
	}

	public Goods findOneGoods(Integer goodsId) {
		return goodsDao.findOneGoods(goodsId);
	}

	public List<Goods> findGoodsList() {
		return goodsDao.findGoodsList();
	}

	public void saveGoods(Goods goods) {
		goodsDao.save(goods);
	}

	public void deleteGoodsById(Integer goodsId) {
		goodsDao.deleteGoodsById(goodsId);
	}

	public void updateGoods(Goods newGoods, Integer id) {
		Goods oldGoods = goodsDao.findOneGoods(id);
		oldGoods.setGoodsName(newGoods.getGoodsName());
		oldGoods.setSlogan(newGoods.getSlogan());
		oldGoods.setGoodsDescribe(newGoods.getGoodsDescribe());
		oldGoods.setPopular(newGoods.getPopular());
		goodsDao.save(oldGoods);
	}

	public List<GoodsImage> findGoodsImageById(Integer goodsId) {
		return goodsImageDao.findGoodsImageById(goodsId);
	}

	public void saveGoodsImage(GoodsImage goodsImage) {
		goodsImageDao.save(goodsImage);
	}

	public void updateGoodsImage(GoodsImage newGoodsImage, Integer goodsImageid) {
		GoodsImage oldGoodsImage = goodsImageDao.findGoodsImageByImageId(goodsImageid);
		oldGoodsImage.setImageUrl(newGoodsImage.getImageUrl());
		oldGoodsImage.setImageType(newGoodsImage.getImageType());
		oldGoodsImage.setImageIndex(newGoodsImage.getImageIndex());
		oldGoodsImage.setStatus(newGoodsImage.getStatus());
		goodsImageDao.save(oldGoodsImage);
	}

	public Integer saveGoodsParameter(GoodsParameter goodsParameter) {
		String paramName = goodsParameter.getParaName();
		Integer oldParamId =goodsParameterDao.findGoodsParameterByName(paramName);
		if(oldParamId != null) {//表示该属性名称已经存在，不用重复添加
			return 0;
		}
		else {
			goodsParameterDao.save(goodsParameter);
			Integer newParamId =goodsParameterDao.findGoodsParameterByName(paramName);
			return newParamId;
		}
	}

	public void saveParamCate(ParamCate paramCate) {
		paramCateDao.save(paramCate);
	}

	public void saveParamGoods(ParamGoods paramGoods) {
		paramGoodsDao.save(paramGoods);
	}

	public List<GoodsParameter> findParameterByGoodsId(Integer goodsId) {
		return goodsParameterDao.findParamByGoodsId(goodsId);
	}

	public List<GoodsParameter> findParameterByCateId(Integer cateId) {
		return goodsParameterDao.findParameterBycateId(cateId);
	}

	public void updateGoodsParameter(GoodsParameter newGoodsParameter,Integer id) {
		GoodsParameter oldGoodsParameter = goodsParameterDao.findParamById(id);
		oldGoodsParameter.setParaName(newGoodsParameter.getParaName());
		oldGoodsParameter.setPid(newGoodsParameter.getPid());
		goodsParameterDao.save(oldGoodsParameter);
	}

	public void deleteGoodsParameterById(Integer goodsParameterId) {
		goodsParameterDao.deleteGoodsParameterById(goodsParameterId);
	}

	public void saveParamValue(ParamValue paramValue) {
		paramValueDao.save(paramValue);
	}

	public List<ParamValue> findParamValueByParamId(Integer id) {
		return paramValueDao.findParamValueByParamId(id);
	}

	public void updateParamValue(ParamValue newParamValue, Integer id) {
		ParamValue oldParamValue = paramValueDao.findParamValueById(id);
		oldParamValue.setValueName(newParamValue.getValueName());
		oldParamValue.setImageUrl(newParamValue.getImageUrl());
		paramValueDao.save(oldParamValue);
	}

	public void deleteParamValue(Integer id) {
		paramValueDao.deleteParamValue(id);
	}
	
	
	
}
