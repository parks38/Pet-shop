package com.petshop.domain.review;

import com.petshop.domain.user.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString(exclude = {"reviewer"})

public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private BigInteger targetId;
    private int targetRate;
    private int userRate;
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private User reviewer;
}
