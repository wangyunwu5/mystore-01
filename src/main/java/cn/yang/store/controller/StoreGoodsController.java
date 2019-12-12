package cn.yang.store.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import cn.yang.store.common.ResponseBean;
import cn.yang.store.entity.Goods;
import cn.yang.store.entity.GoodsImage;
import cn.yang.store.entity.GoodsParameter;
import cn.yang.store.entity.ParamCate;
import cn.yang.store.entity.ParamGoods;
import cn.yang.store.entity.ParamValue;
import cn.yang.store.entity.Brand;
import cn.yang.store.entity.Category;
import cn.yang.store.service.GoodsService;
import cn.yang.store.service.ImgUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "用户操作接口")
@RestController
@RequestMapping("/api/v1/goods")
public class StoreGoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private ImgUploadService imgService;
	
	//定义公共JSONObject
	private JSONObject commonObject = new JSONObject();
	
	private ParamCate paramCate = new ParamCate();
	private ParamGoods paramGoods = new ParamGoods();
	
	/*----品牌信息管理-----*/
	@ApiOperation(value = "保存品牌信息",notes="保存一个品牌信息")
	@RequestMapping(value="/brand",method =RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResponseBean saveBrand(@RequestBody JSONObject object){
		try {
			JSONObject brandObject = object.getJSONObject("brand");
			Brand brand = (Brand)JSONObject.toJavaObject(brandObject,Brand.class);
			System.out.println("新添加的brand的信息为"+brand);
			goodsService.saveBrand(brand);
			return new ResponseBean(200,"提交成功",null);
		}catch(Exception e) {
			commonObject.put("failmsg",e);
			return new ResponseBean(400,"提交失败",commonObject);
		}
	}
	
	@ApiOperation(value = "更新品牌信息",notes="更新全部字段信息，或者局部字段")
	@RequestMapping(value="/brand/{id}",method =RequestMethod.PUT,produces="application/json;charset=UTF-8")
	public ResponseBean updateBrandAll(@RequestBody JSONObject object,@PathVariable Integer id){
		try {
			JSONObject brandObject = object.getJSONObject("brand");
			Brand newBrand = (Brand)JSONObject.toJavaObject(brandObject,Brand.class);
			goodsService.updateBrand(newBrand,id);
			return new ResponseBean(200,"更新成功",null);
		}catch(Exception e) {
			commonObject.put("failmsg",e);
			return new ResponseBean(400,"提交失败",commonObject);
		}
	}
	
	@ApiOperation(value = "更新品牌信息",notes="更新部分字段信息,此接口有待完善")
	@RequestMapping(value="/brand",method =RequestMethod.PATCH)
	public ResponseBean updateBrandSome(@RequestBody JSONObject object){
		try {
			JSONObject brandObject = object.getJSONObject("brand");
			Brand brand = (Brand)JSONObject.toJavaObject(brandObject,Brand.class);
			//goodsService.updateBrand(brand);
			return new ResponseBean(200,"更新成功",null);
		}catch(Exception e) {
			commonObject.put("failmsg",e);
			return new ResponseBean(400,"提交失败",commonObject);
		}
	}
	
	@ApiOperation(value = "获取品牌信息列表",notes="获取所有的品牌信息")
	@RequestMapping(value="/brands",method =RequestMethod.GET)
	public ResponseBean getBrandList(){
		try {
			List<Brand> brandList = goodsService.findBrandList();
			commonObject.put("brands",brandList);
			return new ResponseBean(200,"更新成功",commonObject);
		}catch(Exception e) {
			commonObject.put("failmsg",e);
			return new ResponseBean(400,"提交失败",commonObject);
		}
	}
	@ApiOperation(value="删除一个品牌",notes="通过id删除一个品牌")
	@RequestMapping(value="/brand/{brandid}",method=RequestMethod.DELETE)
	public ResponseBean deleteBrandById(@PathVariable("brandid")Integer brandId) {
		goodsService.deleteBrandById(brandId);
		return new ResponseBean(200,"删除成功",null);
	}
	
	/*----品牌信息管理-----*/
	
	/*----商品类目管理-----*/
	@ApiOperation(value = "保存商品类目信息",notes="保存一个商品类目信息")
	@RequestMapping(value="/category",method =RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResponseBean saveCategory(@RequestBody JSONObject object){
		try {
			JSONObject categoryObject = object.getJSONObject("category");
			Category category = (Category)JSONObject.toJavaObject(categoryObject,Category.class);
			goodsService.saveCategory(category);
			return new ResponseBean(200,"添加成功",null);
		}catch(Exception e) {
			commonObject.put("failmsg",e);
			return new ResponseBean(400,"提交失败",commonObject);
		}
	}
	@ApiOperation(value = "更新类目信息",notes="只能手动更新类目的名称、类目的排序")
	@RequestMapping(value="/category/{id}",method =RequestMethod.PUT,produces="application/json;charset=UTF-8")
	public ResponseBean updateCategoryAll(@RequestBody JSONObject object,@PathVariable Integer id){
		try {
			JSONObject categoryObject = object.getJSONObject("category");
			Category newCategory = (Category)JSONObject.toJavaObject(categoryObject,Category.class);
			goodsService.updateCategoryAll(newCategory,id);
			return new ResponseBean(200,"更新成功",null);
		}catch(Exception e) {
			commonObject.put("failmsg",e);
			return new ResponseBean(400,"提交失败",commonObject);
		}
	}
	@ApiOperation(value = "获取所有商品类目列表")
	@RequestMapping(value="/brand",method =RequestMethod.GET)
	public ResponseBean getCategoryList(){
		try {
			JSONObject categorys = new JSONObject();
			List<Category> categoryList = goodsService.findCategoryList();
			categorys.put("categorys",categoryList);
			return new ResponseBean(200,"更新成功",categorys);
		}catch(Exception e) {
			commonObject.put("failmsg",e);
			return new ResponseBean(400,"提交失败",commonObject);
		}
	}
	
	@ApiOperation(value="通过id删除一个商品类目")
	@RequestMapping(value="/category/{id}",method = RequestMethod.DELETE)
	public ResponseBean deleteCategoryById(@PathVariable Integer id) {
		goodsService.deleteCategoryById(id);
		return new ResponseBean(200,"删除成功",null);
	}
	/*----商品类目管理-----*/
	
	/*----商品管理-----*/
	@ApiOperation(value = "获取goods信息",notes="通过id获取goods信息")
	@RequestMapping(value="/goods/{goodsid}",method =RequestMethod.GET)
	public ResponseBean getGoodsById(@PathVariable("goodsid")Integer goodsId) {
		System.out.println("提交的参数为："+goodsId);
		Goods goods=goodsService.findOneGoods(goodsId);
		System.out.println("goods的信息为:"+goods);
		commonObject.put("goods",goods);
		return new ResponseBean(200,"请求成功",commonObject);
	}
	@ApiOperation(value="获取所有goods信息列表")
	@RequestMapping(value="/goodsList",method =RequestMethod.GET)
	public ResponseBean getGoodsList() {
		List<Goods> goodsList = goodsService.findGoodsList();
		commonObject.put("goodsList",goodsList);
		return new ResponseBean(200,"请求成功",commonObject);
	}
	@ApiOperation(value="保存或者添加一个商品数据")
	@RequestMapping(value="/goods",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResponseBean saveGoods(@RequestBody JSONObject param){
		JSONObject goodsObject = param.getJSONObject("goods");
		Goods goods = (Goods)JSONObject.toJavaObject(goodsObject,Goods.class);
		if(goods !=null) {
			goodsService.saveGoods(goods);
			List<Goods> goodsNewList = goodsService.findGoodsList();
			commonObject.put("goodsList",goodsNewList);
			return new ResponseBean(200,"添加成功",commonObject);
		}
		else {
			commonObject.put("failmsg","提交的数据为空");
			return new ResponseBean(400,"提交失败",commonObject);
		}
	}
	@ApiOperation(value="删除一个商品数据")
	@RequestMapping(value="/goods/{goodsid}",method=RequestMethod.DELETE)
	public ResponseBean deleteGoods(@PathVariable("goodsid")Integer goodsId) {
		goodsService.deleteGoodsById(goodsId);
		return new ResponseBean(200,"删除成功",null);
	}
	@ApiOperation(value="更新一个商品数据",notes="可以更新商品的全部字段、局部字段")
	@RequestMapping(value="/goods/{id}",method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
	public ResponseBean updateGoods(@RequestBody JSONObject param,@PathVariable Integer id){
		JSONObject goodsObject = param.getJSONObject("goods");
		Goods goods = (Goods)JSONObject.toJavaObject(goodsObject,Goods.class);
		if(goods !=null) {
			goodsService.updateGoods(goods,id);
			List<Goods> goodsNewList = goodsService.findGoodsList();
			commonObject.put("goodsList",goodsNewList);
			return new ResponseBean(200,"添加成功",commonObject);
		}
		else {
			commonObject.put("failmsg","添加失败，提交的数据为空");
			return new ResponseBean(400,"提交失败",commonObject);
		}
	}
	
	/*----商品管理-----*/
	
	/*----图片上传管理-----*/
	@ApiOperation(value="图片上传接口",notes="单张图片上传")
	@RequestMapping(value="/image",method = RequestMethod.POST)
	public ResponseBean uploadImage(MultipartFile file) {
		try {
			String imgPath = imgService.uploadOne(file);
			if(imgPath != null) {
				JSONObject imgpath = new JSONObject();
				imgpath.put("imgpath",imgPath);
				return new ResponseBean(200,"上传成功成功",imgpath);
			}else {
				return new ResponseBean(400,"上传成功失败",null);
			}

		}catch(Exception e) {
			e.printStackTrace();
			commonObject.put("failmsg",e);
			return new ResponseBean(400,"上传失败",commonObject);
		}
	}
	/*----图片上传管理-----*/
	
	/*----商品图片管理-----*/
	@ApiOperation(value="获取一个商品的图片数据",notes="通过商品id获取一个商品的图片数据")
	@RequestMapping(value="/goodsimage",method=RequestMethod.GET)
	public ResponseBean findOneGoodsImage(@RequestParam("goodsid")Integer goodsId) {
		try {
			List<GoodsImage> goodsImages= goodsService.findGoodsImageById(goodsId);
			JSONObject goodsImageObject = new JSONObject();
			goodsImageObject.put("goodsimage",goodsImages);
			return new ResponseBean(200,"请求成功",goodsImageObject); 
		}catch(Exception e) {
			e.printStackTrace();
			commonObject.put("failmsg",e);
			return new ResponseBean(400,"上传失败",commonObject);
		}
	}
	
	@ApiOperation(value="保存一个图片信息")
	@RequestMapping(value="/goodsimage",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResponseBean saveGoodsImageMessage(@RequestBody JSONObject param) {
		JSONObject gi = param.getJSONObject("goodsimage");
		GoodsImage goodsImage = (GoodsImage)JSONObject.toJavaObject(gi,GoodsImage.class);
		if(goodsImage!=null) {
			goodsService.saveGoodsImage(goodsImage);
			return new ResponseBean(200,"提交成功",null);
		}
		else {
			return new ResponseBean(400,"提交失败，提交的数据为空",null);
		}
	}
	
	@ApiOperation(value="更新一个图片信息",notes="")
	@RequestMapping(value="/goodsimage/{id}",method=RequestMethod.PUT,produces="application/json;charset=UTF-8")
	public ResponseBean updateGoodsImage(@RequestBody JSONObject param,@PathVariable Integer id) {
		JSONObject gi = param.getJSONObject("goodsimage");
		GoodsImage goodsImage = (GoodsImage)JSONObject.toJavaObject(gi,GoodsImage.class);
		if(goodsImage!=null) {
			goodsService.updateGoodsImage(goodsImage,id);
			return new ResponseBean(200,"更新成功",null);
		}
		else {
			return new ResponseBean(400,"更新失败，提交的数据为空",null);
		}
	}
	/*----商品图片管理-----*/
	
	/*----商品属性管理-----*/
	@ApiOperation(value="添加一个新的商品属性数据，或者添加一个新的类目属性数据",notes="如果是传入类目id，cogid的值应该写为cate+id的形式，如果是传入商品id，则是good+id的形式")
	@RequestMapping(value="/parameter_cate",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResponseBean saveGoodsParameter(@RequestBody JSONObject param) {
		try {
			JSONObject gp = param.getJSONObject("goodsparameter");
			String cogId = (String)param.get("cogid");
			String flag =cogId.substring(0,4);
			Integer id = Integer.parseInt(cogId.substring(4));
			GoodsParameter goodsParameter = (GoodsParameter)JSONObject.toJavaObject(gp,GoodsParameter.class);
			Integer  paramId = goodsService.saveGoodsParameter(goodsParameter);
			if(paramId >0) { 
				if(flag =="cate") {
					paramCate.setCateId(id); 
					paramCate.setParamId(paramId);
					goodsService.saveParamCate(paramCate);
				}
				if(flag == "good") {
					paramGoods.setParamId(paramId);
					paramGoods.setGoodsId(id);
					goodsService.saveParamGoods(paramGoods);
				}
				return new ResponseBean(200,"提交成功",null);
			} else if(paramId == 0){ 
				return new ResponseBean(400,"插入失败，已经存在同样的属性了",null); 
			}else {
				return new ResponseBean(400,"插入失败，传入的参数有错",null); 
			}
		}catch(Exception e) {
			e.printStackTrace();
			commonObject.put("failmsg",e);
			return new ResponseBean(400,"插入失败",commonObject);
		}
	}
	@ApiOperation(value="查询商品属性数据",notes="通过商品id查询商品的属性")
	@RequestMapping(value="/parameter_good",method=RequestMethod.GET)
	public ResponseBean findGoodsParameterByGoodsId(@RequestParam("goodsid")Integer goodsId) {
		if(goodsId == null) {
			return new ResponseBean(403,"服务器拒绝请求，提交的参数为空",null);
		}
		else {
			List<GoodsParameter> goodsParameters = goodsService.findParameterByGoodsId(goodsId);
			JSONObject parameterObject = new JSONObject();
			parameterObject.put("goodsparameter",goodsParameters);
			return new ResponseBean(200,"查询成功",parameterObject);
		}
	}
	
	@ApiOperation(value="查询商品属性数据",notes="通过类目id查询商品的属性")
	@RequestMapping(value="/parameter_cate",method=RequestMethod.GET)
	public ResponseBean findGoodsParameterByCateId(@RequestParam("categoryid")Integer cateId) {
		if(cateId == null) {
			return new ResponseBean(403,"服务器拒绝请求，提交的参数为空",null);
		}
		else {
			List<GoodsParameter> goodsParameters = goodsService.findParameterByCateId(cateId);
			JSONObject parameterObject = new JSONObject();
			parameterObject.put("goodsparameter",goodsParameters);
			return new ResponseBean(200,"查询成功",parameterObject);
		}
	}
	@ApiOperation(value="更新一个商品属性数据")
	@RequestMapping(value="/parameter/{id}",method=RequestMethod.PUT)
	public ResponseBean findGoodsParameterList(@RequestBody JSONObject object,@PathVariable Integer id){
		JSONObject gp = object.getJSONObject("goodsparameter");
		GoodsParameter goodsParameter = (GoodsParameter)JSONObject.toJavaObject(gp,GoodsParameter.class);
		goodsService.updateGoodsParameter(goodsParameter,id);
		return new ResponseBean(200,"更新成功",null);
	}
	
	
	@ApiOperation(value="删除一个商品属性数据")
	@RequestMapping(value="/parameter",method=RequestMethod.DELETE)
	public ResponseBean deleteGoodsParameterById(@RequestParam("goodsparameterid")Integer goodsParameterId) {
		goodsService.deleteGoodsParameterById(goodsParameterId);
		return new ResponseBean(200,"删除成功",null);
	}
	/*----商品属性管理-----*/
	
	/*----商品属性值管理-----*/
	@ApiOperation(value="添加一个商品属性值数据")
	@RequestMapping(value="/paramvalue",method=RequestMethod.POST)
	public ResponseBean saveParamValue(@RequestBody JSONObject object) {
		JSONObject pv = object.getJSONObject("paramvalue");
		ParamValue paramValue = (ParamValue)JSONObject.toJavaObject(pv,ParamValue.class);
		goodsService.saveParamValue(paramValue);
		return new ResponseBean(200,"添加成功",null);
	}
	@ApiOperation(value="查询商品属性值数据",notes="通过商品属性id查询属性值")
	@RequestMapping(value="/paramvalue/{id}",method=RequestMethod.GET)
	public ResponseBean saveParamValue(@RequestParam("id") Integer id) {
	   List<ParamValue> paramValues = goodsService.findParamValueByParamId(id);
	   commonObject.put("paramvalues",paramValues);
		return new ResponseBean(200,"查询成功",commonObject);
	}
	
	@ApiOperation(value="更新商品属性值数据",notes="通过商品属性值id更新属性值")
	@RequestMapping(value="/paramvalue/{id}",method=RequestMethod.PUT)
	public ResponseBean updateParamValue(@RequestBody JSONObject object,@RequestParam("id") Integer id) {
		JSONObject pv = object.getJSONObject("paramvalue");
		ParamValue paramValue = (ParamValue)JSONObject.toJavaObject(pv,ParamValue.class);
		goodsService.updateParamValue(paramValue,id);
		return new ResponseBean(200,"更新成功",commonObject);
	}
	
	@ApiOperation(value="删除商品属性值数据",notes="通过商品属性值id删除属性值")
	@RequestMapping(value="/goods/paramvalue/{id}",method=RequestMethod.DELETE)
	public ResponseBean deleteParamValue(@RequestParam("id") Integer id) {
		goodsService.deleteParamValue(id);
		return new ResponseBean(200,"请求成功",commonObject);
	}
	/*----商品属性值管理-----*/
	/*----商品sku管理-----*/
	
	/*----商品sku管理-----*/
}




