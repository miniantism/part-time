package com.fsse2501pt.Project.util;

import com.fsse2501pt.Project.data.domainObject.FirebaseUserData;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class JwtUtil {

    public static FirebaseUserData toFirebaseUserData (JwtAuthenticationToken token) {
        return new FirebaseUserData(token);
    }

    public static FirebaseUserData getFirebaseUserData(JwtAuthenticationToken jwt) {
        return new FirebaseUserData(jwt);}
}
