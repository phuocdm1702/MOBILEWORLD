package mobileworld.event;

import mobileworld.entity.ManHinhEntity;

public interface EventManHinhDialog {

    public boolean add(ManHinhEntity mh);

    public boolean remove(String id);

    public boolean update(ManHinhEntity mh, String id);
}
