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

@Entity
@EntityListeners(AuditingEntityListener.class)//设置时间
@Table(name="goods_spec")
public class GoodsSpec {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //自增主键
	private Integer id;
	
	@Column(name="goods_id")
	private Integer goodsId;//商品编号
	
	@Column(name="spec_name")
	private String specName;//属性名
	
	@Column(name="spec_value")
	private String specValue;//属性值
	
	@Column(name="image")
	private String image;//图片路径
	
	@Column(name="create_time")
	@CreatedDate
	private Date createTime;//创建时间

	@Column(name="update_time")
	@LastModifiedDate
	private Date updateTime;//更新时间
	
	@Column(name="is_delete",columnDefinition="tinyint default 0")
	private Integer isDelete = 0;

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

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getSpecValue() {
		return specValue;
	}

	public void setSpecValue(String specValue) {
		this.specValue = specValue;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "GoodsSpec [id=" + id + ", goodsId=" + goodsId + ", specName=" + specName + ", specValue=" + specValue
				+ ", image=" + image + ", createTime=" + createTime + ", updateTime=" + updateTime + ", isDelete="
				+ isDelete + "]";
	}

}
