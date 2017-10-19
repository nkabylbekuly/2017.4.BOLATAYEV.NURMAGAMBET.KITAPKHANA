package kz.bolatai.kitapkhana.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.bolatai.kitapkhana.controller.model.ClientInfo;
import kz.bolatai.kitapkhana.controller.model.ClientListDetails;
import kz.bolatai.kitapkhana.controller.model.IntroductionInfo;
import kz.bolatai.kitapkhana.controller.register.ClientRegister;
import kz.bolatai.kitapkhana.controller.utils.Controller;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ParamsTo;
import kz.greetgo.mvc.annotations.ToJson;

import java.util.Date;

@Bean
@Mapping("/client")
public class ClientController implements Controller {

  public BeanGetter<ClientRegister> clientRegister;
  @ToJson()
  @Mapping("/list")
  public ClientListDetails getClientList() {
    return clientRegister.get().getClientList();
  }

  @ToJson()
  @Mapping("/info")
  public ClientInfo getClientInfo(@Par("clientId") String clientId) {
    return clientRegister.get().getClientInfo(clientId);
  }

  @ToJson()
  @Mapping("/save")
  public ClientInfo saveClientInfo(@ParamsTo ClientInfo clientInfo) {
    return clientRegister.get().saveClientInfo(clientInfo);
  }

  @ToJson()
  @Mapping("/delete")
  public Void deleteClientInfo(@Par("clientId") String clientId) {
    return clientRegister.get().deleteClientInfo(clientId);
  }

}
