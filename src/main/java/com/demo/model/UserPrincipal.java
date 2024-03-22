package com.demo.model;

import com.demo.entity.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
public class UserPrincipal implements OAuth2User {

    private Oauth2UserInfoDto userInfo;
    private Map<String, Object> attributes;

    public UserPrincipal(Oauth2UserInfoDto userInfo, Map<String, Object> attributes) {
        this.userInfo = userInfo;
        this.attributes = attributes;
    }

    public static UserPrincipal create(User user, Map<String, Object> attributes) {
        Oauth2UserInfoDto userInfoDto = new Oauth2UserInfoDto();
        userInfoDto.setId(user.getId().toString());
        userInfoDto.setName(user.getName());
        userInfoDto.setEmail(user.getUsername());
        userInfoDto.setUsername(user.getUsername());
        Map<String, Object> nAttributes = new HashMap<>();
        nAttributes.put("login", attributes.get("login").toString());
        nAttributes.put("id", attributes.get("id").toString());

        return new UserPrincipal(userInfoDto, nAttributes);
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getName() {
        return this.userInfo.getName();
    }
}
