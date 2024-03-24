package mobileworld.event;

import mobileworld.entity.BoNhoEntity;

public interface EventRomDialog {

    public boolean add(BoNhoEntity bn);

    public boolean remove(String id);

    public boolean update(BoNhoEntity bn, String id);
}
