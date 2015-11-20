package com.zdz.crm.mapper;

import java.util.List;

import com.zdz.crm.model.BasDict;

public interface BasDictMapper {
	public abstract void save(BasDict transientInstance);

	public abstract void delete(BasDict persistentInstance);

	public abstract BasDict findById(Long id);

	public abstract List findByExample(BasDict instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByDictType(Object dictType);

	public abstract List findByDictItem(Object dictItem);

	public abstract List findByDictValue(Object dictValue);

	public abstract List findByDictIsEditable(Object dictIsEditable);

	public abstract List findAll();

	public abstract BasDict merge(BasDict detachedInstance);

	public abstract void attachDirty(BasDict instance);

	public abstract void attachClean(BasDict instance);
}
