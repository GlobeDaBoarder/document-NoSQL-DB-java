package base.collection;

import base.entity.Entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

public class EntityList extends ArrayList<Entity> {

    public String addEntity(Entity entity) {
        UUID uuid = new UUID(get64MostSignificantBitsForVersion1(), get64LeastSignificantBitsForVersion1());
        entity.setObjId(uuid.toString());

        super.add(entity);

        return uuid.toString();
    }

    private static long get64LeastSignificantBitsForVersion1() {
        Random random = new Random();
        long random63BitLong = random.nextLong() & 0x3FFFFFFFFFFFFFFFL;
        long variant3BitFlag = 0x8000000000000000L;
        return random63BitLong + variant3BitFlag;
    }

    private static long get64MostSignificantBitsForVersion1() {
        final long timeForUuidIn100Nanos = System.currentTimeMillis();
        final long time_low = (timeForUuidIn100Nanos & 0x0000_0000_FFFF_FFFFL) << 32;
        final long time_mid = ((timeForUuidIn100Nanos >> 32) & 0xFFFF) << 16;
        final long version = 1 << 12; final long time_hi = ((timeForUuidIn100Nanos >> 48) & 0x0FFF);
        return time_low + time_mid + version + time_hi;
    }

    @Override
    public Entity get(int index) {
        return super.get(index);
    }

    public Entity getById(String UUID){
        for (Entity currentEntity : this) {
            if (UUID.equals(currentEntity.getObjId())) {
                return currentEntity;
            }
        }

        System.err.println("No entity with UUID = " + UUID );
        return new Entity();
    }


}
