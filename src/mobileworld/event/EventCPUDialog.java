package mobileworld.event;

import mobileworld.entity.CPUEntity;

public interface EventCPUDialog {

    public boolean add(CPUEntity cpu);

    public boolean remove(String id);

    public boolean update(CPUEntity cpu, String id);
}
