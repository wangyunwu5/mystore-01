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
 * 属性——类目关联
 * @author Administrator
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)//设置时间
@Table(name="param_cate")
public class ParamCate {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; //自增主键
	
	@Column(name="param_id")
	private Integer paramId;//属性id
	
	@Column(name="cate_id")
	private Integer cateId;//类目id

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParamId() {
		return paramId;
	}

	public void setParamId(Integer paramId) {
		this.paramId = paramId;
	}

	public Integer getCateId() {
		return cateId;
	}

	public void setCateId(Integer cateId) {
		this.cateId = cateId;
	}

	@Override
	public String toString() {
		return "ParamCate [id=" + id + ", paramId=" + paramId + ", cateId=" + cateId + "]";
	}
	
}
