package kz.bolatai.kitapkhana.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.bolatai.kitapkhana.controller.model.DictionaryInfo;
import kz.bolatai.kitapkhana.controller.model.DictionaryListDetails;
import kz.bolatai.kitapkhana.controller.register.DictionaryRegister;
import kz.bolatai.kitapkhana.controller.utils.Controller;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.ToJson;

@Bean
@Mapping("/dictionary")
public class DictionaryController implements Controller{

    public BeanGetter<DictionaryRegister> dictionaryRegister;

    @ToJson
    @Mapping("/list")
    public DictionaryListDetails getList(){
        return dictionaryRegister.get().getDictionaryListDetails();
    }
}
