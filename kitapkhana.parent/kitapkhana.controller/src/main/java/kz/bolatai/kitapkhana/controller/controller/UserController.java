package kz.bolatai.kitapkhana.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.bolatai.kitapkhana.controller.model.UserInfo;
import kz.bolatai.kitapkhana.controller.register.UserRegister;
import kz.bolatai.kitapkhana.controller.utils.Controller;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ToJson;

@Bean
@Mapping("/user")
public class UserController implements Controller {

  public BeanGetter<UserRegister> userRegister;

  @ToJson
  @Mapping("/info")
  public UserInfo getUserInfo(@Par("personId") String personId) {
    System.out.println(personId);
    return userRegister.get().getUserInfo(personId);
  }

}
