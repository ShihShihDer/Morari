package com.campingmapping.team4.spring.t401member.model.entity;

import java.sql.Blob;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 折價券的基本屬性
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coupon")
@Component
public class Coupon {

    /**
     * 
     * 折價券ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "couponid")
    private Integer couponid;
    /**
     * 
     * 折扣碼
     */
    @Column(name = "couponcode")
    private String couponcode;
    /**
     * 
     * 折價券名稱
     */
    @Column(name = "couponname")
    private String couponname;
    /**
     * 
     * 折價券類型
     */
    @Column(name = "coupontype")
    private int coupontype;
    /**
     * 
     * 折價券發放數量
     */
    @Column(name = "couponamount")
    private int couponamount;
    /**
     * 
     * 折價券已使用數量
     */
    @Column(name = "couponused")
    private int couponused;
    /**
     * 
     * 折價券使用規則
     */
    @Column(name = "couponrule")
    private String couponrule;
    /**
     * 
     * 折價券開始日期
     */
    @Column(name = "startdate")
    private Date startdate;
    /**
     * 
     * 折價券結束日期
     */
    @Column(name = "enddate")
    private Date enddate;
    /**
     * 
     * 折價券建立日期
     */
    @Column(name = "creatdate")
    private Date creatdate;
    /**
     * 
     * 折價券是否顯示
     */
    @Column(name = "showcoupon")
    private String showcoupon;
    /**
     * 
     * 折價券狀態
     */
    @Column(name = "couponstate")
    private String couponstate;
    /**
     * 
     * 折價券圖案
     */
    @Column(name = "couponphoto")
    private Blob couponphoto;
    /**
     * 
     * 折價券錢包
     */
    @JsonIgnore
    @JsonIgnoreProperties("coupon")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "coupon")
    @OrderBy("cwid desc")
    @Builder.Default
    private Set<CouponWallet> couponWallet = new LinkedHashSet<CouponWallet>();
}
