package kz.bolatai.kitapkhana.controller.register;

import kz.bolatai.kitapkhana.controller.model.ClientInfo;
import kz.bolatai.kitapkhana.controller.model.ClientListDetails;

public interface ClientRegister {
  ClientListDetails getClientList();

  ClientInfo getClientInfo(String clientId);

  ClientInfo saveClientInfo(ClientInfo clientInfo);

  Void deleteClientInfo(String clientId);
}
