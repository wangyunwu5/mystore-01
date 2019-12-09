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
import cn.yang.store.entity.Category;
import cn.yang.store.service.GoodsService;
import cn.yang.store.service.ImgUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "用户操作接口")
@RestController
@RequestMapping("/api/v1")
public class myStoreController {
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private ImgUploadService imgService;
	
	/**
	 * 通过id获取goods信息
	 * @param goodsId
	 * @return
	 */
	@ApiOperation(value = "获取goods信息",notes="通过id获取goods信息")
	@RequestMapping(value="/goods/goods/{goodsid}",method =RequestMethod.GET)
	public ResponseBean getGoodsById(@PathVariable("goodsid")Integer goodsId) {
		System.out.println("提交的参数为："+goodsId);
		Goods goods=goodsService.findOneGoods(goodsId);
		System.out.println("goods的信息为:"+goods);
		JSONObject goodsObject = new JSONObject();
		goodsObject.put("goods",goods);
		return new ResponseBean(200,"请求成功",goodsObject);
	}
	/**
	 * 获取所有goods信息
	 * @return
	 */
	@ApiOperation(value="获取所有goods信息列表")
	@RequestMapping(value="/goods/goodsList/",method =RequestMethod.GET)
	public ResponseBean getGoodsList() {
		List<Goods> goodsNew = goodsService.findGoodsList();
		return new ResponseBean(200,"请求成功",goodsNew);
	}
	/**
	 * 添加一个goods数据
	 * @param param
	 * @return
	 * @throws IOException
	 */
	@ApiOperation(value="保存一个商品数据")
	@RequestMapping(value="/goods/goods/",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResponseBean saveGoods(@RequestBody JSONObject param) throws IOException {
		System.out.println("请求成功");
		JSONObject goodsObject = param.getJSONObject("goods");
		Goods goods = (Goods)JSONObject.toJavaObject(goodsObject,Goods.class);
		if(goods !=null) {
			goodsService.saveGoods(goods);
			List<Goods> goodsNew = goodsService.findGoodsList();
			return new ResponseBean(200,"提交成功",goodsNew);
		}
		else {
			return new ResponseBean(400,"提交失败，提交的数据为空",null);
		}
	}
	/**
	 * 通过id删除一个goods数据
	 * @param goodsId
	 * @return
	 */
	@ApiOperation(value="删除一个商品数据")
	@RequestMapping(value="/goods/goods/{goodsid}",method=RequestMethod.DELETE)
	public ResponseBean deleteGoods(@PathVariable("goodsid")Integer goodsId) {
		goodsService.deleteGoodsById(goodsId);
		return new ResponseBean(200,"提交成功",null);
	}
	
	/**
	 * 获取商品类别列表
	 * @return
	 */
	@ApiOperation(value="获取商品类别数据列表")
	@RequestMapping(value="/goods/typelist",method=RequestMethod.GET)
	public ResponseBean getGoodsTypeList() {
		JSONObject goodsTypeObject = new JSONObject();
		List<Category> goodsTypes = goodsService.findGoodsTypeList();
		goodsTypeObject.put("goodsTypeList",goodsTypes);
		return new ResponseBean(200,"请求成功",goodsTypeObject);
	}
	/**
	 * 保存一个商品类别数据
	 * @param param
	 * @return
	 */
	@ApiOperation(value="保存一个商品类别数据")
	@RequestMapping(value="/goods/type",method =RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResponseBean saveGoodsType(@RequestBody JSONObject param) {
		JSONObject gst = param.getJSONObject("goodsType");
		Category goodsType = (Category)JSONObject.toJavaObject(gst,Category.class);
		goodsService.saveGoodsType(goodsType);
		return new ResponseBean(200,"提交成功",null);
	}
	/**
	 * 通过id删除一个goodsType
	 * @param typeId
	 * @return
	 */
	@ApiOperation(value="删除一个商品类别数据")
	@RequestMapping(value="/goods/type",method = RequestMethod.DELETE)
	public ResponseBean deleteGoodsType(@RequestParam("goodstypeid")Integer typeId) {
		goodsService.deleteGoodsTypeById(typeId);
		return new ResponseBean(200,"删除成功",null);
	}
	
	/**
	 * 添加一个goodsParameter数据
	 * @param param
	 * @return
	 */
	@ApiOperation(value="保存一个商品参数数据")
	@RequestMapping(value="/goods/parameter",method=RequestMethod.POST)
	public ResponseBean saveGoodsParameter(@RequestBody JSONObject param) {
		JSONObject gp = param.getJSONObject("goodsparameter");
		GoodsParameter goodsParameter = (GoodsParameter)JSONObject.toJavaObject(gp,GoodsParameter.class);
		goodsService.saveGoodsParameter(goodsParameter);
		
		return new ResponseBean(200,"提交成功",null);
	}
	/**
	 * 通过id获取一个goodsparameter数据
	 * @param goodsParameterId
	 * @return
	 */
	@ApiOperation(value="查询一个商品参数数据")
	@RequestMapping(value="/goods/parameter",method=RequestMethod.GET)
	public ResponseBean findOneGoodsParameterById(@RequestParam("goodsparameterid")Integer goodsParameterId) {
		if(goodsParameterId == null || goodsParameterId.equals("")) {
			return new ResponseBean(403,"服务器拒绝请求，提交的参数为空",null);
		}
		else {
			GoodsParameter goodsParameter = goodsService.findOneGoodsParameterById(goodsParameterId);
			JSONObject parameterObject = new JSONObject();
			parameterObject.put("goodsparameter",goodsParameter);
			return new ResponseBean(200,"请求成功",parameterObject);
		}
	}
	/**
	 * 获取goodsParameter列表
	 * @return
	 * @throws IOException
	 */
	@ApiOperation(value="获取商品参数数据列表")
	@RequestMapping(value="/goods/parameters",method=RequestMethod.GET)
	public ResponseBean findGoodsParameterList() throws IOException {
		List<GoodsParameter> goodsParameters = goodsService.findGoodsParameterList();
		JSONObject parameterObject = new JSONObject();
		parameterObject.put("goodsparameters",goodsParameters);
		return new ResponseBean(200,"请求成功",parameterObject);
	}
	
	/**
	 * 通过id删除一个goodsparameter
	 * @param goodsParameterId
	 * @return
	 */
	@ApiOperation(value="删除一个商品参数数据")
	@RequestMapping(value="/goods/parameter",method=RequestMethod.DELETE)
	public ResponseBean deleteGoodsParameterById(@RequestParam("goodsparameterid")Integer goodsParameterId) {
		if(goodsParameterId == null || goodsParameterId.equals("")) {
			return new ResponseBean(403,"服务器拒绝请求，提交的参数为空",null);
		}
		else {
			goodsService.deleteGoodsParameterById(goodsParameterId);
			return new ResponseBean(200,"删除成功",null);
		}
	}
	
	/**
	 * 通过id获取一个goodsimage信息
	 * @param goodsImageId
	 * @return
	 */
	@ApiOperation(value="获取一个商品图片数据")
	@RequestMapping(value="/goods/image",method=RequestMethod.GET)
	public ResponseBean findOneGoodsImage(@RequestParam("goodsimageid")Integer goodsImageId) {
		if(goodsImageId == null || goodsImageId.equals("")) {
			return new ResponseBean(403,"服务器拒绝请求，提交的参数为空",null);
		}
		else {
		    List<GoodsImage> goodsImage= goodsService.findGoodsImageById(goodsImageId);
		    JSONObject goodsImageObject = new JSONObject();
		    goodsImageObject.put("goodsimage",goodsImage);
		    return new ResponseBean(200,"请求成功",goodsImageObject); 
		}
	}
	/**
	 * 获取GoodsImage列表
	 * @return
	 */
	@ApiOperation(value="获取所有商品图片数据")
	@RequestMapping(value="/goods/images",method=RequestMethod.GET)
	public ResponseBean findGoodsImageList() throws IOException{
		List<GoodsImage> goodsImages = goodsService.findGoodsImageList();
		JSONObject goodsImageList = new JSONObject();
		goodsImageList.put("goodsimage",goodsImages);
		return new ResponseBean(200,"请求成功",goodsImageList);
	}
	/**
	 * 图片上传接口
	 * @return
	 */
	@ApiOperation(value="图片上传接口")
	@RequestMapping(value="/goods/image",method = RequestMethod.POST)
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
			return new ResponseBean(400,"上传失败",null);
		}
	}
	@ApiOperation(value="保存一个图片信息接口")
	@RequestMapping(value="/goods/goodsimage",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResponseBean saveGoodsImageMessage(@RequestBody JSONObject param) {
		System.out.println("保存图片信息方法");
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
	@RequestMapping(value="/goods/goodssku",method=RequestMethod.GET)
	public ResponseBean getGoodsSkuByGoodsId(@RequestParam("goodsid")Integer goodsId) {
		if(goodsId !=null) {
			//goodsService.getGoodsSkuByGoodsId(goodsId);
			return new ResponseBean(200,"请求成功",null);
		}
		else {
			
			return new ResponseBean(200,"请求成功",null);
		}
	}
	
}




