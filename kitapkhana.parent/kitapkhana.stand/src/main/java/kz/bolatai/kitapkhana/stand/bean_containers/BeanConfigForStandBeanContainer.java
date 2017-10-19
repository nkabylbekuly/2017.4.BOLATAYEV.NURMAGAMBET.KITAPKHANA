package kz.bolatai.kitapkhana.stand.bean_containers;

import kz.greetgo.depinject.core.BeanConfig;
import kz.greetgo.depinject.core.Include;
import kz.bolatai.kitapkhana.controller.controller.BeanConfigControllers;
import kz.bolatai.kitapkhana.stand.beans.BeanConfigStand;
import kz.bolatai.kitapkhana.stand.register_stand_impl.BeanConfigRegisterStandImpl;

@BeanConfig
@Include({BeanConfigStand.class, BeanConfigControllers.class, BeanConfigRegisterStandImpl.class})
public class BeanConfigForStandBeanContainer {
}
