package cn.yang.store.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="goods")
public class Goods {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //自增主键
	private Integer id;
	
	@Column(name="goods_name")
	private String goodsName;//商品名称
	
	@Column(name="goods_type_id")
	private Integer goodsTypeId;
	
	@Column(name="scan")
	private Integer scan;//浏览量
	
	@Column(name="sales")
	private Integer sales;//销量
	
	@Column(name="goods_describe")
	private Integer goodsDescribe;//商品描述
	
	@Column(name="create_time")
	private String createTime;//添加时间
	
	@Column(name="update_time")
	private String updateTime;//更新时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsTypeId() {
		return goodsTypeId;
	}

	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public Integer getScan() {
		return scan;
	}

	public void setScan(Integer scan) {
		this.scan = scan;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Integer getGoodsDescribe() {
		return goodsDescribe;
	}

	public void setGoodsDescribe(Integer goodsDescribe) {
		this.goodsDescribe = goodsDescribe;
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
		return "Goods [id=" + id + ", goodsName=" + goodsName + ", goodsTypeId=" + goodsTypeId + ", scan=" + scan
				+ ", sales=" + sales + ", goodsDescribe=" + goodsDescribe + ", createTime=" + createTime
				+ ", updateTime=" + updateTime + "]";
	}

}
