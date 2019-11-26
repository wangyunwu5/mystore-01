package cn.yang.store.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.yang.store.common.ResponseBean;

@RestController
@RequestMapping("/api/v1")
public class myStoreController {

	@RequestMapping(value="/goods/{goodsid}",method =RequestMethod.GET)
	public ResponseBean getGoodsList(@PathVariable("goodsid")Integer goodsId) {
		return new ResponseBean(200,"请求成功",null);
	}
	
	@RequestMapping(value="/goods/",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResponseBean saveGoods(JSONObject goodsObject) {
		System.out.println("请求成功");
		return new ResponseBean(200,"提交成功",goodsObject);
	}
	@RequestMapping(value="/goods/{goodsid}",method=RequestMethod.DELETE)
	public ResponseBean deleteGoods(@PathVariable("goodsid")Integer goodsId) {
		System.out.println("删除成功");
		return new ResponseBean(200,"提交成功",null);
	}
}
