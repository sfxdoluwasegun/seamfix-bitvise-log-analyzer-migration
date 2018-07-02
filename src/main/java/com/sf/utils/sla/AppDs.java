package com.sf.utils.sla;

import nw.orm.core.service.Nworm;

/**
 * @author lash
 */
public class AppDs {
    private static AppDs ds;

    private Nworm dbService;

    private AppDs() {
        dbService = Nworm.getInstance();

    }

    public static AppDs getInstance(){
        if(ds == null){
            synchronized (AppDs.class) {
                if(ds == null){
                    ds = new AppDs();
                }
            }
        }
        return ds;
    }

    public Nworm getDbService() {
        return dbService;
    }


}
