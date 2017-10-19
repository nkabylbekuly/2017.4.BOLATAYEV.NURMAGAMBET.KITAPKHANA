package kz.bolatai.kitapkhana.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.bolatai.kitapkhana.controller.model.BooksInfo;
import kz.bolatai.kitapkhana.controller.model.BooksListDetails;
import kz.bolatai.kitapkhana.controller.register.BooksRegister;
import kz.bolatai.kitapkhana.controller.utils.Controller;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.ToJson;

@Bean
@Mapping("/Books")
public class BooksController implements Controller{

    public BeanGetter<BooksRegister> BooksRegister;

    @ToJson
    @Mapping("/list")
    public BooksListDetails getList(){
        return BooksRegister.get().getBooksListDetails();
    }
}
