package cn.yang.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.yang.store.entity.ParamGoods;

public interface ParamGoodsDao extends JpaRepository<ParamGoods, Integer> {
}
