package mercadoverde.lucas.mercadoverde;


import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ProdutoItemRecyclerAdapter mAdapter;
    private EstadoItemRecyclerAdapter sAdapter;
    private void onItemClicado(int position){
        Toast.makeText(this,"Cliquei no item "+mAdapter.getItem(position).getNome(), Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ProdutoItemRecyclerAdapter(this,obterProdutoCliente());

        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        onItemClicado(position);
                    }
                })
        );

        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        sAdapter = new EstadoItemRecyclerAdapter(this,obterListaDeEstados());

        recyclerView2.setAdapter(sAdapter);
        recyclerView2.addOnItemTouchListener(
                new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        onItemClicado(position);
                    }
                })
        );
        DataBaseHelper.getInstance(this);
        findViewById(R.id.confirmar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserirDados();
                atualizarLista();
            }



        });



    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private List<ProdutoCliente> obterProdutoCliente() {
        ProdutoClienteTable table = new ProdutoClienteTable(this);
        return table.obterTodos();

    }

    private List<EstadoItems> obterListaDeEstados() {
        List<EstadoItems> lista = new ArrayList<>();

        EstadoItems p = new EstadoItems();
        p.setnomeEstado("Acre");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Alogoas");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Amapá");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Amazonas");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Ceará ");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Distrito Federal");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Espírito Santo");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Goiás");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Maranhão");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Mato Grosso");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Mato Grosso do Sul");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Minas Gerais");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Pará");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Paraíba");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Paraná");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Pernambuco");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Piauí ");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Roraima");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Rondônia");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Rio de Janeiro");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Rio Grande do Norte");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Rio Grande do Sul");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Santa Catarina");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("São Paulo");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Sergipe");
        lista.add(p);
        p = new EstadoItems();
        p.setnomeEstado("Tocantins ");
        lista.add(p);

        return lista;



    }
    private void inserirDados(){
        List<ProdutoCliente> lista = new ArrayList<>();

        ProdutoCliente p = new ProdutoCliente();
        p.setnome("Inglaterra");
        p.setpreco(1905);
        p.setdt_anuncio(19022016);
        lista.add(p);

        p = new ProdutoCliente();
        p.setnome("Escócia");
        p.setpreco(2599);

        lista.add(p);



        ProdutoClienteTable table =new ProdutoClienteTable(this);
        for(ProdutoCliente item :lista){
            table.inserir(item);
        }

    }
    private void atualizarLista(){
        mAdapter.clear();
        mAdapter.addAll(obterProdutoCliente());
        mAdapter.notifyDataSetChanged();
    }











}
