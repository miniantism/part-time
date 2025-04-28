package com.fsse2501pt.Project.utill;

import com.fsse2501pt.Project.data.domainObject.FireBaseUserData;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JwtUtil {

    public static FireBaseUserData toFireBaseUserData (JwtAuthenticationToken token) {
        return new FireBaseUserData(token);
    }
}
