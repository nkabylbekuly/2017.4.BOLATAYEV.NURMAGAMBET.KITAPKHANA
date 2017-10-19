  package kz.bolatai.kitapkhana.controller.register;

import kz.bolatai.kitapkhana.controller.model.AuthInfo;

public interface AuthRegister {
  AuthInfo getAutoInfo(String accountName, String password);
}
