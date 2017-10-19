package kz.bolatai.kitapkhana.stand.register_stand_impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.bolatai.kitapkhana.controller.model.IntroductionInfo;
import kz.bolatai.kitapkhana.controller.register.IntroductionRegister;
import kz.bolatai.kitapkhana.stand.register_stand_impl.db.Db;

@Bean
public class IntroductionRegisterStandImpl implements IntroductionRegister {

  public BeanGetter<Db> db;

  @Override
  public IntroductionInfo getIntroductionInfo() {
    IntroductionInfo introductionInfo = new IntroductionInfo();
    return introductionInfo;
  }

}
