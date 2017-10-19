package kz.bolatai.kitapkhana.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.depinject.core.BeanScanner;
import kz.bolatai.kitapkhana.controller.model.IntroductionInfo;
import kz.bolatai.kitapkhana.controller.register.IntroductionRegister;
import kz.bolatai.kitapkhana.controller.utils.Controller;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.ToJson;

@Bean
@Mapping("/introduction")
public class IntroductionController implements Controller {

  public BeanGetter<IntroductionRegister> introductionRegister;

  @ToJson
  @Mapping("/helloWorld")
  public IntroductionInfo getIntroductionInfo() {
    return introductionRegister.get().getIntroductionInfo();
  }
}
