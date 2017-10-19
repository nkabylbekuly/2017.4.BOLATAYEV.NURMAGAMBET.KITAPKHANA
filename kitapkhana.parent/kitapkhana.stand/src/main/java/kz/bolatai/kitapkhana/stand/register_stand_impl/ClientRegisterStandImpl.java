package kz.bolatai.kitapkhana.stand.register_stand_impl;

import com.google.common.base.Strings;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.bolatai.kitapkhana.controller.errors.RestError;
import kz.bolatai.kitapkhana.controller.model.AuthInfo;
import kz.bolatai.kitapkhana.controller.model.ClientInfo;
import kz.bolatai.kitapkhana.controller.model.ClientListDetails;
import kz.bolatai.kitapkhana.controller.register.AuthRegister;
import kz.bolatai.kitapkhana.controller.register.ClientRegister;
import kz.bolatai.kitapkhana.stand.register_stand_impl.db.Db;
import kz.bolatai.kitapkhana.stand.register_stand_impl.model.ClientDot;
import kz.bolatai.kitapkhana.stand.register_stand_impl.model.PersonDot;

@Bean
public class ClientRegisterStandImpl implements ClientRegister {

  public BeanGetter<Db> db;

  @Override
  public ClientListDetails getClientList() {
    ClientListDetails clientListDetails=new ClientListDetails();

    db.get().clientStorage.values().forEach(r->{
      clientListDetails.clientInfoList.add(
              ClientInfo.newBuilder()
                      .setId(r.id)
                      .setSurname(r.surname)
                      .setName(r.name)
                      .setPatronymic(r.patronymic)
                      .setAge(r.age)
                      .build()
      );
    });

    return clientListDetails;
  }

  @Override
  public ClientInfo getClientInfo(String clientId) {

    ClientDot r=db.get().clientStorage.get(clientId);

    return ClientInfo.newBuilder()
                    .setId(r.id)
                    .setSurname(r.surname)
                    .setName(r.name)
                    .setPatronymic(r.patronymic)
                    .setAge(r.age)
                    .build();
  }

  @Override
  public ClientInfo saveClientInfo(ClientInfo clientInfo) {
    if(clientInfo==null) return null;

    if(Strings.isNullOrEmpty(clientInfo.id)) clientInfo.id=db.get().clientSeq.getAndIncrement()+"";
    db.get().clientStorage.put(clientInfo.id,
      ClientDot.newBuilder()
              .setId(clientInfo.id)
              .setSurname(clientInfo.surname)
              .setName(clientInfo.name)
              .setPatronymic(clientInfo.patronymic)
              .setAge(clientInfo.age)
              .build());

    return getClientInfo(clientInfo.id);
  }

  @Override
  public Void deleteClientInfo(String clientId) {
    db.get().clientStorage.remove(clientId);
    return null;
  }
}
