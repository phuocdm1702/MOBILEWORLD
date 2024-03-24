package mobileworld.event;

import mobileworld.entity.RamEntity;

public interface EventRamDialog {

    public boolean add(RamEntity ram);

    public boolean remove(String id);

    public boolean update(RamEntity ram, String id);
}
