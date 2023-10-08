package thatdz.assignment.assigmentjava5.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieSevice {
  @Autowired
  HttpServletRequest request;
  @Autowired
  HttpServletResponse response;

  public String getValue(String name) {
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equalsIgnoreCase(name)) {
          return cookie.getValue();
        }
      }
    }
    return null;
  }

  public Cookie addCookie(String name, String value, int hours) {
    Cookie cookie = new Cookie(name, value);
    cookie.setMaxAge(hours * 60 * 60);
    cookie.setPath("/");
    response.addCookie(cookie);
    return cookie;
  }

  public Cookie remove(String name) {
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equalsIgnoreCase(name)) {
          cookie.setMaxAge(0);
          return cookie;
        }
      }
    }
    return null;
  }

  public List<cookieResponse> getAllCookie() {
    List<cookieResponse> list = new ArrayList<>();
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        System.out.println(cookie.getName());
        list.add(new cookieResponse(cookie.getName(), cookie.getValue()));
      }
    }
    return list;
  }
}

class cookieResponse {
  public String name;
  public String value;

  cookieResponse(String name,
      String value) {
    this.name = name;
    this.value = value;
  }
}
