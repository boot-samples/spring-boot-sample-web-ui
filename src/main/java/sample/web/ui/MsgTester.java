package sample.web.ui;

import java.util.HashMap;

public class MsgTester {

    InMemoryMessageRepository inMemoryMessageRepository;
    void prepare(HashMap<String, Object> params){
        inMemoryMessageRepository = new InMemoryMessageRepository();
        inMemoryMessageRepository.save(new Message());
    }

    void test(){
        inMemoryMessageRepository.findMessage(5L);
    }
}
