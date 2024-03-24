package mobileworld.event;

import mobileworld.entity.PinEntity;

public interface EventPinDialog {

    public boolean add(PinEntity pin);

    public boolean remove(String id);

    public boolean update(PinEntity pin, String id);

}
