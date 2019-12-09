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
 * 商品图片
 * @author Administrator
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)//设置时间
@Table(name="goods_image")
public class GoodsImage {

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //自增主键
	private Integer id;
	
	@Column(name="goods_id")
	private String goodsId;//商品id
	
	@Column(name="image_url")
	private String imageUrl;//商品图片路径
	
	@Column(name="image_type")
	private Integer imageType;//图片类型,0为轮播图，1为介绍图
	
	@Column(name="image_index")
	private Integer imageIndex;//图片下标，编号
	
	@Column(name="create_time")
	@CreatedDate
	private Date createTime;//图片创建时间
	
	@Column(name="update_time")
	@LastModifiedDate
	private Date updateTime;//图片更新时间
	
	@Column(name="status",columnDefinition="tinyint default 0")
	private Integer status=0;//状态，0为正常，1为禁用，2为删除

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getImageType() {
		return imageType;
	}

	public void setImageType(Integer imageType) {
		this.imageType = imageType;
	}

	public Integer getImageIndex() {
		return imageIndex;
	}

	public void setImageIndex(Integer imageIndex) {
		this.imageIndex = imageIndex;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "GoodsImage [id=" + id + ", goodsId=" + goodsId + ", imageUrl=" + imageUrl + ", imageType=" + imageType
				+ ", imageIndex=" + imageIndex + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", status=" + status + "]";
	}
	
}
