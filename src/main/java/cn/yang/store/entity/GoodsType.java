package cn.yang.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="goods_type")
public class GoodsType {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //自增主键
	private Integer id;
	
	@Column(name="goods_type_id")
	private String goodsTypeId;//商品名称
	
	@Column(name="goods_type_name")
	private String goodsTypeName;//商品名称

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(String goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public String getGoodsTypeName() {
		return goodsTypeName;
	}

	public void setGoodsTypeName(String goodsTypeName) {
		this.goodsTypeName = goodsTypeName;
	}

	@Override
	public String toString() {
		return "GoodsType [id=" + id + ", goodsTypeId=" + goodsTypeId + ", goodsTypeName=" + goodsTypeName + "]";
	}
	
}
