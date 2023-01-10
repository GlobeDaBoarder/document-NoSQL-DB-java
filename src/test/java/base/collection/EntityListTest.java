package base.collection;

import base.entity.Entity;
import org.junit.jupiter.api.Test;

import java.util.List;


class EntityListTest {
    //creat einterface for EntityList
    EntityList entityList = new EntityList();

    @Test
    void add() {
        String id1 = entityList.addEntity(new Entity("{user: 'Ura'}"));
        String id2 = entityList.addEntity(new Entity("{user: 'Gleb'}"));

        System.out.println(entityList.toString());
        System.out.println(entityList.getById(id1));
    }

    @Test
    void getById() {
    }
}