package com.main.Container;

import com.main.Service.MainService;
import com.main.Service.IMainService;
import com.main.Entity.MainRepository;

public class MainContainer {
    private static MainContainer container;

    private MainContainer() {
    }

    public static MainContainer getInstance() {
        if (container == null)
            container = new MainContainer();
        return container;
    }

    public IMainService createService() {
        return MainService.getInstance(MainRepository.getInstance());
    }
}
