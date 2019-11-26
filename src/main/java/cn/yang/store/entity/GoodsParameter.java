package cn.yang.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="goods_parameter")
public class GoodsParameter {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //自增主键
	private Integer id;
	
	@Column(name="goods_id")
	private Integer goodsId;//商品编号
	
	@Column(name="para_name")
	private String paraName;//商品参数名称
	
	@Column(name="para_value")
	private String paraValue;//商品参数值

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

	public String getParaName() {
		return paraName;
	}

	public void setParaName(String paraName) {
		this.paraName = paraName;
	}

	public String getParaValue() {
		return paraValue;
	}

	public void setParaValue(String paraValue) {
		this.paraValue = paraValue;
	}

	@Override
	public String toString() {
		return "GoodsParameter [id=" + id + ", goodsId=" + goodsId + ", paraName=" + paraName + ", paraValue="
				+ paraValue + "]";
	}
	
}
