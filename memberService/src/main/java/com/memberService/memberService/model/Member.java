package com.memberService.memberService.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int member_id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    private String password;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @UpdateTimestamp
    private Date updatedAt;
//    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
//    private List<Post> post;
}
