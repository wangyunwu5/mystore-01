package cn.yang.store.entity;

import java.math.BigDecimal;
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
 * 商品sku
 * @author Administrator
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)//设置时间
@Table(name="goods_sku")
public class GoodsSku {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;//自增主键
	
	@Column(name="goods_id")
	
	private Integer goodsId;//商品id
	
	@Column(name="sku_name")
	private String skuName;//商品sku名称
	
	@Column(name="unit")
	private String unit;//库存单位名称
	
	@Column(name="stock")
	private Integer stock;//商品库存量
	
	@Column(name="sale")
	private Integer sale;//销量
	
	@Column(name="sale_price")
	private BigDecimal salePrice;//销售价格
	
	@Column(name="buy_price")
	private BigDecimal buyPrice;//进货价格
	
	@Column(name="image_url")
	private String imageUrl;//代表图片路径
	
	@Column(name="status",columnDefinition="tinyint default 0")
	private Integer status = 0;//状态，0为正常，1为已售完
	
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

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getSale() {
		return sale;
	}

	public void setSale(Integer sale) {
		this.sale = sale;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
		return "GoodsSku [id=" + id + ", goodsId=" + goodsId + ", skuName=" + skuName + ", unit=" + unit + ", stock="
				+ stock + ", sale=" + sale + ", salePrice=" + salePrice + ", buyPrice=" + buyPrice + ", imageUrl="
				+ imageUrl + ", status=" + status + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
}
