package cn.yang.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="goods_image")
public class GoodsImage {

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //自增主键
	private Integer id;
	
	@Column(name="goods_id")
	private Integer goodsId;//商品编号
	
	@Column(name="image_url")
	private String imageUrl;//商品图片
	
	@Column(name="image_type")
	private String imageType;//图片类型
	
	@Column(name="image_index")
	private Integer imageIndex;//图片下标，编号
	
	@Column(name="create_time")
	private String createTime;//图片创建时间
	
	@Column(name="update_time")
	private String updateTime;//图片更新时间

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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public Integer getImageIndex() {
		return imageIndex;
	}

	public void setImageIndex(Integer imageIndex) {
		this.imageIndex = imageIndex;
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
		return "GoodsImage [id=" + id + ", goodsId=" + goodsId + ", imageUrl=" + imageUrl + ", imageType=" + imageType
				+ ", imageIndex=" + imageIndex + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
}
