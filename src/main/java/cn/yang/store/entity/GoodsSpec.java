package cn.yang.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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
		return "GoodsSpec [id=" + id + ", goodsId=" + goodsId + ", specName=" + specName + ", specValue=" + specValue
				+ ", image=" + image + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
}
