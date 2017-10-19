package kz.bolatai.kitapkhana.stand.register_stand_impl;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.bolatai.kitapkhana.controller.model.BooksInfo;
import kz.bolatai.kitapkhana.controller.model.BooksListDetails;
import kz.bolatai.kitapkhana.controller.register.BooksRegister;
import kz.bolatai.kitapkhana.stand.register_stand_impl.db.Db;

@Bean
public class BooksRegisterStandImpl implements BooksRegister{

    public BeanGetter<Db> db;

    @Override
    public BooksListDetails getBooksListDetails() {
        BooksListDetails ret=new BooksListDetails();

        db.get().BooksStorage.values().forEach(BooksDot -> {
            BooksInfo BooksInfo=new BooksInfo();
            BooksInfo.code=BooksDot.code;
            BooksInfo.title=BooksDot.title;
            ret.BooksInfoList.add(BooksInfo);
        });

        return ret;
    }

}
