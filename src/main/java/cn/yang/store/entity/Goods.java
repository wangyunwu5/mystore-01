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

/**
 * 商品，类似spu
 * @author Administrator
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)//设置时间
@Table(name="goods")
public class Goods {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //自增主键
	private Integer id;
	
	@Column(name="goods_no")
	private String goodsNo;//商品编号
	
	@Column(name="goods_name")
	private String goodsName;//商品名称
	
	@Column(name="slogan")
	private String slogan;//广告语
	
	@Column(name="category_id")
	private Integer categoryId;//类目id
	
	@Column(name="brand_id")
	private Integer brandId;//品牌id
	
	@Column(name="scan",columnDefinition="tinyint default 0")
	private Integer scan =0;//浏览量
	
	@Column(name="sales",columnDefinition="tinyint default 0")
	private Integer sales =0;//销量
	
	@Column(name="love",columnDefinition="tinyint default 0")
	private Integer love =0;//点赞量
	
	@Column(name="describe")
	private String describe;//商品描述
	
	@Column(name="status",columnDefinition="tinyint default 0")
	private Integer status=0;//状态，0为上架，1为下架，2为删除
	
	@Column(name="popular",columnDefinition="tinyint default 0")
	private Integer popular=0;//是否热门，0为非热门，1为热门
	
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

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
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

	public Integer getLove() {
		return love;
	}

	public void setLove(Integer love) {
		this.love = love;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPopular() {
		return popular;
	}

	public void setPopular(Integer popular) {
		this.popular = popular;
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
		return "Goods [id=" + id + ", goodsNo=" + goodsNo + ", goodsName=" + goodsName + ", slogan=" + slogan
				+ ", categoryId=" + categoryId + ", brandId=" + brandId + ", scan=" + scan + ", sales=" + sales
				+ ", love=" + love + ", describe=" + describe + ", status=" + status + ", popular=" + popular
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
}
