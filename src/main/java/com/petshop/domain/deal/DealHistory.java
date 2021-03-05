package com.petshop.domain.deal;

import com.petshop.domain.Item.Item;
import com.petshop.domain.common.BaseTimeEntity;
import com.petshop.domain.user.User;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"seller", "item"})
public class DealHistory extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private BigInteger buyer;

    private int itemsCnt;

    @ManyToOne(fetch = FetchType.LAZY)
    private User seller;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;


}
