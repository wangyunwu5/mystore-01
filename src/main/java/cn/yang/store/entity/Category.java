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
 * 商品类目
 * @author Administrator
 *
 */
@Entity
@EntityListeners(AuditingEntityListener.class)//设置时间
@Table(name="category")
public class Category {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //自增主键
	private Integer id;
	
	@Column(name="pid")
	private Integer pid;//父亲id
	
	@Column(name="cate_name")
	private String cateName;//类目名称
	
	@Column(name="level")
	private Integer level;//类目级别，一级、二级、三级...
	
	@Column(name="sort")
	private Integer sort;//类目排序
	
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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		if(this.pid>=0) {
			this.level = this.pid+1;
		}else {
			this.level = 0;
		}
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
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
		return "Category [id=" + id + ", pid=" + pid + ", cateName=" + cateName + ", level=" + level + ", sort=" + sort
				+ ", status=" + status + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
	
}
