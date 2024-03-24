package mobileworld.event;

import mobileworld.entity.MauSacEntity;

public interface EventMauSacDialog {

    public boolean add(MauSacEntity ms);

    public boolean remove(String id);

    public boolean update(MauSacEntity ms, String id);
}
