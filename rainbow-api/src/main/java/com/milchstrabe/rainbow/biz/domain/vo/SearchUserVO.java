package com.milchstrabe.rainbow.biz.domain.vo;

import lombok.*;

/**
 * @Author ch3ng
 * @Date 2020/6/13 19:32
 * @Version 1.0
 * @Description
 **/
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchUserVO {

    private String userId;
    private String username;
    private String avatar;
    private Short age;
    private String email;
    private Short gender;
    private String remark;
    private String nickname;
    private String phone;
}
