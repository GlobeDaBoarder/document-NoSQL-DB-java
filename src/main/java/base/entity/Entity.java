package base.entity;

public class Entity {
    private String objId;
    private String json;

    public Entity(String objId, String json) {
        this.objId = objId;
        this.json = json;
    }

    public Entity() {
    }

    public Entity(String json) {
        this.json = json;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "objId='" + objId + '\'' +
                ", json='" + json + '\'' +
                '}';
    }

    //equals & hashCode


}
