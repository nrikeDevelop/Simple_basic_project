package respiravillenabien.admin.project_base_simple.modules;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusActivity;
import respiravillenabien.admin.project_base_simple.R;

/*
BUTTERKNIFE CONECTA ACTIVITY
1.Activity principal
    >@RequiresPresenter(MainActivityPresenter.class)
    >Extender NucleousActivity <Clase presenter>
2.Activity presenter
    >Extender Presenter <Clase principal>
*/

@RequiresPresenter(MainActivityPresenter.class)
public class MainActivity extends NucleusActivity<MainActivityPresenter> {

    /*
    Context, es el contexto/estado/situacion... en la que se encuentra la activity.
    siempre lo vamos a definir al inicio de la activity, puesto que se va a gastar
    haciendo referencia a la view principal, y no la view en la que se ecuentre,
    ejemplo: No es lo mismo la view ActivityMain, que la view de un OnClickListener
     */
    Context context;

    //TODO: LLAMADA SIMPLE
    Button btSimple;
    public void setUpViews(){
        btSimple = (Button) findViewById(R.id.main_simple_button);
        btSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().showText(context.getString(R.string.message_simple));
            }
        });
    }

    //TODO: LLAMADA BUTTERKNIFE
    //Esto equivale a Button btButterknife = (Button) findViewById(R.id.main_butterknife_button)
    @BindView(R.id.main_butterknife_button) Button btButterknife;

    //Esto equivale a btButterknife.setOnclick(new OnclickListener ...
    @OnClick(R.id.main_butterknife_button)
    public void onClickButterknifeButton(){
        getPresenter().showText(context.getString(R.string.message_butterknife));
    }

    @BindView(R.id.main_button_font) Button btFont;
    @OnClick(R.id.main_button_font)
    public void onClickFontButton(){
        getPresenter().showText(context.getString(R.string.message_font));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        Es necesario (Butterknife.bind(this). Esto enlaza las acciones butterknife
        con la view
         */
        ButterKnife.bind(this);
        context = this;

        //Colocamos fuentes y llamamos a los objectos accionables
        setUpFonts();
        setUpViews();
    }

    public void setUpFonts(){
        Typeface font_bold = Typeface.createFromAsset(getAssets(), "Exo_Regular.ttf");
        btFont.setTypeface(font_bold);
    }

    //TODO: NUCLEOUS METODOS
    //Estos metodos son llamados desde el presenter. Nos ahorramos tener que hacer la interfaz
    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
