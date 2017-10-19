package kz.bolatai.kitapkhana.stand.register_stand_impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.bolatai.kitapkhana.controller.model.DictionaryInfo;
import kz.bolatai.kitapkhana.controller.model.DictionaryListDetails;
import kz.bolatai.kitapkhana.controller.register.DictionaryRegister;
import kz.bolatai.kitapkhana.stand.register_stand_impl.db.Db;

@Bean
public class DictionaryRegisterStandImpl implements DictionaryRegister{

    public BeanGetter<Db> db;

    @Override
    public DictionaryListDetails getDictionaryListDetails() {
        DictionaryListDetails ret=new DictionaryListDetails();

        db.get().dictionaryStorage.values().forEach(dictionaryDot -> {
            DictionaryInfo dictionaryInfo=new DictionaryInfo();
            dictionaryInfo.code=dictionaryDot.code;
            dictionaryInfo.title=dictionaryDot.title;
            ret.dictionaryInfoList.add(dictionaryInfo);
        });

        return ret;
    }

}
