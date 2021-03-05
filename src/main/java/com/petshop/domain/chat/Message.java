package com.petshop.domain.chat;


import com.petshop.domain.common.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@ToString(exclude = {"chatRoomId"})
@EntityListeners(AuditingEntityListener.class)
public class Message extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Length(max = 300, message = "글은 200자를 초과할 수 없습니다.")
    @NotBlank(message = "내용이 비어있습니다. ")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private ChatRoom chatRoomId;




}
