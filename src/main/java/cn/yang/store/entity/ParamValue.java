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
 * 属性值
 * @author Administrator
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)//设置时间
@Table(name="param_value")
public class ParamValue {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer id;//自增主键
	
	@Column(name="param_id")
	private Integer paramId;//参数id
	
	@Column(name="value_name")
	private String valueName;//属性值名称
	
	@Column(name="image_url")
	private String imageUrl;//属性值对应的图片路径，比如手机玫瑰金
	
	@Column(name="status",columnDefinition="tinyint default 0")
	private Integer status = 0;//状态，0为正常，1为禁用
	
	@Column(name="create_time")
	@CreatedDate
	private Date createTime;//创建时间

	@Column(name="update_time")
	@LastModifiedDate
	private Date updateTime;//更新时间

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

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "ParamValue [id=" + id + ", paramId=" + paramId + ", valueName=" + valueName + ", imageUrl=" + imageUrl
				+ ", status=" + status + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
}
