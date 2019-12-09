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
 * 属性值-sku关联
 * @author Administrator
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)//设置时间
@Table(name="param_value_sku")
public class ParamValueSku {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;//自增主键
	
	@Column(name="param_value_id")
	private Integer paramValueId;//参数值id
	
	@Column(name="sku_id")
	private Integer skuId;//sku的id

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParamValueId() {
		return paramValueId;
	}

	public void setParamValueId(Integer paramValueId) {
		this.paramValueId = paramValueId;
	}

	public Integer getSkuId() {
		return skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	@Override
	public String toString() {
		return "ParamValueSku [id=" + id + ", paramValueId=" + paramValueId + ", skuId=" + skuId + "]";
	}
}
