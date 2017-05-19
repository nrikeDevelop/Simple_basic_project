package respiravillenabien.admin.project_base_simple.modules;

import android.content.Context;

import nucleus.factory.RequiresPresenter;
import nucleus.presenter.Presenter;
import nucleus.view.NucleusActivity;

/**
 * Created by susy on 19/05/17.
 */

public class MainActivityPresenter extends Presenter<MainActivity> {

    public void showText(String msg){
        if(getView() != null) getView().showToast(msg);
    }

}
