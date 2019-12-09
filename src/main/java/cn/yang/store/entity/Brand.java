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
 * 品牌
 * @author Administrator
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="brand")
public class Brand {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //自增主键
	private Integer id;//品牌id
	

	@Column(name="name")
	private String name;//品牌名称
	

	@Column(name="logo_url")
	private String logoUrl;//品牌logo路径
	

	@Column(name="describe")
	private String describe;//品牌介绍
	

	@Column(name="goods_no")
	private String goodsNo;//商品编号
	
	@Column(name="create_time")
	@CreatedDate
	private Date createTime;//创建时间
	
	@Column(name="update_time")
	@LastModifiedDate
	private Date updateTime;//更新时间
	
	@Column(name="is_delete",columnDefinition="tinyint default 0")
	private Integer isDelete = 0;//是否删除，0为没有删除，1为删除

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getGoodsNo() {
		return goodsNo;
	}

	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
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
		return "Brand [id=" + id + ", name=" + name + ", logoUrl=" + logoUrl + ", describe=" + describe + ", goodsNo="
				+ goodsNo + ", createTime=" + createTime + ", updateTime=" + updateTime + ", isDelete=" + isDelete
				+ "]";
	}
	
}
