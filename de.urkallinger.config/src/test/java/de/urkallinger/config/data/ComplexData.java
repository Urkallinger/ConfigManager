package de.urkallinger.config.data;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ComplexData {

    private List<SimpleData> list;
    private Map<Integer, SimpleData> map;

    public List<SimpleData> getList() {
        return list;
    }

    public void setList(List<SimpleData> list) {
        this.list = list;
    }

    public Map<Integer, SimpleData> getMap() {
        return map;
    }

    public void setMap(Map<Integer, SimpleData> map) {
        this.map = map;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ComplexData other = (ComplexData) obj;

        if(list == null && other.getList() != null) return false;
        else if(list != null && other.getList() == null) return false;

        if(list != null && other.getList() != null) {
            if(list.size() != other.getList().size()) return false;

            for(int i = 0; i < list.size(); i++) {
                if(!list.get(i).equals(other.getList().get(i))) return false;
            }
        }

        if(map == null && other.getMap() != null) return false;
        else if(map != null && other.getMap() == null) return false;

        if(map != null && other.getMap() != null) {
            if(map.size() != other.getMap().size()) return false;

            for(Entry<Integer, SimpleData> entry : map.entrySet()) {
                if(!other.getMap().containsKey(entry.getKey())) return false;
                if(!other.getMap().get(entry.getKey()).equals(entry.getValue())) return false;
            }
        }

        return true;
    }
}
