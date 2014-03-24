/**
 * 
 */
package com.boroborome.finance.web.jsonmodule;

import com.google.appengine.api.datastore.Entity;

/**
 * @author boroborome
 *
 */
public interface IEntityObject
{
	//Used to save the key of entity.
	//This value is read and write by module logic
	String getKey();
	void setKey(String key);
	
	void loadFromEntity(Entity entity);
	void saveToEntity(Entity entity);
}
