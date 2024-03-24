package mobileworld.event;

import mobileworld.entity.DongSPEntity;

public interface EventSPDialog {

    public boolean add(DongSPEntity dsp);

    public boolean remove(String id);

    public boolean update(DongSPEntity sp, String id);
    
}
