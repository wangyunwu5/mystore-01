package cn.yang.store.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.alibaba.fastjson.annotation.JSONField;

@Entity
@EntityListeners(AuditingEntityListener.class)//设置时间
@Table(name="goods")
public class Goods {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //自增主键
	private Integer id;
	
	@Column(name="goods_name")
	private String goodsName;//商品名称
	
	@Column(name="goods_type_id")
	private Integer goodsTypeId;
	
	@Column(name="scan")
	private Integer scan;//浏览量
	
	@Column(name="sales")
	private Integer sales;//销量
	
	@Column(name="goods_describe")
	private String goodsDescribe;//商品描述
	
	@Column(name="create_time")
	@CreatedDate
	private Date createTime;//创建时间
	
	@Column(name="update_time")
	@LastModifiedDate
	private Date updateTime;//更新时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public Integer getScan() {
		return scan;
	}

	public void setScan(Integer scan) {
		this.scan = scan;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public String getGoodsDescribe() {
		return goodsDescribe;
	}

	public void setGoodsDescribe(String goodsDescribe) {
		this.goodsDescribe = goodsDescribe;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodsName=" + goodsName + ", goodsTypeId=" + goodsTypeId + ", scan=" + scan
				+ ", sales=" + sales + ", goodsDescribe=" + goodsDescribe + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

}
