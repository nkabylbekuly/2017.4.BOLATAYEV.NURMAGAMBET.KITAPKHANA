package kz.bolatai.kitapkhana.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.bolatai.kitapkhana.controller.model.AuthInfo;
import kz.bolatai.kitapkhana.controller.register.AuthRegister;
import kz.bolatai.kitapkhana.controller.utils.Controller;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ToJson;

@Bean
@Mapping("/auth")
public class AuthController implements Controller{

  public BeanGetter<AuthRegister> authRegister;

  @ToJson
  @Mapping("/login")
  public AuthInfo getAuthInfo(@Par("login")String login,@Par("password") String password) {
    return authRegister.get().getAutoInfo(login, password);
  }
}
