package cn.yang.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 属性-商品关联
 * @author Administrator
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)//设置时间
@Table(name="param_goods")
public class ParamGoods {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; //自增主键

	@Column(name="goods_id")
	private Integer goodsId;//商品id
	
	@Column(name="param_id")
	private Integer paramId;//属性id
	
	@Column(name="is_sale")
	private Integer isSale;//是否为销售属性

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

	public Integer getParamId() {
		return paramId;
	}

	public void setParamId(Integer paramId) {
		this.paramId = paramId;
	}

	public Integer getIsSale() {
		return isSale;
	}

	public void setIsSale(Integer isSale) {
		this.isSale = isSale;
	}

	@Override
	public String toString() {
		return "ParamGoods [id=" + id + ", goodsId=" + goodsId + ", paramId=" + paramId + ", isSale=" + isSale + "]";
	}
	
}
