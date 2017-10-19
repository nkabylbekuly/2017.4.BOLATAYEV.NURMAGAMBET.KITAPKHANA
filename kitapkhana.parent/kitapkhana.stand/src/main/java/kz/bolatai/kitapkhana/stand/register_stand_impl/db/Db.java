package kz.bolatai.kitapkhana.stand.register_stand_impl.db;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.HasAfterInject;
import kz.bolatai.kitapkhana.stand.register_stand_impl.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Bean
public class Db implements HasAfterInject{
  public final Map<String, PersonDot> personStorage = new HashMap<>();
  public final Map<String, RoleDot> roleStorage = new HashMap<>();
  public final Map<String, FuncDot> funcStorage = new HashMap<>();
  public final Map<String, List<String>> roleFuncMapping = new HashMap<>();
  public final Map<String, String> personRoleMapping = new HashMap<>();
  public final Map<String, ClientDot> clientStorage=new HashMap<>();
  public final Map<String, DictionaryDot> dictionaryStorage=new HashMap<>();
  public final Map<String, BooksDot> booksStorage=new HashMap<>();

  public final AtomicLong clientSeq=new AtomicLong(1);

  @Override
  public void afterInject() throws Exception {
    prepareData();
  }

  private void prepareData() {
    personStorage.put("main",new PersonDot("main","main"));
    personStorage.put("main_tab_1",new PersonDot("main_tab_1","main_tab_1"));
    personStorage.put("main_tab_2",new PersonDot("main_tab_2","main_tab_2"));

    personStorage.put("admin",new PersonDot("admin","admin"));
    personStorage.put("admin_can_see_part",new PersonDot("admin_can_see_part","admin_can_see_part"));

    roleStorage.put("admin",new RoleDot("admin","Administrator of system"));
    roleStorage.put("admin_part",new RoleDot("admin_part","Administrator with half access"));

    roleStorage.put("main_user",new RoleDot("main_user","User with all access"));
    roleStorage.put("user_for_tab_1",new RoleDot("user_for_tab_1","User who work's with Main Tab 1"));
    roleStorage.put("user_for_tab_2",new RoleDot("user_for_tab_2","User who work's with Main Tab 2"));

    funcStorage.put("admin",new FuncDot("admin","Have access to work with administration part"));
    funcStorage.put("can_see_admin_tab_1",new FuncDot("can_see_admin_tab_1", "Have access to work with Admin Tab 1"));
    funcStorage.put("can_see_admin_tab_2",new FuncDot("can_see_admin_tab_2", "Have access to work with Admin Tab 2"));
    funcStorage.put("can_see_admin_tab_3",new FuncDot("can_see_admin_tab_3", "Have access to work with Admin Tab 3"));
    funcStorage.put("can_see_admin_tab_4",new FuncDot("can_see_admin_tab_4", "Have access to work with Admin Tab 4"));
    funcStorage.put("can_see_admin_tab_5",new FuncDot("can_see_admin_tab_5", "Have access to work with Admin Tab 5"));
    funcStorage.put("can_see_admin_tab_6",new FuncDot("can_see_admin_tab_6", "Have access to work with Admin Tab 6"));
    funcStorage.put("can_see_admin_tab_7",new FuncDot("can_see_admin_tab_7", "Have access to work with Admin Tab 7"));

    funcStorage.put("main",new FuncDot("main","Have access to work with main part"));
    funcStorage.put("can_see_main_tab_1",new FuncDot("can_see_main_tab_1", "Have access to work with Main Tab 1"));
    funcStorage.put("can_see_main_tab_2",new FuncDot("can_see_main_tab_2", "Have access to work with Main Tab 2"));

    roleFuncMapping.put("admin",new ArrayList<String>(){{add("admin");
      add("can_see_admin_tab_1"); add("can_see_admin_tab_2"); add("can_see_admin_tab_3");
      add("can_see_admin_tab_4"); add("can_see_admin_tab_5"); add("can_see_admin_tab_6");
      add("can_see_admin_tab_7");
    }});

    roleFuncMapping.put("admin_part",new ArrayList<String>(){{add("admin");
      add("can_see_admin_tab_1"); add("can_see_admin_tab_4");
      add("can_see_admin_tab_6"); add("can_see_admin_tab_7");
    }});

    roleFuncMapping.put("main",new ArrayList<String>(){{add("main");
      add("can_see_main_tab_1"); add("can_see_main_tab_2");
    }});

    roleFuncMapping.put("user_for_tab_1",new ArrayList<String>(){{add("main");
      add("can_see_main_tab_1");
    }});

    roleFuncMapping.put("user_for_tab_2",new ArrayList<String>(){{add("main");
      add("can_see_main_tab_2");
    }});

    personRoleMapping.put("main","main");
    personRoleMapping.put("main_tab_1","user_for_tab_1");
    personRoleMapping.put("main_tab_2","user_for_tab_2");
    personRoleMapping.put("admin","admin");
    personRoleMapping.put("admin_can_see_part","admin_part");

    clientStorage.put(clientSeq.get()+"",
            ClientDot
              .newBuilder()
              .setId(clientSeq.getAndIncrement()+"")
              .setSurname("Tukibayev")
              .setName("Ilyas")
              .setPatronymic("Bakbergenovich")
              .setAge(26)
            .build());

    clientStorage.put(clientSeq.get()+"",
            ClientDot
              .newBuilder()
              .setId(clientSeq.getAndIncrement()+"")
              .setSurname("Tursyn")
              .setName("Seyit")
              .setPatronymic("Nurmuhanbetuly")
              .setAge(26)
            .build());
    BooksDot books = new BooksDot();
    books.code="Abay Joly";
    books.title="Muhtar Auezov";
    booksStorage.put("Abay Joly",books);


    DictionaryDot iphone = new DictionaryDot();
    iphone.code="iphone";
    iphone.title="IPhone X";
    dictionaryStorage.put("iphone", iphone);
    DictionaryDot samsung = new DictionaryDot();
    samsung.code="samsung";
    samsung.title="Samsung Galaxy S8";
    dictionaryStorage.put("samsung",samsung);

    DictionaryDot Huawei = new DictionaryDot();
    Huawei.code="Huawei";
    Huawei.title="Huawei Test";
    dictionaryStorage.put("Huawei",Huawei);

  }
}
