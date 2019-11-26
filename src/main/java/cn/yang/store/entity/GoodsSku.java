package cn.yang.store.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="goods_sku")
public class GoodsSku {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //自增主键
	private Integer id;
	
	@Column(name="goods_id")
	private Integer goodsId;//商品编号
	
	@Column(name="goods_sku")
	private String goodsSku;//商品sku,库存量单位
	
	@Column(name="stock")
	private Integer stock;//商品库存
	
	@Column(name="price")
	private BigDecimal price;//商品价格
	
	@Column(name="image")
	private String image;//图片路径
	
	@Column(name="create_time")
	private String createTime;//创建时间

	@Column(name="update_time")
	private String updateTime;//更新时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsSku() {
		return goodsSku;
	}

	public void setGoodsSku(String goodsSku) {
		this.goodsSku = goodsSku;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "GoodsSku [id=" + id + ", goodsId=" + goodsId + ", goodsSku=" + goodsSku + ", stock=" + stock
				+ ", price=" + price + ", image=" + image + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ "]";
	}
	
}
