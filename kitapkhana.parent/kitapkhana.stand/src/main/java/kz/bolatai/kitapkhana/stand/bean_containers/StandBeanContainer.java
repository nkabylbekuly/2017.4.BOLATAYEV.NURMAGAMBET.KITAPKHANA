package kz.bolatai.kitapkhana.stand.bean_containers;

import kz.greetgo.depinject.core.BeanContainer;
import kz.greetgo.depinject.core.Include;
import kz.bolatai.kitapkhana.stand.beans.StandServer;

@Include(BeanConfigForStandBeanContainer.class)
public interface StandBeanContainer extends BeanContainer {
  StandServer standServer();
}
