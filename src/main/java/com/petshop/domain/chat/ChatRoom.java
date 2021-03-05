package com.petshop.domain.chat;

import com.petshop.domain.common.BaseTimeEntity;
import com.petshop.domain.user.User;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class ChatRoom extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private BigInteger target;

    private BigInteger createdBy;
    private BigInteger deletedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private User user;

    @OneToMany(mappedBy = "chatRoomId",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messageList = new ArrayList<>();

}
