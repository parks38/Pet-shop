package com.petshop.domain.user;

import com.petshop.domain.Item.Item;
import com.petshop.domain.chat.ChatRoom;
import com.petshop.domain.common.BaseTimeEntity;
import com.petshop.domain.deal.DealHistory;
import com.petshop.domain.review.UserReview;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String username;

    private String password;

    @Email
    private String email;

    private String location;

    private int zipcode;

    private String interest1;

    private String interest2;

    @Enumerated(EnumType.STRING)
    private Role role;

    private int status;

    private BigInteger deletedBy;

    //user : chatRooms
    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChatRoom> chatRoomsList = new ArrayList<>();

    // user : dealsHistory
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DealHistory> dealsHistoryList = new ArrayList<>();

    // user: userReviews
    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserReview> userReviewsList = new ArrayList<>();

    // user: items
    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> itemsList = new ArrayList<>();



    @Builder
    public User(BigInteger id, String username, String password, String email, String location, int zipcode,
                String interest1, String interest2, Role role, int status, BigInteger deletedBy){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.location = location;
        this.zipcode = zipcode;
        this.interest1 = interest1;
        this.interest2 = interest2;
        this.role = role;
        this.status = status;
        this.deletedBy = deletedBy;
    }

}
